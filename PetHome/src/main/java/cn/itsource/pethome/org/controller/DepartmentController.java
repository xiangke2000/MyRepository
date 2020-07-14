package cn.itsource.pethome.org.controller;

import cn.itsource.pethome.org.domain.Department;
import cn.itsource.pethome.org.query.DepartmentQuery;
import cn.itsource.pethome.org.service.IDepartmentService;
import cn.itsource.pethome.org.util.AjaxResult;
import cn.itsource.pethome.org.util.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
@Api(value = "部门", tags = {"部门操作接口"})
//@CrossOrigin使用注解实现跨域
public class DepartmentController {

    @Autowired
    private IDepartmentService iDepartmentService;

    @ApiOperation(value = "查询全部部门信息")
    @PatchMapping
    public AjaxResult findAll(@RequestBody DepartmentQuery departmentQuery) {
        PageList<Department> query = iDepartmentService.findByQuery(departmentQuery);
        return AjaxResult.me().setResultObj(query);
    }

    @GetMapping("/parent")
    public AjaxResult findAllParent() {
        List<Department> parent = iDepartmentService.findAll();
        return AjaxResult.me().setResultObj(parent);
    }

    @ApiOperation(value = "根据部门id获取部门")
    @ApiParam(name = "id", value = "部门id", required = true, type = "Long")
    @GetMapping(value = "/{id}")
    public AjaxResult findOne(@PathVariable(name = "id") Long id) {
        Department one = iDepartmentService.findOne(id);
        return AjaxResult.me().setResultObj(one);
    }

    @ApiOperation(value = "根据传入部门信息修改部门")
    @ApiParam(name = "Department", value = "部门信息", required = true, type = "Department")
    @PostMapping
    public AjaxResult update(@RequestBody Department department) {
        iDepartmentService.update(department);
        return AjaxResult.me();
    }

    @ApiOperation(value = "根据传入部门信息添加部门")
    @ApiParam(name = "Department", value = "部门信息", required = true, type = "Department")
    @PutMapping
    public AjaxResult add(@RequestBody Department department) {
        iDepartmentService.save(department);
        return AjaxResult.me();
    }

    @ApiOperation(value = "根据部门id删除部门")
    @ApiParam(name = "id", value = "部门id", required = true, type = "Long")
    @DeleteMapping(value = "/{id}")
    public AjaxResult del(@PathVariable(name = "id") Long id) {
        iDepartmentService.delete(id);
        return AjaxResult.me();
    }

    @PatchMapping(value = "/del/{ids}")
    public AjaxResult delMore(@PathVariable(name = "ids") Long[] ids) {
        iDepartmentService.deleteMore(ids);
        return AjaxResult.me();
    }
}
