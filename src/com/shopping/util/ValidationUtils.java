package com.shopping.util;

public class ValidationUtils {
	/*
	 * 문자열(str) 빈 값 체크(null+공백)
	 */
	public static void requireNonEmpty(String str, String message) {
		if (message == null || str.trim().isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void requireMinLength(String str, int minLength, String message) {
		requreNonNull(str,message);
		if (str.length()<minLength) {
			throw new IllegalArgumentException(message);
		}
	}

	private static void requreNonNull(String obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
	}

}

	