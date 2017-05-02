package com.chm.shop.app.constant;

import java.util.ArrayList;
import java.util.List;

public class UrlRightConstant {
    //会诊室
    public static List<String> echatRoomUrlList = new ArrayList<String>();
    // 忽略所有验证
    public static List<String> notVerifyUrlList = new ArrayList<String>();


    static {
        notVerifyUrlList.add("/login");
        notVerifyUrlList.add("/user/login");
        notVerifyUrlList.add("/logout");
        notVerifyUrlList.add("/rlogin");
        notVerifyUrlList.add("/dologin");
        notVerifyUrlList.add("/error");
        notVerifyUrlList.add("/nopermission");
        notVerifyUrlList.add("/expired");
        notVerifyUrlList.add("/notfound");
        notVerifyUrlList.add("/common/getimagecode");
        notVerifyUrlList.add("/common/upload");
        notVerifyUrlList.add("/homepage");
        notVerifyUrlList.add("/area");
        notVerifyUrlList.add("/toHomePage");
    }

}
