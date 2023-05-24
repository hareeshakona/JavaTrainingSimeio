package com.simeio.fun;

public class Converter {
	
	void convertFile(String filename, ICompressor compressor) {
		System.out.println("Convert file :"+filename);
		compressor.compressFile(filename);
		System.out.println("Completed");
	}

}
