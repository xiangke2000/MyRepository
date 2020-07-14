package cn.itsource.pethome.org.controller;
import cn.itsource.pethome.org.domain.Employee;
import cn.itsource.pethome.org.query.EmployeeQuery;
import cn.itsource.pethome.org.service.IEmployeeService;
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
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @PatchMapping
    public AjaxResult findAll(@RequestBody EmployeeQuery employeeQuery) {
        PageList<Employee> pageList = iEmployeeService.findByQuery(employeeQuery);
        return AjaxResult.me().setResultObj(pageList);
    }

    @PostMapping
    public AjaxResult save(@RequestBody Employee employee) {
        iEmployeeService.save(employee);
        return AjaxResult.me();
    }

    @PutMapping
    public AjaxResult update(@RequestBody Employee employee) {
        iEmployeeService.update(employee);
        return AjaxResult.me();
    }

    @DeleteMapping(value = "/{id}")
    public AjaxResult del(@PathVariable(name = "id") Long id) {
        iEmployeeService.delete(id);
        return AjaxResult.me();
    }

    @PatchMapping(value = "/del/{ids}")
    public AjaxResult delMore(@PathVariable(name = "ids") Long[] ids) {
        iEmployeeService.deleteMore(ids);
        return AjaxResult.me();
    }
}
