package com.luwei.mvn;

import java.io.File;

public class MvnClean {

	public static void main(String[] args) {

		run();

	}

	private static void run() {

		String dir = "/Users/luwei/xncode";

		File mainDir = new File(dir);

		handleFile(mainDir);

	}

	static void handleFile(File Dir) {

		// System.out.println(Dir.getAbsolutePath());

		File[] files = Dir.listFiles();

		if (null != files && files.length > 0) {

			for (File file : files) {
				if (file.getName().toLowerCase().contains("target")) {
					continue;
				}
				if (file.getName().equalsIgnoreCase("pom.xml")) {
					write(Dir);
				}
				if (file.isDirectory()) {
					handleFile(file);
				}
			}

		}

	}

	private static void write(File dir) {

		System.out.println("cd " + dir.getAbsolutePath() + "; mvn clean;");

	}

}
