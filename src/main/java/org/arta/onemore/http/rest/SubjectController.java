package org.arta.onemore.http.rest;

import lombok.RequiredArgsConstructor;
import org.arta.onemore.dto.SubjectReadDto;
import org.arta.onemore.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/subjects")
@RequiredArgsConstructor
@RestController
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    List<SubjectReadDto> findAll() {
        return subjectService.findAll();
    }

}
