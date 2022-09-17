package com.fan.myproject;

import org.junit.jupiter.api.Test;

public class VMTest {
    private Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2*_1MB];

    @Test
    void test1() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

//    @Test
//    void directMemoryOOM() throws IllegalAccessException {
//        Field declaredField = Unsafe.class.getDeclaredFields()[0];
//        declaredField.setAccessible(true);
//        Unsafe o =(Unsafe) declaredField.get(null);
//        while (true){
//            o.allocateMemory(_1MB);
//        }
//    }
//
    public static void main(String[] args) throws IllegalAccessException {
//        List<OOMObject> list = new ArrayList<>();
//        while (true){
////            list.add(new OOMObject());
//        }

        VMTest objA = new VMTest();
        VMTest objB = new VMTest();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }
    static class OOMObject{

    }

    @Test
    void testGC(){

    }
}
