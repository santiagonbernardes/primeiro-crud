package br.com.santiago.controle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santiago.controle.controlador.Controlador;

@WebServlet(value = "/crud", name="DispatcherServlet")
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao;
		
		if(request.getAttribute("novaAcao") != null) {
			acao = (String) request.getAttribute("novaAcao");
		} else {
			acao = request.getParameter("acao");
		}
		
		String caminho = "br.com.santiago.controle.controlador." + acao;

		try {
			Class classe = Class.forName(caminho);
			Controlador controlador = (Controlador) classe.newInstance();
			String proximaPagina = controlador.executa(request, response);

			request.getRequestDispatcher(proximaPagina).forward(request, response);

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		} catch (InstantiationException e) {
			throw new RuntimeException(e.getMessage());
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
