package hgkj.com.model.dao;

import hgkj.com.model.entity.Customer;

public interface CustomerDao {
    /**
     * 用户登录
     * @param customer
     * @return
     */
    public Customer loginDao(Customer customer);

    /**
     * 用户注册
     * @param customer
     * @return
     */
    public boolean registerDao(Customer customer);
}
