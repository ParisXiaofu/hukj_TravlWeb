package hgkj.com.model.dao;

import hgkj.com.model.entity.Orderdetail;
import hgkj.com.model.entity.Tourist;

import java.util.List;

public interface OrderDao {

    /**
     * 查询订单
     * @param customerID
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Orderdetail> SelectAllOrderDao(int customerID,int pageIndex,int pageSize);

    /**
     * 查询订单总条数
     * @param customerID
     * @param pageSize
     * @return
     */
    public int TotalPageDao(int customerID,int pageSize);

    /**
     * 删除订单
     * @param odID
     * @return
     */
    public boolean DeleteOrderDao(String odID);

    /**
     * 添加出游人
     * @param tourist
     * @return
     */
    public boolean insertCustDao(Tourist tourist);

    /**
     * 查询出游人
     * @param IDcard
     * @return
     */
    public Tourist SelectCustDao(String IDcard);

    /**
     * 添加订单
     * @param orderdetail
     * @return
     */
    public boolean InsertOrderDao(Orderdetail orderdetail);

    /**
     * 查询订单的条数
     * @return
     */
    public int SelectCountDao();
}
