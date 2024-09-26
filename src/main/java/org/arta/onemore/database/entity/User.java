package org.arta.onemore.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false, unique = true)
    private String nickname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer respect;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Solution> solutions = new ArrayList<>();
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Task> tasks = new ArrayList<>();

    public void addSolution(Solution solution) {
        this.solutions.add(solution);
        solution.setAuthor(this);
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        task.setAuthor(this);
    }
}
