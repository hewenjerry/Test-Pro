/**
 * 
 */
package com.guava.test.jerry.model;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppVer implements Comparable<AppVer> {

    private final int majorVer;

    private final int minorVer;

    private final int bugfixVer;

    /**
     * @param majorVer
     * @param minorVer
     * @param bugfixVer
     */
    private AppVer(int majorVer, int minorVer, int bugfixVer) {
        this.majorVer = majorVer;
        this.minorVer = minorVer;
        this.bugfixVer = bugfixVer;
    }

    private static Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)$"); // ^(\d+)\.(\d+)\.(\d+)$

    public static final AppVer of(String appVer) {
        if (appVer == null) {
            return null;
        }
        Matcher matcher = pattern.matcher(appVer);
        if (matcher.matches()) {
            return new AppVer(NumberUtils.toInt(matcher.group(1)), NumberUtils.toInt(matcher
                    .group(2)), NumberUtils.toInt(matcher.group(3)));
        } else {
            return null;
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(AppVer o) {
        return ComparisonChain.start().compare(o.majorVer, majorVer).compare( o.minorVer, minorVer)
                .compare(o.bugfixVer,bugfixVer).result();
    }

    @Override
    public String toString() {
        return majorVer + "." + minorVer + "." + bugfixVer;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bugfixVer;
        result = prime * result + majorVer;
        result = prime * result + minorVer;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AppVer)) {
            return false;
        }
        AppVer other = (AppVer) obj;
        if (bugfixVer != other.bugfixVer) {
            return false;
        }
        if (majorVer != other.majorVer) {
            return false;
        }
        if (minorVer != other.minorVer) {
            return false;
        }
        return true;
    }

}
