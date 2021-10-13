/*******************************************************************************
 * Copyright (c) 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package componenttest.rules.repeater;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.transformer.jakarta.JakartaTransformer;

import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.ws.fat.util.SharedServer;

import componenttest.custom.junit.runner.RepeatTestFilter;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.impl.LibertyServerFactory;
import componenttest.topology.utils.FileUtils;

/**
 * Test repeat action that will do 2 things:
 * <ol>
 * <li>Invoke the Jakarta transformer on all war/ear files under the autoFVT/publish/ folder</li>
 * <li>Update all server.xml configs under the autoFVT/publish/ folder to use EE 9 features</li>
 * </ol>
 */
public class JakartaEE9Action extends AbstractReplacementAction<JakartaEE9Action> {
    private static final Class<?> c = JakartaEE9Action.class;

    public static final String ID = "EE9_FEATURES";

    private static final String TRANSFORMER_RULES_APPEND_ROOT = System.getProperty("user.dir") + "/publish/rules/";
    private static final String TRANSFORMER_RULES_ROOT = System.getProperty("user.dir") + "/autoFVT-templates/";
    private static final Map<String, String> DEFAULT_TRANSFORMATION_RULES = new HashMap<String, String>();
    private static final Map<String, String> TRANSFORMATION_RULES_APPEND = new HashMap<String, String>();

    static {
        // Fill the default transformation rules for the transformer
        // The rules are copied from 'open-liberty/dev/wlp-jakartaee-transform/rules' to
        // the user 'autoFVT-templates' folder.
        //
        //   jakarta-selections.properties
        //   jakarta-renames.properties
        //   jakarta-versions.properties
        //   jakarta-bundles.properties
        //   jakarta-direct.properties
        //   jakarta-xml-master.properties
        //   (other xml properties files as referenced by 'jakarta-xml-master.properties'
        DEFAULT_TRANSFORMATION_RULES.put("-tr", TRANSFORMER_RULES_ROOT + "jakarta-renames.properties"); // Package renames
        DEFAULT_TRANSFORMATION_RULES.put("-ts", TRANSFORMER_RULES_ROOT + "jakarta-selections.properties"); // File selections and omissions
        DEFAULT_TRANSFORMATION_RULES.put("-tv", TRANSFORMER_RULES_ROOT + "jakarta-versions.properties"); // Package version updates
        DEFAULT_TRANSFORMATION_RULES.put("-tb", TRANSFORMER_RULES_ROOT + "jakarta-bundles.properties"); // bundle identity updates
        DEFAULT_TRANSFORMATION_RULES.put("-td", TRANSFORMER_RULES_ROOT + "jakarta-direct.properties"); // exact java string constant updates
        DEFAULT_TRANSFORMATION_RULES.put("-tf", TRANSFORMER_RULES_ROOT + "jakarta-xml-master.properties"); // master xml subsitution file
    }

    // Point-in-time list of enabled JakartaEE9 features.
    // This list is of only the currently enabled features.
    //
    // FAT tests use a mix of enabled features and not yet enabled
    // features, which is necessary for the FATs to run.

    static final String[] EE9_FEATURES_ARRAY = {
                                                 "appClientSupport-2.0",
                                                 "jakartaee-9.1",
                                                 "webProfile-9.1",
                                                 "jakartaeeClient-9.1",
                                                 "componenttest-2.0", // replaces "componenttest-1.0"
                                                 "txtest-2.0",
                                                 "appAuthentication-2.0",
                                                 "appAuthorization-2.0",
                                                 "appSecurity-4.0",
                                                 "batch-2.0",
                                                 "beanValidation-3.0",
                                                 "cdi-3.0",
                                                 "concurrent-2.0",
                                                 "connectors-2.0",
                                                 "connectorsInboundSecurity-2.0",
                                                 "expressionLanguage-4.0",
                                                 "enterpriseBeans-4.0",
                                                 "enterpriseBeansHome-4.0",
                                                 "enterpriseBeansLite-4.0",
                                                 "enterpriseBeansPersistentTimer-4.0",
                                                 "enterpriseBeansRemote-4.0",
                                                 "enterpriseBeansTest-2.0",
                                                 "mail-2.0",
                                                 "persistence-3.0",
                                                 "persistenceContainer-3.0",
                                                 "jsonp-2.0",
                                                 "jsonb-2.0",
                                                 "jsonpContainer-2.0",
                                                 "jsonbContainer-2.0",
                                                 "faces-3.0",
                                                 "facesContainer-3.0",
                                                 "pages-3.0",
                                                 "managedBeans-2.0",
                                                 "mdb-4.0",
                                                 "messaging-3.0",
                                                 "messagingClient-3.0",
                                                 "messagingServer-3.0",
                                                 "messagingSecurity-3.0",
                                                 "restfulWS-3.0",
                                                 "restfulWSClient-3.0",
                                                 "servlet-5.0",
                                                 "websocket-2.0",
                                                 "xmlBinding-3.0",
                                                 "xmlWS-3.0"
    };

    public static final Set<String> EE9_FEATURE_SET = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(EE9_FEATURES_ARRAY)));

    public JakartaEE9Action() {
        // Remove the EE7 and EE8 features; replace them with the EE9 features
        super(EE9_FEATURE_SET);
        removeFeatures(EE6FeatureReplacementAction.EE6_FEATURE_SET);
        removeFeatures(EE7FeatureReplacementAction.EE7_FEATURE_SET);
        removeFeatures(EE8FeatureReplacementAction.EE8_FEATURE_SET);
        forceAddFeatures(false);
        withID(ID);
    }

    @Override
    public String toString() {
        return "JakartaEE9 FAT repeat action (" + getID() + ")";
    }

    /**
     * Specifies which file in the rules directory of the FAT will be used for
     * adding additional package transformations.
     *
     * @param fileName The file name in the publish/rules directory to use for appending
     *
     */
    public JakartaEE9Action withLocalPackageTransformAppend(String fileName) {
        TRANSFORMATION_RULES_APPEND.put("-tr", TRANSFORMER_RULES_APPEND_ROOT + fileName);
        return this;
    }

    /**
     * Specifies which file in the rules directory of the FAT will be used for
     * adding additional selection transformations.
     *
     * @param fileName The file name in the publish/rules directory to use for appending
     *
     */
    public JakartaEE9Action withLocalSelectionTransformAppend(String fileName) {
        TRANSFORMATION_RULES_APPEND.put("-ts", TRANSFORMER_RULES_APPEND_ROOT + fileName);
        return this;
    }

    /**
     * Specifies which file in the rules directory of the FAT will be used for
     * adding additional version transformations.
     *
     * @param fileName The file name in the publish/rules directory to use for appending
     *
     */
    public JakartaEE9Action withLocalVersionTransformAppend(String fileName) {
        TRANSFORMATION_RULES_APPEND.put("-tv", TRANSFORMER_RULES_APPEND_ROOT + fileName);
        return this;
    }

    /**
     * Specifies which file in the rules directory of the FAT will be used for
     * adding additional bundle transformations.
     *
     * @param fileName The file name in the publish/rules directory to use for appending
     *
     */
    public JakartaEE9Action withLocalBundleTransformAppend(String fileName) {
        TRANSFORMATION_RULES_APPEND.put("-tb", TRANSFORMER_RULES_APPEND_ROOT + fileName);
        return this;
    }

    /**
     * Specifies which file in the rules directory of the FAT will be used for
     * adding additional string transformations.
     *
     * @param fileName The file name in the publish/rules directory to use for appending
     *
     */
    public JakartaEE9Action withLocalStringTransformAppend(String fileName) {
        TRANSFORMATION_RULES_APPEND.put("-td", TRANSFORMER_RULES_APPEND_ROOT + fileName);
        return this;
    }

    /**
     * Specifies which file in the rules directory of the FAT will be used for
     * adding additional xml transformations.
     *
     * @param fileName The file name in the publish/rules directory to use for appending
     *
     */
    public JakartaEE9Action withLocalXMLTransformAppend(String fileName) {
        TRANSFORMATION_RULES_APPEND.put("-tf", TRANSFORMER_RULES_APPEND_ROOT + fileName);
        return this;
    }

    //

    @Override
    public void setup() throws Exception {
        clean();

        // Transform server.xml's
        super.setup();
    }

    static void clean() throws Exception {
        // Ensure all shared servers are stopped and applications are cleaned
        LibertyServerFactory.tidyAllKnownServers(SharedServer.class.getCanonicalName());
        LibertyServerFactory.recoverAllServers(SharedServer.class.getCanonicalName());
        for (LibertyServer server : LibertyServerFactory.getKnownLibertyServers(SharedServer.class.getCanonicalName())) {
            Path rootPath = Paths.get(server.getServerRoot());
            FileUtils.recursiveDelete(rootPath.toFile());
        }
        ShrinkHelper.cleanAllExportedArchives();
    }

    public static boolean isActive() {
        return RepeatTestFilter.isRepeatActionActive(ID);
    }

    /**
     * Invoke the Jakarta transformer on an application (ear or war or jar).
     *
     * A backup of the original application is placed under "&lt;server&gt;/backup".
     * ".jakarta" is appended to name the initially transformed application. However,
     * that application is renamed to the initial application name.
     *
     * @param appPath The application path to be transformed to Jakarta
     */
    public static void transformApp(Path appPath) {
        transformApp(appPath, null);
    }

    /**
     * Invoke the Jakarta transformer on an application with added transformation rules.
     *
     * @param appPath                   The application path to be transformed to Jakarta
     * @param newAppPath                The application path of the transformed file (or <code>null<code>)
     * @param transformationRulesAppend The map with the additional transformation rules to add
     */
    public static void transformApp(Path appPath, Path newAppPath, Map<String, String> transformationRulesAppend) {
        TRANSFORMATION_RULES_APPEND.putAll(transformationRulesAppend);
        transformApp(appPath, newAppPath);
    }

    /**
     * Invoke the Jakarta transformer on an application (ear or war or jar).
     * to create a new transformed copy.
     *
     * If the destination Path is null, the application is transformed into
     * the same file as the source. A backup of the original application is placed
     * under "&lt;server&gt;/backup". The extension ".jakarta" is appended to
     * name the initially transformed application. However,
     * that application is renamed to the initial application name.
     *
     * @param appPath    The application path of file to be transformed to Jakarta
     * @param newAppPath The application path of the transformed file (or <code>null<code>)
     */
    public static void transformApp(Path appPath, Path newAppPath) {
        final String m = "transformApp";
        appPath = appPath.toAbsolutePath();
        Log.info(c, m, "Transforming app: " + appPath);

        // Setup file output stream and only keep if we fail
        FileOutputStream fos = null;
        File outputLog = getTransformerLogFile(appPath);
        try {
            fos = new FileOutputStream(outputLog);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        PrintStream out = System.out;
        PrintStream err = System.err;
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
        System.setErr(ps);

        try {
            try {
                Class.forName("org.eclipse.transformer.jakarta.JakartaTransformer");
            } catch (Throwable e) {
                String mesg = "Unable to load the org.eclipse.transformer.jakarta.JakartaTransformer class. " +
                              "Did you remember to include 'addRequiredLibraries.dependsOn addJakartaTransformer' in the FATs build.gradle file?";
                Log.error(c, m, e, mesg);
                throw new RuntimeException(mesg, e);
            }

            Path outputPath;
            if (newAppPath == null) {
                outputPath = getTransformedAppPath(appPath).toAbsolutePath();
            } else {
                outputPath = newAppPath.toAbsolutePath();
            }
            Log.info(c, m, "outputPath: " + outputPath);

            try {
                //Initializing transformer args
                String[] args = getTransformerArgs(appPath, outputPath);
                Log.info(c, m, "Initializing transformer with args: " + Arrays.toString(args));

                // Invoke the jakarta transformer
                // Note the use of 'com.ibm.ws.JakartaTransformer'.
                // 'org.eclipse.transformer.Transformer' might also be used instead.
                JakartaTransformer.main(args);

                //Move original to backup.
                Path backupPath = getBackupAppPath(appPath).toAbsolutePath();
                Log.info(c, m, "backupPath: " + backupPath);
                movePath(appPath, backupPath);

                // Copy jakarta app to the original filename
                Log.info(c, m, "Replacing original: " + appPath + " with transformed: " + outputPath);
                copyPath(outputPath, appPath);

                //It is actually useful to keep the transformed app for local use
//            if (outputLog.exists()) {
//                outputLog.delete();
//            }
            } catch (Exception e) {
                Log.info(c, m, "Unable to transform app at path: " + appPath);
                Log.error(c, m, e);
                throw new RuntimeException(e);
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                }
                Log.info(c, m, "Transforming complete app: " + outputPath);
            }
        } finally {
            //set system out and err back to what they were before
            System.setOut(out);
            System.setErr(err);
        }
    }

    private static String[] getTransformerArgs(Path appPath, Path outputPath) {
        String[] args = new String[15 + TRANSFORMATION_RULES_APPEND.size() * 2];

        args[0] = appPath.toAbsolutePath().toString(); // input
        args[1] = outputPath.toAbsolutePath().toString(); // output

        args[2] = "-q"; // quiet output

        // override jakarta default properties, which are
        // packaged in the transformer jar
        args[3] = "-tr"; // package-renames
        args[4] = DEFAULT_TRANSFORMATION_RULES.get("-tr");
        args[5] = "-ts"; // file selections and omissions
        args[6] = DEFAULT_TRANSFORMATION_RULES.get("-ts");
        args[7] = "-tv"; // package version updates
        args[8] = DEFAULT_TRANSFORMATION_RULES.get("-tv");
        args[9] = "-tb"; // bundle identity updates
        args[10] = DEFAULT_TRANSFORMATION_RULES.get("-tb");
        args[11] = "-td"; // exact java string constant updates
        args[12] = DEFAULT_TRANSFORMATION_RULES.get("-td");
        args[13] = "-tf"; // master xml subsitution file
        args[14] = DEFAULT_TRANSFORMATION_RULES.get("-tf");

        // Go through the additions
        if (TRANSFORMATION_RULES_APPEND.size() > 0) {
            String[] additions = new String[TRANSFORMATION_RULES_APPEND.size() * 2];
            int index = 0;
            for (Entry<String, String> addition : TRANSFORMATION_RULES_APPEND.entrySet()) {
                additions[index++] = addition.getKey();
                additions[index++] = addition.getValue();
            }
            System.arraycopy(additions, 0, args, 15, TRANSFORMATION_RULES_APPEND.size() * 2);
        }
        return args;
    }

    /**
     * Move the source path and its contents to the target path. May be either a file or dir.
     *
     * @param  source      The path to move.
     * @param  target      The path to move to.
     * @throws IOException If an I/O error occurs moving the path.
     */
    private static void movePath(Path source, Path dest) throws IOException {
        final String m = "movePath";
        /*
         * Don't use Files.move, b/c it can lead to:
         *
         * java.nio.file.FileSystemException: The process cannot access the
         * file because it is being used by another process.
         */
        copyPath(source, dest);
        Log.info(c, m, "Deleting: " + source);
        FileUtils.recursiveDelete(source.toFile());
    }

    /**
     * Copy the source directory and its contents to the target directory.
     *
     * @param  source      The directory to make a copy of.
     * @param  target      The directory to copy to.
     * @throws IOException If an I/O error occurs copying the directory.
     */
    private static void copyPath(Path source, Path dest) throws IOException {
        final String m = "copyPath";
        Log.info(c, m, "Copying from: " + source + " to: " + dest);
        FileUtils.copyDirectory(source.toFile(), dest.toFile());
    }

    /**
     * Get a Path to where the transformer log file should be.
     *
     * @param  appPath
     * @return
     */
    private static File getTransformerLogFile(Path appPath) {
        String filename = "transformer_" + appPath.getFileName() + ".log";
        Path logPath = getTransformerPath().resolve(filename);
        File logFile = logPath.toFile();
        return logFile;
    }

    /**
     * Get a Path to where a transformed version of an app should be.
     *
     * @param  appPath
     * @return
     */
    private static Path getTransformedAppPath(Path appPath) {
        String filename = appPath.getFileName().toString();
        Path transformedPath = getTransformedPath().resolve(filename);
        return transformedPath;
    }

    /**
     * Get a Path to where a backup of an app should be.
     *
     * @param  appPath
     * @return
     */
    private static Path getBackupAppPath(Path appPath) {
        String filename = appPath.getFileName().toString();
        Path backupPath = getBackupPath().resolve(filename);
        return backupPath;
    }

    /**
     * Get a Path to the working dir for this transformer. Ensure it exists.
     * Currently this is just "jakarta" but it may be that EE9 and EE10 apps need to be
     * transformed differently. In such a case we may want to use separate folders.
     *
     * @return
     */
    private static Path getTransformerPath() {
        Path rootPath = getTransformerWorkingDir();
        Path transformerPath = getSubPath(rootPath, "jakarta");
        return transformerPath;
    }

    /**
     * Get a Path to the dir where the original apps should be backed up to. Ensure it exists.
     *
     * @return
     */
    private static Path getBackupPath() {
        Path rootPath = getTransformerPath();
        Path backupPath = getSubPath(rootPath, "original");
        return backupPath;
    }

    /**
     * Get a Path to the dir where transformed apps should be output. Ensure it exists.
     *
     * @return
     */
    private static Path getTransformedPath() {
        Path rootPath = getTransformerPath();
        Path transformedPath = getSubPath(rootPath, "transformed");
        return transformedPath;
    }

    /**
     * Get a sub-directory Path. Ensure it exists.
     *
     * @param  parent
     * @param  subName
     * @return
     */
    private static Path getSubPath(Path parent, String subName) {
        Path subPath = parent.resolve(subName);
        mkdirs(subPath);
        return subPath;
    }

    /**
     * Get a Path which represents the transformer working directory. Ensure that it exists.
     *
     * @return the transformer working dir
     */
    private static Path getTransformerWorkingDir() {
        String dirName = "transformer";
        File file = mkdirs(new File(dirName));
        Path path = file.toPath();
        return path;
    }

    /**
     * Ensure that a directory exists. If it does not, try to create it.
     *
     * @param  path A Path that represents the directory
     * @return      return the created dir Path
     */
    private static Path mkdirs(Path path) {
        File file = path.toFile();
        mkdirs(file);
        return path;
    }

    /**
     * Ensure that a directory exists. If it does not, try to create it.
     *
     * @param  dir A File that represents the directory
     * @return     return the created dir File
     */
    private static File mkdirs(File dir) {
        final String m = "mkdirs";
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                String msg = "Failed to create directory: " + dir;
                Log.info(c, m, msg);
                RuntimeException e = new RuntimeException(msg);
                Log.error(c, m, e);
                throw e;
            }
        } else if (!dir.isDirectory()) {
            String msg = "File already exists but is not a directory: " + dir;
            Log.info(c, m, msg);
            RuntimeException e = new RuntimeException(msg);
            Log.error(c, m, e);
            throw e;
        }
        return dir;
    }
}
