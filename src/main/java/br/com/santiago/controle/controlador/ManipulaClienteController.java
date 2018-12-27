package br.com.santiago.controle.controlador;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santiago.modelo.dao.ClienteDAO;
import br.com.santiago.modelo.entities.Cliente;

public class ManipulaClienteController implements Controlador {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		Cliente cliente = new Cliente();
		ClienteDAO dao = new ClienteDAO((Connection) request.getAttribute("conexao"));
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		cliente.setDataNascimento(LocalDate.parse(request.getParameter("dataNascimento"), formatador));
		
		if(request.getParameter("id") == null) {
			dao.add(cliente);
		} else {
			cliente.setId(Long.parseLong(request.getParameter("id")));
			dao.update(cliente);
		}		
		return "/crud?acao=ListaClientesController";
	}

}
