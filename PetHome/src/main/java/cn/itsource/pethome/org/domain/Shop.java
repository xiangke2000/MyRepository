package cn.itsource.pethome.org.domain;

import cn.itsource.pethome.org.base.domain.BaseDomain;
import lombok.Data;

import java.util.Date;

/**
 * @version v1.8
 * @ProjectName: PetHome
 * @ClassName: Shop
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Think
 * @Date: 2020/7/10 21:30
 */
@Data
public class Shop extends BaseDomain {
    private String name;
    private String tel;
    private Date registerTime = new Date();
    private int state = 0;
    private String address;
    private String logo;
    private Employee admin; 

}
