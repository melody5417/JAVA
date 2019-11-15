package com.example.demo.ReadingList;

import com.example.demo.ReadingList.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 扩展 spring data jpa 的 JpaRepository 接口
public interface ReadingListRepository extends JpaRepository<Book, Long> {

    // 根据读者的用户名来查找阅读列表
    // ? 只需要定义仓库接口，在应用程序启动后，该接口在运行时会自动实现。？
    List<Book> findByReader(String reader);

}
