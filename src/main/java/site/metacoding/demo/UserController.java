package site.metacoding.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController {

	public String user(String username, String password, String email) {
		
		return null;
	}
	
	public String go() {
		return "main.jsp";
	}
	
	public void back(Model model) {
		System.out.println("back");
	}
}
