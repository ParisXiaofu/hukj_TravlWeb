package hgkj.com.contorller.Servlet;

import hgkj.com.model.dao.OrderDao;
import hgkj.com.model.entity.*;
import hgkj.com.model.service.CarService;
import hgkj.com.model.service.OrderService;
import hgkj.com.model.service.impl.CarServiceImpl;
import hgkj.com.model.service.impl.OrderServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet",urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    private OrderService orderService=new OrderServiceImpl();
    private CarService carService=new CarServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = request.getSession();
        /**
         * 查询购物车
         */
        if ("all".equalsIgnoreCase(action)) {
            Customer customer = (Customer) session.getAttribute("customer");
            if (customer == null) {
                response.sendRedirect("login.html");
            } else {
                int customerID =customer.getCustomerID();
                int pageSize = 4;
                int totalPage = orderService.TotalPageService(customerID, pageSize);
                int pageIndex = request.getParameter("OrderpageIndex") == null ? 1 : Integer.parseInt(request.getParameter("OrderpageIndex"));
                if (pageIndex < 1) {
                    pageIndex = 1;
                } else if (pageIndex > totalPage) {
                    pageIndex = totalPage;
                }
                List<Orderdetail> orderdetailList=orderService.SelectAllOrderService(customerID, pageIndex, pageSize);
                request.getSession().setAttribute("OrderpageIndex", pageIndex);
                request.getSession().setAttribute("OrdertotalPage", totalPage);
                request.getSession().setAttribute("orderdetailList", orderdetailList);
                response.sendRedirect("HistoryOrder.jsp");
            }
        }
        /**
         * 删除订单
         */
        if ("delete".equalsIgnoreCase(action)){
            String  odID =request.getParameter("odID");
            String result =orderService.DeleteOrderService(odID) ? "ok" : "error";
            out.write(result);
        }
        /**
         * 单条订单下单
         */
        if("insert".equalsIgnoreCase(action)){
            String name=request.getParameter("name");
            String tel=request.getParameter("tel");
            String identity=request.getParameter("iden");
            String travelDate=request.getParameter("time");
            Tourist tourist=new Tourist(identity,tel,name);
            if(orderService.insertCustService(tourist)){
                Tourist tourist1=orderService.SelectCustService(identity);
                if (tourist1!=null){
                    Customer customer = (Customer) session.getAttribute("customer");
                    Line line=(Line) session.getAttribute("lines");
                    int customerID=customer.getCustomerID();
                    String lineNames=line.getLineName()+line.getDays()+"日游";
                    double prices=line.getPrice();
                    Date date=new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    String orderDate=sdf.format(date);
                    double total=line.getPrice();
                    String lineID=line.getLineID();
                    int  touristID= Integer.parseInt(tourist1.getTouristID());
                    Orderdetail orderdetail=new Orderdetail(customerID,lineNames,prices,orderDate,travelDate,total,lineID,touristID);
                    if (orderService.InsertOrderService(orderdetail)){
                        int carID = Integer.parseInt(request.getParameter("carID"));
                        response.sendRedirect("/CarServlet?action=deletes&carID="+carID+"");
                    }
                    else {
                       response.sendRedirect("orders.jsp");
                    }
                }
            }
        }
        /**
         * 多条订单下单
         */
        if("inserts".equalsIgnoreCase(action)){
            String name=request.getParameter("name");
            String tel=request.getParameter("tel");
            String identity=request.getParameter("iden");
            String travelDate=request.getParameter("time");
            Tourist tourist=new Tourist(identity,tel,name);
            if(orderService.insertCustService(tourist)){
                Tourist tourist1=orderService.SelectCustService(identity);
                if (tourist1!=null){
                    List<Car> carList=(ArrayList)session.getAttribute("insertCarList");
                    for (Car car:carList) {
                        Customer customer = (Customer) session.getAttribute("customer");
                        int customerID = customer.getCustomerID();
                        String lineNames = car.getLine().getLineName() + car.getLine().getDays() + "日游";
                        double prices = car.getLine().getPrice();
                        Date date = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                        String orderDate = sdf.format(date);
                        double total = car.getLine().getPrice();
                        String lineID = car.getLine().getLineID();
                        int carID=car.getCarID();
                        int touristID = Integer.parseInt(tourist1.getTouristID());
                        Orderdetail orderdetail = new Orderdetail(customerID, lineNames, prices, orderDate, travelDate, total, lineID, touristID);
                        orderService.InsertOrderService(orderdetail);
                        carService.DeleteCarService(carID);
                    }
                    response.sendRedirect("index.jsp");
                }
            }
        }
        if ("allcount".equalsIgnoreCase(action)){
            int count=orderService.SelectCountService();
            String result=mapper.writeValueAsString(count);
            out.write(result);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
