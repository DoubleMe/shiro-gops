package com.chm.shop.manager.rolemenu.impl;

import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.common.reponse.ResponseCode;
import com.chm.shop.app.constants.MessageConstats;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.rolemenu.RoleMenuService;
import com.chm.shop.manager.rolemenu.dataobject.RoleMenuDO;
import com.chm.shop.manager.rolemenu.query.RoleMenuQuery;
import com.chm.shop.mapper.RoleMenuMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/6 10:45
 */

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Override
    public Response<RoleMenuDO> insert(RoleMenuDO roleMenuDO) {
        roleMenuMapper.insert(roleMenuDO);
        return ResponseUtils.successResponse(roleMenuDO, MessageConstats.ADD_SUCCESS);
    }

    @Override
    public Response<List<RoleMenuDO>> getByRoleId(Long roleId) {

        return ResponseUtils.successResponse(roleMenuMapper.getByRoleId(roleId), MessageConstats.SUCCESS);
    }

    @Override
    public Response<Boolean> delByRoleId(Long roleId) {

        roleMenuMapper.delById(roleId);
        return ResponseUtils.successResponse(Boolean.TRUE, MessageConstats.DELETE_SUCCESS);
    }

    @Override
    public Response<List<MenuDO>> listByRoleId(Long roleId) {
        return ResponseUtils.successResponse(roleMenuMapper.listMenu(roleId), MessageConstats.DELETE_SUCCESS);
    }

    @Override
    public PageResponse<PageList<RoleMenuDO>> list(RoleMenuQuery roleMenuQuery) {

        PageList<RoleMenuDO> list = roleMenuMapper.list(roleMenuQuery, new PageBounds(roleMenuQuery.getPage(), roleMenuQuery.getSize()));
        return ResponseUtils.pageResponse(ResponseCode.SUCCESS, MessageConstats.SUCCESS, list);
    }


}
