package hgkj.com.model.dao;

import hgkj.com.model.entity.Car;

import java.util.List;

public interface CarDao {
    public List<Car> allDao(int customerID);
    /**
     * 查询购物车
     * @param customerID
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Car> allCarDao(int customerID,int pageIndex,int pageSize);

    /**
     * 获取购物车总条数
     * @param customerID
     * @param pageSize
     * @return
     */
    public int SelectTotalPageDao(int customerID,int pageSize);

    /**
     * 删除购物车
     * @param carID
     * @return
     */
     public boolean DeleteCarDao(int carID);

    /**
     * 添加购物车
     * @param car
     * @return
     */
     public boolean InsertCarDao(Car car);
}
