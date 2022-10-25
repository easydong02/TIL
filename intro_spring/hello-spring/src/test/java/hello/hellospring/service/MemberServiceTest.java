package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.service.MemberService;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    //동작하기 전에
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); //이러면 같은 MemoryMemberRepository 객체를 사용한다.
    }

    //Memoryrepo의 객체를 통일시켜줄 필요가 있음.
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    
    //각 메서드 작동 후에
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //테스트 패턴은 given - when - then 패턴 추천

        //given
        Member member = new Member();
        member.setName("spring");


        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member = new Member();
        member.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member);

        //방법 2
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /* 방법1
        try{
            memberService.join(member2);
            fail("예외가 발생해야 합니다.");
        }catch (IllegalStateException e ){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}