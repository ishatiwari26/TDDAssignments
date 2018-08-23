package com.yash.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.yash.controller.PasswordVarifier;

public class PasswordVarifierTest {
	private PasswordVarifier passwordVerifier = new PasswordVarifier();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void shouldVerifyPasswordWhenCharLengthIs8() {
		Boolean result = passwordVerifier.verify("passwords");
		System.out.println(result);
		Assert.assertEquals(true, result);
	}

	@Test
	public void shouldVerifyPasswordWhenPasswordNull() {
		exception.expect(NullPointerException.class);
		exception.expectMessage("Password should not be null.");
		passwordVerifier.verify(null);
	}

	@Test
	public void shouldVerifyWhenHaveAtLeastOneUpperCaseLetter() {
		Boolean result = passwordVerifier.verify("pAssWord");
		System.out.println(result);
		Assert.assertEquals(true, result);
	}

	@Test
	public void shouldVerifyWhenHaveAtLeastOneLowerCaseLetter() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("Password character lower case.");
		passwordVerifier.verify("123");
	}

	@Test
	public void shouldVerifyWhenHaveAtLeastOneNumber() {
		Boolean result = passwordVerifier.verify("pass14566");
		System.out.println(result);
		Assert.assertEquals(true, result);
	}

	@Test
	public void shouldPasswordOKWhenHaveAtLeastThreeConditionVerify() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("Password is ok.");
		passwordVerifier.verify("Pass1word");
	}

	@Test
	public void shouldThrowExceptionWhenHaveLowerCaseNotSatisfy() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("Password never ok.");
		passwordVerifier.verify("pass");
	}

}
