package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			contacts(request, response);
		} else if(action.equals("/insert")){
			newContact(request, response);
		}
		response.sendRedirect("index.html");
	}

	protected void contacts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<JavaBeans> list = dao.findAll();
		
		request.setAttribute("contacts", list);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}
	
	protected void newContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			JavaBeans contact = new JavaBeans();
			contact.setNome(request.getParameter("name"));
			contact.setFone(request.getParameter("phone"));
			contact.setEmail(request.getParameter("email"));
			
			dao.insertContact(contact);
			
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			response.sendRedirect("main");
			return;
		}
	}

}
