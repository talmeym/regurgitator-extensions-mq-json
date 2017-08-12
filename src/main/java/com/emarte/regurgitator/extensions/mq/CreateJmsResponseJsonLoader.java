package com.emarte.regurgitator.extensions.mq;

import com.emarte.regurgitator.core.*;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.JsonConfigUtil.loadOptionalStr;
import static com.emarte.regurgitator.extensions.mq.ExtensionsMqConfigConstants.*;

public class CreateJmsResponseJsonLoader implements JsonLoader<CreateJmsResponse> {
	private CreateResponseJsonLoader responseJsonLoader = new CreateResponseJsonLoader();

	@Override
	public CreateJmsResponse load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		CreateResponse response = (CreateResponse) responseJsonLoader.load(jsonObject, allIds);
		String messageId = loadOptionalStr(jsonObject, JMS_MESSAGE_ID);
		String type = loadOptionalStr(jsonObject, JMS_TYPE);
		String destination = loadOptionalStr(jsonObject, JMS_DESTINATION);
		String correlationId = loadOptionalStr(jsonObject, JMS_CORRELATION_ID);
		String deliveryMode = loadOptionalStr(jsonObject, JMS_DELIVERY_MODE);
		String expiration = loadOptionalStr(jsonObject, JMS_EXPIRATION);
		String priority = loadOptionalStr(jsonObject, JMS_PRIORITY);
		String redelivered = loadOptionalStr(jsonObject, JMS_REDELiVERED);
		String replyTo = loadOptionalStr(jsonObject, JMS_REPLY_TO);
		String timestamp = loadOptionalStr(jsonObject, JMS_TIMESTAMP);
		return new CreateJmsResponse(response, messageId, type, destination, correlationId, deliveryMode, expiration, priority, redelivered, replyTo, timestamp);
	}
}
