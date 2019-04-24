package com.yqkj.utile;


import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 *
  * class_name: ListUtil
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午11:05
  *
 **/
public class ListUtil {

    /**
     * @param t
     * @param <T>
     * @return
     */
    public  static<T>  Boolean isNull(List<T> t) {

        if (null == t || t.isEmpty()) {
            return  Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    /**
     *
     * @param ids
     * @return
     */
    public  static  List<Long> ids(String ids){
        List<Long> idLog = new ArrayList<>(10);

        try {

            if (StringUtils.isBlank(ids)) {

                return idLog;

            }

            return Arrays.stream(Arrays.stream(ids.split(",")).mapToLong(s ->
                    Long.parseLong(s)).toArray()).boxed().collect(Collectors.toList());

        }catch (Exception e) {
            e.printStackTrace();
        }

        return idLog;

    }
    /**
     * List 初始值
     * @param list
     * @param consumer
     * @param v
     * @param <T>
     * @param <V>
     * @return
     */
    public  static <T,V> List<T> initDefaultValues(List<T> list ,  Function<T , Consumer<V>> consumer , V v) {

        if (null == list ) {

            return list;

        }
        for (T t : list) {
            try {
                consumer.apply(t).accept(v);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;

    }
    /**
     * 跟一个值另一个值
     * @param list
     * @param consumer
     * @param <T>
     * @param <V>
     * @return
     */
    public  static <T,V> List<T> initOneInfoValue(List<T> list ,  Function<T , Consumer<V>> consumer, V v) {

        if (null == list || null == v) {
            return list;
        }
        for (T t : list) {

            consumer.apply(t).accept(v);


        }

        return list;

    }
    /**
     * 跟一个值另一个值
     * @param list
     * @param fn
     * @param consumer
     * @param map
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public  static <T,K,V> List<T> initOneInfo(List<T> list , Function<T , K> fn , Function<T , Consumer<V>> consumer, Map<K , V> map) {

        if (null == list || null == map) {
            return list;
        }
        for (T t : list) {

            K key = fn.apply(t);

            if (map.containsKey(key)) {

               V value =  map.get(key);

               consumer.apply(t).accept(value);

            }

        }
        return list;

    }
    /**
     * 列表转为另一个列表
     * @param list
     * @param fn
     * @param <T>
     * @param <R>
     * @return
     */
    public  static  <T , R> List<R> convertToList(List<T> list , Function<T , R> fn) {
        return  list.stream().map(fn).collect(Collectors.toList());
    }
    /**
     *  利用方法<T>
     * List<Object> 转换成Map<String , Object>
     * @param list
     * @param <K>
     * @param <T>
     * @return
     */
    public static  <K , T , V> Map<K , V> convertMap( List<T> list , Function<T , K> key , Function<T , V> value) {
        Map<K , V> result = new HashMap<>(list.size());

        if (null == list || list.isEmpty()) {

            return  result;

        }

        for (T ob : list ) {

            result.put(key.apply(ob) , value.apply(ob));

        }

        return  result;

    }
    /**
     *  利用方法<T>
     * List<Object> 转换成Map<String , Object>
     * @param convert
     * @param list
     * @param <K>
     * @param <T>
     * @return
     */
    public static  <K , T> Map<K , T> convertMap( List<T> list , Function<T , K> convert) {
        Map<K , T> result = new HashMap<>(list.size());

        if (null == list || list.isEmpty()) {

            return  result;

        }

        for (T ob : list ) {

            result.put(convert.apply(ob) , ob);

        }

        return  result;

    }
    /**
     * 分组数据
     * @param list
     * @param group
     * @param <K>
     * @return
     * @param <O>
     */
    public static <K, O >  Map<K , List<O>> groupList(List<O> list , Function<O , K> group){
        if (null == list) {
            return  new HashMap<>();
        }
        return  list.stream().collect(Collectors.groupingBy(group));
    }
    /**
     * 链接字符串
     * @param list
     * @param group
     * @param <O>
     * @param <R>
     * @return
     */
    public  static <O , R>  String joinStr(List<O> list  , Function<O , R> group ) {
        return  joinStr(list , group , ",");
    }
    /**
     * 链接字符串
     * @param list
     * @param group
     * @param separate
     * @param <O>
     * @param <R>
     * @return
     */
    public  static <O , R>  String joinStr(List<O> list  , Function<O , R> group , String separate) {

        if (null == separate) {

            separate = "";

        }

        if (null == list || list.isEmpty()) {

            return "";

        }
        StringBuffer sb = new StringBuffer(list.size()*2);

        for (O o : list) {

            if (null != group.apply(o)) {

                sb.append(group.apply(o)).append(separate);

            }
        }

        try {
            if (StringUtils.isNotBlank(sb.toString()) && sb.toString().lastIndexOf(separate) > -1) {

                return sb.toString().substring(0, sb.toString().length() - separate.length());

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  sb.toString();
    }

    /**
     * List 一个方法
     * @param list
     * @param fn
     * @param <O>
     * @param <R>
     * @return
     */
    public static  <O , R> List<O> excuteMethod(List<O> list , Function<O,R> fn){
        if (Objects.isNull(list)) {
            return new ArrayList<>();
        }

        for (O o : list) {

            fn.apply(o);

        }
        return list;
    }


}
