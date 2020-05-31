package com.example.secondhandmarket.controller;

import com.example.secondhandmarket.domain.Users;
import com.example.secondhandmarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin        // 解决：No 'Access-Control-Allow-Origin' header is present on the requested resource
@RestController     // RestController 直接返回JSON数据
@RequestMapping("/UserController")
public class UserController {

    //自动装配
    @Autowired
    private UserService userService;

    /* 获取所有用户信息 */
    @RequestMapping(value = "/allUsers")
    public List<Users> getAllUsers(){
        return userService.findAll();
    }

    /* 根据用户名查找用户 */
    @RequestMapping(value = "/getUser")
    public Users getAUser(@RequestParam(value = "username") String name){
        return userService.getAUser(name);
    }

    /* 添加一个新用户 */
    @RequestMapping("/addUser")
    public boolean addUser(@RequestParam(value = "username") String name, @RequestParam(value = "password") String password) throws Exception {
        try {
            if(!userIsExist(name)) {
                Users users = new Users();
                users.setName(name);
                users.setPassword(password);
                userService.addUser(users);
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /* 登录 */
    @RequestMapping("/login")
    public String login(@RequestParam(value = "username") String name, @RequestParam(value = "password") String password){
        String log = "";
        System.out.println(name + " " + password);
        if(userIsExist(name)){
            if(checkPassword(name, password)){
                log = "true";
            }
            else {
                log = "loginFalse";
            }
        }
        else{
            log = "userNotExist";
        }
        System.out.println(log);
        return log;
    }
    @RequestMapping(value = "/deleter")
    public void deleteUser(String name)throws Exception{
        userService.deleteUser(name);

    }
    /* 判断用户是否已经存在 */
    public boolean userIsExist(String name){
        if(userService.getAUser(name) != null){
            return true;
        }
        return false;
    }

    /* 判断密码是否正确 */
    public boolean checkPassword(String name, String password) {
        try {
            Users user = userService.getAUser(name);
            if (user.getPassword().equals(password)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}
