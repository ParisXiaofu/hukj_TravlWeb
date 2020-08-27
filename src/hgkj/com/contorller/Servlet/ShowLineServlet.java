package hgkj.com.contorller.Servlet;

import hgkj.com.model.entity.Line;
import hgkj.com.model.entity.Picture;
import hgkj.com.model.service.LineService;
import hgkj.com.model.service.impl.LineServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowLineServlet",urlPatterns = "/ShowLineServlet")
public class ShowLineServlet extends HttpServlet {

    private LineService lineService=new LineServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");
        PrintWriter out=response.getWriter();
        String action=request.getParameter("action");
        ObjectMapper mapper=new ObjectMapper();
        /**
         * 境内游
         */
        if ("inCountry".equalsIgnoreCase(action)){
            String lineTypeID="20201001";
            List<Line> lineList= lineService.InCountryService(lineTypeID);
            String result=mapper.writeValueAsString(lineList);
            request.getSession().setAttribute("lineList1",lineList);
            out.write(result);
        }
        /**
         * 境外游
         */
         if ("outCountry".equalsIgnoreCase(action)){
            String lineTypeID="20201002";
            List<Line> lineList= lineService.InCountryService(lineTypeID);
            String result=mapper.writeValueAsString(lineList);
             request.getSession().setAttribute("lineList2",lineList);
            out.write(result);
        }
        /**
         * 海岛游
         */
         if ("sea".equalsIgnoreCase(action)){
            String lineTypeID="20201003";
            List<Line> lineList= lineService.InCountryService(lineTypeID);
            String result=mapper.writeValueAsString(lineList);
            out.write(result);
        }
        /**
         * 自驾游游
         */
         if ("myself".equalsIgnoreCase(action)){
            String lineTypeID="20201004";
            List<Line> lineList= lineService.InCountryService(lineTypeID);
            String result=mapper.writeValueAsString(lineList);
            out.write(result);
        }
        /**
         * 旅游天数 一日
         */
         if ("one".equalsIgnoreCase(action)){
            String days="1";
            List<Line> lineList= lineService.DayTravlService(days);
            String result=mapper.writeValueAsString(lineList);
            out.write(result);
        }
        /**
         * 旅游天数 两日
         */
        if ("two".equalsIgnoreCase(action)){
            String days="2";
            List<Line> lineList= lineService.DayTravlService(days);
            String result=mapper.writeValueAsString(lineList);
            out.write(result);
        }
        /**
         * 旅游天数 多日
         */
        if ("more".equalsIgnoreCase(action)){
            List<Line> lineList= lineService.DaysTravlService();
            String result=mapper.writeValueAsString(lineList);
            out.write(result);
        }
        /**
         * 团购展示
         */
         if ("teamBuyall".equalsIgnoreCase(action)){
             int pageSize=6;
            int totalPage=lineService.getTotalPageService(pageSize);
            int pageIndex=request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex"));
            if (pageIndex<1){
                pageIndex=1;
            }else if (pageIndex>totalPage){
                pageIndex=totalPage;
            }
            List<Line> lineList=lineService.TeamBuyService(pageIndex,pageSize);
            request.getSession().setAttribute("pageIndex",pageIndex);
            request.getSession().setAttribute("totalPage",totalPage);
            request.getSession().setAttribute("lineList",lineList);
            response.sendRedirect("group.jsp");
        }
        /**
         * 首页展示团购
         */
         if ("teamshow".equalsIgnoreCase(action)){
            List<Line> lineList=lineService.IndexShowTeamBuyService();
            String result=mapper.writeValueAsString(lineList);
            out.write(result);
        }
        /**
         * 旅游类型查询团购-境内游
         */
        if ("inTeam".equalsIgnoreCase(action)){
            String lineTypeID="20201001";
            List<Line> lineList=lineService.TeamInSelectService(lineTypeID);
            String result=mapper.writeValueAsString(lineList);
            out.write(result);
        }
        /**
         * 旅游类型查询团购-境外游
         */
        if ("outTeam".equalsIgnoreCase(action)){
            String lineTypeID="20201002";
            List<Line> lineList=lineService.TeamInSelectService(lineTypeID);
            String result=mapper.writeValueAsString(lineList);
            out.write(result);
        }
        /**
         * 境内游详情界面展示
         */
        if ("Inall".equalsIgnoreCase(action)){
            String lineType="20201001";
            int pageSize=8;
            int totalPage=lineService.SelectInPageSizeService(lineType,pageSize);
            int pageIndex=request.getParameter("InpageIndex")==null?1:Integer.parseInt(request.getParameter("InpageIndex"));
            if (pageIndex<1){
                pageIndex=1;
            }else if (pageIndex>totalPage){
                pageIndex=totalPage;
            }
            List<Line> lineList=lineService.TypeSelectService(lineType,pageIndex,pageSize);
            request.getSession().setAttribute("InpageIndex",pageIndex);
            request.getSession().setAttribute("IntotalPage",totalPage);
            request.getSession().setAttribute("InlineList",lineList);
            response.sendRedirect("intype.jsp");
        }
        /**
         * 境外游详情界面展示
         */
        if ("Outall".equalsIgnoreCase(action)){
            String lineType="20201002";
            int pageSize=8;
            int totalPage=lineService.SelectInPageSizeService(lineType,pageSize);
            int pageIndex=request.getParameter("OutpageIndex")==null?1:Integer.parseInt(request.getParameter("OutpageIndex"));
            if (pageIndex<1){
                pageIndex=1;
            }else if (pageIndex>totalPage){
                pageIndex=totalPage;
            }
            List<Line> lineList=lineService.TypeSelectService(lineType,pageIndex,pageSize);
            request.getSession().setAttribute("OutpageIndex",pageIndex);
            request.getSession().setAttribute("OuttotalPage",totalPage);
            request.getSession().setAttribute("OutlineList",lineList);
            response.sendRedirect("outtype.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
