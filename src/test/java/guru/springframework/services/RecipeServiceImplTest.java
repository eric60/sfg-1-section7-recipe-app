package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks((this));
        recipeService = new RecipeServiceImpl((recipeRepository));
        // not using spring context so need to inject our own dependencies
        // to test business logic inside service layers
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet recipeSet = new HashSet();
        recipeSet.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeSet);

        assertEquals(1, recipeService.getRecipes().size());
        verify(recipeRepository, times(1)).findAll();
    }
}