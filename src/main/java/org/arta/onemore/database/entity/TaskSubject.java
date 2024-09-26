package org.arta.onemore.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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

    public void setTask(Task task) {
        this.task = task;
        task.getTaskSubjects().add(this);
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
        subject.getTaskSubjects().add(this);
    }
}
