package hello.hellospring;

import hello.hellospring.domain.service.MemberService;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository()); // ctrl + p 하면 어떤 것을 인자로 넣어줘야 하는지 알려준다.
    }


    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }


}
