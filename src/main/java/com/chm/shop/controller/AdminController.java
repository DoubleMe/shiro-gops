package com.chm.shop.controller;

import com.chm.shop.biz.manager.product.ProductManager;
import com.chm.shop.biz.manager.product.dataobject.ProductDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chen-hongmin on 2017/5/20.
 */
@RequestMapping("/admin/shop")
@Controller
public class AdminController {


    @Resource
    private ProductManager productManager;

    /**
     * 商品列表
     *
     * @return
     */
    @RequestMapping("/list")
    public String shop(@RequestParam(defaultValue = "1") Integer page, String q, Model model) {

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
        return "/admin/shop/list";
    }

    /**
     * 商品列表
     *
     * @return
     */
    @RequestMapping("/detail")
    public String detail(Long id, Model model) {

        if (id != null){

            ProductDO productDO = productManager.findOne(id);
            model.addAttribute("data",productDO);
        }
        return "/admin/shop/detail";
    }

    /**
     * 商品列表
     *
     * @return
     */
    @RequestMapping("/add")
    public String add(ProductDO productDO, Model model) {

        productManager.save(productDO);
        return "/admin/shop/detail";
    }
}
