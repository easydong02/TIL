package jpaBook;

import javax.persistence.*;

public class JpaBookMain {

    public static void main(String[] args) {
        // 엔티티매니저 팩토리는 어플에서 1개만 사용
        // 엔티티매니저는 쓰고 버려야 한다.(쓰레드간 공유 X)
        // 모든 Jpa 제어문은 트랜잭션 안에서

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hellojpabook");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Author author = new Author();
            author.setName("John");
            Poem poem = new Poem();
            poem.setTitle("bookA");

            author.getPoems().add(poem);

            em.persist(author);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

        emf.close();
    }
}
