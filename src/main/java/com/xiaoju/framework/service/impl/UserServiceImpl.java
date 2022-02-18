package com.xiaoju.framework.service.impl;

import com.alibaba.druid.support.logging.Log;
import com.xiaoju.framework.constants.enums.StatusCode;
import com.xiaoju.framework.entity.dto.User;
import com.xiaoju.framework.entity.exception.CaseServerException;
import com.xiaoju.framework.entity.request.auth.UserLoginReq;
import com.xiaoju.framework.entity.request.auth.UserRegisterReq;
import com.xiaoju.framework.mapper.UserMapper;
import com.xiaoju.framework.service.UserService;
import com.xiaoju.framework.util.CodecUtils;
import com.xiaoju.framework.util.CookieUtils;
import com.xiaoju.framework.util.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 刘智 on 2021/4/22.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger Log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User register(UserRegisterReq req, HttpServletRequest request, HttpServletResponse response) {
        // 1.检查数据库中是否已经存在该用户
        User dbuser = userMapper.selectByUserName(req.getUsername());
        if (dbuser != null) {
            throw new CaseServerException("用户名已存在", StatusCode.INTERNAL_ERROR);
        }
        // 2.生成盐，对密码进行加密再保存到数据库中
        User user = new User();
        String salt = CodecUtils.generateSalt();
        user.setSalt(salt);
        user.setPassword(CodecUtils.md5Hex(req.getPassword(), salt));

        user.setUsername(req.getUsername());
        user.setChannel(1);
        user.setProductLineId(1L);
        user.setIsDelete(0);

        // 3.将新用户数据保存到数据库中
        userMapper.insertSelective(user);

        // 4.将新用户设置到cookie中去
        if (req.isLogin()) {
            CookieUtils.setCookie(request, response, "username", req.getUsername(), 60 * 60 * 24, null, false);
        } else {
            CookieUtils.setCookie(request, response, "username", req.getUsername(), 60 * 60 * 1, null, false);
        }
        return dbuser;
    }

    @Override
    public User login(UserLoginReq req, HttpServletRequest request, HttpServletResponse response) {
        if (!req.getUsername().matches("[\u4E00-\u9FA5]*[0-9]*")) {
            throw new CaseServerException("请输入中文账号", StatusCode.INTERNAL_ERROR);
        }
        // 1.检查数据库中是否存在该用户
        User dbuser = userMapper.selectByUserName(req.getUsername());
        if (dbuser == null) {
            throw new CaseServerException("用户名不存在", StatusCode.INTERNAL_ERROR);
        }
        // 2.校验密码是否正确
        if (!dbuser.getPassword().equals(CodecUtils.md5Hex(req.getPassword(), dbuser.getSalt()))) {
            throw new CaseServerException("密码错误", StatusCode.INTERNAL_ERROR);
        }
        // 3.将新用户设置到cookie中去
        if (req.getIsLogin()) {
            CookieUtils.setCookie(request, response, "username", req.getUsername(), 60 * 60 * 24, null, false);
        } else {
            CookieUtils.setCookie(request, response, "username", req.getUsername(), 60 * 60 * 1, null, false);
        }
        return dbuser;
    }

    @Override
    public Integer logout(HttpServletRequest request, HttpServletResponse response) {
        Integer result = 0;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {

            // 删除cookie中的username
            if (cookie.getName().equals("username")) {
                Cookie newcookie = new Cookie(cookie.getName(), null);

                // 路径path相同才会被判定为同名cookie，才能达到覆盖效果
                newcookie.setPath("/");
                newcookie.setMaxAge(0);

                response.addCookie(newcookie);
            }

            // 删除cookie中的jsessionid
            if (cookie.getName().equals("JSESSIONID")) {
                Cookie newcookie = new Cookie(cookie.getName(), null);

                // 路径path相同才会被判定为同名cookie，才能达到覆盖效果
                newcookie.setPath("/");
                newcookie.setMaxAge(0);

                response.addCookie(newcookie);
            }
        }

        return result;
    }

    @Override
    public List<User> getUserList(Integer isDelete) {
        List<User> userList = userMapper.getUserList(isDelete);
        return userList;
    }

    @Override
    public Integer updatePassWord(UserRegisterReq req, HttpServletRequest request, HttpServletResponse response) {
        Integer result = 0;
        User dbuser = userMapper.selectByUserName(req.getUsername());
        LinkedList<String> strs = new LinkedList<String>();
        strs.add(req.getUsername());
        strs.add(req.getPassword());
        strs.add(req.getNewpassword());
        if (StringUtil.isEmpty(strs)) {
            throw new CaseServerException("账号，新密码，确定新密码不能为空", StatusCode.INTERNAL_ERROR);
        } else if (StringUtil.isNotEqual(req.getPassword(), req.getNewpassword())) {
            throw new CaseServerException("新密码，确定新密码不一致", StatusCode.INTERNAL_ERROR);
        } else if (StringUtil.isEqual(CodecUtils.md5Hex(req.getPassword(), dbuser.getSalt()), dbuser.getPassword())) {
            throw new CaseServerException("新密码和原密码一致", StatusCode.INTERNAL_ERROR);
        } else {
            result = userMapper.updateUserPassWord(req.getUsername(),
                    CodecUtils.md5Hex(req.getPassword(), dbuser.getSalt()));
        }
        return result;
    }

    public static void main(String[] args) {
        // String str = "中a111124214124512500A";
        // String reg_charset = "[\u4E00-\u9FA5]*[a-z]*[0-9]*[A-Z]*";
        // Pattern p = Pattern.compile(reg_charset);
        // Matcher m = p.matcher(str);
        // System.out.println(m.matches());
        // if(m.matches()){
        // System.out.println("匹配");
        // }else{
        // System.out.println("不匹配");
        // }

        // String str = "中a111124214124512500A";
        // Pattern pattern = Pattern.compile("[\u4E00-\u9FA5]*[a-z]*[0-9]*[A-Z]*");
        // String str = "刘智1";
        // Pattern pattern = Pattern.compile("[\u4E00-\u9FA5]*[0-9]*");
        // char c[] = str.toCharArray();
        // System.out.println(c);
        // for(int i=0;i<c.length;i++){
        // System.out.println(c[i]);
        // Matcher matcher = pattern.matcher(String.valueOf(c[i]));
        // if(matcher.matches()){
        // System.out.println("true");
        // }else{
        // System.out.println("false");
        // }
        // }

        // String userName = "刘发送艾丝凡阿萨发送智1234567890987654321";
        // if (userName.matches("[\u4E00-\u9FA5]*[0-9]*")) {
        // System.out.println("true");
        // } else {
        // System.out.println("false");
        // }

        LinkedList<String> strs = new LinkedList<String>();
        strs.add("1");
        strs.add("2");
        strs.add("3");
        System.out.println(strs.toString());
        if (StringUtil.isNotEmpty(strs)) {
            System.out.println("true");
        }
    }
}
