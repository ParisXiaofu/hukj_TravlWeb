package hgkj.com.model.dao;

import hgkj.com.model.entity.Line;
import hgkj.com.model.entity.Picture;

import java.util.List;

public interface LineDao {
    /**
     * 旅游类型
     * @return
     */
    public List<Line> InCountryDao(String lineTypeID);

    /**
     * 旅游天数 一天，两天
     * @param days
     * @return
     */
    public List<Line> DayTravlDao(String days);

    /**
     * 旅游天数 多日
     * @return
     */
    public List<Line> DaysTravlDao();

    /**
     * 查询旅游详情
     * @param lineID
     * @return
     */
    public Line LineInfoDao(String lineID);

    /**
     * 团购
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Line> TeamBuyDao(int pageIndex,int pageSize);

    /**
     * 获取总页码
     * @param pageSize
     * @return
     */
    public  int getTotalPageDao(int pageSize);

    /**
     * 首页展示团购
     * @return
     */
    public List<Line> IndexShowTeamBuyDao();

    /**
     * 图片查询
     * @param lineID
     * @return
     */
    public List<Picture> SelectPictureDao(String lineID);

    /**
     * 旅游类型查询团购
     * @param lineTypeID
     * @return
     */
    public List<Line> TeamInSelectDao(String lineTypeID);

    /**
     * 获取按类型查询的总页数
     * @param lineTypeID
     * @param pageSize
     * @return
     */
    public int SelectInPageSizeDao(String lineTypeID,int pageSize);

    /**
     * 对旅游类型查询出来的数据进行分页
     * @param pageIndex
     * @param pageSize
     * @param lineTypeID
     * @return
     */
    public List<Line> TypeSelectDao(String lineTypeID,int pageIndex,int pageSize);
}
