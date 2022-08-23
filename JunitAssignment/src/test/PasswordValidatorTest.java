package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.infy.exception.InfyAcademyException;

import application.EmailValidator;
import application.PasswordValidator;

public class PasswordValidatorTest {
	
	PasswordValidator passwordValidator;
	
	@BeforeEach
	void setUp() throws Exception {
		passwordValidator = new PasswordValidator();
	}

	@AfterEach
	void tearDown() throws Exception {
		passwordValidator = null;
	}
	
	@Test
	public void validatePasswordValidPassword() throws InfyAcademyException {
		assertTrue(passwordValidator.validatePassword("Asdf123"));
	}
	
	@Test
	public void validatePasswordInvalidPassword() throws InfyAcademyException {
		assertFalse(passwordValidator.validatePassword("Asdf"));
	}
	
	@Test
	public void validatePasswordInvalidPasswordException() throws InfyAcademyException {
		assertThrows(InfyAcademyException.class, () -> passwordValidator.validatePassword(null));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Qwerty", "Qwerty1234", "QwerAsdfZxcvVcxzFdsaRewq", "Zxcvb54321"})
	public void validatePasswordParameterizedPassword(String password) throws InfyAcademyException {
		assertTrue(passwordValidator.validatePassword(password));
	}
}