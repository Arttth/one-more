package org.arta.onemore.database.repository;

import org.arta.onemore.database.entity.TaskSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSubjectRepository extends JpaRepository<TaskSubject, Integer> {
}
