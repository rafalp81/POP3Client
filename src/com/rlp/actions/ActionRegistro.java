package com.rlp.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rlp.DB.DBUtil;

public class ActionRegistro extends Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		DBUtil db = new DBUtil();
		db.actualiza("insert into usuarios values ('" + nombre + "','" + usuario + "','" + password + "')");
		db.cierraConexion();
		request.setAttribute("MSG", "Usuario creado con éxito. Por favor, inicie sesión.");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
