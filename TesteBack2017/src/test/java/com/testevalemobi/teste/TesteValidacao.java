package com.testevalemobi.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.testevalemobi.util.Validator;

public class TesteValidacao {
	
	@Test
	public void validaCpf(){
		assertTrue(Validator.isValido("87763351519"));
		assertFalse(Validator.isValido("00000000000"));
		assertFalse(Validator.isValido("11111111111"));
		assertFalse(Validator.isValido("22222222222"));
		assertFalse(Validator.isValido("33333333333"));
		assertFalse(Validator.isValido("44444444444"));
		assertFalse(Validator.isValido("55555555555"));
		assertFalse(Validator.isValido("66666666666"));
		assertFalse(Validator.isValido("77777777777"));
		assertFalse(Validator.isValido("88888888888"));
		assertFalse(Validator.isValido("99999999999"));
	}
	
	@Test
	public void validaCnpj(){
		assertTrue(Validator.isValido("42893581000188"));
		assertFalse(Validator.isValido("00000000000000"));
		assertFalse(Validator.isValido("11111111111111"));
		assertFalse(Validator.isValido("22222222222222"));
		assertFalse(Validator.isValido("33333333333333"));
		assertFalse(Validator.isValido("44444444444444"));
		assertFalse(Validator.isValido("55555555555555"));
		assertFalse(Validator.isValido("66666666666666"));
		assertFalse(Validator.isValido("77777777777777"));
		assertFalse(Validator.isValido("88888888888888"));
		assertFalse(Validator.isValido("99999999999999"));
	}
}
