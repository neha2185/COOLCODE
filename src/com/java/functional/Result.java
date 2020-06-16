package com.java.functional;

public interface Result {
	public class Success implements Result {}
	public class Failure implements Result {
		private final String errorMsg;
		
		public Failure(String s) {
			errorMsg = s;			
		}
		
		public String getMessage() {
			return this.errorMsg;
		}
		
	}
}
