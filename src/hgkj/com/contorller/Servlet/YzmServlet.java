package hgkj.com.contorller.Servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "YzmServlet",urlPatterns = "/YzmServlet")
public class YzmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg;charset=UTF-8");
        //创建Image对象
        BufferedImage image = new BufferedImage(65, 25, BufferedImage.TYPE_INT_RGB);
        //创建画笔
        Graphics graphics = image.createGraphics();
        //设置画笔颜色
        graphics.setColor(randomColor());
        //画一个填充矩形
        graphics.fillRect(0, 0, 70, 30);
        //设置画笔的字体
        graphics.setFont(new Font("隶书", Font.BOLD, 20));
        //画验证码
        String yzm = randomString();
        request.getSession().setAttribute("yzm", yzm);
        for (int i = 0; i < yzm.length(); i++) {
            graphics.setColor(randomColor());
            graphics.drawString(yzm.substring(i, i + 1), i * 15 + 5, 20);
        }
        //输出验证码
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
        outputStream.flush();
        outputStream.close();
    }

    private String randomString() {
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
        String yzm = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(chars.length);
            yzm += chars[index];
        }
        return yzm;
    }

    private Color randomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r,g,b);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
