package hgkj.com.model.service;

import hgkj.com.model.entity.Car;

import java.util.List;

public interface CarService {
    public List<Car> AllService(int customerID);
    /**
     * 查询购物车
     * @param customerID
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Car> AllCarService(int customerID,int pageIndex,int pageSize);
    /**
     * 获取购物车总条数
     * @param customerID
     * @param pageSize
     * @return
     */
    public int SelectTotalPage(int customerID,int pageSize);

    /**
     * 删除购物车
     * @param carID
     * @return
     */
    public boolean DeleteCarService(int carID);

    /**
     * 添加购物车
     * @param car
     * @return
     */
    public boolean InsertCarService(Car car);
}
