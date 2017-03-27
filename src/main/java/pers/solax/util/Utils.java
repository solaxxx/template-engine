package pers.solax.util;

import java.lang.reflect.Field;

/**
 * Created by solax on 2017-3-3.
 */
public class Utils {
    /**
     * 获取bean 名称
     * @param domain
     * @return
     */
    public static String getClassName (Object domain) {
        String className = domain.getClass().getName();
        return className.substring(className.lastIndexOf('.') + 1, className.length());
    }

    public static Long getDomainId (Object domain) {
        Field field; Long id = null;
        try {
            field = domain.getClass().getDeclaredField("id");
            field.setAccessible(true);
            id = Long.valueOf(String.valueOf(field.get(domain)));
        } catch (Exception e) {}
        return id;
    }

    public static Object parseDomain (Object domain) {
        Object d = new Object();
        try {
        Field field = domain.getClass().getDeclaredField("grailsApplication");
        } catch (Exception e) {}
        return null;
    }
}
