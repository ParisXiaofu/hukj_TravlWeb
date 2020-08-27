package hgkj.com.contorller.Servlet;

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

@WebServlet(name = "LineShowInfoServlet",urlPatterns = "/LineShowInfoServlet")
public class LineShowInfoServlet extends HttpServlet {
    private LineService lineService=new LineServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");
        HttpSession session=request.getSession();
        String  lineID=request.getParameter("lineID");
        Line line= lineService.LineInfoService(lineID);
        List<Picture> pictureList=lineService.SelectPictureService(lineID);
        session.setAttribute("line",line);
        session.setAttribute("pictureList",pictureList);
        response.sendRedirect("detail.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
