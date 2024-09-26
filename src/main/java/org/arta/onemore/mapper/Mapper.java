package org.arta.onemore.mapper;


public interface Mapper <F, T> {
    T map(F object);

    default T map(F object, T to) {
        return to;
    }
}
