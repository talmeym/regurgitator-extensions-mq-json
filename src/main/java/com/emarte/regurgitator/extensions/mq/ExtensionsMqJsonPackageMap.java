/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions.mq;

import com.emarte.regurgitator.core.AbstractJsonPackageMap;

import java.util.*;

import static java.util.Collections.singletonList;

public class ExtensionsMqJsonPackageMap extends AbstractJsonPackageMap {
    private static final List<String> kinds = singletonList("create-jms-response");

    public ExtensionsMqJsonPackageMap() {
        addPackageMapping(kinds, "com.emarte.regurgitator.extensions.mq");
    }
}
