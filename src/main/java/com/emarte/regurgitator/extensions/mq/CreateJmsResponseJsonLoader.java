package com.emarte.regurgitator.extensions.mq;

import com.emarte.regurgitator.core.*;
import com.emarte.regurgitator.extensions.mq.CreateJmsResponse;
import net.sf.json.JSONObject;

import java.util.Set;

import static com.emarte.regurgitator.core.JsonConfigUtil.loadOptionalStr;
import static com.emarte.regurgitator.extensions.mq.ExtensionsMqConfigConstants.*;

public class CreateJmsResponseJsonLoader implements JsonLoader<CreateJmsResponse> {
	private CreateResponseJsonLoader responseJsonLoader = new CreateResponseJsonLoader();

	@Override
	public CreateJmsResponse load(JSONObject jsonObject, Set<Object> allIds) throws RegurgitatorException {
		CreateResponse response = (CreateResponse) responseJsonLoader.load(jsonObject, allIds);
		String destination = loadOptionalStr(jsonObject, JMS_DESTINATION);
		String correlationId = loadOptionalStr(jsonObject, JMS_CORRELATION_ID);
		String type = loadOptionalStr(jsonObject, JMS_TYPE);
		return new CreateJmsResponse(response, destination, correlationId, type);
	}
}
