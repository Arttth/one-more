package org.arta.onemore.database.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tasks_subject")
public class TaskSubject {
    @Id
    @Column(name = "task_subject_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
}
