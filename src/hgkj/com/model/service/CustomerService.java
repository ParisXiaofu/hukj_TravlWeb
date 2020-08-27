package hgkj.com.model.service;

import hgkj.com.model.entity.Customer;

public interface CustomerService {
    /**
     * 用户登录
     * @param customer
     * @return
     */
    public Customer loginService(Customer customer);
    /**
     * 用户注册
     * @param customer
     * @return
     */
    public boolean RegisterService(Customer customer);
}
