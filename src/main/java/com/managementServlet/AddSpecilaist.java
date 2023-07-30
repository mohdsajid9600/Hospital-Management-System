package com.managementServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoServlet.SpecialistDao;
import com.dbConnection.DBConnection;

@WebServlet("/addSepcialist")
public class AddSpecilaist extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String scpeName = req.getParameter("scpeName");

			SpecialistDao SDao = new SpecialistDao(DBConnection.MakeCon());

			Boolean f = SDao.addSpecialist(scpeName);
			HttpSession session = req.getSession();

			if (f) {
				System.out.println(
						"[managementServlet.AddSpecialist.java]-- New record added of Specialist details in specialist_table database successfully by management login.");
				session.setAttribute("successMsg", "Thank You!!  New Specialist Added Successfully");
				resp.sendRedirect("management/index.jsp");

			} else {
				System.out.println(
						"[managementServlet.AddSpecialist.java]-- Something went wrong on server to add Specialist by management addspecialist page.");
				session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
				resp.sendRedirect("management/index.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [managementServlet.AddSpecialist.java] while running the method protected void doPost(){} "
							+ e);
		}

	}

}