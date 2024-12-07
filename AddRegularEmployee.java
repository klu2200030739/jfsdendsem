package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeManager;
import model.RegularEmployee;

/**
 * Servlet implementation class AddRegularEmployee
 */
@WebServlet("/AddRegularEmployee")
public class AddRegularEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRegularEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int eid = Integer.parseInt(request.getParameter("EID"));
		String ename = request.getParameter("ENAME");
		double salary = Double.parseDouble(request.getParameter("ESALARY"));
		int bonus = Integer.parseInt(request.getParameter("EBOUNS"));
		response.setContentType("text/html");
		PrintWriter PW = response.getWriter();
		try
		{
			RegularEmployee R = new RegularEmployee();
			R.setId(eid);
			R.setEname(ename);
			R.setSalary(salary);
			R.setBouns(bonus);
			
			EmployeeManager EM =  new EmployeeManager();
			String ack = EM.addRegularEmployee(R);
			PW.print(ack);
		}catch (Exception e) 
		{
			PW.print(e.getMessage());
		}
		RequestDispatcher RD = request.getRequestDispatcher("index.htnl");
		RD.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
