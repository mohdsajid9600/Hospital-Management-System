package com.userServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoServlet.AppointmentDao;
import com.dbConnection.DBConnection;
import com.entity.AppointEntity;

@WebServlet("/bookAppointment")
public class BookAppointment extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int userId = Integer.parseInt(req.getParameter("userid"));
			String name = req.getParameter("fullname");
			String gender = req.getParameter("gender");
			String age = req.getParameter("age");
			String appointDate = req.getParameter("apointDate");
			String email = req.getParameter("email");
			String phoneNo = req.getParameter("phno");
			String diseases = req.getParameter("diseases");
			int doctorId = Integer.parseInt(req.getParameter("doctname"));
			String address = req.getParameter("address");

			AppointEntity apoint = new AppointEntity(userId, name, gender, age, appointDate, email, phoneNo, diseases,
					doctorId, address, "Pending");
			AppointmentDao dao = new AppointmentDao(DBConnection.MakeCon());

			HttpSession session = req.getSession();

			if (dao.insertAppointDetails(apoint)) {
				System.out.println(
						"[userServlet.BookAppointment.java]-- New record added of appointment details in appointment_details database successfully bt user login page.");
				session.setAttribute("successMsg", "Thank you !!! Your Appointment has been successfully booked.");
				resp.sendRedirect("appointment_details.jsp");
			} else {
				System.out.println(
						"[userServlet.BookAppointment.java]-- Something went wrong on server to Make an Appointment details, please do correct.");
				session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
				resp.sendRedirect("bookAppointment.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [userServlet.BookAppointment.java] while running the method protected void doPost(){} "
							+ e);
		}

	}

}
