package cn.itsource.pethome.org.controller;
import cn.itsource.pethome.org.domain.Shop;
import cn.itsource.pethome.org.query.ShopQuery;
import cn.itsource.pethome.org.service.IShopService;
import cn.itsource.pethome.org.util.AjaxResult;
import cn.itsource.pethome.org.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.8
 * @ProjectName: pethome_02
 * @ClassName: EmployeeController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Think
 * @Date: 2020/7/9 18:24
 */
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private IShopService iShopService;

    @PatchMapping
    public AjaxResult findAll(@RequestBody ShopQuery shopQuery) {
        PageList<Shop> pageList = iShopService.findByQuery(shopQuery);
        return AjaxResult.me().setResultObj(pageList);
    }

    @PostMapping
    public AjaxResult save(@RequestBody Shop shop) {
        iShopService.save(shop);
        return AjaxResult.me();
    }

    @PutMapping
    public AjaxResult update(@RequestBody Shop shop) {
        iShopService.update(shop);
        return AjaxResult.me();
    }

    @DeleteMapping(value = "/{id}")
    public AjaxResult del(@PathVariable(name = "id") Long id) {
        iShopService.delete(id);
        return AjaxResult.me();
    }

    @PatchMapping(value = "/del/{ids}")
    public AjaxResult delMore(@PathVariable(name = "ids") Long[] ids) {
        iShopService.deleteMore(ids);
        return AjaxResult.me();
    }
    @PostMapping("/settledIn")
    public AjaxResult settledIn(@RequestBody Shop shop) {
        iShopService.settledIn(shop);
        return AjaxResult.me();
    }
}
