package com.bitc.sec.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSocket
// 지정된 요청 경로로 client와 고정된 통신을 등록 하는 class
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
	
	private final ChatHandler chatHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// js로 전달된 데이터의 end point 지정
		registry.addHandler(chatHandler, "/chatHandler").withSockJS();
	}

}

















