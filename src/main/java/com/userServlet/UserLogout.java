package com.userServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserLogout")
public class UserLogout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			session.removeAttribute("userObj");

			session.setAttribute("successMsg", "Thank You!! You have successfully logged out.");

			resp.sendRedirect("user_login.jsp");

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [userServlet.UserLogout.java] while running the method protected void doGet(){} "
							+ e);
		}
	}

}
