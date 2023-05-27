package com.coding.web.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Random
 */
@WebServlet("/")
public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        //String name = request.getParameter("name");
        //session.setAttribute("number", 1);
        if(session.getAttribute("number") == null) {
        	session.setAttribute("number", 1);
        }else {
        	session.setAttribute("number", (int)session.getAttribute("number")+1);
        }
        request.setAttribute("number", session.getAttribute("number"));
        System.out.println(session.getAttribute("number"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, YYYY - HH:mm a");  
        LocalDateTime now = LocalDateTime.now(); 
        request.setAttribute("fecha", dtf.format(now));
        
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
        StringBuilder sb = new StringBuilder(10);
         for (int i = 0; i < 10; i++) {
          int index = (int)(AlphaNumericString.length() * Math.random());
          sb.append(AlphaNumericString.charAt(index));
         }
         request.setAttribute("word", sb.toString());
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);
	}


}
