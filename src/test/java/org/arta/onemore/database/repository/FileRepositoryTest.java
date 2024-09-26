package org.arta.onemore.database.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.arta.onemore.OneMoreApplication;
import org.arta.onemore.database.entity.File;
import org.arta.onemore.database.entity.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {OneMoreApplication.class})
@Transactional
class FileRepositoryTest {
}