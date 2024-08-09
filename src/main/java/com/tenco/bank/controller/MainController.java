package com.tenco.bank.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tenco.bank.handler.exception.DataDeliveryException;
import com.tenco.bank.handler.exception.RedirectException;
import com.tenco.bank.handler.exception.UnAuthorizedExecption;

@Controller	// Ioc 대상(싱그톤 패턴 관리가 된다.)  --> 제어의 역전
public class MainController {
	
	// REST API 기반으로 주소설계 가능
	
	// 주소설계
	// http://localhost:8080/main-page
	
	@GetMapping({"/main-page", "/index"})
	public String mainPage() {
		System.out.println("mainPage() 호출 확인");
		// [JSP 파일 찾기 (yml 설정)] - 뷰 리졸버
		// prefix: /WEB-INF/view
		//		   /main
		// suffix: .jsp
		
		return "/main";
	}
	
	@GetMapping("/error-test1")
	public String errorPage() {
		if(true) {
			throw new RedirectException(("잘못된 요청입니다."), HttpStatus.NOT_FOUND);
		}
		return "/main";
	}
	
	@GetMapping("/error-test2")
	public String errorData2() {
		if(true) {
			throw new DataDeliveryException("잘못된 데이터 입니다.", HttpStatus.BAD_REQUEST);
		}
		return "/main";
	}
	
	@GetMapping("/error-test3")
	public String errorData3() {
		if(true) {
			throw new UnAuthorizedExecption("인증 안된 사용자 입니다.", HttpStatus.UNAUTHORIZED);
		}
		return "main";
	}
	
}
