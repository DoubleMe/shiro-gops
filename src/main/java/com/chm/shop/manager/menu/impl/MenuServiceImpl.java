package com.chm.shop.manager.menu.impl;

import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.common.reponse.ResponseCode;
import com.chm.shop.app.util.PageUtils;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.manager.menu.MenuService;
import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.menu.query.MenuQuery;
import com.chm.shop.mapper.MenuMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/1 17:58
 */

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public PageResponse<List<MenuDO>> list(MenuQuery menuQuery) {

        PageList<MenuDO> list = menuMapper.list(menuQuery, menuQuery.getPageBounds());

        return ResponseUtils.pageResponse(ResponseCode.SUCCESS, "成功", list);
    }

    @Override
    public Response<MenuDO> save(MenuDO menuDO) {

        if (menuDO.getId() != null) {
            menuMapper.update(menuDO);
        } else {
            menuMapper.insert(menuDO);
        }
        return ResponseUtils.successResponse(menuDO, "新增成功");
    }

    @Override
    public Response<Boolean> delete(Long id) {
        menuMapper.delById(id);

        return ResponseUtils.successResponse(Boolean.TRUE, "删除成功");
    }

    @Override
    public Response<MenuDO> detail(Long id) {
        return ResponseUtils.successResponse(menuMapper.getById(id), "");
    }
}
