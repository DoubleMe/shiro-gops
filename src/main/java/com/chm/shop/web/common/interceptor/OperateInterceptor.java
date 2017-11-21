package com.chm.shop.web.common.interceptor;


import com.chm.shop.app.constants.CommonConstants;
import com.chm.shop.web.common.cache.MenuCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chen-hongmin on 2015/6/25.
 */
public class OperateInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(OperateInterceptor.class);

    @Resource
    private MenuCacheService menuCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        //保存当前用户菜单ID
        String mid = request.getParameter(CommonConstants.CURR_MENU_ID);
        if (!ObjectUtils.isEmpty(mid)) {
            menuCache.setCurrMenuId(mid);
        }


        logger.debug("当前访问路径：" + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);
        if (modelAndView != null) {
            modelAndView.addObject(CommonConstants.MENU, menuCache.getShowMenu());
            modelAndView.addObject(CommonConstants.CURR_MENU_ID, menuCache.getCurrMenuId());
        }

    }
}
