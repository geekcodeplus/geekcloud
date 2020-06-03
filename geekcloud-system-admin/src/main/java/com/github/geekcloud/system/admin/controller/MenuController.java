package com.github.geekcloud.system.admin.controller;

import com.github.geekcloud.framework.core.response.ResultWrapper;
import com.github.geekcloud.system.admin.entity.form.MenuForm;
import com.github.geekcloud.system.admin.entity.form.MenuQueryForm;
import com.github.geekcloud.system.admin.entity.param.MenuQueryParam;
import com.github.geekcloud.system.admin.entity.po.Menu;
import com.github.geekcloud.system.admin.service.IMenuService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName: MenuController
 * @author: jeffrey
 * @date: 2020年06月02日
 * @Description: TODO
 */
@RestController
@RequestMapping("/menu")
@Api("menu")
@Slf4j
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @ApiOperation(value = "新增菜单", notes = "新增一个菜单")
    @ApiImplicitParam(name = "menuForm", value = "新增菜单form表单", required = true, dataType = "MenuForm")
    @PostMapping
    public ResultWrapper add(@Valid @RequestBody MenuForm menuForm) {
        log.debug("name:{}", menuForm);
        Menu menu = menuForm.toPo(Menu.class);
        return ResultWrapper.success(menuService.add(menu));
    }

    @ApiOperation(value = "删除菜单", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "菜单ID", required = true, dataType = "long")
    @DeleteMapping(value = "/{id}")
    public ResultWrapper delete(@PathVariable String id) {
        return ResultWrapper.success(menuService.delete(id));
    }

    @ApiOperation(value = "修改菜单", notes = "修改指定菜单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜单ID", required = true, dataType = "long"),
            @ApiImplicitParam(name = "menuForm", value = "菜单实体", required = true, dataType = "MenuForm")
    })
    @PutMapping(value = "/{id}")
    public ResultWrapper update(@PathVariable String id, @Valid @RequestBody MenuForm menuForm) {
        Menu menu = menuForm.toPo(Menu.class);
        menu.setId(id);
        return ResultWrapper.success(menuService.update(menu));
    }

    @ApiOperation(value = "获取菜单", notes = "获取指定菜单信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "菜单ID", required = true, dataType = "long")
    @GetMapping(value = "/{id}")
    public ResultWrapper get(@PathVariable String id) {
        log.debug("get with id:{}", id);
        return ResultWrapper.success(menuService.get(id));
    }

    @ApiOperation(value = "查询菜单", notes = "根据条件查询菜单信息，简单查询")
    @ApiImplicitParam(paramType = "query", name = "name", value = "菜单名称", required = true, dataType = "string")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = ResultWrapper.class)
    )
    @GetMapping
    public ResultWrapper query(@RequestParam String name) {
        log.debug("query with name:{}", name);
        MenuQueryParam menuQueryParam = new MenuQueryParam(name);
        return ResultWrapper.success(menuService.query(menuQueryParam));
    }

    @ApiOperation(value = "搜索菜单", notes = "根据条件查询菜单信息")
    @ApiImplicitParam(name = "menuQueryForm", value = "菜单查询参数", required = true, dataType = "MenuQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = ResultWrapper.class)
    )
    @PostMapping(value = "/conditions")
    public ResultWrapper search(@Valid @RequestBody MenuQueryForm menuQueryForm) {
        log.debug("search with menuQueryForm:{}", menuQueryForm);
        return ResultWrapper.success(menuService.query(menuQueryForm.toParam(MenuQueryParam.class)));
    }

    @ApiOperation(value = "根据父id查询菜单", notes = "根据父id查询菜单列表")
    @ApiImplicitParam(paramType = "path", name = "id", value = "菜单父ID", required = true, dataType = "long")
    @GetMapping(value = "/parent/{id}")
    public ResultWrapper search(@PathVariable String id) {
        log.debug("query with parent id:{}", id);
        return ResultWrapper.success(menuService.queryByParentId(id));
    }
}
