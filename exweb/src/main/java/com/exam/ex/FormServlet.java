package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;

/*http://localhost:8000/exweb/dollar?num=10000&unit=dollar
  http://localhost:8000/exweb/dollar?num=10000&unit=won  */
@WebServlet("/form.do")
public class FormServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		String prodval = req.getParameter("prod");
		String fruitval = req.getParameter("fruit");
		String drinkval = req.getParameter("drink"); 
		
		
		
		String piclink="";
		String printfruit="";
		String printdrink="";

		
		
		switch(prodval) {
		case "shoes": piclink = "http://api.lorem.space/image/shoes?w=150&h=150";
			break;
		case "watch": piclink = "http://api.lorem.space/image/watch?w=150&h=150";
			break;
		case "furniture": piclink = "http://api.lorem.space/image/furniture?w=150&h=150";
			break;
		}
		
		switch(fruitval) {
		case "berry": 
			printfruit = "berry";
			break;
		case "peach":
			printfruit = "peach";
			break;
		case "orange":
			printfruit = "orange";
			break;
		}
		
		switch(drinkval) {
		case "coffee": 
			printdrink = "coffee";
			break;
		case "greentea":
			printdrink = "greentea";
			break;
		case "blacktea":
			printdrink = "blacktea";
			break;
		}
	
	
		
		PrintWriter out = resp.getWriter();

		out.println("<html>                   ");
		out.println("<!DOCTYPE html>          ");
		out.println("<head>                   ");
		out.println("<meta charset=\"UTF-8\"> ");
		out.println("<title>Calculater</title>     ");
		out.println("</head>                  ");
		out.println("<body>                   ");
		out.println("<img src="+piclink+">");
	
		out.println("<h1>"+printfruit+"</h1> ");
	
		out.println("<h1>"+printdrink+"</h1> ");
		out.println("</body>                  ");
		out.println("</html>                  ");
	}
}