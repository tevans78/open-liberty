/*******************************************************************************
 * Copyright (c) 2023 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package componenttest.common;

import java.util.Objects;

import com.ibm.websphere.simplicity.log.Log;

/**
 * Common Utilities and Constants related to accessing Artifactory
 */
public class ArtifactoryUtils {

    private static final Class<ArtifactoryUtils> c = ArtifactoryUtils.class;

    public static final String FAT_TEST_PREFIX = "fat.test.";
    public static final String ARTIFACTORY_FORCE_EXTERNAL_KEY = "artifactory.force.external.repo";
    public static final String ARTIFACTORY_SERVER_KEY = "artifactory.download.server";
    public static final String ARTIFACTORY_USER_KEY = "artifactory.download.user";
    public static final String ARTIFACTORY_TOKEN_KEY = "artifactory.download.token";

    /**
     * Manual override that will allow builds or users to pull from Artifactory instead of DockerHub.
     */
    public static final String DOCKER_SUBSTITUTION_OVERRIDE_KEY = "use.artifactory.substitution";

    /**
     * Checks whether we are configured to use artifactory or not
     *
     * @return {@code true} if we are configured to use artifactory, {@code false} if not
     */
    public static boolean useArtifactory() {
        boolean forceExternal = isArtifactoryForceExternal();
        String artifactoryServer = getArtifactoryServer();

        boolean useArtifactory = Objects.nonNull(artifactoryServer) && !forceExternal;

        Log.info(c, "useArtifactory", "Use artifactory = " + useArtifactory + " ("
                                      + ArtifactoryUtils.ARTIFACTORY_SERVER_KEY + "=" + artifactoryServer + ", "
                                      + ArtifactoryUtils.ARTIFACTORY_FORCE_EXTERNAL_KEY + "=" + forceExternal
                                      + ")");
        return useArtifactory;
    }

    /**
     * Get the flag for forcing artfiactory usage
     *
     * @return true if flag was true, false otherwise
     */
    public static boolean isArtifactoryForceExternal() {
        return Boolean.parseBoolean(getArtifactoryForceExternal());
    }

    /**
     * Get the flag for forcing artfiactory usage
     *
     * @return true if flag was true, false otherwise
     */
    public static String getArtifactoryForceExternal() {
        return normalizeStringProperty(System.getProperty(ArtifactoryUtils.FAT_TEST_PREFIX + ArtifactoryUtils.ARTIFACTORY_FORCE_EXTERNAL_KEY));
    }

    /**
     * Get the artifactory server to use
     *
     * @return the artifactory server or {@code null} if none is configured
     */
    public static String getArtifactoryServer() {
        return normalizeStringProperty(System.getProperty(ArtifactoryUtils.FAT_TEST_PREFIX + ArtifactoryUtils.ARTIFACTORY_SERVER_KEY));
    }

    /**
     * Get the username to access artifactory
     *
     * @return the username, or {@code null} if none is configured
     */
    public static String getArtifactoryUser() {
        return normalizeStringProperty(System.getProperty(ArtifactoryUtils.FAT_TEST_PREFIX + ArtifactoryUtils.ARTIFACTORY_USER_KEY));
    }

    /**
     * Get the token to use to access artifactory
     *
     * @return the token, or {@code null} if none is configured
     */
    public static String getArtifactoryToken() {
        return normalizeStringProperty(System.getProperty(ArtifactoryUtils.FAT_TEST_PREFIX + ArtifactoryUtils.ARTIFACTORY_TOKEN_KEY));
    }

    /**
     * This validates the result string from using System.getProperty().
     * See launch.xml line 322 we first check if a property was set via a command line property
     * If not we assume the property was set as an environment property.
     *
     * Which mean fat.test.artifactory.download.server could equal "${env.artifactory.download.server}"
     *
     * @param  result the string to validate
     * @return        null if the string was invalid, itself otherwise.
     */
    public static String normalizeStringProperty(String result) {
        if (result == null)
            return result;

        if (result.isEmpty()) {
            return null;
        }

        if (result.startsWith("${"))
            return null;

        return result;
    }

    /**
     * @return
     */
    public static boolean dockerSubstitutionOverride() {
        return Boolean.parseBoolean(getDockerSubstitution());
    }

    /**
     * Get the flag for forcing artfiactory usage
     *
     * @return true if flag was true, false otherwise
     */
    public static String getDockerSubstitution() {
        return normalizeStringProperty(System.getProperty(ArtifactoryUtils.FAT_TEST_PREFIX + ArtifactoryUtils.DOCKER_SUBSTITUTION_OVERRIDE_KEY));
    }

}
