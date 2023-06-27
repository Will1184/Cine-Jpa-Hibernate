package org.will1184.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Pais {
    EEUU("Estados Unidos"),
    ESPAÑA(null),
    ARGENTINA(null);
    private final String nacion;
}
