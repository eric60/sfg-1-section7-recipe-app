package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeJPAService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.expression.Sets;

import java.util.Set;

@Controller
public class IndexController {
    private final RecipeJPAService recipeJPAService;

    public IndexController(RecipeJPAService recipeJPAService) {
        this.recipeJPAService = recipeJPAService;
    }


    @RequestMapping({"/", "/index"})
    public String getIndex(Model model) {
       /* Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println(categoryOptional.get().getId());
        System.out.println(unitOfMeasureOptional.get().getId());*/
        model.addAttribute("recipes", recipeJPAService.getRecipes());
        return "index";
    }
}
