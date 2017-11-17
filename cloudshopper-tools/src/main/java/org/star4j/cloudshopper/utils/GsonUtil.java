package org.star4j.cloudshopper.utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: WuYL
 * @Description: JSON 对象处理类
 * @Date: Create in 2017/11/9 9:25
 * @Modified By:
 */
@Slf4j
public class GsonUtil {

    private static final Gson GSON = new Gson();

    /**
     * 将 JSON 转换为 POJO
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String jsonStr, Class<T> clazz) {
        T obj;
        try {
            obj = GSON.fromJson(jsonStr, clazz);
        } catch (Exception e) {
            log.error("convert JSON to POJO failure", e);
            throw new RuntimeException(e);
        }
        return obj;
    }


    /**
     * 将 POJO 转换为 JSON
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String toJson(T object) {
        String json;
        try {
            json = GSON.toJson(object);
        } catch (Exception e) {
            log.error("convert POJO to JSON failure", e);
            throw new RuntimeException(e);
        }
        return json;
    }

}
