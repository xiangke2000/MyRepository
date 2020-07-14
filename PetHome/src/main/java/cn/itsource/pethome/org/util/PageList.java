package cn.itsource.pethome.org.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.8
 * @ProjectName: Pethome_02
 * @ClassName: PageList
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Think
 * @Date: 2020/7/10 9:06
 */
@Data
public class PageList<T> {
    private Integer total;
    private List<T> list = new ArrayList<>();
}
