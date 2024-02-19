package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;


@Component
public class BookServices {
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book>list = new ArrayList<>() ; 
    
    // static{
    //     list.add(new Book(12,"java advance","xvy"));
    //     list.add(new Book(12,"java advance1","xvy"));
    //     list.add(new Book(12,"java advance2","xvy"));
    //     list.add(new Book(12,"java advance3","xvy"));
    //     list.add(new Book(12,"java advance4","xvy"));
    // }
    public List<Book> getAllBooks(){
        
        List<Book>list =(List<Book>) this.bookRepository.findAll();
        return list;
    }
    //get single book by id

    public Book getBookById(int id){
        Book book = null;

        try {
            // book =  list.stream().filter(e->e.getId()==id).findFirst().get();
            book = this.bookRepository.findBookById(id);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not found book");
        }
       
       return book;

    }

    //adding the book
    public Book addBook(Book b){
       Book result =  bookRepository.save(b);
        return result;
    }

    //delete book
    public void deleteBook(int bid){
        bookRepository.deleteById(bid);
        // list = list.stream().filter(book->{
        //     if (book.getId() != bid) {
        //         return true;
                
        //     } else {
        //         return false;  
        //     }
        // }).collect(Collectors.toList());
    }

    //upadate book

    public void updateBook(Book book, int bookId) {
        book.setId(bookId);
        bookRepository.save(book);
        // list.stream()
        //     .filter(b -> b.getId() == bookId)
        //     .forEach(b -> {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     });
    }
    
   

}

