package edu.ucam.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionUpdate extends Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title>Hello World</title></head>");
		out.println("<body>");
		out.println("Accion actualizar");		 
		out.println("</body></html>");

	}

}
