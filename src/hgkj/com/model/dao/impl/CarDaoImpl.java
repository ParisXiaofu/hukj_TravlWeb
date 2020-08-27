package hgkj.com.model.dao.impl;

import hgkj.com.model.dao.CarDao;
import hgkj.com.model.entity.Car;
import hgkj.com.model.entity.Line;
import hgkj.com.model.entity.Picture;
import hgkj.com.model.unti.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    @Override
    public List<Car> allDao(int customerID) {
        List<Car> carList=new ArrayList<>();
        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from Car join customer on car.customerID=customer.customerID JOIN line on car.lineID=line.lineID JOIN indexpicture on line.lineID=indexpicture.lineID Where customer.customerID=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,customerID);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Car car=new Car();
                car.setCarID(resultSet.getInt("carID"));
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
                car.setLine(line);
                Picture picture=new Picture();
                picture.setPicintroduction(resultSet.getString("showpicintroduction"));
                picture.setPictureID(resultSet.getInt("showpictureID"));
                car.setPicture(picture);
                carList.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return carList;
    }

    /**
     * 查询购物车
     * @param customerID
     * @return
     */
    @Override
    public List<Car> allCarDao(int customerID,int pageIndex,int pageSize) {
        List<Car> carList=new ArrayList<>();
        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="select * from Car join customer on car.customerID=customer.customerID JOIN line on car.lineID=line.lineID JOIN indexpicture on line.lineID=indexpicture.lineID Where customer.customerID=? limit ?,?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,customerID);
            statement.setInt(2,(pageIndex-1)*pageSize);
            statement.setInt(3,pageSize);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Car car=new Car();
                car.setCarID(resultSet.getInt("carID"));
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
                car.setLine(line);
                Picture picture=new Picture();
                picture.setPicintroduction(resultSet.getString("showpicintroduction"));
                picture.setPictureID(resultSet.getInt("showpictureID"));
                car.setPicture(picture);
                carList.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return carList;
    }

    /**
     * 获取购物车总条数
     * @param customerID
     * @param pageSize
     * @return
     */
    @Override
    public int SelectTotalPageDao(int customerID,int pageSize) {
        int totalPage=0;
        Connection connection=DBManager.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select count(*) from car where customerID=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,customerID);
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
     * 删除购物车
     * @param carID
     * @return
     */
    @Override
    public boolean DeleteCarDao(int carID) {
        String sql="delete from car where carID=?";
        Object[] objects={carID};
        return DBManager.executeUpdate(sql,objects);
    }

    /**
     * 添加购物车
     * @param car
     * @return
     */
    @Override
    public boolean InsertCarDao(Car car) {
        String sql="insert into car(customerID,lineID,time) values(?,?,?)";
        Object[] objects={car.getCustomerID(),car.getLineID(),car.getTime()};
        return DBManager.executeUpdate(sql,objects);
    }
}
