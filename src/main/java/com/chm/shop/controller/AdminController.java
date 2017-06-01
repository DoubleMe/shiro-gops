package com.chm.shop.controller;

import com.chm.shop.biz.manager.product.ProductManager;
import com.chm.shop.biz.manager.product.dataobject.ProductDO;
import com.chm.shop.controller.base.BaseJsonObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuwen on 2017/5/20.
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
    @RequestMapping("/main")
    public String main() {

        return "/admin/main";
    }

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
    @ResponseBody
    public Object add(ProductDO productDO) {

        BaseJsonObject baseJsonObject = new BaseJsonObject();
        productManager.save(productDO);
        baseJsonObject.successRes("操作成功",null);
        return baseJsonObject;
    }


    /**
     * 商品列表
     *
     * @return
     */
    @RequestMapping("/del/{id}")
    @ResponseBody
    public Object del(@PathVariable Long id) {

        BaseJsonObject baseJsonObject = new BaseJsonObject();
        productManager.delete(id);
        baseJsonObject.successRes("操作成功",null);
        return baseJsonObject;
    }
}
