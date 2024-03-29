/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.extensions.mq;

import net.sf.json.JSONObject;
import uk.emarte.regurgitator.core.JsonLoader;
import uk.emarte.regurgitator.core.Log;
import uk.emarte.regurgitator.core.RegurgitatorException;

import java.util.Set;

import static uk.emarte.regurgitator.core.JsonConfigUtil.loadId;
import static uk.emarte.regurgitator.core.JsonConfigUtil.loadMandatoryStr;
import static uk.emarte.regurgitator.extensions.mq.ExtensionsMqConfigConstants.DESTINATION;

public class JmsCallJsonLoader implements JsonLoader<JmsCall> {
    private static final Log log = Log.getLog(JmsCallJsonLoader.class);

    @Override
    public JmsCall load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
        MqMessagingSystem mqMessagingSystem = MqMessagingLookup.mqMessagingSystem();

        String id = loadId(jsonObject, allIds);
        log.debug("Loaded jms call '{}'", id);
        return new JmsCall(id, mqMessagingSystem, loadMandatoryStr(jsonObject, DESTINATION));
    }
}