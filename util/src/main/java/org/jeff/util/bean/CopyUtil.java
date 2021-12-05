package org.jeff.util.bean;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于 Spring 提供的 BeanUtil 基础上封装
 * {对象复制,列表赋值}
 *
 * @author jeff
 * @since 1.0.0
 */
public class CopyUtil {

    /**
     * 单体复制
     *
     * @param source source bean
     * @param clazz  class
     * @param <T>    返回的对象类型
     * @return
     */
    public static <T> T copy(Object source, Class<T> clazz) {
        if (source == null)
            return null;

        T obj;
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BeanUtils.copyProperties(source, obj);
        return obj;
    }

    /**
     * 列表复制
     *
     * @param sources List source
     * @param clazz   class
     * @param <T>     return bean class
     * @return
     */
    public static <T> List<T> copyList(List sources, Class<T> clazz) {
        List<T> target = new ArrayList<>();
        if (sources != null && !sources.isEmpty()) {
            for (Object source : sources) {
                T obj = copy(source, clazz);
                target.add(obj);
            }
        }
        return target;
    }

}