package me.dio.sdw24.application;

import me.dio.sdw24.domain.exception.ChampionNotFoundException;
import me.dio.sdw24.domain.model.Champion;
import me.dio.sdw24.domain.ports.ChampionsRepository;


public record AskChampionUseCase(ChampionsRepository repository) {
    public String askChampion(Long championId, String question){

        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId)); //Lança uma excessão

        String championContext = champion.generateContextByQuestion(question);

        // TODO: evolução de logica de negocios para considerar a integração de IA's generativas.

        return championContext;
    }
}
