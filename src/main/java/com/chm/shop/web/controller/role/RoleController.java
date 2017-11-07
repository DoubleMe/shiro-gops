package com.chm.shop.web.controller.role;

import com.chm.shop.app.UserTokenManager;
import com.chm.shop.app.common.anno.MyValid;
import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.manager.menu.MenuService;
import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.menu.query.MenuQuery;
import com.chm.shop.manager.role.RoleService;
import com.chm.shop.manager.role.dataobject.RoleDO;
import com.chm.shop.manager.role.query.RoleQuery;
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
 * @since 2017/11/3 16:35
 */

@RequestMapping("/role")
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(RoleQuery query, Model model) {

        PageResponse<List<RoleDO>> pageResponse = roleService.list(query);

        model.addAttribute("data", pageResponse);
        model.addAttribute("query", query);
        return "/role/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object postList(RoleQuery query, Model model) {

        PageResponse<List<RoleDO>> pageResponse = roleService.list(query);

        return pageResponse;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@MyValid RoleDO roleDO) {

        Response<RoleDO> save = null;
        roleDO.setLoginId(UserTokenManager.getLoginId());
        if (roleDO.getId() != null){
            save = roleService.update(roleDO);
        }else {
            save = roleService.insert(roleDO);
        }

        return save;
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object del(@PathVariable Long id) {

        Response<Boolean> response = roleService.delById(id);

        return response;
    }
}
