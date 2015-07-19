package amg.start.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		writer.print("<font size=\"12px\" color=\"" + color + "\">" + "Hellow World" + "</font>");

	}

}
