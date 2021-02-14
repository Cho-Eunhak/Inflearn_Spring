package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    
    // /hello로 url로 매핑시켜주고 이 메소드 실행시켜줌
    @GetMapping("hello")
    public String hello(Model model) {
        //key는 데이터로 값을 hello로 리턴시켜줌
        model.addAttribute("data", "hello!!");
        return "hello";//hello.html을 찾아서 실행시켜라
    }
    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    //http://127.0.0.1:8080/hello-mvc?name=spring???? 이 url로 가면 보인다
}