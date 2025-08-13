package com.shopping;

import com.shopping.comtroller.MainController;

/*
 * == 메인 메뉴 ==
 * 로그인 되지 않음
 * 
 * 1. 사용자 관리
 * 2. 상품 보기
 * 3. 주문 관리
 * 0. 종료
 * 
 * 선택 : 1
 * 
 * == 사용자 관리 메뉴 ==
 * 1. 회원가입
 * 2. 로그인
 * 3. 로그아웃
 * 4. 내 정보 보기
 * 0. 돌아가기
 * 선택 : 1
 * 
 * == 회원 가입 ==
 * 아이디 : 3자이상 영문.숫자 :
 * 패스워드 4자이상 : 
 * 이름 : 
 * 
 * 새로 생성됩니다.
 * 새 사용자 등록!
 * 회원가입 성공!
 * 
 * 환영합니다 [사용자]님!
 * 초기 잔액 : 10000원
 * 
 * == 로그인 ==
 * 아이디 : 
 * 패스워드 : 
 * [FileManager] 파일 읽기 성공 : data\\users.dat
 * [UserServicr] 로그인 성공 : user001
 * 세션 생성 : user001님 로그인
 * 로그인 성공!
 * 		환영합니다, user001님!
 */
/*
 * 구현 완료 순서
 * 	1) Model Layer
 * 		- User.java
 * 		- serializable 구현
 * 	2) Persistence Layer
 * 		- Filemanager.java
 * 	3) Repository Layer
 * 		- UserRepository.java
 * 		- CRUD 메소드 구현
 * 	4) Service Layer
 * 		- 비지니스 로직 구현
 * 		- 예외 처리 구현
 * 	5) Util Layer
 * 		- Constant.java
 * 	6) Controller Layer
 * 		- UserController.java		- 회원 가입 테스트
 * 	7) Main Application
 * 		- Main.java
 */
/*
 * 로그인 기능의 주요 요구사항
 * 	- 사용자 ID와 비밀번호를 통한 인증
 * 	- 세션 관리를 통한 로그인 상태 유지
 * 	- 파일 시스템 기반 사용자 데이터 영속성
 * 	- 예외 처리 및 유효성 검
 * * 로그인 프로세스 흐름
 * 	- UI Layer : 사용자로부터 ID/PW 입력 받기
 * 	- Controller : 입력값 유효성 검증
 * 	- Service : 비지니스 로직 처리(인증
 * 	- Repository : 사용자 데이터 조회
 * 	- FileManager : 파일에서 데이터 로드
 * 	- SessionManager : 로그인 세션 생성
 */
public class Main {

	public static void main(String[] args) {
		// 메인 컨트롤러 인스턴스 생성
		MainController mainController = new MainController();
		mainController.start();
	}

}












	