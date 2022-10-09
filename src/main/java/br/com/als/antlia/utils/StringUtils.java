package br.com.als.antlia.utils;

public class StringUtils {

	public static String generateCode(int size) {
		var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		var result = "";
		for (int i = 0; i < size; i++) {
			result += chars.charAt((int) Math.floor(Math.random() * chars.length()));
		}

		return result;
	}
}
