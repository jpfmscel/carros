package br.com.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.service.UsuarioService;

@WebServlet("/jsonServlet")
public class JsonServlet extends HttpServlet {

	private static final long serialVersionUID = 2437571978006550234L;

	private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

	@Inject
	private UsuarioService usuarioService;
	
	
	private Logger log = Logger.getGlobal();

	public JsonServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer method = Integer.valueOf(request.getParameter("method"));
		String userid = request.getParameter("userid");
		response.setCharacterEncoding("ISO-8859-1");

		if (method == null) {
			response.getWriter().write("Par�metros insuficientes.");
			return;
		}

		String json = getRequestBody(request);

		log.log(Level.INFO, json);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	private String getRequestBody(HttpServletRequest request) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			String line = "";
			while ((line = br.readLine()) != null) {
				json += line;
			}
		}
		return json;
	}

}
