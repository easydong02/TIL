package hellojpa;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "mem_seq", initialValue = 1, allocationSize = 50)
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
//    @GeneratedValue(strategy = GenerationType.TABLE,
//            generator = "MEMBER_SEQ_GENERATOR")
    private Integer id;
    @Column(name = "name", nullable = false)
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Member() {
    }

}
