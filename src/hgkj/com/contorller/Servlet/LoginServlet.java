package hgkj.com.contorller.Servlet;

import hgkj.com.model.entity.Customer;
import hgkj.com.model.service.CustomerService;
import hgkj.com.model.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private CustomerService customerService=new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");
        String account=request.getParameter("account");
        String password=request.getParameter("pwd");
        Customer customer=new Customer(account,password);
       customer=customerService.loginService(customer);
       HttpSession session=request.getSession();
        if (customer!=null){
            session.setAttribute("customer",customer);
            response.sendRedirect("index.jsp");
        }
        else {
            response.sendRedirect("login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
