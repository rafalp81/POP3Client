package edu.ucam.tags;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class SecurityTag extends TagSupport{
	
	private static final long serialVersionUID = 1L;

    public int doStartTag() throws JspException {
        try{
        	
        	if(pageContext.getSession().getAttribute("LOGGED")==null ){
    			pageContext.forward("nologged.jsp");
    		}       	
        	
        	
        	
        } catch (IOException | ServletException e) {
            throw new JspException ("Error: IOException" + e.getMessage());
        }
        return SKIP_BODY;
    }
	
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}
