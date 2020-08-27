package hgkj.com.model.dao.impl;

import hgkj.com.model.dao.CustomerDao;
import hgkj.com.model.entity.Customer;
import hgkj.com.model.unti.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    /**
     * 用户登录
     * @param customer
     * @return
     */
    @Override
    public Customer loginDao(Customer customer) {

        Connection connection= DBManager.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        String sql="SELECT * from customer where account=? and password=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,customer.getAccount());
            statement.setString(2,customer.getPassword());
            resultSet=statement.executeQuery();
            if (resultSet.next()){
                customer.setName(resultSet.getString("name"));
                customer.setCustomerID(resultSet.getInt("customerID"));
            }
            else{
                customer=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closeAll(connection,statement,resultSet);
        }
        return customer;
    }

    /**
     * 用户注册
     * @param customer
     * @return
     */
    @Override
    public boolean registerDao(Customer customer) {
        String sql="insert into customer(account,name,passWord,gender,identityID,tel) values(?,?,?,?,?,?);";
        Object[]  objects={customer.getAccount(),customer.getName(), customer.getPassword(),customer.getGender(),customer.getIdentityID(),customer.getTel()};
        return DBManager.executeUpdate(sql,objects);
    }
}
