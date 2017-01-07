package br.com.common.util;

import java.util.Random;

public class PasswordUtils {

	private PasswordUtils() {
	}
	
	public static String random(int maxBlocks, int blockSize) {
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < maxBlocks; i++) {
			for (int j = 0; j < blockSize; j++) {
				int random = new Random().nextInt(9);
				stringBuilder.append(random);
			}
			if (i + 1 < maxBlocks) {
				stringBuilder.append("-");
			}
		}

		return stringBuilder.toString();
	}
}
