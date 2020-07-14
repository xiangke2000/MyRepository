package cn.itsource.pethome.org.service.impl;

import cn.itsource.pethome.org.domain.Shop;
import cn.itsource.pethome.org.mapper.EmployeeMapper;
import cn.itsource.pethome.org.mapper.ShopMapper;
import cn.itsource.pethome.org.service.IShopService;
import cn.itsource.pethome.org.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version v1.8
 * @ProjectName: PetHome
 * @ClassName: ShopServiceImpl
 * @Description: TODO(一句话描述该类的功能)
 * @Author: xiangke
 * @Date: 2020/7/10 22:47
 */
@Service
public class ShopServiceImpl extends BaseServiceImpl<Shop> implements IShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public void settledIn(Shop shop) {
        employeeMapper.save(shop.getAdmin());
        shopMapper.save(shop);
    }
}
