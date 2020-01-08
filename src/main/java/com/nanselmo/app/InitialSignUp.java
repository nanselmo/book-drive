package com.nanselmo.app;

import com.google.appengine.api.utils.SystemProperty;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

@WebServlet(name = "InitialSignUp", value = "/signup")
public class InitialSignUp extends HttpServlet {


  @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("signup.html").forward(request,response);
	}

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String email=request.getParameter("emailAddress");
    String participantType=request.getParameter("participantType");
    System.out.println("the participant type is: " + participantType);
    String partTypeDesc = "unknown";
    if (participantType.equals("donate")) {
        partTypeDesc = "book donor to Chicago BookMobile";
    }
    else if (participantType.equals("recieve")) {
        partTypeDesc = "benefactor of Chicago BookMobile";
    }
    else if (participantType.equals("both")) {
        partTypeDesc = "donor to and benefactor of Chicago BookMobile";
    }
    response.setContentType("text/plain");
    response.getWriter().println("Okay " + email + ", we have you as a future " + partTypeDesc);
  }


}
