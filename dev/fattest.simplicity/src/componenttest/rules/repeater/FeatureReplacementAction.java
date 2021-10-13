/*******************************************************************************
 * Copyright (c) 2017, 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package componenttest.rules.repeater;

import java.util.Set;

/**
 * Test repeat action that removes and adds features during setup.
 *
 * A basic implementation of AbstractReplacementAction
 */
public class FeatureReplacementAction extends AbstractReplacementAction<FeatureReplacementAction> {

    private static final Class<?> c = FeatureReplacementAction.class;

    public FeatureReplacementAction() {}

    /**
     * Remove one feature and add one feature.
     *
     * By default features are added even if there was not another version already there
     *
     * @param removeFeature the feature to be removed
     * @param addFeature    the feature to add
     */
    public FeatureReplacementAction(String removeFeature, String addFeature) {
        this();
        addFeature(addFeature);
        removeFeature(removeFeature);
    }

    /**
     * Remove a set of features and add a set of features
     *
     * By default features are added even if there was not another version already there
     *
     * @param removeFeatures the features to remove
     * @param addFeatures    the features to add
     */
    public FeatureReplacementAction(Set<String> removeFeatures, Set<String> addFeatures) {
        this();
        addFeatures(addFeatures);
        removeFeatures(removeFeatures);
    }

    /**
     * Add a set of features.
     *
     * Currently there is no constructor which allows you to just remove features. If you need to do that then
     * pass an empty set to {@link #FeatureReplacementAction(Set, Set)}
     *
     * By default features are added even if there was not another version already there
     *
     * @param addFeatures the features to add
     */
    public FeatureReplacementAction(Set<String> addFeatures) {
        this();
        addFeatures(addFeatures);
    }

    /**
     * Add a single feature
     *
     * Currently there is no constructor which allows you to just remove a single feature. If you need to do that then
     * pass an empty set to {@link #FeatureReplacementAction(Set, Set)}
     *
     * By default features are added even if there was not another version already there
     *
     * @param addFeature the feature to add.
     */
    public FeatureReplacementAction(String addFeature) {
        this();
        addFeature(addFeature);
    }

}
