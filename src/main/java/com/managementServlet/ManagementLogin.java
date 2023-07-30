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
import com.entity.MangeEntity;

@WebServlet("/ManagementLogin")
public class ManagementLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String Memail = req.getParameter("management_email");
			String Mpassword = req.getParameter("management_password");

			HttpSession session = req.getSession();
			ManagementDao dao = new ManagementDao(DBConnection.MakeCon());

			MangeEntity mEntity = dao.forManagementLogin(Memail, Mpassword);

			if (mEntity != null) {
				System.out.println(
						"[managementServlet.ManagementLogin.java]-- Anyone person login into Management login page successfully.");
				session.setAttribute("managementObj", mEntity);
				resp.sendRedirect("management/index.jsp");
				
			} else {
				System.out.println(
						"[managementServlet.ManagementLogin.java] -- Wrong user try to login in management login page.");
				session.setAttribute("errorMsg", "OOPs!! Invalid User Id & Password");
				resp.sendRedirect("management_login.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [managementServlet.ManagementLogin.java] while running the method protected void doPost(){} "
							+ e);
		}

	}

}
