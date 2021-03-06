/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.extensions.mq;

import com.emarte.regurgitator.core.CreateResponse;
import com.emarte.regurgitator.core.CreateResponseJsonLoader;
import com.emarte.regurgitator.core.JsonLoader;
import com.emarte.regurgitator.core.RegurgitatorException;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.JsonConfigUtil.*;
import static com.emarte.regurgitator.extensions.mq.ExtensionsMqConfigConstants.*;

public class CreateJmsResponseJsonLoader implements JsonLoader<CreateJmsResponse> {
    private final CreateResponseJsonLoader responseJsonLoader = new CreateResponseJsonLoader();

    @Override
    public CreateJmsResponse load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
        CreateResponse response = (CreateResponse) responseJsonLoader.load(jsonObject, allIds);
        String messageId = loadOptionalStr(jsonObject, JMS_MESSAGE_ID);
        String type = loadOptionalStr(jsonObject, JMS_TYPE);
        String destination = loadOptionalStr(jsonObject, JMS_DESTINATION);
        String correlationId = loadOptionalStr(jsonObject, JMS_CORRELATION_ID);
        Long deliveryMode = loadOptionalLong(jsonObject, JMS_DELIVERY_MODE);
        Long expiration = loadOptionalLong(jsonObject, JMS_EXPIRATION);
        Long priority = loadOptionalLong(jsonObject, JMS_PRIORITY);
        Boolean redelivered = loadOptionalBool(jsonObject, JMS_REDELIVERED);
        String replyTo = loadOptionalStr(jsonObject, JMS_REPLY_TO);
        Long timestamp = loadOptionalLong(jsonObject, JMS_TIMESTAMP);
        return new CreateJmsResponse(response, messageId, type, destination, correlationId, deliveryMode, expiration, priority, redelivered, replyTo, timestamp);
    }
}
