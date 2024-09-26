package org.arta.onemore.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.arta.onemore.database.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {
}
