package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecipeJPAService {
    private final RecipeRepository recipeRepository;

    public RecipeJPAService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Iterable<Recipe> getRecipes() {
        Collection<Recipe> collection = new ArrayList<>();
        Iterable<Recipe> iterable = recipeRepository.findAll();
        Set<Recipe> recipes = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toSet());
        return recipes;
    }
}
