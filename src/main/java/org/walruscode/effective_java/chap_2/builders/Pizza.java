package org.walruscode.effective_java.chap_2.builders;

import java.util.List;

public interface Pizza {

    List<String> showIngredients();

    static Pizza create(List<String> ingredients) {
        return SourdoughPizza.builder()
                .ingredients(ingredients)
                .build();
    }
}
