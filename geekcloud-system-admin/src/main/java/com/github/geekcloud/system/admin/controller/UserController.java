package com.github.geekcloud.system.admin.controller;

import com.github.geekcloud.framework.core.response.ResultWrapper;
import com.github.geekcloud.system.admin.entity.form.UserForm;
import com.github.geekcloud.system.admin.entity.form.UserQueryForm;
import com.github.geekcloud.system.admin.entity.form.UserUpdateForm;
import com.github.geekcloud.system.admin.entity.param.UserQueryParam;
import com.github.geekcloud.system.admin.entity.po.User;
import com.github.geekcloud.system.admin.service.IUserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName: UserController
 * @author: jeffrey
 * @date: 2020年06月02日
 * @Description: TODO
 */
@RestController
@RequestMapping("/user")
@Api("user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "新增用户", notes = "新增一个用户")
    @ApiImplicitParam(name = "userForm", value = "新增用户form表单", required = true, dataType = "UserForm")
    @PostMapping
    public ResultWrapper add(@Valid @RequestBody UserForm userForm) {
        log.debug("name:{}", userForm);
        User user = userForm.toPo(User.class);
        return ResultWrapper.success(userService.add(user));
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象，逻辑删除")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public ResultWrapper delete(@PathVariable String id) {
        return ResultWrapper.success(userService.delete(id));
    }

    @ApiOperation(value = "修改用户", notes = "修改指定用户信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userUpdateForm", value = "用户实体", required = true, dataType = "UserUpdateForm")})
    @PutMapping(value = "/{id}")
    public ResultWrapper update(@PathVariable String id, @Valid @RequestBody UserUpdateForm userUpdateForm) {
        User user = userUpdateForm.toPo(User.class);
        user.setId(id);
        return ResultWrapper.success(userService.update(user));
    }

    @ApiOperation(value = "获取用户", notes = "获取指定用户信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public ResultWrapper get(@PathVariable String id) {
        log.debug("get with id:{}", id);
        return ResultWrapper.success(userService.get(id));
    }

    @ApiOperation(value = "获取用户", notes = "根据用户唯一标识（username or mobile）获取用户信息")
    @ApiImplicitParam(paramType = "query", name = "uniqueId", value = "用户唯一标识", required = true, dataType = "string")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = ResultWrapper.class))
    @GetMapping
    public ResultWrapper query(@RequestParam String uniqueId) {
        log.debug("query with username or mobile:{}", uniqueId);
        return ResultWrapper.success(userService.getByUniqueId(uniqueId));
    }

    @ApiOperation(value = "搜索用户", notes = "根据条件查询用户信息")
    @ApiImplicitParam(name = "userQueryForm", value = "用户查询参数", required = true, dataType = "UserQueryForm")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = ResultWrapper.class))
    @PostMapping(value = "/conditions")
    public ResultWrapper search(@Valid @RequestBody UserQueryForm userQueryForm) {
        log.debug("search with userQueryForm:{}", userQueryForm);
        return ResultWrapper.success(userService.query(userQueryForm.getPage(), userQueryForm.toParam(UserQueryParam.class)));
    }
}
