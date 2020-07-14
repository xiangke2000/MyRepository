package cn.itsource.pethome.org.service;

import cn.itsource.pethome.org.domain.Shop;
import cn.itsource.pethome.org.base.service.IBaseService;

/**
 * @version v1.8
 * @ProjectName: PetHome
 * @ClassName: IShopService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: xiangke
 * @Date: 2020/7/10 22:47
 */
public interface IShopService extends IBaseService<Shop>  {
    void settledIn(Shop shop);
}
