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

@WebServlet("/editUserProfile")
public class EditUserProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("uid"));
			String name = req.getParameter("uname");
			String dob = req.getParameter("udob");
			String address = req.getParameter("uaddress");
			String email = req.getParameter("uemail");

			UserEntity Uentity = new UserEntity(id, name, dob, address, email, "");

			UserDao dao = new UserDao(DBConnection.MakeCon());

			HttpSession session = req.getSession();

			if (dao.updateUserByEditProfile(Uentity)) {
				UserEntity updated = dao.getUserDetailsById(id);
				System.out.println(
						"[userServlet.EditProfile.java]--- Upadted user Details into user_details database successfully by particular user EditPage.");
				session.setAttribute("userObj", updated);
				session.setAttribute("successMsg", "Thank You!!  Your Details Updated Successfully");
				resp.sendRedirect("index.jsp");

			} else {
				System.out.println(
						"[userServlet.EditProfile.java]---Something went wrong on server to update the user information by user EditPage, please do correct.");
				session.setAttribute("errorMsg", "Something went wrong on server please try after sometime.");
				resp.sendRedirect("editUserProfile.jsp");
			}
		} catch (Exception e) {
			System.out.println(
					"An error/exception has been found in the [userServlet.EditProfile.java] while running the method protected void doPost(){} "
							+ e);
		}

	}

}
