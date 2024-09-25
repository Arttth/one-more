package org.arta.onemore.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tasks")
public class Task implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Integer likes;
    @Enumerated(EnumType.STRING)
    private Level level;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;
    @OneToMany(mappedBy = "task")
    @Builder.Default
    private List<TaskSubject> taskSubjects = new ArrayList<>();
}
