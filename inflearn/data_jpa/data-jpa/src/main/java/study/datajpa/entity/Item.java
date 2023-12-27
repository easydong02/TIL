package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item implements Persistable<String> {

    //새로운 객체의 기준은 객체값이면 null, 일반자료형이면 0일 때 새로운 엔티티라고 판단한다.
    //GeneratedValue는 persist()를 하고 엔티티에 id값을 넣는다. -> 왜? 최적화하기 위해서
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    @CreatedDate
    private LocalDateTime createdDate;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return createdDate == null;
    }

    public Item(String id) {
        this.id = id;
    }
}
