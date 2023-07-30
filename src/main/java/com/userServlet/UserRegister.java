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

@WebServlet("/userRegister")
public class UserRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String UserName = req.getParameter("username");
			String UserDob = req.getParameter("udob");
			String UserAddress = req.getParameter("uaddress");
			String UserEmail = req.getParameter("useremail");
			String UserPassword = req.getParameter("userpassword");

			UserEntity user = new UserEntity(UserName, UserDob, UserAddress, UserEmail, UserPassword);
			UserDao dao = new UserDao(DBConnection.MakeCon());

			boolean checkQuery = dao.userRegister(user);

			HttpSession session = req.getSession();
			if (checkQuery) {
				System.out.println("[userServlet.UserRegister.java]-- New User Register Successfully.");
				session.setAttribute("successMsg",
						"Thank You!! Your are Register successfully Please login in your Account");
				resp.sendRedirect("user_login.jsp");
			} else {
				System.out.println(
						"[userServlet.UserRegister.java]-- Something went worng on server user not register, please do correct.");
				session.setAttribute("errorMsg", "Something went worng on server please try after sometime.");
				resp.sendRedirect("user_register.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [userServlet.UserRegister.java] while running the method protected void doPost(){} "
							+ e);
		}

	}

}
