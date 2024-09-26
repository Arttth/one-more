package org.arta.onemore.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.arta.onemore.database.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}