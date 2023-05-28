package org.walruscode.effective_java.chap_2.builders;

import com.google.common.collect.ImmutableList;

import java.util.List;


class SourdoughPizza implements Pizza {

    private final ImmutableList<String> ingredients;

    private SourdoughPizza(DefaultBuilder builder) {
        this.ingredients = builder.ingredients;
    }

    @Override
    public List<String> showIngredients() {
        return ingredients;
    }

    static Builder builder() {
        return new DefaultBuilder();
    }

    interface Builder {

        Builder ingredients(List<String> ingredients);

        Pizza build();
    }

    private static class DefaultBuilder implements Builder {

        private ImmutableList<String> ingredients;

        @Override
        public Builder ingredients(List<String> ingredients) {
            this.ingredients = ImmutableList.copyOf(ingredients);
            return this;
        }

        @Override
        public Pizza build() {
            return new SourdoughPizza(this);
        }
    }
}
