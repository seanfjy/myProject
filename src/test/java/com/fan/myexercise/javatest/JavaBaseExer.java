package com.fan.myexercise.javatest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.ServiceLoader;

import org.junit.jupiter.api.Test;

import com.fan.myproject.bean.Dog;
import com.fan.myproject.test.Search;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

public class JavaBaseExer {

    private final Log log = LogFactory.get(this.getClass());

    @Test
    void test1() {

        int a = 1;
        int b = a << 4;
        int c = b >> 2;
        int d = b >>> 3;
        log.info("a={}", a);
        log.info("b={}", b);
        log.info("c={}", c);
        log.info("d={}", d);
        log.info("maxInt={}", Integer.MAX_VALUE);

    }

    @Test
    void test2() {
        double add = add(3.5, 4.6);
        double add2 = add(5.5, 7.6);
    }

    @Test
    void test3() {
        Point<String> p = new Point<>();
        p.setVar("hello,world!");
        log.info("{}的长度：{}", p.getVar(), p.getVar().length());

        NotePad<String, Integer> np = new NotePad<>();
        np.setKey("曾果果");
        np.setValue(2);
        log.info("姓名：{}，年龄：{}", np.getKey(), np.getValue());
    }

    private static <T extends Number> double add(T a, T b) {
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }

    class Point<T> {
        private T var;

        public T getVar() {
            return var;
        }

        public void setVar(T var) {
            this.var = var;
        }
    }

    class NotePad<K, V> {
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    interface Info<T> {
        T getVar();
    }

    class InfoImpl<T> implements Info<T> {
        private T var;

        public InfoImpl(T var) {
            this.setVar(var);
        }

        @Override
        public T getVar() {
            return this.var;
        }

        public void setVar(T var) {
            this.var = var;
        }
    }

    @Test
    void test5() {
        Info<String> i = new InfoImpl<>("曾宝");
        log.info("内容：{}", i.getVar());
    }

    @Test
    void test6() {
        File file = new File("./temp.txt");

        try (FileInputStream fis = new FileInputStream(file)) {

        } catch (FileNotFoundException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }

    }

    @Test
    void classTest() throws Exception {

        Class<Dog> dogClass = Dog.class;
        log.info("根据类名:{}", dogClass);
        log.info("根据对象:{}", new Dog().getClass());
        log.info("根据全限定类名：{}", Class.forName("com.fan.myproject.bean.Dog"));

        // 常用的方法
        log.info("获取全限定类名：{}",dogClass.getName());
        log.info("获取类名：{}",dogClass.getSimpleName());
        log.info("实例化：{}",dogClass.getDeclaredConstructor().newInstance());
    }

    @Test
    void test7(){
        ServiceLoader<Search> load = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = load.iterator();
        while (iterator.hasNext()){
            Search next = iterator.next();
            next.searchDoc("hello,world!");
        }
    }

}
