package com.shopping.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/*
 * 파일 입출력을 담당하는 유틸리티 클래스
 * Persistence Layer의 핵심 컴포넌트 
 */
public class FileManager {
	// data디렉토리 경로
	private static final String DATA_DIR = "data";
	/*
	 * 파일에서 객체 리스트 읽기
	 */
	public static<T> List<T> readFromFile(String fileName) {
		// 파일 경로
		String fullPath = normalizePath(fileName);
		File file = new File(fullPath);
		// 파일이 존재하지 않는 경우
		if (!file.exists()) {
			System.err.println("파일이 존재하지 않습니다 : "+fullPath);
			System.out.println("빈 리스트를 반환합니다.");
			return new ArrayList<T>();
		}
		// 비어 있는 경우
		if (file.length() == 0) {
			System.err.println("파일이 비어 있습니다.");
			return new ArrayList<T>();
		}
		// 파일 읽기
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			@SuppressWarnings("unchecked")
			List<T> data = (List<T>) ois.readObject();
			System.out.println("파일 읽기 성공 : "+ fullPath+" ("+data.size()+"개 항목)");
			return data;
		} catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
//			e.printStackTrace();
			return new ArrayList<T>();
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
			return new ArrayList<T>();
		}
	}
	// 파일 경로 정규화
	/*
	 * - 파일 경로를 표준 형태로 만들어 주는 것
	 * - 비유) 서울시 마포구 
	 * 			서울 \ 마포
	 * 			서울 / 마포
	 * 	- data\\user.dat
	 * 	- data/users.dat
	 */
	// 운영체제 상관없이 올바른 경로 바환
	private static String normalizePath(String fileName) {
		// 이미 경로가 포함된 경우 그대로 반환
		if (fileName.contains(File.separator)||fileName.contains("/")||fileName.contains("\\")) {
			return fileName;
		}
		// data 디렉토리 경로 추가
		return DATA_DIR + File.separator+fileName;
			
	}
	public static <T> void writeToFile(String fileName, List<T> data) {
		if (data == null) {
			System.err.println("[FileManager] 저장할 데이터가 null입니다.");
			return;
		}
		// 파일 경로
		String fullpath = normalizePath(fileName);
		File file = new File(fullpath);
		
		// 부모 디렉토리 확인 및 생성
		File parentDir = file.getParentFile();
		if (parentDir != null && !parentDir.exists()) {
			Boolean created = parentDir.mkdirs();
			if (created) {
				System.out.println("디렉토리 생성 : "+parentDir.getPath());
			}
		}
		// 파일 저장 시도
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
			oos.writeObject(data);
			oos.flush(); // 버퍼 강제 flush
			System.out.println("파일 저장 성공 : "+ fullpath+"("+data.size()+"개 항목)");
		} catch (IOException e) {
			System.err.println("파일 저장 실패 : "+fullpath);
			System.err.println("오류 내용 : "+e.getLocalizedMessage());
//			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
}

	