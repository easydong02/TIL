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
            Movie movie = new Movie();

            movie.setDirector("John");
            movie.setActor("Hee");
            movie.setName("바람과");
            movie.setPrice(25000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = "+ findMovie);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
