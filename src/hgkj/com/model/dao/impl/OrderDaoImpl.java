package hgkj.com.model.dao.impl;

import hgkj.com.model.dao.OrderDao;
import hgkj.com.model.entity.*;
import hgkj.com.model.unti.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    /**
     * 查询订单
     * @param customerID
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<Orderdetail> SelectAllOrderDao(int customerID, int pageIndex, int pageSize) {
        List<Orderdetail> orderdetailList=new ArrayList<>();
        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="SELECT * FROM orderdetail JOIN customer on orderdetail.customerID=customer.customerID JOIN line on  orderdetail.lineID=line.lineID JOIN indexpicture on indexpicture.lineID=line.lineID where customer.customerID=? limit ?,?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,customerID);
            statement.setInt(2,(pageIndex-1)*pageSize);
            statement.setInt(3,pageSize);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Orderdetail orderdetail=new Orderdetail();
                orderdetail.setOdID(resultSet.getString("odID"));
                orderdetail.setLineNames(resultSet.getString("lineNames"));
                orderdetail.setTotal(resultSet.getDouble("total"));
                orderdetail.setOrderDate(resultSet.getString("orderDate"));
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
                orderdetail.setLine(line);
                Picture picture=new Picture();
                picture.setPicintroduction(resultSet.getString("showpicintroduction"));
                picture.setPictureID(resultSet.getInt("showpictureID"));
                orderdetail.setPicture(picture);
                orderdetailList.add(orderdetail);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return orderdetailList;
    }

    /**
     * 查询订单总条数
     * @param customerID
     * @param pageSize
     * @return
     */
    @Override
    public int TotalPageDao(int customerID, int pageSize) {
        int totalPage=0;
        Connection connection= DBManager.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select count(*) from orderdetail where customerID=?";
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
     * 删除订单
     * @param odID
     * @return
     */
    @Override
    public boolean DeleteOrderDao(String odID) {
        String sql="delete from orderdetail where odID=?";
        Object[] objects={odID};
        return DBManager.executeUpdate(sql,objects);
    }

    /**
     * 添加出游人
     * @param tourist
     * @return
     */
    @Override
    public boolean insertCustDao(Tourist tourist) {
        String sql="insert into tourist(IDcard,tel,realName) values(?,?,?)";
        Object[] objects={tourist.getIDCard(),tourist.getTel(),tourist.getRealName()};
        return DBManager.executeUpdate(sql,objects);
    }

    /**
     * 查询出游人
     * @param IDcard
     * @return
     */
    @Override
    public Tourist SelectCustDao(String IDcard) {
        Tourist tourist=new Tourist();
        Connection connection= DBManager.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from tourist where IDcard=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,IDcard);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                tourist.setTouristID(resultSet.getString("touristID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,preparedStatement,resultSet);
        }
        return tourist;
    }

    /**
     * 添加订单
     * @param orderdetail
     * @return
     */
    @Override
    public boolean InsertOrderDao(Orderdetail orderdetail) {
        String sql="insert into orderdetail(customerID,lineNames,prices,orderDate,travelDate,total,lineID,touristID) values(?,?,?,?,?,?,?,?)";
        Object[] objects={orderdetail.getCustomerID(),orderdetail.getLineNames(),orderdetail.getPrices(),orderdetail.getOrderDate(),
        orderdetail.getTravelDate(),orderdetail.getTotal(),orderdetail.getLineID(),orderdetail.getTouristID()
        };
        return DBManager.executeUpdate(sql,objects);
    }

    /**
     * 查询订单的条数
     * @return
     */
    @Override
    public int SelectCountDao() {
        int count=0;
        Connection connection= DBManager.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select count(*) from orderdetail ";
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                count=(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,preparedStatement,resultSet);
        }
        return count;
    }
}
