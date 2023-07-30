package com.managementServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoServlet.DoctorDao;
import com.dbConnection.DBConnection;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int Id = Integer.parseInt(req.getParameter("id"));

			DoctorDao dao = new DoctorDao(DBConnection.MakeCon());
			boolean f = dao.deleteDoctorDetails(Id);

			HttpSession session = req.getSession();

			if (f) {
				System.out.println(
						"[managementServlet.DeleteDoctor.java]---  Delete the particular Doctor details into the doctor_details database successfully by management login.");
				session.setAttribute("successMsg", "Alert!! Doctor Deleted successfully by You.");
				resp.sendRedirect("management/doctorPage.jsp");
			} else {
				System.out.println(
						"[managementServlet.DeleteDoctor.java]-- Something went wrong on server to delete Doctor Details by management page please do correct.");
				session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
				resp.sendRedirect("management/doctorPage.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [managementServlet.DeleteDoctor.java] while running the method protected void doGet(){} "
							+ e);
		}
	}

}
