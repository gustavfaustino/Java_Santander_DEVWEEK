package me.dio.sdw24.domain.model;

public record Champion(
        long id, String name,
        String role,
        String lore,
        String imageUrl
) {
 public String generateContextByQuestion(String question){
     // Criação de contexto para IAs
     return """
             Pergunta: %s
             Nome do Campeão: %s
             Função: %s
             História: %s
             """.formatted(question, this.name, this.role, this.lore);
 }
}
