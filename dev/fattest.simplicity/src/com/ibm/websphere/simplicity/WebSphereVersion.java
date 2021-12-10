/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.websphere.simplicity;


/**
 * This class represents a WebSphere version number. 
 * 
 * @author Tim Burns
 */
public class WebSphereVersion implements Comparable {
    
	protected static final String REGEX_DOT = "\\.";

	protected final String versionString;
	protected final int[] versionBytes;

    /**
     * Constructor
     * 
     * @param version The version number
     * @throws IllegalArgumentException
     */
	public WebSphereVersion(String version) throws IllegalArgumentException {
		this.versionString = version;
		if (version == null || version.trim().length() < 1) {
			throw new IllegalArgumentException(this.getInvalidWebSphereVersionMsg(version));
		}
		String[] versionNumbers = version.split(REGEX_DOT);
		this.versionBytes = new int[versionNumbers.length];
		try {
			for (int i = 0; i < versionNumbers.length; i++) {
				this.versionBytes[i] = Integer.parseInt(versionNumbers[i]);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(this.getInvalidWebSphereVersionMsg(version), e);
		}
	}

    /**
     * Get the message for an invalid version number.
     * 
     * @param version The version number
     * @return The message
     */
	protected String getInvalidWebSphereVersionMsg(String version) {
		return "The version string \"" + version + "\" is invalid";
	}

    /**
     * Returns true if this WebSphereVersion is lower than the specifed version
     * 
     * @param target The WebSphereVersion to compare this one to
     * @return true if this is lower than the target
     */
	public boolean isLowerThan(WebSphereVersion target) {
		return (this.compareTo(target) < 0);
	}

    /**
     * Returns true if the specified WebSphereVersion is in between the lower and higher WebSphere versions
     * 
     * @param lower The WebSphereVersion with the lower value
     * @param higher The WebSphereVersion with the higher value
     * @return true if this WebSphereVersion is in between higher and lower
     */
	public boolean isBetween(WebSphereVersion lower, WebSphereVersion higher) {
		return this.isHigherThan(lower) && this.isLowerThan(higher);
	}

    /**
     * Returns true if this WebSphereVersion is higher than the specified version
     * 
     * @param target The WebSphereVersion to compare this one to
     * @return true if this is higher than the target
     */
	public boolean isHigherThan(WebSphereVersion target) {
		return (this.compareTo(target) > 0);
	}

	public String toString() {
		return this.versionString;
	}

    /**
     * Fill the version array with zeros
     * 
     * @param version The array to fill
     * @param length The length of the final version
     * @return The zero filled version
     */
	protected static int[] zeroFill(int[] version, int length) {
		if (version.length >= length) {
			// The input array is already of sufficient length, return it
			return version;
		} else {
			/* The input array is shorter than the requested length, so fill in
			 * extra spaces with zeros
			 */
			int[] tmp = new int[length];
			for (int i = 0; i < length; i++) {
				if (i < version.length) {
					tmp[i] = version[i];
				} else {
					tmp[i] = 0;
				}
			}
			return tmp;
		}
	}

	public int compareTo(Object obj) throws ClassCastException {
		/* Javadoc says to throw a ClassCastException if the specified object's
		 * type prevents it from being compared to this object
		 */
		WebSphereVersion otherVersion = (WebSphereVersion) obj;

		// A null WebSphereVersion is automatically lower than this WebSphereVersion
		if (otherVersion == null) {
			return 1;
		}

		/* Ensure that both arrays are of the same length */
		int[] r1 = zeroFill(this.versionBytes, otherVersion.versionBytes.length);
		int[] r2 = zeroFill(otherVersion.versionBytes, this.versionBytes.length);

		// Iterate through the arrays to determine which WebSphereVersion is higher
		for (int i = 0; i < r1.length; i++) {
			if (r1[i] > r2[i])
				return 1;
			else if (r2[i] > r1[i])
				return -1;
		}

		// Every digit of both WebSphereVersions match. They are equal!
		return 0;
	}

	/**
	 * Returns a comparison guaranteed to be at least a partial (if not complete)
	 * match.  So comparing the two strings "6.1" and "6.1.0.21" will return 0,
	 * while comparing "6.1" with "7.0.0.0" will return -1, and so on.
	 * @param obj
	 * @return
	 * @throws ClassCastException
	 */
	public int compareToPartial(Object obj) throws ClassCastException {
		/* Javadoc says to throw a ClassCastException if the specified object's
		 * type prevents it from being compared to this object
		 */
		WebSphereVersion otherVersion = (WebSphereVersion) obj;

		// A null WebSphereVersion is automatically lower than this WebSphereVersion
		if (otherVersion == null) {
			return 1;
		}

		int min = Math.min(this.versionBytes.length, otherVersion.versionBytes.length);

		// Iterate through the arrays to determine which WebSphereVersion is higher
		for (int i = 0; i < min; i++) {
			if (this.versionBytes[i] > otherVersion.versionBytes[i])
				return 1;
			else if (this.versionBytes[i] < otherVersion.versionBytes[i])
				return -1;
		}

		// Existing digits of both WebSphereVersions match. They are at least partially equal!
		return 0;
	}

	public boolean equals(Object obj) {
		return (obj != null && obj instanceof WebSphereVersion && this.compareTo(obj) == 0);
	}
	
	public boolean equalsPartial(Object obj) {
		return (obj != null && obj instanceof WebSphereVersion && this.compareToPartial(obj) == 0);
	}
    
}
