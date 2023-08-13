package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // 엔티티매니저 팩토리는 어플에서 1개만 사용
        // 엔티티매니저는 쓰고 버려야 한다.(쓰레드간 공유 X)
        // 모든 Jpa 제어문은 트랜잭션 안에서

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hellojpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member findMember = em.find(Member.class, 1L);//  조회

            //jpql은 객체를 가져온다. 따라서 select m이라고 씀, 컬럼 안 쓰고.
            //sq은 데이터베이스 테이블을 대상으로 쿼리를 한다는 것에 jpql과 sql의 차이
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1) //pagination 1부터 5번까지
                    .setMaxResults(5)
                    .getResultList();

            for(Member member : result){
                System.out.println(member.getName());
            }

            //em.persist(findMember); 삽입
            //em.remove(findMember); 삭제

            //findMember.setName("dhshin2"); 수정

            //비영속
            Member member = new Member(150L,"A");
            Member member2 = new Member(150L,"B");


            //영속(그러나 이때 DB에 insert되는 것이 아니다.)
            em.persist(member);
            em.persist(member2);

            //영속해제
            //em.detach(member);

            //db삭제
            //em.remove(member);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
