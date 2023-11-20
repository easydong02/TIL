package jpaBook;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

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
            Student student = new Student();
            student.setName("John");

            Contact contact = new Contact();
            contact.setEmail("easydong02@mgmail.com");
            contact.setAddress("서울");
            contact.setPhone("010-6645-2753");

            student.setContact(contact);

            em.persist(student);

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
