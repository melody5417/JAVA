package com.example.demo.ReadingList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.List;

@Controller // 组件扫描会自动将其注册为Spring应用程序上下文里的一个bean
@RequestMapping("/readingList") // 将其中所有的处理器方法都映射到了 /readingList 这个url路径上
public class ReadingListController {
    private static  final String reader = "craig";

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping // 和上一个注解等价
    public  String readersBooks(Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList";
    }
}
