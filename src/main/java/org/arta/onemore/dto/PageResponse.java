package org.arta.onemore.dto;

import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;

@Value
public class PageResponse <T> {
    List<T> content;
    Metadata metadata;

    public static <T> PageResponse of(Page<T> page) {
        Metadata metadata = new Metadata(page.getSize(), page.getNumber(), page.getTotalElements());
        return new PageResponse<>(page.getContent(), metadata);
    }

    @Value
    static class Metadata {
        int size;
        int page;
        long totalElements;
    }
}
