package com.chm.shop.controller;

import com.chm.shop.biz.manager.user.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by chen-hongmin on 2017/4/26.
 */
@RequestMapping("/")
@Controller
public class IndexController {

    @Resource
    private UserManager userManager;
    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String homepage(Model model){

//        model.addAttribute("users",userManager.findAll());
//        model.addAttribute("errorMsg","获取用户信息");
        return "/index";
    }
}
