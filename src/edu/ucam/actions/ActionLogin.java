package edu.ucam.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionLogin extends Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("USER");
		String pass = request.getParameter("PASS");
		
		if ("admin".equals(user)&&"admin".equals(pass)){
			request.getSession().setAttribute("LOGGED", true);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else{
			request.setAttribute("ERROR_MSG", "Error en el login");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
