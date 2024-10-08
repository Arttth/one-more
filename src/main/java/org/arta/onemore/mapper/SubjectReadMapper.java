package org.arta.onemore.mapper;

import org.arta.onemore.database.entity.Subject;
import org.arta.onemore.dto.SubjectReadDto;
import org.springframework.stereotype.Component;

@Component
public class SubjectReadMapper implements Mapper<Subject, SubjectReadDto>{
    @Override
    public SubjectReadDto map(Subject object) {
        return new SubjectReadDto(object.getId(), object.getName());
    }
}
