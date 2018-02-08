package cn.merryyou.logback.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created on 2018/1/17.
 *
 * @author zlf
 * @since 1.0
 */
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
