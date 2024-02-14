package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//원래 static에 있는 welcome 페이지가 있지만 이게 더 우선순위다.따라서 home.html이 실행된다.
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
