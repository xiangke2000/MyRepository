package cn.itsource.pethome.org.domain;

import cn.itsource.pethome.org.base.domain.BaseDomain;
import lombok.Data;

/**
 * @version v1.8
 * @ProjectName: pethome_02
 * @ClassName: Employee
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Think
 * @Date: 2020/7/9 11:38
 */
@Data
public class Employee extends BaseDomain {
    private String username;
    private String email;
    private String phone;
    private String password;
    private Integer age;
    private Integer state=0;
}
