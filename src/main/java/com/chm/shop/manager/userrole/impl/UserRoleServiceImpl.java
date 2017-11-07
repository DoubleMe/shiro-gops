package com.chm.shop.manager.userrole.impl;

import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.constants.MessageConstats;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.manager.userrole.UserRoleService;
import com.chm.shop.manager.userrole.dataobject.UserRoleDO;
import com.chm.shop.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chen-hongmin
 * @since 2017/11/6 14:40
 */

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public Response<UserRoleDO> insert(UserRoleDO userRole) {
        userRoleMapper.insert(userRole);
        return ResponseUtils.successResponse(userRole, MessageConstats.ADD_SUCCESS);
    }

    @Override
    public Response<UserRoleDO> update(UserRoleDO userRole) {

        userRoleMapper.update(userRole);
        return ResponseUtils.successResponse(userRole, MessageConstats.UPDATE_SUCCESS);
    }

    @Override
    public Response<UserRoleDO> getByUserId(Long userId) {

        UserRoleDO byUserId = userRoleMapper.getByUserId(userId);
        return ResponseUtils.successResponse(byUserId, MessageConstats.SUCCESS);
    }
}
