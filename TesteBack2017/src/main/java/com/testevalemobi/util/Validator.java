package com.testevalemobi.util;

import java.util.InputMismatchException;

public class Validator {
	
	public static boolean isValido(String cpfcnpj){
		if(cpfcnpj.length() > 11){
			return validaCnpj(cpfcnpj);
		}
		return validaCpf(cpfcnpj);
	}
	
	/**
	 * Metodo que valida um cpf
	 * @param cpf
	 * @return retorna true caso o cpf seja valido, ou false caso o cpf seja
	 * invalido
	 */
	private static boolean validaCpf(String cpf){
		if(cpf.equals("00000000000") || cpf.equals("11111111111") ||
		   cpf.equals("22222222222") || cpf.equals("33333333333") ||
		   cpf.equals("44444444444") || cpf.equals("55555555555") ||
		   cpf.equals("66666666666") || cpf.equals("77777777777") ||
		   cpf.equals("88888888888") || cpf.equals("99999999999") ||
		   (cpf.length() != 11)){
			return false;
		}
		
		char digito10, digito11;
		int peso;
		
		try{
			//calcular primeiro digito verificador
			peso = 10;
			digito10 = calculaDigitoVerificadorCpf(produtoEscalarCpf(cpf, peso));
			
			//calcular segundo digito verificador
			peso = 11;
			digito11 = calculaDigitoVerificadorCpf(produtoEscalarCpf(cpf, peso));
			
			if(digito10 == cpf.charAt(9) && digito11 == cpf.charAt(10)){
				return true;
			}
			return false;
			
		} catch(InputMismatchException e){
			return false;
		}	
	}
	
	/**
	 * Metodo que valida um cnpj
	 * @param cnpj
	 * @return retorna true caso o cnpj seja valido, ou false caso o cnpj seja
	 * invalido 
	 */
	private static boolean validaCnpj(String cnpj){
		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || 
			cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || 
			cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
			cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || 
			cnpj.equals("88888888888888") || cnpj.equals("99999999999999") || 
			(cnpj.length() != 14)) {
			return(false);
		}
		
		char digito13, digito14;
		try{
			
			digito13 = calculaDigitoVerificadorCnpj(produtoEscalarCnpj(cnpj, 11));
			digito14 = calculaDigitoVerificadorCnpj(produtoEscalarCnpj(cnpj, 12));
			
			if(digito13 == cnpj.charAt(12) && digito14 == cnpj.charAt(13)){
				return true;
			}
			return false;
		} catch(InputMismatchException e){
			return false;
		}
	}
	
	private static int produtoEscalarCpf(String cpf, int peso){
		int soma = 0, numero, lenght=peso-1;
		for(int i=0; i < lenght; i++){
			numero = (int) (cpf.charAt(i)-48);
			soma += (numero * peso);
			peso -= 1;
		}
		return soma;
	}
	
	private static char calculaDigitoVerificadorCpf(int soma){
		int resto;
		resto = soma % 11;
		
		if(resto < 2){
			return '0';
		} 
		return (char) ((11-resto)+48);
	}
	
	private static int produtoEscalarCnpj(String cnpj, int tamanho){
		int soma = 0, peso = 2, numero;
		
		for(int i = tamanho; i>=0;i--){
			numero = (int)(cnpj.charAt(i)-48);
			soma += (numero * peso);
			peso += 1;
			if(peso == 10){
				peso = 2;
			}
		}
		return soma;
	}
	
	private static char calculaDigitoVerificadorCnpj(int soma){
		int resto;
		resto = soma % 11;
		if(resto == 0 || resto == 1)
			return '0';
		return (char)((11-resto) + 48);
	}

}
