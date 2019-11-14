package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController = @Controller + @ResponseBody
// 用于返回字符串json 方法可以省略@ResponseBody
public class MVCController {

    @RequestMapping("/test/RestController")
    public Object getUser() {
        User user = new User();
        user.setId(100);
        user.setName("melody");
        return user;
    }

}
