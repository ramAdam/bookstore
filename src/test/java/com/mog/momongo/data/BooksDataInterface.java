package com.mog.momongo.data;

import java.util.List;

/**
 * BooksDataInterface
 */
public interface BooksDataInterface {

    public void addBook(String Category, List<String> authors, String title);
}