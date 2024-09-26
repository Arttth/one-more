package org.arta.onemore.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "subjects")
public class Subject implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_subject_id")
    private Subject parentSubject;
    @OneToMany(mappedBy = "parentSubject", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Subject> childSubjects = new ArrayList<>();
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    @Builder.Default
    private List<TaskSubject> taskSubjects = new ArrayList<>();

    public void addChildSubject(Subject subject) {
        subject.setParentSubject(this);
        this.childSubjects.add(subject);
    }

    public void setParentSubject(Subject subject) {
        this.parentSubject = subject;
        subject.getChildSubjects().add(this);
    }

    public void addTaskSubject(TaskSubject taskSubject) {
        taskSubject.setSubject(this);
    }
}
