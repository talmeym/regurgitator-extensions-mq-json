/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions.mq;

import uk.emarte.regurgitator.core.AbstractJsonPackageMap;

import java.util.Arrays;
import java.util.List;

public class ExtensionsMqJsonPackageMap extends AbstractJsonPackageMap {
    private static final List<String> kinds = Arrays.asList("create-jms-response", "jms-call");

    public ExtensionsMqJsonPackageMap() {
        addPackageMapping(kinds, "uk.emarte.regurgitator.extensions.mq");
    }
}
