package com.chm.shop.web.controller.auth;

import com.chm.shop.app.common.anno.MyValid;
import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.constants.MessageConstats;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.manager.menu.MenuService;
import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.menu.query.MenuQuery;
import com.chm.shop.manager.role.RoleService;
import com.chm.shop.manager.rolemenu.RoleMenuService;
import com.chm.shop.manager.rolemenu.dataobject.RoleMenuDO;
import com.chm.shop.web.controller.auth.vo.RoleMenuVO;
import com.chm.shop.web.controller.auth.vo.SaveVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen-hongmin
 * @since 2017/11/6 10:43
 */

@RequestMapping("/auth")
@Controller
public class RoleMenuController {

    @Resource
    private MenuService menuService;

    @Resource
    private RoleService roleService;
    @Resource
    private RoleMenuService roleMenuService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object postList(Long roleId, Model model) {

        PageResponse<List<MenuDO>> pageResponse = menuService.list(new MenuQuery());

        Response<List<RoleMenuDO>> byRoleId = roleMenuService.getByRoleId(roleId);

        List<MenuDO> data = pageResponse.getData();
        List<Map<String,Object>> result = new ArrayList<>(data.size());
        for (MenuDO menuDO : data){
            Map<String,Object> map = new HashMap<>();
            map.put("id",menuDO.getId());
            map.put("name",menuDO.getName());
            map.put("url",menuDO.getUrl());
            map.put("LAY_CHECKED",hasAuth(menuDO.getId(),byRoleId.getData()));

            result.add(map);
        }

        return ResponseUtils.successResponse(result, MessageConstats.SUCCESS);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@MyValid SaveVO saveVO, Model model) {

        roleMenuService.delByRoleId(saveVO.getRoleId());
        String[] ids = saveVO.getMenuId().split(",");
        for (String id : ids){
            RoleMenuDO roleMenuDO = new RoleMenuDO();
            roleMenuDO.setRoleId(saveVO.getRoleId());
            roleMenuDO.setMenuId(Long.parseLong(id));
            roleMenuService.insert(roleMenuDO);
        }
        return ResponseUtils.successResponse(Boolean.TRUE, MessageConstats.SUCCESS);
    }

    /**
     * 是否已有权限
     * @param menuId
     * @param list
     * @return
     */
    private boolean hasAuth(Long menuId,List<RoleMenuDO> list){

        if (CollectionUtils.isEmpty(list)){
            return false;
        }

       for (RoleMenuDO roleMenuDO : list){
            if (menuId.equals(roleMenuDO.getMenuId())){
                return true;
            }

       }

        return false;
    }
}
