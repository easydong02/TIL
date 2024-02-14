package study.datajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass //데이터만 공유하는 진짜 jpa 상속관계가 아님
@Getter
@Setter
public class JpaBaseEntity {

    @Column(updatable = false) //최초 삽입만 가능 업데이트 불가능
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist //persist하기 전에 이벤트 발생
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate = now;
    }

    @PreUpdate
    public void preUpdate(){
        updatedDate = LocalDateTime.now();
    }
}
