package hgkj.com.contorller.Servlet;

import hgkj.com.model.entity.Car;
import hgkj.com.model.entity.Customer;
import hgkj.com.model.entity.Line;
import hgkj.com.model.service.CarService;
import hgkj.com.model.service.impl.CarServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CarServlet",urlPatterns = "/CarServlet")
public class CarServlet extends HttpServlet {
    private CarService carService=new CarServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
/**
 * 购物车所有订单进行购买
 */
        if ("OC".equalsIgnoreCase(action)){
            Customer customer = (Customer) session.getAttribute("customer");
            int customerID = customer.getCustomerID();
            List<Car> carList=carService.AllService(customerID);
            ObjectMapper mapper=new ObjectMapper();
            String result=mapper.writeValueAsString(carList);
            session.setAttribute("insertCarList",carList);
            out.write(result);

        }
        /**
         * 查询购物车
         */
        if ("all".equalsIgnoreCase(action)) {
            Customer customer = (Customer) session.getAttribute("customer");
            if (customer == null) {
                response.sendRedirect("login.html");
            } else {
                int customerID = customer.getCustomerID();
                int pageSize = 5;
                int totalPage = carService.SelectTotalPage(customerID, pageSize);
                int pageIndex = request.getParameter("carpageIndex") == null ? 1 : Integer.parseInt(request.getParameter("carpageIndex"));
                if (pageIndex < 1) {
                    pageIndex = 1;
                } else if (pageIndex > totalPage) {
                    pageIndex = totalPage;
                }
                List<Car> carList = carService.AllCarService(customerID, pageIndex, pageSize);
                request.getSession().setAttribute("carpageIndex", pageIndex);
                request.getSession().setAttribute("cartotalPage", totalPage);
                request.getSession().setAttribute("carList", carList);
                response.sendRedirect("cart.jsp");
            }
        }
            /**
             * 删除购物车
             */
            if ("delete".equalsIgnoreCase(action)) {
                int carID = Integer.parseInt(request.getParameter("carID"));
                String result = carService.DeleteCarService(carID) ? "ok" : "error";
                out.write(result);
            }
            /**
             * 单条记录下单后删除购物车中的该条数据
             */
        if ("deletes".equalsIgnoreCase(action)) {
            int carID = Integer.parseInt(request.getParameter("carID"));
            boolean result = carService.DeleteCarService(carID);
            if (result ) {
                response.sendRedirect("/CarServlet?action=all");
            }
            else {
                response.sendRedirect("order.jsp");
            }
        }
        /**
         * 添加购物车
         */
            if ("insert".equalsIgnoreCase(action)){
                Customer customer = (Customer) session.getAttribute("customer");
                if (customer!=null){
                    int customerID=customer.getCustomerID();
                    Line line=(Line) request.getSession().getAttribute("line");
                    String  lineID= line.getLineID();
                    Date date=new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    String time=sdf.format(date);
                    Car car=new Car(customerID,lineID,time);

                    boolean result=carService.InsertCarService(car);
                    if (result){
                        response.sendRedirect("/CarServlet?action=all");
                    }
                }
                else {
                    response.sendRedirect("login.html");
                }
            }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
