package com.lazy.infrastructure.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONUtils {
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * javaBean,list,array convert to json string
     */
    public static String obj2json(Object obj) throws Exception {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    /**
     * json string convert to javaBean
     */
    public static <T> T json2pojo(String jsonStr, Class<T> clazz) throws Exception {
        return OBJECT_MAPPER.readValue(jsonStr, clazz);
    }

    /**
     * json string convert to map
     */
    public static Map<String, Object> json2map(String jsonStr) throws Exception {
        return OBJECT_MAPPER.readValue(jsonStr, Map.class);
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) throws Exception {
        return OBJECT_MAPPER.readValue(jsonStr, getCollectionType(Map.class, String.class, clazz));
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) throws Exception {
        return OBJECT_MAPPER.readValue(jsonArrayStr, getCollectionType(ArrayList.class, clazz));
    }

    /**
     * map convert to javaBean
     */
    public static <T> T map2pojo(Map map, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(map, clazz);
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return OBJECT_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
