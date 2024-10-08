package org.arta.onemore.service;

import lombok.RequiredArgsConstructor;
import org.arta.onemore.database.repository.SubjectRepository;
import org.arta.onemore.dto.SubjectReadDto;
import org.arta.onemore.mapper.SubjectReadMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectReadMapper subjectReadMapper;

    public List<SubjectReadDto> findAll() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectReadMapper::map)
                .toList();
    }
}
