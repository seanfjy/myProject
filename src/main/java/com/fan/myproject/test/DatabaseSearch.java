package com.fan.myproject.test;

import java.util.List;

public class DatabaseSearch implements Search{
    @Override
    public List<String> searchDoc(String keyWord) {
        System.out.println("数据库搜索 "+ keyWord);
        return null;
    }
}
