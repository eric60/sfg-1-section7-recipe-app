package guru.springframework.domain;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataLoader implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    public DataLoader(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Recipe guacamole = new Recipe();
        guacamole.setDescription("Guacamole");

        Ingredient avacado = new Ingredient();
        avacado.setDescription("Avacados");
        avacado.setRecipe(guacamole);

        Optional<UnitOfMeasure> whole = unitOfMeasureRepository.findByDescription("Whole");
        whole.get().setUom("2");
        whole.get().setIngredient(avacado);

        Ingredient salt = new Ingredient();
        salt.setDescription("Salt");
        salt.setRecipe(guacamole);

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        teaspoon.get().setUom("1/4");
        teaspoon.get().setIngredient(avacado);

        recipeRepository.save(guacamole);


        Recipe grilledChicken = new Recipe();
        grilledChicken.setDescription("Grilled Chicken");

        Ingredient chiliPower = new Ingredient();
        chiliPower.setDescription("Chili Powder");
        chiliPower.setRecipe(grilledChicken);
        Optional<UnitOfMeasure> tablespoons = unitOfMeasureRepository.findByDescription("Tablespoon");
        whole.get().setUom("2");
        tablespoons.get().setIngredient(chiliPower);

        recipeRepository.save(grilledChicken);
    }
}
