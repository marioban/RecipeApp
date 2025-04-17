package com.marioban.recipeapp.repository;

import com.marioban.recipeapp.data.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JdbcRecipeRepository implements RecipeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Recipe> findById(Integer id) {
        return Optional.of(jdbcTemplate.queryForObject(
                "SELECT * FROM RECIPE WHERE ID = ?",
                new RecipeRowMapper(),
                id
        ));
    }

    @Override
    public List<Recipe> findAll() {
        return jdbcTemplate.query("SELECT * FROM RECIPE", new RecipeRowMapper());
    }

    class RecipeRowMapper implements RowMapper<Recipe> {
        @Override
        public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
            Recipe recipe = new Recipe();
            recipe.setId(rs.getInt("ID"));
            recipe.setName(rs.getString("NAME"));
            recipe.setKcal(rs.getInt("KCAL"));
            recipe.setProtein(rs.getInt("PROTEIN"));
            recipe.setCarbs(rs.getInt("CARBS"));
            recipe.setFats(rs.getInt("FATS"));
            recipe.setIngredients(rs.getString("INGREDIENTS"));
            recipe.setPrice(rs.getBigDecimal("PRICE"));
            return recipe;
        }
    }
}
