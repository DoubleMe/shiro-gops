package com.chm.shop.web.controller.menu;

import com.chm.shop.app.common.anno.MyValid;
import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.manager.menu.MenuService;
import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.menu.query.MenuQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/10/26 17:36
 */

@RequestMapping("/menu")
@Controller
public class MenuController {

    @Resource
    private MenuService menuService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(MenuQuery query, Model model) {

        PageResponse<List<MenuDO>> pageResponse = menuService.list(query);
        model.addAttribute("data", pageResponse);
        model.addAttribute("query", query);
        return "/menu/list";
    }


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object postList(MenuQuery query, Model model) {

        PageResponse<List<MenuDO>> pageResponse = menuService.list(query);
        return pageResponse;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object detail(@PathVariable Long id) {

        Response<MenuDO> response = menuService.detail(id);

        return response;
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@MyValid MenuDO menuDO) {

        Response<MenuDO> save = menuService.save(menuDO);

        return save;
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object del(@PathVariable Long id) {

        Response<Boolean> response = menuService.delete(id);

        return response;
    }
}
