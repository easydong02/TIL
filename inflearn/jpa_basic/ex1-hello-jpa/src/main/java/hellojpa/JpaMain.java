package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
            Member member = new Member();
            member.setUsername("John");
            member.setAddress(new Address("homeCity","street","1000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            AddressEntity addressEntity1= new AddressEntity("old1","street","10000");
            AddressEntity addressEntity2= new AddressEntity("old2","street","10000");

            addressEntity1.setMember(member);
            addressEntity2.setMember(member);

            member.getAddressEntityList().add(addressEntity1);
            member.getAddressEntityList().add(addressEntity2);

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("=========================start select=========================");
            Member findMember = em.find(Member.class, member.getId());

            List<AddressEntity> addressHistory = findMember.getAddressEntityList();
            for(AddressEntity addressEntity : addressHistory){
                System.out.println("address= " +addressEntity.getAddress().getCity());
            }

            Set<String> foods = findMember.getFavoriteFoods();
            for(String food : foods){
                System.out.println("food = "+food);
            }
            System.out.println("=========================start update=========================");

            //homecity -> newcity 값 타입은 새로 갈아 끼워야 한다. setter를 통해서 그 안의 속성을 변경하면 안 된다!
            Address address = findMember.getAddress();
            findMember.setAddress(new Address("newCity",address.getStreet(), address.getZipcode()));

            //치킨 -> 한식 이건 하나의 String이 값타입이라서 update도 안 된다.
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            //주소이력 바꾸기 equals와 hashCode를 재정의 했기 때문에 new 해도 비교가 가능!
//            findMember.getAddressEntityList().remove(new Address("old1","street","10000"));
//            findMember.getAddressEntityList().add(new Address("newCity1","street","10000"));

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

        emf.close();
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username= "+ username);

        Team team = member.getTeam();
        System.out.println("team= "+team.getName());
    }
}
