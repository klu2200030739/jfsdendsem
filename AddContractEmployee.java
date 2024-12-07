package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContractEmployee;
import model.EmployeeManager;

/**
 * Servlet implementation class AddContractEmployee
 */
@WebServlet("/AddContractEmployee")
public class AddContractEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContractEmployee() {
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
		double payperhour = Double.parseDouble(request.getParameter("EPPH"));
		String duration = request.getParameter("EDURATION");
		response.setContentType("text/html");
		PrintWriter PW = response.getWriter();
		try
		{
			ContractEmployee C = new ContractEmployee();
			C.setId(eid);
			C.setEname(ename);
			C.setPayperhour(payperhour);
			C.setDuration(duration);
			
			EmployeeManager EM =  new EmployeeManager();
			String ack = EM.addContractEmployee(C);
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
