package com.doctorServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoServlet.AppointmentDao;
import com.dbConnection.DBConnection;

@WebServlet("/updateComment")
public class UpdateComment extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int apointId = Integer.parseInt(req.getParameter("apointId"));
			int doctorId = Integer.parseInt(req.getParameter("doctorId"));
			String status = "Completed";

			AppointmentDao dao = new AppointmentDao(DBConnection.MakeCon());
			HttpSession session = req.getSession();

			if (dao.updateStatus(apointId, doctorId, status)) {
				System.out.println(
						"[doctorServlet.UpdateComment.java]-- Update status into the appointment_details database by login of Doctor page ");
				session.setAttribute("successMsg", "Thank You!! Appointment successfully Completed");
				resp.sendRedirect("doctor/patient.jsp");
			} else {
				System.out.println(
						"[doctorServlet.UpdateComment.java]--Something went wrong on server to update the status of appointment by the Doctor, please do correct.");
				session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
				resp.sendRedirect("doctor/commentPage.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [doctorServlet.UpdateComment.java] while running the method protected void doPost(){} "
							+ e);
		}

	}

}
