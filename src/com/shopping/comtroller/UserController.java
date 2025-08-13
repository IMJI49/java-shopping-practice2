package com.shopping.comtroller;
/*
 * 사용자 관련 UI를 담당하는 컨트롤러
 * Presentation Layer의 일부로 사용자 입력을 받고 결과를 표시
 */

import java.util.Scanner;

import com.shopping.model.User;
import com.shopping.service.UserService;

public class UserController {
	private UserService service;
	private Scanner scanner;
	public UserController() {
		this.service = new UserService();
		this.scanner = new Scanner(System.in);
	}
	public void showUserMenu() {
		while (true) {
			System.out.println("\n== 사용자 메뉴 ==");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 로그아웃");
			System.out.println("4. 내정보 보기");
			System.out.println("0. 돌아가기");
			System.out.print("선택 : ");
			String choice = scanner.nextLine();
			// 사용자 선택에 따른 메소드 호출
			switch (choice) {
			case "0":
				return;
			case "1":
				register();
				break;

			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
		
	}
	// 회원가입 처리
	private void register() {
		System.out.println("\n== 회원 가입 ==");
		// 아이디 입력
		System.out.print("아이디 (3자이상, 영문/숫자) : ");
		String id = scanner.nextLine();
		//입력 검증
		
		// 패스워드 입력
		System.out.print("패스워드 (4자 이상) : ");
		String password = scanner.nextLine();
		// 입력 검증
		
		// 이름 입력 받기
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		try {
			User user = service.register(id, password, name);
			System.out.println("회원 가입 성공!");
			System.out.println("환영합니다 "+user.getName()+"님!");
			System.out.println("초기 잔액 : "+user.getBalance()+" 원");
			
		} catch (Exception e) {
			System.err.println("회원 가입 실패 : "+e.getLocalizedMessage());
		}
		
	}
}

	