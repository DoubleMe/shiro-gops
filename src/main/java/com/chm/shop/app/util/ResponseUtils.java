package com.chm.shop.app.util;

import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.common.reponse.ResponseCode;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import org.springframework.data.domain.Page;

/**
 * @author chen-hongmin
 * @since 2017/10/26 11:15
 */
public class ResponseUtils {


    /**
     *  成功response
     * @param t 对象
     * @param message 消息
     * @param <T> 泛型
     * @return
     */
    public static<T> Response successResponse(T t,String message){


        return new Response(ResponseCode.SUCCESS,message,t);
    }


    /**
     * 失败response
     * @param message 失败信息
     * @return Response
     */
    public static Response failResponse(String message){


        return new Response(ResponseCode.ERROR,message);
    }

    /**
     * 分页response
     * @param code 状态码
     * @param message 信息
     * @param page 分页对象
     * @param <T>
     * @return
     */
    public static<T> PageResponse pageResponse(int code , String message, PageList<T> page){

        PageResponse pageResponse = new PageResponse();

        Paginator paginator = page.getPaginator();
        if (paginator != null){

            pageResponse.setPageResult(paginator.getPage(),paginator.getLimit(),paginator.getTotalCount(),page);
        }

        pageResponse.setCode(code);
        pageResponse.setMessage(message);

        return pageResponse;
    }
}
