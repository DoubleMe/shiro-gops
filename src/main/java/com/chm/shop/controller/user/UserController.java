package com.chm.shop.controller.user;

import com.chm.shop.app.util.CookieUtils;
import com.chm.shop.biz.manager.user.UserManager;
import com.chm.shop.biz.manager.user.dataobject.UserDO;
import com.chm.shop.controller.user.vo.UserLoginVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chen-hongmin on 2017/4/30.
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Resource
    private UserManager userManager;
    @Resource
    private HttpServletRequest request;
    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String toLogin(UserLoginVO vo, HttpServletResponse response,Model model){
        UserDO userDO = userManager.findByLoginId(vo.getUserName());
        if (userDO == null || !userDO.getUserPwd().equals(vo.getUserPwd())){
            model.addAttribute("msg","用户名或密码错误");
            return "/user/login";
        }

        CookieUtils.addCookie(response,"userId", String.valueOf(userDO.getUserId()));
        CookieUtils.addCookie(response,"userName", String.valueOf(userDO.getUserName()));
        return "redirect:/main.ftl";
    }

    @RequestMapping("/add")
    public String addUser(UserDO userDO,HttpServletResponse response,Model model){

        UserDO user = userManager.findByLoginId(userDO.getLoginId());
        if (user != null){
            model.addAttribute("msg","用户名已经存在");
            return "/user/register";
        }
        UserDO auser = userManager.save(userDO);
        CookieUtils.addCookie(response,"userId", String.valueOf(userDO.getUserId()));
        CookieUtils.addCookie(response,"userName", String.valueOf(userDO.getUserName()));
        return "redirect:/main.ftl";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){

        return "/user/register";
    }

    /**
     * 卖家登录
     * @return
     */
    @RequestMapping("/admin/toLogin")
    public String toAdminLogin(){
        return "/admin/login";
    }
    /**
     * 卖家登录
     * @return
     */
    @RequestMapping("/admin/login")
    public String adminLogin(UserLoginVO vo, HttpServletResponse response,Model model){
        if (!"admin".equals(vo.getUserName()) || !"admin".equals(vo.getUserPwd())){
            model.addAttribute("msg","用户名或密码错误");
            return "/admin/login";
        }
        CookieUtils.addCookie(response,"userId", "admin");
        CookieUtils.addCookie(response,"userName", "admin");
        return "/admin/main";
    }
}
