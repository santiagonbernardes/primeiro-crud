package br.com.santiago.utils;

public class Util {
	
	public static boolean validaNome(String nome) {		
		return nome.matches("^\\p{L}{1,10} ?\\p{L}{1,10}? ?\\p{L}{1,10}?$");
	}
	
	public static boolean validaEmail(String email) {
		return email.matches("^\\w{1,20}@\\w{1,10}\\.\\w{2,5}\\.?\\w{1,3}$");
	}
	
	public static boolean validaDataNascimento(String dataNascimento) {
		return dataNascimento.matches("^\\d{2}\\/\\d{2}\\/\\d{4}$");
	}

}
