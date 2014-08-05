package com.vvtour.shop.utils;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.admin.Constant;


/**
 * @author fuqi
 * @date 2014-08-04
 */
public class JSONView extends AbstractView {

    /**
     * 该View对应的输出类型
     */
    public String getContentType() {
        return "application/json; charset=UTF-8";
    }

    /**
     * 输出JSON数据
     * @param response
     * @param message JSON字符串
     */
    private void writeData(HttpServletResponse response, String message) {
        response.setContentType(getContentType());
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=null;
        try {
            out=response.getWriter();
            out.print(message);
            out.flush();
        } catch(IOException e) {
        } finally {
            if(out != null) {
                out.close();
                out=null;
            }
        }
    }

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Object res=model.get(Constant.JSON_ROOT);
        String jsonStr=JsonUtil.getJSON(res);
        writeData(response, jsonStr);
		
	}

}
