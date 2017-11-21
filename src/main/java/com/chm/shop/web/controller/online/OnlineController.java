package com.chm.shop.web.controller.online;

import com.chm.shop.app.UserToken;
import com.chm.shop.app.common.query.PageQuery;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.manager.online.OnlineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/7 16:26
 */

@RequestMapping("/online")
@Controller
public class OnlineController {

    @Resource
    private OnlineService onlineService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(PageQuery pageQuery,Model model) {

        Response<List<UserToken>> listResponse = onlineService.onlineUser();
        model.addAttribute("data",listResponse.getData());
        return "/online/list";
    }
}
