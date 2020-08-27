package hgkj.com.model.service.impl;

import hgkj.com.model.dao.LineDao;
import hgkj.com.model.dao.impl.LineDaoImpl;
import hgkj.com.model.entity.Line;
import hgkj.com.model.entity.Picture;
import hgkj.com.model.service.LineService;

import java.util.List;

public class LineServiceImpl implements LineService {
    private LineDao lineDao=new LineDaoImpl();
    /**
     * 旅游类型
     * @return
     */
    @Override
    public List<Line> InCountryService(String lineTypeID) {
        return lineDao.InCountryDao(lineTypeID);
    }

    /**
     * 旅游天数 一天，两天
     * @param days
     * @return
     */
    @Override
    public List<Line> DayTravlService(String days) {
        return lineDao.DayTravlDao(days);
    }
    /**
     * 旅游天数 多日
     * @return
     */
    @Override
    public List<Line> DaysTravlService() {
        return lineDao.DaysTravlDao();
    }

    /**
     * 旅游详情
     * @param lineID
     * @return
     */
    @Override
    public Line LineInfoService(String lineID) {
        return lineDao.LineInfoDao(lineID);
    }

    /**
     * 团购
     * @return
     */
    @Override
    public List<Line> TeamBuyService(int pageIndex,int pageSize) {
        return lineDao.TeamBuyDao(pageIndex,pageSize);
    }

    /**
     * 获取总页码数
     * @param pageSize
     * @return
     */
    @Override
    public int getTotalPageService(int pageSize) {
        return lineDao.getTotalPageDao(pageSize);
    }
    /**
     * 首页展示团购
     * @return
     */
    @Override
    public List<Line> IndexShowTeamBuyService() {
        return lineDao.IndexShowTeamBuyDao();
    }

    /**
     * 查询图片
     * @param lineID
     * @return
     */
    @Override
    public List<Picture> SelectPictureService(String lineID) {
        return lineDao.SelectPictureDao(lineID);
    }

    /**
     * 旅游类型查询团购
     * @param lineTypeID
     * @return
     */
    @Override
    public List<Line> TeamInSelectService(String lineTypeID) {
        return lineDao.TeamInSelectDao(lineTypeID);
    }

    /**
     * 获取按类型查询的总页数
     * @param lineTypeID
     * @param pageSize
     * @return
     */
    @Override
    public int SelectInPageSizeService(String lineTypeID,int pageSize) {
        return lineDao.SelectInPageSizeDao(lineTypeID,pageSize);
    }
    /**
     * 对旅游类型查询出来的数据进行分页
     * @param pageIndex
     * @param pageSize
     * @param lineTypeID
     * @return
     */
    @Override
    public List<Line> TypeSelectService(String lineTypeID, int pageIndex, int pageSize) {
        return lineDao.TypeSelectDao(lineTypeID,pageIndex,pageSize);
    }
}
