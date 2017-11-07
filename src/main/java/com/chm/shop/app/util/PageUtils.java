package com.chm.shop.app.util;

import com.chm.shop.app.common.query.PageQuery;
import org.springframework.data.domain.PageRequest;

/**
 * @author chen-hongmin
 * @since 2017/10/31 13:03
 */
public class PageUtils {

    /**
     * page 对象转为 model
     * @param query
     * @param <T>
     * @return
     */
    public static<T> PageRequest queryToRequest(PageQuery query){

        PageRequest pageRequest = new PageRequest(query.getPage() - 1,query.getSize());

        return pageRequest;
    }
}
