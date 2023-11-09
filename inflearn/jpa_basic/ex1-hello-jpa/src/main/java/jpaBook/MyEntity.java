package jpaBook;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Id
//    private Long id2;

    private String name;

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

//    public Long getId2() {
//        return id2;
//    }
//
//    public void setId2(Long id2) {
//        this.id2 = id2;
//    }

//    public class MyEntityId implements Serializable{
//        private Long id;
//        private Long id2;
//    }
}
