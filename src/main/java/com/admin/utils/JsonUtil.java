package com.admin.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author fuqi
 * @date 2014-08-04
 */
public class JsonUtil {

    public static Map<String, String> getOkStatusMsg(String msg) {
        Map<String, String> res=new HashMap<String, String>();
        res.put("statusCode", "200");
        if(null != msg && msg.length() > 0) {
            res.put("message", msg);
        }
        return res;
    }

    public static Map<String, String> getErrorStatusMsg(String msg) {
        Map<String, String> res=new HashMap<String, String>();
        res.put("statusCode", "300");
        res.put("message", msg);
        return res;
    }

    public static String getSessionTimeOutMsg() {
        return "{\"statusCode\":\"301\", \"message\":\"会话超时，请重新登录!\"}";
    }

    @SuppressWarnings("deprecation")
    public static String getJSON(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper=new ObjectMapper();
        mapper.getSerializationConfig().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String jsonStr=mapper.writeValueAsString(obj);
        return jsonStr;
    }
}
