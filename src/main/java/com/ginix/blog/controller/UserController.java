package com.ginix.blog.controller;


import com.ginix.blog.domain.User;
import com.ginix.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 *  UserController
 */
@RestController
@RequestMapping("/users") //设置请求路径 针对users 进行请求处理
public class UserController {

//注入用户资源库
    @Autowired
    private UserRepository userRepository;


    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping   //映射
    //以页面形式进行返回
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.findAll());
        model.addAttribute("title","用户管理");
        //返回的路径 模型的名称 模型的内容
        return  new ModelAndView("users/list","userModel",model);
//        return  new ModelAndView("users/list");

//        return  null;
    }




    /**
     * 查询用户 根据用户id 查询
     * @param model
     * @return
     */
    @GetMapping("{id}")  //映射 需要传入Id
    //接受id 需要添加的注解
    public ModelAndView view(@PathVariable("id") Long id, Model model){

        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return  new ModelAndView("users/view","userModel",model);
    }

    /**
     * 创建表单
     * @param model
     * @return
     */
    @GetMapping("/form")
    //接受id 需要添加的注解
    public ModelAndView createForm(Model model){

        model.addAttribute("user",new User( null,null,null));
        model.addAttribute("title","创建用户");
        return  new ModelAndView("users/form","userModel",model);
    }





//    保存用户
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user)
    {
       userRepository.save(user);
         //自测试 有效
        //       return   list(model); 自测试有效
            return  new ModelAndView("redirect:/users");
    }

//    删除用户
    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id)
    {

        userRepository.deleteById(id);

        return  new ModelAndView("redirect:/users");
    }


//    修改用户
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id ,Model model)
    {

        Optional<User>  user = userRepository.findById(id);

      model.addAttribute("title","修改用户");
      model.addAttribute("user",user);

        return new ModelAndView("users/form","userModel",model);
    }
}
