package org.arta.onemore.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "solutions")
public class Solution implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solution_id")
    private Integer id;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String testAnswer;
    @Column(nullable = false)
    private LocalDateTime creatingTime;
    @Column(nullable = false)
    private Integer likes;
    @OneToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
    @OneToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;
}
