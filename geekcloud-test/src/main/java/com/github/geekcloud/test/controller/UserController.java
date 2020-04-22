package com.github.geekcloud.test.controller;

import com.github.geekcloud.framework.core.annotation.SysLog;
import com.github.geekcloud.framework.core.response.ResultWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @author: jeffrey
 * @date: 2020年04月15日
 * @Description: TODO
 */
@RestController
public class UserController {

    @GetMapping("/getuser")
    @SysLog("用户信息查询.")
    public Object user() {
        //return "张三。。查询成功。。。";
        return ResultWrapper.success("张三。。查询成功。。。");
    }
}
