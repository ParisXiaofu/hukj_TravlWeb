package hgkj.com.model.service.impl;

import hgkj.com.model.dao.CustomerDao;
import hgkj.com.model.dao.impl.CustomerDaoImpl;
import hgkj.com.model.entity.Customer;
import hgkj.com.model.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao=new CustomerDaoImpl();

    /**
     * 用户登录
     * @param customer
     * @return
     */
    @Override
    public Customer loginService(Customer customer) {
        return customerDao.loginDao(customer);
    }
    /**
     * 用户注册
     * @param customer
     * @return
     */
    @Override
    public boolean RegisterService(Customer customer) {
        return customerDao.registerDao(customer);
    }

}
