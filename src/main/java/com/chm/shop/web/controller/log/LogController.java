package com.chm.shop.web.controller.log;

import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.manager.log.LogService;
import com.chm.shop.manager.log.dataobject.LogApiDO;
import com.chm.shop.manager.log.dataobject.LogSqlDO;
import com.chm.shop.manager.log.query.LogApiQuery;
import com.chm.shop.manager.log.query.LogSqlQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author chen-hongmin
 * @since 2017/11/17 14:25
 */

@RequestMapping("/log")
@Controller
public class LogController {

    @Resource
    private LogService logService;

    @RequestMapping("/sql/list")
    public String sqlList(LogSqlQuery query,Model model){

        Response<LogSqlDO> logSqlDOResponse = logService.sqlList(query);

        model.addAttribute("data",logSqlDOResponse);
        return "/log/sqlList";
    }

    @RequestMapping("/api/list")
    public String apiList(LogApiQuery query, Model model){

        Response<LogApiDO> logSqlDOResponse = logService.apiList(query);

        model.addAttribute("data",logSqlDOResponse);
        return "/log/apiList";
    }
}
