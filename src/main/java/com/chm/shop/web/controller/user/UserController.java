package com.chm.shop.web.controller.user;

import com.chm.shop.app.common.anno.MyValid;
import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.util.Md5Utils;
import com.chm.shop.app.util.RandomUtils;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.manager.role.RoleService;
import com.chm.shop.manager.user.UserService;
import com.chm.shop.manager.user.dataobject.UserDO;
import com.chm.shop.manager.user.query.UserQuery;
import com.chm.shop.manager.userrole.UserRoleService;
import com.chm.shop.manager.userrole.dataobject.UserRoleDO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yuwen on 2017/4/30.
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(UserQuery query, Model model) {

        PageResponse<UserDO> pageResponse = userService.list(query);
        model.addAttribute("data", pageResponse);
        return "/user/list";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String toRegister() {

        return "/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@MyValid UserDO userDO) throws Exception {

        String randomStr = RandomUtils.randomStr(6);
        userDO.setSalt(randomStr);
        String md5 = Md5Utils.getMD5(userDO.getPassword() + userDO.getSalt());
        userDO.setPassword(md5);

        UserDO byLoginId = userService.getByLoginId(userDO.getLoginId());
        if (byLoginId != null){
            return ResponseUtils.failResponse(byLoginId.getLoginId() + " 已经存在");
        }
        userService.register(userDO);
        return ResponseUtils.successResponse("/login","注册成功");
    }

    @RequestMapping(value = "/role/save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveRole(@MyValid UserRoleDO userRoleDO) throws Exception {

        Response<UserRoleDO> response;
       if (userRoleDO.getId() == null){
           response = userRoleService.insert(userRoleDO);
       }else {
           response = userRoleService.update(userRoleDO);
       }
        return response;
    }

    @RequestMapping(value = "/role/detail", method = RequestMethod.POST)
    @ResponseBody
    public Object roleDetail(Long userId) throws Exception {

        Response<UserRoleDO> byUserId = userRoleService.getByUserId(userId);

        if (byUserId.getData() != null){
            return roleService.getById(byUserId.getData().getRoleId());
        }
        return byUserId;
    }

    public static void main(String[] args) {
        //7847b3c5cd5ea3f3d6e94278b646f2bd
        String md5 = Md5Utils.getMD5("C36lC393");
        System.out.println(md5);
    }

}
