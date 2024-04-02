package me.dio.sdw24.domain.exception;

import static java.lang.StringTemplate.STR;

public class ChampionNotFoundException extends RuntimeException {
    public ChampionNotFoundException(Long championId) {
        super("Champion %d not found".formatted(championId));
    }
}
