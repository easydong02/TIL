package jpaBook;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private IDCard idCard;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        getCourses().add(course);
        course.getStudents().add(this);
    }
}
