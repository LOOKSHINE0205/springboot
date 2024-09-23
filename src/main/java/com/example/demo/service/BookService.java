package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll(); // select * from Book : JPQL->SQL전송

    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id); // delete from Book b where b.id=?
    }

    public Book save(Book book) {
        return bookRepository.save(book); // insert into Book ~ save는 이미 만들어서 제공해주는 메서드
    }

    public Book findById(Long id) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get(); //
        }else{
            throw new RuntimeException("Book not found with id:"+id);
        }
    }

    @Transactional
    public Book update(Long id, Book book){
      Optional<Book> optional=bookRepository.findById(book.getId());
    if(optional.isPresent()) {
        Book dbbook = optional.get(); // DB에서 가져온 Book
        dbbook.setTitle(book.getTitle());
        dbbook.setPrice(book.getPrice());
        dbbook.setAuthor(book.getAuthor());
        dbbook.setPage(book.getPage());
        //bookRepository.save(dbbook); // update SQL / dbbook이 테이블이라서 세이브안해도 테이블이 변경은 업데이트하는 것 @Transactional 필요
        return dbbook; // 리턴할때 update가 됩니다. // 업데이트시 수정이됩니다. (더티체킹) 조금 늦게됩니다.
        // jpa에서 알아서하니 편하지만 메모리 체킹하는 시간필요 성능저하
    }else {
        throw new RuntimeException("Book not found with id:"+book.getId());

         }
    }

}
