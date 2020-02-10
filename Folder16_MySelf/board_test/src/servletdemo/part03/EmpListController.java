package servletdemo.part03;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//바로호출할꺼니까 
@WebServlet("/empList") 
public class EmpListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeesDAO dao = EmployeesDAO.getInstance();
		List<EmployeesDTO> aList=dao.search();
		req.setAttribute("aList", aList);
		//RequestDispatcher dis = req.getRequestDispatcher("/servletview/part03/empList.jsp");
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part03/empList2.jsp");
		dis.forward(req, resp);
	}
	 

}//end class////////////
