package me.dio.sdw24.adapters.out;

import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.domain.ports.ChampionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ChampionsJdbcRepository implements ChampionsRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Champions> rowMapper;

    public ChampionsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        // Mapeamento de dados para busca no DB
        this.rowMapper = (rs, rowNum) -> new Champions(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")
        );
    }

    @Override
    public List<Champions> findAll() {
        return jdbcTemplate.query("SELECT * FROM CHAMPIONS", rowMapper); // Fazer verficação no DB
    }

    @Override
    public Optional<Champions> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WHERE ID = ?"; // Busca um ID no DB
        Champions champion = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return Optional.ofNullable(champion); // Retorna nada caso ID incorreta
    }
}
