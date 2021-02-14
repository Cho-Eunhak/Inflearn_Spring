package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    
    // /hello로 url로 매핑시켜주고 이 메소드 실행시켜줌
    @GetMapping("hello")
    public String hello(Model model) {
        //key는 데이터로 값을 hello로 리턴시켜줌
        model.addAttribute("data", "hello!!");
        return "hello";//hello.html을 찾아서 실행시켜라
    }
}