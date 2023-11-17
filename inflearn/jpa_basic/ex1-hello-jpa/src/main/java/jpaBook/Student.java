package jpaBook;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private IDCard idCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
