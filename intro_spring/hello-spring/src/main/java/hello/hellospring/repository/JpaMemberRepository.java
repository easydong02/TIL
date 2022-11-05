package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em; //jpa 에서 sqlSession처럼 쿼리문 관리해주는 객체이다.


    public JpaMemberRepository(EntityManager em) {
        this.em = em; //DI로 삽입해준다.
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //persist -> 영속
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // jpa는 객체를 대상으로 쿼리를 날리기 때문에 타입을 써주어야 한다.
        return em.createQuery("select m from Member m ", Member.class).getResultList();
        // ctrl + alt + T 누르면 리턴할 변수랑 return 문이랑 그냥 붙여준다.
    }
}
