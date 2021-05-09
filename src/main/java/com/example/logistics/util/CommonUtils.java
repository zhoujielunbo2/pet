package com.example.logistics.util;
import org.springframework.cglib.beans.BeanCopier;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hexiaobo
 * @title: CommonUtils
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/1919:00
 */
public class CommonUtils {
    private CommonUtils(){
    }
    /**
     * copy value
     * @param target
     * @param source
     * @param <T>
     * @return
     */
    public static    <T> T convert(T target, T source) {
        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
        copier.copy(source, target, null);
        return target;
    }

    public static String productNo(int randomCount){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<=randomCount;i++){
            sb.append(ThreadLocalRandom.current().nextInt(10)).append((char)(Math.random()*26+'A'));
        }
        return sb.toString();
    }
//
//    public static    <T> T  convertList(List<T> target, List<T> source){
//        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
//        copier.copy(source, target, null);
//        return target;
//    }
}