package com.infotech.client2;

public class ResourceManagement {

	public static void main(String[] args) throws Exception {
		try {
			tryWithResourceManagementException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			normalTryCatchException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void normalTryCatchException() throws Exception {
		MyResource myResource = null;
		try {
			myResource = new MyResource();
			System.out.println("----------------------------------------");
			System.out.println("MyResource created in try block");
			if (true)
				throw new Exception("Exception in try block");
		} finally {
			if (myResource != null)
				myResource.close();
		}

	}

	private static void tryWithResourceManagementException() throws Exception {
		try (MyResource myResource = new MyResource()) {
			System.out.println("MyResource created in try-with-resources");
			if (true)
				throw new Exception("Exception in try");
		}
	}
}