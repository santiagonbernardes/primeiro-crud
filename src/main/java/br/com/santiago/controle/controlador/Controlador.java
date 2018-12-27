package br.com.santiago.controle.controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controlador {
	
	String executa(HttpServletRequest request, HttpServletResponse response);

}
