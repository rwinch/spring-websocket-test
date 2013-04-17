/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.websocket.echo.stomp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stomp.StompHandler;
import org.springframework.stomp.StompMessage;
import org.springframework.stomp.server.Subscription;

/**
 *
 * @author Rossen Stoyanchev
 * @since 4.0
 */
public class EchoStompHandler implements StompHandler {

	private static final Log logger = LogFactory.getLog(EchoStompHandler.class);


	@Override
	public void handleSend(StompMessage message) {
		logger.debug("Received " + message);
	}

	@Override
	public void handleSubscription(Subscription subscription) {
		try {
			subscription.sendMessage("Hello stomp");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
