package br.com.santiago.controle.controlador;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santiago.modelo.dao.ClienteDAO;

public class ListaClientesController implements Controlador {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		ClienteDAO dao = new ClienteDAO((Connection) request.getAttribute("conexao"));
		
		request.setAttribute("clientes", dao.getLista());
		
		return "/WEB-INF/views/lista-clientes.jsp";
	}

}
