package com.cos.blogapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cos.blogapp.handler.SessionInterceptor;

//최초실행시 webmcvconfigure를 Ioc컨테이너에서 먼저 찾기때문에 Ioc컨테이너등록해야됨
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	public WebMvcConfig() {
		//System.out.println("webMvcConfig 실행됨");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//System.out.println("디스패쳐 서블릿이 실행시켜서 인터셉트 설정완료");
		//의존성 주입이 가능하나 딴곳에서 쓸것이아니여서 할필요가없음
		//인증필요한것 /board/1/comment
		//api/board/1 과같이 인증필요한것에 api만 붙혀줌으로 글로벌하게 조절
		registry.addInterceptor(new SessionInterceptor())
			.addPathPatterns("/hello");
		
	}
}
