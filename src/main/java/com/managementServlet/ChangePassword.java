package com.managementServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoServlet.ManagementDao;
import com.dbConnection.DBConnection;

@WebServlet("/mngeChangePassword")
public class ChangePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int uid = Integer.parseInt(req.getParameter("uid"));
			String currentPassword = req.getParameter("currentPassword");
			String newPassword = req.getParameter("newPassword");

			HttpSession session = req.getSession();
			ManagementDao dao = new ManagementDao(DBConnection.MakeCon());

			if (dao.checkCurrentPassword(uid, currentPassword)) {
				if (dao.setNewPassword(uid, newPassword)) {
					System.out.println(
							"[managementServlet.ChangePassword.java]-- Management login password have been changed successfully.");
					session.removeAttribute("managementObj");
					session.setAttribute("SuccessMsg", "Your password have been changed successfully.");
					resp.sendRedirect("management_login.jsp");
				} else {
					System.out.println(
							"[managementServlet.ChangePassword.java]-- Something went wrong on server to change password by management login page please do correct..");
					session.setAttribute("errorMsg", "Something went wrong on server please try again after sometime.");
					resp.sendRedirect("management/changePassword.jsp");
				}
			} else {
				System.out
						.println("[managementServlet.ChangePassword.java]-- Please fill the correct current password.");
				session.setAttribute("errorMsg", "Please fill the correct old password.");
				resp.sendRedirect("management/changePassword.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [managementServlet.ChangePassword.java] while running the method protected void doPost(){} "
							+ e);
		}
	}

}
