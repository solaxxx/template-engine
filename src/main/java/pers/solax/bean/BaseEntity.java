package pers.solax.bean;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by solax on 2017-3-27.
 */
public abstract  class BaseEntity {
    Map<String, Object> resultMap = new HashMap<String, Object>();

    public Map<String, Object> toMap () {
        try {
            Field[] field = this.getClass().getDeclaredFields();
            for (Field oneField : field) {
                String modifier = Modifier.toString(oneField.getModifiers()) ;
                if (modifier.indexOf("final") < 0) {
                    oneField.setAccessible(true);
                    resultMap.put(oneField.getName(), oneField.get(this));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  resultMap;
    }
}
