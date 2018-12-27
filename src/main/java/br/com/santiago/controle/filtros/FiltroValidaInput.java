package br.com.santiago.controle.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.santiago.utils.Util;

@WebFilter(servletNames = "DispatcherServlet")
public class FiltroValidaInput implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request.getParameter("acao").equalsIgnoreCase("ManipulaClienteController")) {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String dataNascimento = request.getParameter("dataNascimento");
			String id = null;
			if(request.getParameter("id") != null) {
				id = request.getParameter("id");
			}

			if (!Util.validaNome(nome) || !Util.validaEmail(email) || !Util.validaDataNascimento(dataNascimento)) {
				request.setAttribute("nome", nome);
				request.setAttribute("email", email);
				request.setAttribute("dataNascimento", dataNascimento);
				request.setAttribute("novaAcao", "ListaClientesController");
				if(id != null) {
					request.setAttribute("id", id);
				}

				if (!Util.validaNome(nome)) {
					request.setAttribute("erroNome", "Nome inválido. O nome completo pode ser composto por 3 nomes.");
				}
				if (!Util.validaEmail(email)) {
					request.setAttribute("erroEmail", "Email inválido.");
				}
				if (!Util.validaDataNascimento(dataNascimento)) {
					request.setAttribute("erroDataNascimento", "Data inválida. Formato: dd/mm/aaaa");
				}

			}

		}

		chain.doFilter(request, response);

	}
}
