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

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int uid = Integer.parseInt(req.getParameter("uid"));
			String currentPassword = req.getParameter("currentPassword");
			String newPassword = req.getParameter("newPassword");

			HttpSession session = req.getSession();
			UserDao dao = new UserDao(DBConnection.MakeCon());

			if (dao.checkCurrentPassword(uid, currentPassword)) {
				if (dao.setNewPassword(uid, newPassword)) {
					System.out.println(
							"[userServlet.ChangePasswrod.java]--Anyone user Login password has been changed successfully.");
					session.removeAttribute("userObj");
					session.setAttribute("successMsg", "Your password has been changed successfully.");
					resp.sendRedirect("user_login.jsp");
				} else {
					System.out.println(
							"[userServlet.ChangePasswrod.java]-- Something went wrong on server to change the user login Password please do correct.");
					session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
					resp.sendRedirect("changePassword.jsp");
				}
			} else {
				System.out.println(
						"[userServlet.ChangePasswrod.java]-- anyone user fill the incorrect current password.");
				session.setAttribute("errorMsg", "Please fill the your correct Old password.");
				resp.sendRedirect("changePassword.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [userServlet.ChangePassword.java] while running the method protected void doPost(){} "
							+ e);
		}
	}

}
