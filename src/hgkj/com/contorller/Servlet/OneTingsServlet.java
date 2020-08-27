package hgkj.com.contorller.Servlet;

import hgkj.com.model.entity.Customer;
import hgkj.com.model.entity.Line;
import hgkj.com.model.entity.Picture;
import hgkj.com.model.service.LineService;
import hgkj.com.model.service.impl.LineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OneTingsServlet",urlPatterns = "/OneTingsServlet")
public class OneTingsServlet extends HttpServlet {
    private LineService lineService=new LineServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 这个Servlet是用来单个下单
         */
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");
        HttpSession session=request.getSession();
        String  lineID=request.getParameter("lineID");
        Line line= lineService.LineInfoService(lineID);
        int carID= Integer.parseInt(request.getParameter("carID"));
        session.setAttribute("lines",line);
        session.setAttribute("carIDS",carID);
        Customer customer=(Customer) request.getSession().getAttribute("customer");
        if (customer==null){
            response.sendRedirect("login.html");
        }else {
            response.sendRedirect("order.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
