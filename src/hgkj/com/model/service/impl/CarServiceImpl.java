package hgkj.com.model.service.impl;

import hgkj.com.model.dao.CarDao;
import hgkj.com.model.dao.impl.CarDaoImpl;
import hgkj.com.model.entity.Car;
import hgkj.com.model.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    private CarDao carDao=new CarDaoImpl();

    @Override
    public List<Car> AllService(int customerID) {
        return carDao.allDao(customerID);
    }

    /**
     * 查询购物车
     * @param customerID
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<Car> AllCarService(int customerID,int pageIndex,int pageSize) {
        return carDao.allCarDao(customerID,pageIndex,pageSize);
    }

    /**
     * 查询购物车总页数
     * @param customerID
     * @param pageSize
     * @return
     */
    @Override
    public int SelectTotalPage(int customerID, int pageSize) {
        return carDao.SelectTotalPageDao(customerID,pageSize);
    }

    /**
     * 删除购物车
     * @param carID
     * @return
     */
    @Override
    public boolean DeleteCarService(int carID) {
        return carDao.DeleteCarDao(carID);
    }

    /**
     * 添加购物车
     * @param car
     * @return
     */
    @Override
    public boolean InsertCarService(Car car) {
        return carDao.InsertCarDao(car);
    }
}
