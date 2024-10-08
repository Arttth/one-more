package org.arta.onemore.database.repository;

import org.arta.onemore.database.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Integer> {
}
