package com.emarte.regurgitator.extensions.mq;

import com.emarte.regurgitator.core.AbstractJsonPackageMap;

import java.util.*;

public class ExtensionsMqJsonPackageMap extends AbstractJsonPackageMap {
	private static final List<String> kinds = Arrays.asList("create-jms-response");

	public ExtensionsMqJsonPackageMap() {
		addPackageMapping(kinds, "com.emarte.regurgitator.extensions.mq");
	}
}
