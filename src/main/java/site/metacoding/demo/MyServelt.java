package site.metacoding.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class Model {
	
	HttpServletRequest request;
	
	public Model(HttpServletRequest request) {
		this.request = request;
	}

	public void addAttribute(String key, Object value) {
		request.setAttribute(key, value);
	}
}


@WebServlet("/demo")
public class MyServelt extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader body = req.getReader();
		System.out.println(body.readLine());
		
		String username = "ssar";
		String password = "1234";
		String email = "ssar@nate.com";
		
		UserController c = new UserController();
		
		c.user(username, password, email);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		String path = req.getParameter("path");
		System.out.println(path);
		
		UserController userController = new UserController();
		if(path.equals("go")) {
			String direct = userController.go();
			RequestDispatcher dis = req.getRequestDispatcher(direct);
			dis.forward(req, resp);
		}else if(path.equals("back")) {
			Model model = new Model(req);
			userController.back(model);
		}
	}

}
