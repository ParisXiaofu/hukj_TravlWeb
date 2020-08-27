package hgkj.com.model.dao.impl;

import com.sun.corba.se.impl.interceptors.PICurrent;
import hgkj.com.model.dao.LineDao;
import hgkj.com.model.entity.Line;
import hgkj.com.model.entity.Picture;
import hgkj.com.model.unti.DBManager;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LineDaoImpl implements LineDao {
    /**
     * 旅游类型
     * @return
     */
    @Override
    public List<Line> InCountryDao(String lineTypeID) {
        List<Line> lineList =new ArrayList<>();
        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from Line left JOIN indexpicture on line.lineID=indexpicture.lineID where lineTypeID=? limit 10";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,lineTypeID);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Line line=new Line();
               line.setLineID(resultSet.getString("lineID"));
               line.setLineName(resultSet.getString("lineName"));
               line.setDays(resultSet.getString("days"));
               line.setVehicle(resultSet.getString("vehicle"));
               line.setIntroduction(resultSet.getString("introduction"));
               line.setReason(resultSet.getString("reason"));
               line.setArrange(resultSet.getString("arrange"));
               line.setPrice(resultSet.getDouble("price"));
                line.setTeamBuy(resultSet.getInt("teamBuy"));
                line.setTeamBuyPrice(resultSet.getDouble("teamBuyPrice"));
               line.setBeginTime(resultSet.getString("beginTime"));
               line.setEndTime(resultSet.getString("endTime"));
               line.setOnTime(resultSet.getString("onTime"));
                Picture picture=new Picture();
                picture.setPicintroduction(resultSet.getString("showpicintroduction"));
                picture.setPictureID(resultSet.getInt("showpictureID"));
                line.setPicture(picture);
               lineList.add(line);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return lineList;
    }

    /**
     * 旅游天数  一日游 两日游
     * @param days
     * @return
     */
    public List<Line> DayTravlDao(String days) {
        List<Line> lineList =new ArrayList<>();
        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from Line where days=? limit 9";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,days);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Line line=new Line();
                line.setLineID(resultSet.getString("lineID"));
                line.setLineTypeID(resultSet.getString("lineTypeID"));
                line.setLineName(resultSet.getString("lineName"));
                line.setDays(resultSet.getString("days"));
                line.setVehicle(resultSet.getString("vehicle"));
                line.setIntroduction(resultSet.getString("introduction"));
                line.setReason(resultSet.getString("reason"));
                line.setArrange(resultSet.getString("arrange"));
                line.setPrice(resultSet.getDouble("price"));
                line.setTeamBuy(resultSet.getInt("teamBuy"));
                line.setTeamBuyPrice(resultSet.getDouble("teamBuyPrice"));
                line.setBeginTime(resultSet.getString("beginTime"));
                line.setEndTime(resultSet.getString("endTime"));
                line.setOnTime(resultSet.getString("onTime"));
                lineList.add(line);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return lineList;
    }
    /**
     * 旅游天数  多日游
     * @param
     * @return
     */
    public List<Line> DaysTravlDao() {
        List<Line> lineList =new ArrayList<>();
        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from Line where days>2 limit 9";
        try {
            statement=connection.prepareStatement(sql);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Line line=new Line();
                line.setLineID(resultSet.getString("lineID"));
                line.setLineTypeID(resultSet.getString("lineTypeID"));
                line.setLineName(resultSet.getString("lineName"));
                line.setDays(resultSet.getString("days"));
                line.setVehicle(resultSet.getString("vehicle"));
                line.setIntroduction(resultSet.getString("introduction"));
                line.setReason(resultSet.getString("reason"));
                line.setArrange(resultSet.getString("arrange"));
                line.setPrice(resultSet.getDouble("price"));
                line.setTeamBuy(resultSet.getInt("teamBuy"));
                line.setTeamBuyPrice(resultSet.getDouble("teamBuyPrice"));
                line.setBeginTime(resultSet.getString("beginTime"));
                line.setEndTime(resultSet.getString("endTime"));
                line.setOnTime(resultSet.getString("onTime"));
                lineList.add(line);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return lineList;
    }

    /**
     * 查询旅游详情
     * @param lineID
     * @return
     */
    @Override
    public Line LineInfoDao(String lineID) {
        Line line =null;
        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from Line where lineID=?" ;
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,lineID);
            resultSet=statement.executeQuery();
           while (resultSet.next()){
                line=new Line();
               line.setLineID(resultSet.getString("lineID"));
               line.setLineTypeID(resultSet.getString("lineTypeID"));
               line.setLineName(resultSet.getString("lineName"));
               line.setDays(resultSet.getString("days"));
               line.setVehicle(resultSet.getString("vehicle"));
               line.setIntroduction(resultSet.getString("introduction"));
               line.setReason(resultSet.getString("reason"));
               line.setArrange(resultSet.getString("arrange"));
               line.setPrice(resultSet.getDouble("price"));
               line.setTeamBuy(resultSet.getInt("teamBuy"));
               line.setTeamBuyPrice(resultSet.getDouble("teamBuyPrice"));
               line.setBeginTime(resultSet.getString("beginTime"));
               line.setEndTime(resultSet.getString("endTime"));
               line.setOnTime(resultSet.getString("onTime"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return line;
    }

    /**
     * 团购
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<Line> TeamBuyDao(int pageIndex,int pageSize) {
        List<Line> lineList =new ArrayList<>();
        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from Line RIGHT JOIN  indexpicture on line.lineID=indexpicture.lineID where  teambuy=1 limit ?,?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,(pageIndex-1)*pageSize);
            statement.setInt(2,pageSize);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Line line=new Line();
                line.setLineID(resultSet.getString("lineID"));
                line.setLineTypeID(resultSet.getString("lineTypeID"));
                line.setLineName(resultSet.getString("lineName"));
                line.setDays(resultSet.getString("days"));
                line.setVehicle(resultSet.getString("vehicle"));
                line.setIntroduction(resultSet.getString("introduction"));
                line.setReason(resultSet.getString("reason"));
                line.setArrange(resultSet.getString("arrange"));
                line.setPrice(resultSet.getDouble("price"));
                line.setTeamBuy(resultSet.getInt("teamBuy"));
                line.setTeamBuyPrice(resultSet.getDouble("teamBuyPrice"));
                line.setBeginTime(resultSet.getString("beginTime"));
                line.setEndTime(resultSet.getString("endTime"));
                line.setOnTime(resultSet.getString("onTime"));
                Picture picture=new Picture();
                picture.setPicintroduction(resultSet.getString("showpicintroduction"));
                picture.setPictureID(resultSet.getInt("showpictureID"));
                line.setPicture(picture);
                lineList.add(line);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return lineList;
    }

    /**
     * 获取团购总页码
     * @param pageSize
     * @return
     */
    @Override
    public int getTotalPageDao(int pageSize) {
        int totalPage=0;
        Connection connection=DBManager.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select count(*) from line where teambuy=1";
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                totalPage=((resultSet.getInt(1)-1)/pageSize)+1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,preparedStatement,resultSet);
        }
        return totalPage;
    }

    /**
     * 首页展示团购
     * @return
     */
    @Override
    public List<Line> IndexShowTeamBuyDao() {
        List<Line> lineList =new ArrayList<>();
        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from Line RIGHT JOIN indexpicture on line.lineID=indexpicture.lineID and teambuy=1 limit 6";
        try {
            statement=connection.prepareStatement(sql);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Line line=new Line();
                line.setLineID(resultSet.getString("lineID"));
                line.setLineTypeID(resultSet.getString("lineTypeID"));
                line.setLineName(resultSet.getString("lineName"));
                line.setDays(resultSet.getString("days"));
                line.setVehicle(resultSet.getString("vehicle"));
                line.setIntroduction(resultSet.getString("introduction"));
                line.setReason(resultSet.getString("reason"));
                line.setArrange(resultSet.getString("arrange"));
                line.setPrice(resultSet.getDouble("price"));
                line.setTeamBuy(resultSet.getInt("teamBuy"));
                line.setTeamBuyPrice(resultSet.getDouble("teamBuyPrice"));
                line.setBeginTime(resultSet.getString("beginTime"));
                line.setEndTime(resultSet.getString("endTime"));
                line.setOnTime(resultSet.getString("onTime"));
                Picture picture=new Picture();
                picture.setPicintroduction(resultSet.getString("showpicintroduction"));
                picture.setPictureID(resultSet.getInt("showpictureID"));
                line.setPicture(picture);
                lineList.add(line);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return lineList;
    }

    /**
     * 浏览详情查询图片
     * @param lineID
     * @return
     */
    @Override
    public List<Picture> SelectPictureDao(String lineID) {
        List<Picture> pictureList=new ArrayList<>();
        Connection connection=DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from picture where lineID=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,lineID);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Picture picture=new Picture();
                picture.setPictureID(resultSet.getInt("pictureID"));
                picture.setPicintroduction(resultSet.getString("picintroduction"));
                picture.setName(resultSet.getString("name"));
                pictureList.add(picture);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return pictureList;
    }

    /**
     * 旅游类型查询团购
     * @param lineTypeID
     * @return
     */
    @Override
    public List<Line> TeamInSelectDao(String lineTypeID) {
        List<Line> lineList =new ArrayList<>();
        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from Line right JOIN indexpicture on line.lineID=indexpicture.lineID where teambuy=1 and lineTypeID=? limit 3";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,lineTypeID);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Line line=new Line();
                line.setLineID(resultSet.getString("lineID"));
                line.setLineName(resultSet.getString("lineName"));
                line.setDays(resultSet.getString("days"));
                line.setVehicle(resultSet.getString("vehicle"));
                line.setIntroduction(resultSet.getString("introduction"));
                line.setReason(resultSet.getString("reason"));
                line.setArrange(resultSet.getString("arrange"));
                line.setPrice(resultSet.getDouble("price"));
                line.setTeamBuy(resultSet.getInt("teamBuy"));
                line.setTeamBuyPrice(resultSet.getDouble("teamBuyPrice"));
                line.setBeginTime(resultSet.getString("beginTime"));
                line.setEndTime(resultSet.getString("endTime"));
                line.setOnTime(resultSet.getString("onTime"));
                Picture picture=new Picture();
                picture.setPicintroduction(resultSet.getString("showpicintroduction"));
                picture.setPictureID(resultSet.getInt("showpictureID"));
                line.setPicture(picture);
                lineList.add(line);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return lineList;
    }

    /**
     * 按类型查询数据的总页码数
     * @param pageSize
     * @return
     */
    @Override
    public int SelectInPageSizeDao(String lineTypeID,int pageSize) {
        int totalPage=0;
        Connection connection=DBManager.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select count(*) from line where lineTypeID=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,lineTypeID);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                totalPage=((resultSet.getInt(1)-1)/pageSize)+1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,preparedStatement,resultSet);
        }
        return totalPage;
    }
    /**
     * 对旅游类型查询出来的数据进行分页
     * @param pageIndex
     * @param pageSize
     * @param lineTypeID
     * @return
     */
    @Override
    public List<Line> TypeSelectDao(String lineTypeID,int pageIndex, int pageSize) {
        List<Line> lineList =new ArrayList<>();
        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from Line RIGHT JOIN  indexpicture on line.lineID=indexpicture.lineID where  lineTypeID=? limit ?,?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,lineTypeID);
            statement.setInt(2,(pageIndex-1)*pageSize);
            statement.setInt(3,pageSize);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Line line=new Line();
                line.setLineID(resultSet.getString("lineID"));
                line.setLineTypeID(resultSet.getString("lineTypeID"));
                line.setLineName(resultSet.getString("lineName"));
                line.setDays(resultSet.getString("days"));
                line.setVehicle(resultSet.getString("vehicle"));
                line.setIntroduction(resultSet.getString("introduction"));
                line.setReason(resultSet.getString("reason"));
                line.setArrange(resultSet.getString("arrange"));
                line.setPrice(resultSet.getDouble("price"));
                line.setTeamBuy(resultSet.getInt("teamBuy"));
                line.setTeamBuyPrice(resultSet.getDouble("teamBuyPrice"));
                line.setBeginTime(resultSet.getString("beginTime"));
                line.setEndTime(resultSet.getString("endTime"));
                line.setOnTime(resultSet.getString("onTime"));
                Picture picture=new Picture();
                picture.setPicintroduction(resultSet.getString("showpicintroduction"));
                picture.setPictureID(resultSet.getInt("showpictureID"));
                line.setPicture(picture);
                lineList.add(line);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return lineList;
    }


}
