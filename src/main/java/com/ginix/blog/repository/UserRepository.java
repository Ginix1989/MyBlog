package com.ginix.blog.repository;

import com.ginix.blog.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *  User Respository
 *  用户的增删改查
 *
 */
public interface UserRepository extends CrudRepository<User,Long> {
//
////    添加或修改用户
//    User saveOrUpadateUser(User user);
//
////    删除用户
//    void deleteUser(Long id);
////根据用户Id进行查询
//    User getUserById(Long id);
////获取用户列表
//    List<User> getListUsers();

}
