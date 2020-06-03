package com.github.geekcloud.security.authentication.controller;

import com.github.geekcloud.framework.core.response.ResultWrapper;
import com.github.geekcloud.security.authentication.service.IAuthenticationService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: AuthenticationController
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@RestController
@Api("auth")
@Slf4j
public class AuthenticationController {

    @Autowired
    IAuthenticationService authenticationService;

    @ApiOperation(value = "权限验证", notes = "根据用户token，访问的url和method判断用户是否有权限访问")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "url", value = "访问的url", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "method", value = "访问的method", required = true, dataType = "string")
    })
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = ResultWrapper.class))
    @PostMapping(value = "/auth/permission")
    public ResultWrapper decide(@RequestParam String url, @RequestParam String method, HttpServletRequest request) {
        boolean decide = authenticationService.decide(new HttpServletRequestAuthWrapper(request, url, method));
        return ResultWrapper.success(decide);
    }

}
