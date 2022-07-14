package com.fan.myproject.service;

import org.springframework.stereotype.Service;

import com.fan.myproject.dao.BookDao;

import javax.inject.Inject;

@Service
public class BookService {
    // @Autowired(required = false)
    // @Qualifier("bookDao")
    // @Resource(name = "bookDao2")
    @Inject
    private BookDao bookDao;

    public void print() {
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" + "bookDao=" + bookDao + '}';
    }
}
