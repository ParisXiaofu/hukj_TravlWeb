package hgkj.com.contorller.Servlet;

import hgkj.com.model.entity.Customer;
import hgkj.com.model.service.CustomerService;
import hgkj.com.model.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private CustomerService customerService=new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");
            String account=request.getParameter("account");
            String password=request.getParameter("password");
            String name=request.getParameter("name");
            String identityID=request.getParameter("identityID");
            String gender=request.getParameter("gender");
            String tel=request.getParameter("tel");
            String yzm=request.getParameter("yzm");
            Customer customer=new Customer(account,name,password,gender,identityID,tel);
            if (yzm.equalsIgnoreCase(request.getSession().getAttribute("yzm").toString())){
                if (customerService.RegisterService(customer)){
                    request.setAttribute("mmsg","注册成功！");
                    request.getRequestDispatcher("regist.jsp").forward(request,response);

                }else {
                    request.setAttribute("mmsg","注册失败！");
                    request.getRequestDispatcher("regist.jsp").forward(request,response);

                }
        }
            else {
                request.setAttribute("msg","请输入正确的验证码");
                    request.getRequestDispatcher("regist.jsp").forward(request,response);

            }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
