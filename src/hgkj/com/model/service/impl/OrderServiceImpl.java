package hgkj.com.model.service.impl;

import hgkj.com.model.dao.OrderDao;
import hgkj.com.model.dao.impl.OrderDaoImpl;
import hgkj.com.model.entity.Orderdetail;
import hgkj.com.model.entity.Tourist;
import hgkj.com.model.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    /**
     * 查询订单
     * @param customerID
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<Orderdetail> SelectAllOrderService(int customerID, int pageIndex, int pageSize) {
        return orderDao.SelectAllOrderDao(customerID,pageIndex,pageSize);
    }
    /**
     * 查询订单总条数
     * @param customerID
     * @param pageSize
     * @return
     */
    @Override
    public int TotalPageService(int customerID, int pageSize) {
        return orderDao.TotalPageDao(customerID,pageSize);
    }

    /**
     * 删除订单
     * @param odID
     * @return
     */
    @Override
    public boolean DeleteOrderService(String odID) {
        return orderDao.DeleteOrderDao(odID);
    }

    /**
     * 添加出游人
     * @param tourist
     * @return
     */
    @Override
    public boolean insertCustService(Tourist tourist) {
        return orderDao.insertCustDao(tourist);
    }

    /**
     * 查询出游人
     * @param IDcard
     * @return
     */
    @Override
    public Tourist SelectCustService(String IDcard) {
        return orderDao.SelectCustDao(IDcard);
    }

    /**
     * 添加订单
     * @param orderdetail
     * @return
     */
    @Override
    public boolean InsertOrderService(Orderdetail orderdetail) {
        return orderDao.InsertOrderDao(orderdetail);
    }

    /**
     * 查询订单的条数
     * @return
     */
    @Override
    public int SelectCountService() {
        return orderDao.SelectCountDao();
    }
}
