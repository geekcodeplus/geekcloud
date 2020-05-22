package com.github.geekcloud.test.controller;

import com.github.geekcloud.framework.cache.repository.CacheRepository;
import com.github.geekcloud.framework.core.annotation.SysLog;
import com.github.geekcloud.framework.core.response.ResultWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: UserController
 * @author: jeffrey
 * @date: 2020年04月15日
 * @Description: TODO
 */
@RestController
public class UserController {

    @Resource
    private CacheRepository cacheRepository;

    @GetMapping("/user")
    @SysLog("用户信息查询.")
    public Object user() {
        //return "张三。。查询成功。。。";
        //cacheRepository.set("user:123", "jack");
        return ResultWrapper.success("张三。。查询成功。。。");
    }

    @GetMapping("/setuser")
    public Object setuser(@RequestParam(name = "key") String key, @RequestParam(name = "value") String value) {
        cacheRepository.set("user:" + key, value);
        return ResultWrapper.success();
    }

    @GetMapping("/getuser")
    public Object getuser(@RequestParam(name = "key") String key) {
        String value = cacheRepository.get("user:" + key);
        return ResultWrapper.success(value);
    }
}
