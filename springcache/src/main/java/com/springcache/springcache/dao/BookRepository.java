package com.springcache.springcache.dao;

import com.springcache.springcache.entity.Book;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
