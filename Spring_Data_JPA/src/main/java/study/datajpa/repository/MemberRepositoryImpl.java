package study.datajpa.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import java.util.List;

public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final EntityManager em;

    @Autowired
    public MemberRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m").getResultList();
    }
}
