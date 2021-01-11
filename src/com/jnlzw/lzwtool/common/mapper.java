package com.jnlzw.lzwtool.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.BeanUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
     * Object转成指定的类型
     */
    public static <T> T convert(Object obj, Class<T> type) {
        if (obj != null && StringUtils.isNotBlank(obj.toString())) {
            if (type.equals(Integer.class) || type.equals(int.class)) {
                return (T) new Integer(obj.toString());
            } else if (type.equals(Long.class) || type.equals(long.class)) {
                return (T) new Long(obj.toString());
            } else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
                return (T) new Boolean(obj.toString());
            } else if (type.equals(Short.class) || type.equals(short.class)) {
                return (T) new Short(obj.toString());
            } else if (type.equals(Float.class) || type.equals(float.class)) {
                return (T) new Float(obj.toString());
            } else if (type.equals(Double.class) || type.equals(double.class)) {
                return (T) new Double(obj.toString());
            } else if (type.equals(Byte.class) || type.equals(byte.class)) {
                return (T) new Byte(obj.toString());
            } else if (type.equals(Character.class) || type.equals(char.class)) {
                return (T) new Character(obj.toString().charAt(0));
            } else if (type.equals(String.class)) {
                return (T) obj;
            } else if (type.equals(BigDecimal.class)) {
                return (T) new BigDecimal(obj.toString());
            } else if (type.equals(LocalDateTime.class)) {
                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                return (T) LocalDateTime.parse(obj.toString());
            } else if (type.equals(Date.class)) {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    return (T) formatter.parse(obj.toString());
                } catch (ParseException e) {
                    throw new RuntimeException(e.getMessage());
                }

            } else {
                return null;
            }
        } else {
            if (type.equals(int.class)) {
                return (T) new Integer(0);
            } else if (type.equals(long.class)) {
                return (T) new Long(0L);
            } else if (type.equals(boolean.class)) {
                return (T) new Boolean(false);
            } else if (type.equals(short.class)) {
                return (T) new Short("0");
            } else if (type.equals(float.class)) {
                return (T) new Float(0.0);
            } else if (type.equals(double.class)) {
                return (T) new Double(0.0);
            } else if (type.equals(byte.class)) {
                return (T) new Byte("0");
            } else if (type.equals(char.class)) {
                return (T) new Character('\u0000');
            } else {
                return null;
            }
        }
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
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
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

    public static Object copy(Object oldObj) {
        Object obj = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(oldObj);
            out.flush();
            out.close();

            // Retrieve an input stream from the byte array and read
            // a copy of the object back in.
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bis);
            obj = in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return obj;
    }
}
