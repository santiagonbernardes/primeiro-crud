package br.com.santiago.controle.controlador;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santiago.modelo.dao.ClienteDAO;
import br.com.santiago.modelo.entities.Cliente;

public class FormClienteController implements Controlador {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("id") != null) {
			ClienteDAO dao = new ClienteDAO((Connection) request.getAttribute("conexao"));
			
			Cliente cliente = dao.searchById(Long.parseLong(request.getParameter("id")));
			request.setAttribute("cliente", cliente);
		}
		
		return "/crud?acao=ListaClientesController";
	}

}
