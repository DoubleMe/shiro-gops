package com.chm.shop.controller;

import com.chm.shop.biz.manager.product.ProductManager;
import com.chm.shop.biz.manager.product.dataobject.ProductDO;
import com.chm.shop.biz.manager.user.UserManager;
import com.chm.shop.biz.manager.user.dataobject.UserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuwen on 2017/4/26.
 */
@RequestMapping("/")
@Controller
public class IndexController {

    @Resource
    private ProductManager productManager;
    @Resource
    private UserManager userManager;
    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String homepage(Model model){

        return "redirect:main";
    }
    /**
     * 首页
     * @return
     */
    @RequestMapping("/main")
    public String main(@RequestParam(defaultValue = "1") Integer page,String q,Model model){

        q = q == null ? "" : q;
        int pageNum = (page - 1) * 2;
        int size = 8;
        List<ProductDO> list = productManager.query(q.trim(),pageNum,size);
        Page<ProductDO> pageModel = productManager.findAll(new PageRequest(page,8));

        model.addAttribute("products",list);
        model.addAttribute("totalPage",pageModel.getTotalElements()/8 + 1);
        model.addAttribute("pageNum",page);
        model.addAttribute("total",pageModel.getTotalElements());
        model.addAttribute("q",q);
        model.addAttribute("size",size);
        return "/index";
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable Long id,Model model){

        ProductDO productDO = productManager.findOne(id);
        model.addAttribute("detail",productDO);
        return "/detail";
    }

    /**
     * 订单页
     * @param id
     * @return
     */
    @RequestMapping("/order/{id}")
    public String order(@PathVariable Long id,Model model){
        ProductDO productDO = productManager.findOne(id);
        model.addAttribute("detail",productDO);
        return "/order";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String toLogin(){
        return "/user/login";
    }


}
