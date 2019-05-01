package com.springcache.springcache.dao.bookrepositoryimpl;

import com.springcache.springcache.dao.BookRepository;
import com.springcache.springcache.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryImpl implements BookRepository  {
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn,"Some book");
    }

    //Don't do this at home,将线程暂停私有化
    private  void simulateSlowService(){
        try{
            long time=3000L;
            Thread.sleep(time);
        }catch (InterruptedException e){
            throw new IllegalStateException();
        }
    }
}
