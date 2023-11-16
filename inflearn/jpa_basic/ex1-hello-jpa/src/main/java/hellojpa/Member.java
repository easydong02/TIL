package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "mem_seq", initialValue = 1, allocationSize = 50)
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
@Table(name = "Member")
public class Member extends BaseEntity{

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.TABLE,
//            generator = "MEMBER_SEQ_GENERATOR")
    private Long id;
    @Column(name = "USER_NAME", nullable = false)
    private String username;

//    @ManyToOne(fetch = FetchType.LAZY)//Lazy로 하면 Team은 프록시 객체로 준다.
    @ManyToOne(fetch = FetchType.EAGER)//Eager로 하면 Team은 실제 객체로 준다.
    @JoinColumn(insertable = false, updatable = false, name = "TEAM_ID") //읽기 전용 필드 옵션
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public List<MemberProduct> getMemberProducts() {
        return memberProducts;
    }

    public void setMemberProducts(List<MemberProduct> memberProducts) {
        this.memberProducts = memberProducts;
    }
}
