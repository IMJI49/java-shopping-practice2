package com.shopping.test;

import java.io.File;

import com.shopping.model.User;
import com.shopping.service.UserService;

public class RegisterTest {

	public static void main(String[] args) {
		new File("data").mkdir();
		UserService userService = new UserService();
		// 테스트 1 : 정상 회원가입
		System.out.println("1. 정상 회원 가입 테스트");
		try {
			User user = userService.register("testuser1", "pass1234", "테스트유저1");
			System.out.println("성공 : "+ user.getName()+"잔액 : "+user.getBalance()+"원");
			
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
		try {
			userService.register("testuser1", "pass5678", "테스트유저2");
			System.out.println("오류 : 중복 ID 허용됨!");
		} catch (Exception e) {
			System.out.println("정상 : 중복 ID 거부됨 -"+e.getLocalizedMessage());
			System.err.println(e.getLocalizedMessage());
		}
	}

}

	