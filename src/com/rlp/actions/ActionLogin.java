package com.rlp.actions;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rlp.DB.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionLogin extends Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("USER");
		String pass = request.getParameter("PASS");
		DBUtil db = new DBUtil();
		ResultSet rs = db.consulta("select password from usuarios where usuario='" + user + "'");
		try {
			if(rs.next()){
				String password = rs.getString("password");
				if(password.equals(pass)){
					request.getSession().setAttribute("LOGGED", true);
					request.getSession().setAttribute("USERNAME", user);
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}else{
					request.setAttribute("MSG", "Error en el login");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("MSG", "El usuario indicado no existe");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.cierraConexion();
		}
	}

}
