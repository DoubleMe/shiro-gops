package com.chm.shop.app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author chen-hongmin
 * @since 2017/11/6 16:56
 */
public class JsonUtils {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }


    public static String ObjToJson(Object obj){

        String json = null;
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
}

