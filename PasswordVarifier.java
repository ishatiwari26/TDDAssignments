package com.yash.controller;

public class PasswordVarifier {
	private int flagAnyThreeOk = 0;

	private String passwordRegx = "^(?=.+[a-z])(?=.*[A-Z])(?=.*\\d).*\\w{9,}$";
	private String passwordLoweCaseRegx = "(?=.*[a-z]).+";
	private String passwordUpperCaseRegx = "(?=.*[A-Z]).+";
	private String passwordNumberRegx = "[0-9].+";
	private String passwordLengthRegx = "\\w{9,}";

	public boolean verify(String password) {

		if (password == null) {
			throw new NullPointerException("Password should not be null.");
		}
		if (!(password.matches(passwordLoweCaseRegx) || password.matches(passwordRegx))) {
			throw new RuntimeException("Password character lower case.");
		}

		flagAnyThreeOk = password.matches(passwordLoweCaseRegx)
				&& (password.matches(passwordUpperCaseRegx) || password.matches(passwordRegx)) ? flagAnyThreeOk + 1
						: flagAnyThreeOk;
		flagAnyThreeOk = password.matches(passwordLoweCaseRegx)
				&& (password.matches(passwordNumberRegx) || password.matches(passwordRegx)) ? flagAnyThreeOk + 1
						: flagAnyThreeOk;
		flagAnyThreeOk = password.matches(passwordLoweCaseRegx)
				&& (password.matches(passwordLengthRegx) || password.matches(passwordRegx)) ? flagAnyThreeOk + 1
						: flagAnyThreeOk;
		if (flagAnyThreeOk == 1)
			return true;
		else if (flagAnyThreeOk > 2)
			throw new RuntimeException("Password is ok.");
		else
			throw new RuntimeException("Password never ok.");

	}
}
