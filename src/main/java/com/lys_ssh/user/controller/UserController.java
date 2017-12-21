package com.lys_ssh.user.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys_ssh.base.BaseController;
import com.lys_ssh.base.page.Pager;
import com.lys_ssh.user.entity.UserEntity;
import com.lys_ssh.user.service.UserService;





@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Autowired
    UserService userService;
	
    @RequestMapping(value = "/index")
    public String index() {
        return "jsp/user/index";
    }
    
   
    @RequestMapping(value = "/findByHql")
    @ResponseBody
    public Pager findByHql(Pager p){
    	p.setHql("from UserEntity");
    	return userService.findByHql(p, null);
    }
    
    @RequestMapping(value = "/save")
    @ResponseBody
    public void save(UserEntity user){
    	user.setCreateTime(new Date());
    	user.setAlterTime(new Date());
    	userService.save(user);
    }
    
    

}
