package com.github.geekcloud.gateway.admin.controller;

import com.github.geekcloud.framework.core.response.ResultWrapper;
import com.github.geekcloud.gateway.admin.entity.form.GatewayRouteForm;
import com.github.geekcloud.gateway.admin.entity.form.GatewayRouteQueryForm;
import com.github.geekcloud.gateway.admin.entity.param.GatewayRouteQueryParam;
import com.github.geekcloud.gateway.admin.entity.po.GatewayRoute;
import com.github.geekcloud.gateway.admin.entity.vo.GatewayRouteVo;
import com.github.geekcloud.gateway.admin.service.IGatewayRouteService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import javax.validation.Valid;

/**
 * @ClassName: GatewayRouteController
 * @author: jeffrey
 * @date: 2020年05月25日
 * @Description: TODO
 */

@RestController
@RequestMapping("/gateway/routes")
@Api("gateway routes")
@Slf4j
public class GatewayRouteController {

    @Autowired
    private IGatewayRouteService gatewayRouteService;

    @ApiOperation(value = "新增网关路由", notes = "新增一个网关路由")
    @ApiImplicitParam(name = "gatewayRoutForm", value = "新增网关路由form表单", required = true, dataType = "GatewayRouteForm")
    @PostMapping
    public ResultWrapper add(@Valid @RequestBody GatewayRouteForm gatewayRoutForm) {
        log.info("name:" + gatewayRoutForm);
        GatewayRoute gatewayRout = gatewayRoutForm.toPo(GatewayRoute.class);
        return ResultWrapper.success(gatewayRouteService.add(gatewayRout));
    }

    @ApiOperation(value = "删除网关路由", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "网关路由ID", required = true, dataType = "long")
    @DeleteMapping(value = "/{id}")
    public ResultWrapper delete(@PathVariable String id) {
        return ResultWrapper.success(gatewayRouteService.delete(id));
    }

    @ApiOperation(value = "修改网关路由", notes = "修改指定网关路由信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "网关路由ID", required = true, dataType = "long"),
            @ApiImplicitParam(name = "gatewayRoutForm", value = "网关路由实体", required = true, dataType = "GatewayRouteForm")
    })
    @PutMapping(value = "/{id}")
    public ResultWrapper update(@PathVariable String id, @Valid @RequestBody GatewayRouteForm gatewayRoutForm) {
        GatewayRoute gatewayRout = gatewayRoutForm.toPo(GatewayRoute.class);
        gatewayRout.setId(id);
        return ResultWrapper.success(gatewayRouteService.update(gatewayRout));
    }

    @ApiOperation(value = "获取网关路由", notes = "根据id获取指定网关路由信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "网关路由ID", required = true, dataType = "long")
    @GetMapping(value = "/{id}")
    public ResultWrapper get(@PathVariable String id) {
        log.info("get with id:{}", id);
        return ResultWrapper.success(new GatewayRouteVo(gatewayRouteService.get(id)));
    }

    @ApiOperation(value = "根据uri获取网关路由", notes = "根据uri获取网关路由信息，简单查询")
    @ApiImplicitParam(paramType = "query", name = "name", value = "网关路由路径", required = true, dataType = "string")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = ResultWrapper.class)
    )
    @GetMapping
    public ResultWrapper getByUri(@RequestParam String uri) {
        return ResultWrapper.success(gatewayRouteService.query(new GatewayRouteQueryParam(uri)).stream().findFirst());
    }

    @ApiOperation(value = "搜索网关路由", notes = "根据条件查询网关路由信息")
    @ApiImplicitParam(name = "gatewayRoutQueryForm", value = "网关路由查询参数", required = true, dataType = "GatewayRouteQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = ResultWrapper.class)
    )
    @PostMapping(value = "/conditions")
    public ResultWrapper search(@Valid @RequestBody GatewayRouteQueryForm gatewayRouteQueryForm) {
        return ResultWrapper.success(gatewayRouteService.query(gatewayRouteQueryForm.toParam(GatewayRouteQueryParam.class)));
    }

    @ApiOperation(value = "重载网关路由", notes = "将所以网关的路由全部重载到redis中")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = ResultWrapper.class)
    )
    @PostMapping(value = "/overload")
    public ResultWrapper overload() {
        return ResultWrapper.success(gatewayRouteService.overload());
    }

}