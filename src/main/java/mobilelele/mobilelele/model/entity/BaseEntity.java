package mobilelele.mobilelele.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public BaseEntity setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public BaseEntity setModifiedOn(LocalDateTime modified) {
        this.modifiedOn = modified;
        return this;
    }

    @PrePersist
    public void beforeCreate() {
        setCreatedOn(LocalDateTime.now());
    }
}
