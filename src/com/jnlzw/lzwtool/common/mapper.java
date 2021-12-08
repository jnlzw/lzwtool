package com.jnlzw.lzwtool.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.beans.BeanUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 方便类之间的属性映射。
 */
public class mapper {
    public static <T, Y> T mapTo(Y a, Class<T> b) {
        T to = null;
        try {
            to = (T) b.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (to == null) return null;
        mapTo(a, to);
        return to;
    }

    public static <T, Y> List<T> mapTo(List<Y> a, Class<T> b) {
        List<T> toList = new ArrayList<>();
        a.forEach(o -> {
            toList.add(mapTo(o, b));
        });
        return toList;
    }

    public static <Y, T> T mapTo(Y a, T b) {
        BeanUtils.copyProperties(a, b);
        return b;
    }

    public static <Y, T> T mapTo(Y a, T b, Map<String, String> paraMap) {
        BeanUtils.copyProperties(a, b);
        paraMap.forEach((o1, o2) -> {
            try {
                Object values = getValues(o1, a);
                setValues(o2, copy(values), b);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return b;
    }

    public static <Y, T> T mapTo(Y a, Class<T> b, Map<String, String> paraMap) {
        T to = mapTo(a, b);
        if (null == to) return null;
        paraMap.forEach((o1, o2) -> {
            try {
                Object values = getValues(o1, a);
                setValues(o2, copy(values), to);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return to;
    }




    /**
     * @param key    属性名
     * @param value  属性名的值
     * @param object 属性的实体类
     */
    public static void setValues(String key, Object value, Object object) {
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getAnnotation(JsonProperty.class) != null) {
                    JsonProperty annotation = ((JsonProperty) field.getAnnotation(JsonProperty.class));
                    if (annotation != null) {
                        System.out.println(annotation + "");
                        String jsonPropertyValue = annotation.value();
                        if (key.equals(jsonPropertyValue)) {
                            field.set(object, value);
                            break;
                        }
                    }
                } else {
                    String fieldName = field.getName();
                    if (key.equals(fieldName)) {
                        field.set(object, value);
                        break;
                    }
                }
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过属性名获取属性的值
     *
     * @param key    属性名
     * @param object 对象
     */
    public static Object getValues(String key, Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getAnnotation(JsonProperty.class) != null) {
                JsonProperty annotation = ((JsonProperty) field.getAnnotation(JsonProperty.class));
                if (annotation != null) {
                    String jsonPropertyValue = annotation.value();
                    if (key.equals(jsonPropertyValue)) {
                        Object values = field.get(object);
                        return values;
                    }
                }
            } else {
                //获取的不是@jsonproperty的属性名称
                String fieldName = field.getName();
                if (key.equals(fieldName)) {
                    Object values = field.get(object);
                    return values;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param 原对象
     * @return 深拷贝对象
     */
    public static Object copy(Object oldObj) {
        Object obj = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(oldObj);
            out.flush();
            out.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bis);
            obj = in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
