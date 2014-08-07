package com.vvtour.shop.utils;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 获取 module.properties 中的value
 * @author fuqi
 * @date 2014-08-07
 */
public class PropUtil {

    private static final Properties prop=new Properties();
    static {
        InputStream fis=new PropUtil().getClass().getClassLoader().getResourceAsStream("module.properties");
        try {
            prop.load(fis);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null)
                try {
                    fis.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
