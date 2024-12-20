package com.zh;

import org.junit.jupiter.api.Test;

public class ThreadLocalHost {

    @Test
    public void testThreadLocalSetAndGet(){

        ThreadLocal t1=new ThreadLocal();


        new Thread(()->{
            t1.set("zhouhui");
            System.out.println(Thread.currentThread().getName()+": "+t1.get());
            System.out.println(Thread.currentThread().getName()+": "+t1.get());
            System.out.println(Thread.currentThread().getName()+": "+t1.get());
        },"蓝色").start();

        new Thread(()->{
            t1.set("LYP");
            System.out.println(Thread.currentThread().getName()+": "+t1.get());
            System.out.println(Thread.currentThread().getName()+": "+t1.get());
            System.out.println(Thread.currentThread().getName()+": "+t1.get());
        },"绿色").start();


    }
}
