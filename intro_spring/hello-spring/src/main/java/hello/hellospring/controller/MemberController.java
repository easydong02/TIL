package hello.hellospring.controller;


import hello.hellospring.domain.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


//어노테이션 달아 놓으면 스프링이 객체를 만들어 놓고 관리를 해준다. (스프링 빈이 관리 된다.)
@Controller
public class MemberController {


    private final MemberService memberService;


    //이걸 쓰면 스프링이 넣어준다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
