package com.chm.shop.web.common.cache;

import com.chm.shop.app.UserTokenManager;
import com.chm.shop.app.cache.CommonCacheManager;
import com.chm.shop.app.cache.RedisKeys;
import com.chm.shop.manager.menu.MenuService;
import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.menu.query.MenuQuery;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/3 15:50
 */

@Component
public class MenuCache {

    @Resource
    private CommonCacheManager commonCacheManager;

    @Resource
    private MenuService menuService;

    /**
     * 获取用户菜单
     * @return
     */
    public List<MenuDO> getMenu(){

        String loginId = UserTokenManager.getLoginId();
        String menuKey = RedisKeys.getMenuKey(loginId);
        Object value = commonCacheManager.getValue(menuKey);

        if (value != null){
            return (List<MenuDO>)value;
        }

        return menuService.list(new MenuQuery()).getData();
    }

    /**
     * 获取当前用户打开页面,第一次进入 默认打开第一个菜单
     * @return
     */
    public Object getCurrMenuId(){

        Object value = commonCacheManager.getValue(RedisKeys.getCurrMenuKey(UserTokenManager.getLoginId()));

        if (value != null){
            return value;
        }

        List<MenuDO> menu = getMenu();
        if (!CollectionUtils.isEmpty(menu)){
            return menu.get(0).getId();
        }
        return null;
    }

    /**
     * 保存用户当前菜单ID
     * @param id
     */
    public void setCurrMenuId(Object id){
        commonCacheManager.setValue(RedisKeys.getCurrMenuKey(UserTokenManager.getLoginId()),id);
    }
}
