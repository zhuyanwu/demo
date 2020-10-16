package com.example.demo.util;

import com.example.demo.vo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ThreadPoolUtil {

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolUtil.class);

    private static ExecutorService threadPool = Executors.newFixedThreadPool(100);

    public static void testMethod(){
        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }

    public static Future testReturn(Integer id ,String name){
        return threadPool.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            return new Person(id,"name-->" + Thread.currentThread().getName());
        });
    }
}
