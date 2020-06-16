package com.java.functional;

import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidation {
	static Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
	
	static Function<String, Result> emailChecker = f -> 
		f == null ? new Result.Failure("Email must not be null"):
		f.length() == 0 ?  new Result.Failure("Email should not be empty"):
		emailPattern.matcher(f).matches() ?  new Result.Success():
		new Result.Failure("Email is invalid");
	;
	
	/**
	 * @param args
	 */
	public static void main(String... args) {
		validate("neha2185@gmail.com").exec123();
		validate("").exec123();
		validate(" ").exec123();
		validate(null).exec123();
	}
	
	static Executable validate(String s) {
		Result result = emailChecker.apply(s);
		return (result instanceof Result.Success) ? () -> sendEmailVerification(s) : () -> logError(((Result.Failure)result).getMessage()); 
	}
	
	static void sendEmailVerification(String s) {
		System.out.println("Email sent to " + s);
	}
	
	static void logError(String s) {
		System.out.println("Error message logged : " + s);		
	}
}
