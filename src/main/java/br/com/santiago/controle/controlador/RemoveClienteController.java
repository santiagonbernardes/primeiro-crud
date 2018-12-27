package br.com.santiago.controle.controlador;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santiago.modelo.dao.ClienteDAO;
import br.com.santiago.modelo.entities.Cliente;

public class RemoveClienteController implements Controlador {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		Cliente cliente = new Cliente();
		ClienteDAO dao = new ClienteDAO((Connection) request.getAttribute("conexao"));
		
		cliente.setId(id);
		dao.delete(cliente);
		
		return "/crud?acao=ListaClientesController";
	}
}
