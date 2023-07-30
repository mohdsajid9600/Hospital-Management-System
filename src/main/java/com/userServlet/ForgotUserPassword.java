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

@WebServlet("/forgotUserPassword")
public class ForgotUserPassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String name = req.getParameter("username");
			String dob = req.getParameter("udob");
			String email = req.getParameter("loginemail");
			String newPassword = req.getParameter("newPassword");

			UserDao dao = new UserDao(DBConnection.MakeCon());
			HttpSession session = req.getSession();

			UserEntity Uentity = dao.forgotUserPassword(name, dob, email);

			if (Uentity != null) {
				int id = Uentity.getId();
				if (dao.setNewPassword(id, newPassword)) {
					System.out.println(
							"[userServlet.ForgotDoctorPassword.java]-- forgotten password change successfully by doctor forgot page.");
					session.setAttribute("successMsg", "Your Password successfully forgotted.");
					resp.sendRedirect("user_login.jsp");
				} else {
					System.out.println(
							"[userServlet.ForgotDoctorPassword.java]-- Something went wrong on server to change the forgot password by user forgot page, please do correct");
					session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
					resp.sendRedirect("forgotUserPassword.jsp");
				}
			} else {
				System.out.println(
						"[userServlet.ForgotDoctorPassword.java]-- Wrong details are being given by the user to change the forgotten password.");
				session.setAttribute("errorMsg", "The Given details is incorrect, Please fill the correct details.");
				resp.sendRedirect("forgotUserPassword.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [userServlet.ForgotDoctorPassword.java] while running the method protected void doPost(){} "
							+ e);
		}
	}

}
