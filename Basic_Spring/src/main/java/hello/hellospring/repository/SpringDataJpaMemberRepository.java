package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//DTO 타입과 PK를 적어준다
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long >,MemberRepository {

    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
