package com.managementServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoServlet.UserDao;
import com.dbConnection.DBConnection;

@WebServlet("/deleteUserDetails")
public class DeleteUserDetails extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int userId = Integer.parseInt(req.getParameter("id"));

			UserDao uDao = new UserDao(DBConnection.MakeCon());
			HttpSession session = req.getSession();

			if (uDao.DeleteUserById(userId)) {

				System.out.println(
						"[managementServlet.DeleteUserDetails.java]-- Delete the particular user details into the user_details database successfully by management login.");
				session.setAttribute("successMsg", "Alert!! User Deleted successfully by You.");
				resp.sendRedirect("management/userDetails.jsp");
				
			} else {

				System.out.println(
						"[managementServlet.DeleteUserDetails.java]-- Something went wrong on server to delete User by mangement login please do correct.");
				session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
				resp.sendRedirect("management/userDetails.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [managementServlet.DeleteUserDetails.java] while running the method protected void doGet(){} "
							+ e);
		}

	}

}
