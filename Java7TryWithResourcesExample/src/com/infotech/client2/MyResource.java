package com.infotech.client2;

public class MyResource implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("Closing MyResource");
		throw new Exception("Exception in Closing");
	}
}