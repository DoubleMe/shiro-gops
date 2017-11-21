package com.chm.shop.web.controller;

import com.chm.shop.app.shiro.ShiroService;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.web.controller.user.vo.UserLoginVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * @author chen-hongmin
 * @since 2017/10/26 17:36
 */

@RequestMapping("/")
@Controller
public class IndexController {

    @Resource
    private ShiroService shiroService;

    /**
     * 主页
     *
     * @return
     */
    @RequestMapping("/")
    public String main() {

        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated() || subject.isRemembered()) {
            return "/index";
        }
        return "redirect:/index/login";
    }


    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "/index/login", method = RequestMethod.GET)
    public String toLogin(String kickout, RedirectAttributes attr) {


        attr.addFlashAttribute("kickout", kickout);

        return "redirect:/index/toLogin";
    }

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "/index/toLogin", method = RequestMethod.GET)
    public String toLoginPage() {
        return "/login";
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/index/login", method = RequestMethod.POST)
    public String login(UserLoginVO vo, Model model) {

        boolean rememberMe = false;
//        if (vo.getRememberMe() != null && vo.getRememberMe() == 1) {
//            rememberMe = false;
//        }
        Response<String> login = shiroService.login(vo.getUserName(), vo.getUserPwd(), rememberMe);
        if (login.isSuccess()) {
            return "/index";
        }

        model.addAttribute("msg", login.getMessage());
        return "/login";
    }

    /**
     * 跳转404
     *
     * @return
     */
    @RequestMapping(value = "/index/notFound", method = RequestMethod.GET)
    public String notFound() {
        return "/notFound";
    }

    /**
     * 跳转错误页面
     *
     * @return
     */
    @RequestMapping(value = "/index/error", method = RequestMethod.GET)
    public String error(String msg, Model model) {

        model.addAttribute("msg",msg);
        return "/error";
    }

    /**
     * 跳转没有权限页面
     *
     * @return
     */
    @RequestMapping(value = "/index/noPermission", method = RequestMethod.GET)
    public String noPermission() {

        return "/noPermission";
    }
}
