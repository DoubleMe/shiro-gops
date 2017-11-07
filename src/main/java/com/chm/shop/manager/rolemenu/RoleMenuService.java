package com.chm.shop.manager.rolemenu;

import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.manager.rolemenu.dataobject.RoleMenuDO;
import com.chm.shop.manager.rolemenu.query.RoleMenuQuery;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/6 10:45
 */
public interface RoleMenuService {

    /**
     * 新增
     */
    Response<RoleMenuDO> insert(RoleMenuDO roleMenuDO);

    /**
     * 主键查询
     */
    Response<List<RoleMenuDO>> getByRoleId(Long roleId);

    /**
     * 根据主键删除
     */
    Response<Boolean> delByRoleId(Long roleId);

    /**
     * 列表查询
     */
    PageResponse<PageList<RoleMenuDO>> list(RoleMenuQuery roleMenuQuery);
}
