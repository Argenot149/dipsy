package cn.tedu.boot32.controller;

import cn.tedu.boot32.entity.User;
import cn.tedu.boot32.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;
    @RequestMapping("/reg")
    public String reg(User user){
        System.out.println("user = " + user);
        //通过用户输入的用户名查询是否存在数据  u代表查询回来的用户信息
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){ //如果不为null 说明此用户名已存在
            return "用户名已存在!";
        }
        //用户名不存在 可以注册
        mapper.insert(user);
        return "注册成功!";
    }
}
