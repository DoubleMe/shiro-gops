package com.chm.shop.web.common.cache;

import com.chm.shop.app.UserTokenManager;
import com.chm.shop.app.cache.BaseCache;
import com.chm.shop.app.cache.RedisKeys;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.rolemenu.RoleMenuService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author chen-hongmin
 * @since 2017/11/3 15:50
 */

@Component
public class MenuCacheService {

    @Resource
    private BaseCache baseCache;

    @Resource
    private RoleMenuService roleMenuService;


    /**
     * 获取角色菜单
     *
     * @return
     */
    public List<MenuDO> getRoleMenu() {

        String userRole = UserTokenManager.getUserRole();
        if (StringUtils.isEmpty(userRole)){
            return null;
        }
        String menuKey = RedisKeys.getMenuKey(userRole);
        Object value = baseCache.getValue(menuKey);
//        if (value == null) {
            value = refreshMenu(userRole);

//        }

        if (value == null){
            return null;
        }

        return (List<MenuDO>)value;
    }

    /**
     * 获取侧边栏菜单
     *
     * @return
     */
    public List<MenuDO> getShowMenu() {

        List<MenuDO> menuDOList = getRoleMenu();
        if (CollectionUtils.isEmpty(menuDOList)){
            return menuDOList;
        }

        Map<Long,List<MenuDO>> menuMap = new HashMap<>();
        Iterator<MenuDO> iterator = menuDOList.iterator();
        //经历两次遍历 时间复杂度为2*n

        //遍历菜单列表 映射成 parentId - children menu
        while (iterator.hasNext()){
            MenuDO menuDO = iterator.next();
            //一级机构和
            if (menuDO.getType() == 1){
                iterator.remove();
                continue;
            }
            List<MenuDO> menuDOS = menuMap.get(menuDO.getParentId());
            if (menuDOS == null){
                menuDOS = new ArrayList<>();
                menuMap.put(menuDO.getParentId(),menuDOS);
            }
            menuDOS.add(menuDO);
        }
        Object currMenuId = getCurrMenuId();
        //遍历菜单列表 装配菜单的children
        menuDOList.forEach(menuDO -> {
            List<MenuDO> menuDOS = menuMap.get(menuDO.getId());
            menuDO.setChildren(menuDOS);
            if (!CollectionUtils.isEmpty(menuDOS)){
                for (MenuDO menu : menuDOS){
                    if (menu.getId().toString().equals(currMenuId)){
                        menuDO.setSelected(true);
                    }
                }
            }
        });
        //返回父菜单是0 及顶级菜单链接
        return menuMap.get(0L);
    }

    /**
     * 获取当前用户打开页面,第一次进入 默认打开第一个菜单
     *
     * @return
     */
    public Object getCurrMenuId() {

        Object value = baseCache.getValue(RedisKeys.getCurrMenuKey(UserTokenManager.getLoginId()));

        if (value != null) {
            return value;
        }

        List<MenuDO> menu = getRoleMenu();
        if (!CollectionUtils.isEmpty(menu)) {
            return menu.get(0).getId();
        }
        return null;
    }

    /**
     * 保存用户当前菜单ID
     *
     * @param id
     */
    public void setCurrMenuId(Object id) {
        baseCache.setValue(RedisKeys.getCurrMenuKey(UserTokenManager.getLoginId()), id);
    }


    /**
     * 刷新菜单
     * @return
     */
    public List<MenuDO> refreshMenu(String role) {

        Response<List<MenuDO>> listResponse = roleMenuService.listByRoleId(Long.valueOf(role));
        if (!listResponse.isSuccess() || listResponse.getData() == null) {
            return null;
        }
        String menuKey = RedisKeys.getMenuKey(role);
        baseCache.setValue(menuKey, listResponse.getData());

        return listResponse.getData();
    }

}
