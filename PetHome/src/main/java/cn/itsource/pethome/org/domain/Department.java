package cn.itsource.pethome.org.domain;

import cn.itsource.pethome.org.base.domain.BaseDomain;
import lombok.Data;

@Data
public class Department extends BaseDomain {
    private String sn;
    private String name;
    private Integer state;
    private Employee manager;
    private Department parent;
}
