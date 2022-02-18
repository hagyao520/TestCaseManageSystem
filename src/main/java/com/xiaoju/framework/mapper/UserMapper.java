package com.xiaoju.framework.mapper;

import java.util.List;

import com.xiaoju.framework.entity.dto.User;

public interface UserMapper {

    int insert(User record);

    int insertSelective(User record);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateUserPassWord(String username, String password);

    User selectByPrimaryKey(Long id);

    User selectByUserName(String username);

    List<User> getUserList(Integer isDelete);
}