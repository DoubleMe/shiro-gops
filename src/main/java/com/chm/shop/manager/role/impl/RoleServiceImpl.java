package com.chm.shop.manager.role.impl;

import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.common.reponse.ResponseCode;
import com.chm.shop.app.constants.MessageConstats;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.manager.role.RoleService;
import com.chm.shop.manager.role.dataobject.RoleDO;
import com.chm.shop.manager.role.query.RoleQuery;
import com.chm.shop.mapper.RoleMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/3 16:25
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Response<RoleDO> insert(RoleDO role) {

        roleMapper.insert(role);
        return ResponseUtils.successResponse(role, MessageConstats.ADD_SUCCESS);
    }

    @Override
    public Response<RoleDO> update(RoleDO role) {
        roleMapper.update(role);
        return ResponseUtils.successResponse(role, MessageConstats.UPDATE_SUCCESS);
    }

    @Override
    public Response<RoleDO> getById(Long id) {

        RoleDO byId = roleMapper.getById(id);
        return ResponseUtils.successResponse(byId, MessageConstats.SUCCESS);
    }

    @Override
    public Response<Boolean> delById(Long id) {
        roleMapper.delById(id);
        return ResponseUtils.successResponse(Boolean.TRUE, MessageConstats.DELETE_SUCCESS);
    }

    @Override
    public PageResponse<List<RoleDO>> list(RoleQuery query) {
        PageList<RoleDO> list = roleMapper.list(query, query.getPageBounds());
        return ResponseUtils.pageResponse(ResponseCode.SUCCESS, MessageConstats.SUCCESS, list);
    }
}
