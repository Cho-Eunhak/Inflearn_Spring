package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @GetMapping("hello-raw")
    @ResponseBody//html body 태그가 아니라 body부분에 이내용을 직접 넣어주겠따...!
    public String helloRAW(@RequestParam("name") String name) {
        return "hello" + name;//hello spring이런식으로  간다
    }


    //많이 쓰이는 방식, json 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}