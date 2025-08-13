package com.shopping.service;
/*
 * 사용자 관련 비지니스 로직을 처리하는 서비스 클래스
 * 	- 로그인 인증 관리
 * 	- 잔액 관리
 */

import com.shopping.model.User;
import com.shopping.repository.UserRepository;
import com.shopping.util.ValidationUtils;

public class UserService {
	// 데이터 접근을 위한 Repository
	private UserRepository userRepository;

	// UserService 생성자 : UserRepository 인스턴스 생성
	public UserService() {
		userRepository = new UserRepository();
	}

	// 회원 가입 처리 - ID 중복 불가, 패스워드 최소 4자리, 이름 필수, 초기 잔액 10000원 부여
	public User register(String id, String password, String name) {
		// 입력값 검증 (한 곳에 모아서 처리)
		validateRegisterInput(id, password, name);
		// 중복불가
		if (userRepository.existsByID(id)) {
			throw new RuntimeException("이미 존재하는 id입니다: "+id);
		}
		// user 객체 생성
		User user = new User(id, password, name.trim());

		// Repository 기능 호출
		User savedUser = userRepository.save(user);

		System.out.println("새 사용자 목록 : " + savedUser.getId());
		return savedUser;
	}

	/*
	 * 회원가입 입력값 검증
	 */
	private void validateRegisterInput(String id, String password, String name) {
		ValidationUtils.requireNonEmpty(id, "ID를 입력해 주세요");
		ValidationUtils.requireMinLength(password, 4, "패스워드는 최소 4자리 이상이어야 합니다.");
		ValidationUtils.requireMinLength(name, 2, "이름은 최소 2자리 이상이어야 합니다.");
	}

}
