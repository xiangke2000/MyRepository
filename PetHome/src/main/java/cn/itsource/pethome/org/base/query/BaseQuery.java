package cn.itsource.pethome.org.base.query;

import lombok.Data;

/**
 * @version v1.8
 * @ProjectName: pethome_02
 * @ClassName: BaseQuery
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Think
 * @Date: 2020/7/6 23:11
 */
@Data
public class BaseQuery {
    //当前页
    private Integer pageNum=1;
    //每页条数
    private Integer pageSize=10;
    //关键词
    private String keyWord;
    //计算分页起始位置
    public Integer getStart(){
        return  (this.pageNum-1)*this.pageSize;
    }
}
