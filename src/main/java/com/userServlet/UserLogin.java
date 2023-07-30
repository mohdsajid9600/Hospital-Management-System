package com.userServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoServlet.UserDao;
import com.dbConnection.DBConnection;
import com.entity.UserEntity;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String UserEmail = req.getParameter("loginemail");
			String UserPassword = req.getParameter("loginpassword");

			HttpSession session = req.getSession();
			UserDao dao = new UserDao(DBConnection.MakeCon());

			UserEntity user = dao.getUserDetails(UserEmail, UserPassword);

			if (user != null) {
				System.out.println("[userServlet.UserLogin.java]--The " + user.getFullname()
						+ " has been successfully login into the doctor login page ");
				session.setAttribute("userObj", user);
				resp.sendRedirect("index.jsp");
			} else {
				System.out.println("[userServlet.UserLogin.java]--Wrong person try to login into the user login page");
				session.setAttribute("errorMsg", "Opps!!  Invalid User Id and Password.");
				resp.sendRedirect("user_login.jsp");

			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [userServlet.UserLogin.java] while running the method protected void doPost(){} "
							+ e);
		}

	}

}
