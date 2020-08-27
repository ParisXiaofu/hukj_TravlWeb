package hgkj.com.model.service;

import hgkj.com.model.entity.Line;
import hgkj.com.model.entity.Picture;

import java.util.List;

public interface LineService {
    /**
     * 旅游类型
     * @return
     */
    public List<Line> InCountryService(String lineTypeID);
    /**
     * 旅游天数 一天，两天
     * @param days
     * @return
     */
    public List<Line> DayTravlService(String days);

    /**
     * 旅游天数 多日
     * @return
     */
    public List<Line> DaysTravlService();

    /**
     * 查询详情
     * @param lineID
     * @return
     */
    public Line LineInfoService(String lineID);

    /**
     * 团购
     * @return
     */
    public  List<Line> TeamBuyService(int pageIndex,int pageSize);

    /**
     * 获取总页码
     * @param pageSize
     * @return
     */
    public  int getTotalPageService(int pageSize);

    /**
     * 首页展示团购
     * @return
     */
    public List<Line> IndexShowTeamBuyService();

    /**
     * 查询图片
     * @param lineID
     * @return
     */
    public List<Picture> SelectPictureService(String lineID);

    /**
     * 旅游类型查询团购
     * @param lineTypeID
     * @return
     */
    public List<Line> TeamInSelectService(String lineTypeID);
    /**
     * 获取按类型查询的总页数
     * @param pageSize
     * @return
     */
    public int SelectInPageSizeService(String lineTypeID,int pageSize);

    /**
     * 对旅游类型查询出来的数据进行分页
     * @param pageIndex
     * @param pageSize
     * @param lineTypeID
     * @return
     */
    public List<Line> TypeSelectService(String lineTypeID,int pageIndex,int pageSize);
}
