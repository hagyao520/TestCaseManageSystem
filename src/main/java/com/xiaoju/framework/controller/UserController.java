package com.xiaoju.framework.controller;

import com.xiaoju.framework.entity.request.auth.UserLoginReq;
import com.xiaoju.framework.entity.request.auth.UserRegisterReq;
import com.xiaoju.framework.entity.response.controller.Response;
import com.xiaoju.framework.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * Created by 刘智 on 2021/4/22.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    UserService userService;

    /**
     * 用户注册
     * 
     * @param req
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/register")
    public Response<?> register(@RequestBody UserRegisterReq req, HttpServletRequest request,
            HttpServletResponse response) {
        return Response.success(userService.register(req, request, response));
    }

    /**
     * 用户登录
     * 
     * @param req
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    public Response<?> login(@RequestBody UserLoginReq req, HttpServletRequest request, HttpServletResponse response) {
        return Response.success(userService.login(req, request, response));
    }

    /**
     * 修改密码
     * 
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/updatePassWord")
    public Response<?> updatePassWord(@RequestBody UserRegisterReq req, HttpServletRequest request,
            HttpServletResponse response) {
        return Response.success(userService.updatePassWord(req, request, response));
    }

    /**
     * 用户退出
     * 
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/quit")
    public Response<?> logout(HttpServletRequest request, HttpServletResponse response) {
        return Response.success(userService.logout(request, response));
    }

    /**
     * 获取用户列表
     * 
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "/getUserList")
    public Response<?> getUserList(
            @RequestParam(defaultValue = "0", required = false) @NotNull(message = "是否删除为空") Integer isDelete) {
        return Response.success(userService.getUserList(isDelete));
    }
}
