package com.udacity.sandwichclub.model;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Sandwich {

    private String mainName;
    private List<String> alsoKnownAs;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients;

    Sandwich(String mainName, JSONArray alsoKnownAs, String placeOfOrigin,
             String description, String image, JSONArray ingredients) throws JSONException {
        this.mainName = mainName;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.alsoKnownAs = convertJsonArrayToList(alsoKnownAs);
        this.ingredients = convertJsonArrayToList(ingredients);
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    private List<String> convertJsonArrayToList(JSONArray jsonArray) throws JSONException {
        List<String> conversionList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            conversionList.add(jsonArray.getString(i));
        }
        return conversionList;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "mainName='" + mainName + '\'' +
                ", alsoKnownAs=" + alsoKnownAs +
                ", placeOfOrigin='" + placeOfOrigin + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class SandwichBuilder {
        private String mainName;
        private JSONArray alsoKnownAs;
        private String placeOfOrigin;
        private String description;
        private String image;
        private JSONArray ingredients;

        public SandwichBuilder setMainName(String mainName) {
            this.mainName = mainName;
            return this;
        }

        public SandwichBuilder setAlsoKnownAs(JSONArray alsoKnownAs) {
            this.alsoKnownAs = alsoKnownAs;
            return this;
        }

        public SandwichBuilder setPlaceOfOrigin(String placeOfOrigin) {
            this.placeOfOrigin = placeOfOrigin;
            return this;
        }

        public SandwichBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public SandwichBuilder setImage(String image) {
            this.image = image;
            return this;
        }

        public SandwichBuilder setIngredients(JSONArray ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Sandwich makeMeASandwich() throws JSONException {
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image,
                    ingredients);
        }
    }
}
