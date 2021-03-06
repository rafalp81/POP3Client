package com.rlp.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rlp.DB.DBUtil;
import com.rlp.actions.Action;
import com.rlp.actions.ActionList;
import com.rlp.actions.ActionLogin;
import com.rlp.actions.ActionNoAction;
import com.rlp.actions.ActionNoLogged;
import com.rlp.actions.ActionRegistro;
import com.rlp.actions.ActionUpdate;


/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Hashtable<String, Action> actions = new Hashtable<String, Action>();
	
	
	
    @Override
	public void init() throws ServletException {
		super.init();
		
		actions.put("LIST", new ActionList());
		actions.put("UPDATE", new ActionUpdate());
		actions.put("NO_ACTION", new ActionNoAction());
		actions.put("LOGIN", new ActionLogin());
		actions.put("NO_LOGGED", new ActionNoLogged());
		actions.put("REGISTRO", new ActionRegistro());
		
		//Inicialización de la base de datos
		DBUtil db = new DBUtil();
		db.inicializaDB();
		db.cierraConexion();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionId = request.getParameter("ACTION_ID"); 
		
		Action action = actions.get(actionId);
		
		//Si la accion no se encuentra en el listado de disponibles
		if (action == null){
			action = actions.get("NO_ACTION");
			
		//Si el usuario no est� logueado y la accion no es la de login, se le bloquea el acceso	
		}else if(request.getSession().getAttribute("LOGGED")==null && !actionId.equals("LOGIN")){
			action = actions.get("NO_LOGGED");
		}
		
		action.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
