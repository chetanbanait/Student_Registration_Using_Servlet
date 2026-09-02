package com.Student.Registration;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Registrationstudent extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res)throws ServletException, IOException {
    	
    	String fname = req.getParameter("fname");

    	if(fname == null)
    	{
    	    res.setContentType("text/html");

    	    PrintWriter out = res.getWriter();

    	    out.println("<script>");
    	    out.println("window.location='Registration.html';");
    	    out.println("</script>");

    	    return;
    	}

        String lname = req.getParameter("lname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String course = req.getParameter("course");
        String mobile = req.getParameter("mobile");

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Details</title>");
        out.println("</head>");
        out.println("<body style='font-family:Arial;background:#f2f2f2;'>");

        out.println("<div style='width:500px;margin:50px auto;"
                + "padding:20px;background:white;"
                + "border-radius:10px;box-shadow:0 0 5px gray;'>");

        out.println("<h2 style='color:green;text-align:center;'>");
        out.println("Registration Successful");
        out.println("</h2>");

        out.println("<hr>");

        out.println("<p><b>First Name :</b> " + fname + "</p>");
        out.println("<p><b>Last Name :</b> " + lname + "</p>");
        out.println("<p><b>Email :</b> " + email + "</p>");
        out.println("<p><b>Password :</b> " + password + "</p>");
        out.println("<p><b>Gender :</b> " + gender + "</p>");
        out.println("<p><b>Course :</b> " + course + "</p>");
        out.println("<p><b>Mobile Number :</b> " + mobile + "</p>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
        System.out.println("Student data print Successfully on browser");
    }
}
