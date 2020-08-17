package guru.springframework.domain;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne // default no cascade don't want to delete recipe when delete the ingredient
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER) // tell hibernate to use eager fetch type. retrieved every time from db.
    private UnitOfMeasure unitofMeasure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUnitofMeasure() {
        return unitofMeasure;
    }

    public void setUnitofMeasure(UnitOfMeasure unitofMeasure) {
        this.unitofMeasure = unitofMeasure;
    }
}
