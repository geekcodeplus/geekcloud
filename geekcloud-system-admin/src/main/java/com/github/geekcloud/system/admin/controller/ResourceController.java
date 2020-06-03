package com.github.geekcloud.system.admin.controller;

import com.github.geekcloud.framework.core.response.ResultWrapper;
import com.github.geekcloud.system.admin.entity.form.ResourceForm;
import com.github.geekcloud.system.admin.entity.form.ResourceQueryForm;
import com.github.geekcloud.system.admin.entity.param.ResourceQueryParam;
import com.github.geekcloud.system.admin.entity.po.Resource;
import com.github.geekcloud.system.admin.service.IResourceService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName: ResourceController
 * @author: jeffrey
 * @date: 2020年06月02日
 * @Description: TODO
 */
@RestController
@RequestMapping("/resource")
@Api("resource")
@Slf4j
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    @ApiOperation(value = "新增资源", notes = "新增一个资源")
    @ApiImplicitParam(name = "resourceForm", value = "新增资源form表单", required = true, dataType = "ResourceForm")
    @PostMapping
    public ResultWrapper add(@Valid @RequestBody ResourceForm resourceForm) {
        log.debug("name:{}", resourceForm);
        Resource resource = resourceForm.toPo(Resource.class);
        return ResultWrapper.success(resourceService.add(resource));
    }

    @ApiOperation(value = "删除资源", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "资源ID", required = true, dataType = "long")
    @DeleteMapping(value = "/{id}")
    public ResultWrapper delete(@PathVariable String id) {
        return ResultWrapper.success(resourceService.delete(id));
    }

    @ApiOperation(value = "修改资源", notes = "修改指定资源信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "资源ID", required = true, dataType = "long"),
            @ApiImplicitParam(name = "resourceForm", value = "资源实体", required = true, dataType = "ResourceForm")
    })
    @PutMapping(value = "/{id}")
    public ResultWrapper update(@PathVariable String id, @Valid @RequestBody ResourceForm resourceForm) {
        Resource resource = resourceForm.toPo(id, Resource.class);
        return ResultWrapper.success(resourceService.update(resource));
    }

    @ApiOperation(value = "获取资源", notes = "获取指定资源信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "资源ID", required = true, dataType = "long")
    @GetMapping(value = "/{id}")
    public ResultWrapper get(@PathVariable String id) {
        log.debug("get with id:{}", id);
        return ResultWrapper.success(resourceService.get(id));
    }

    @ApiOperation(value = "查询资源", notes = "根据userId查询用户所拥有的资源信息")
    @ApiImplicitParam(paramType = "path", name = "userId", value = "用户id", required = true, dataType = "long")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = ResultWrapper.class)
    )
    @GetMapping(value = "/user/{username}")
    public ResultWrapper queryByUsername(@PathVariable String username) {
        log.debug("query with username:{}", username);
        return ResultWrapper.success(resourceService.query(username));
    }

    @ApiOperation(value = "查询所有资源", notes = "查询所有资源信息")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = ResultWrapper.class)
    )
    @GetMapping(value = "/all")
    public ResultWrapper queryAll() {
        return ResultWrapper.success(resourceService.getAll());
    }

    @ApiOperation(value = "搜索资源", notes = "根据条件搜索资源信息")
    @ApiImplicitParam(name = "resourceQueryForm", value = "资源查询参数", required = true, dataType = "RoleQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = ResultWrapper.class)
    )
    @PostMapping(value = "/conditions")
    public ResultWrapper query(@Valid @RequestBody ResourceQueryForm resourceQueryForm) {
        log.debug("query with name:{}", resourceQueryForm);
        return ResultWrapper.success(resourceService.query(resourceQueryForm.getPage(), resourceQueryForm.toParam(ResourceQueryParam.class)));
    }
}