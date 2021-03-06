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

    Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin,
             String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.alsoKnownAs = alsoKnownAs;
        this.ingredients = ingredients;
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

    // nice mapper class to hold all things sandwich object related
    // note: this does not follow the rubric for udacity android nanodegree
    public static class Mapper {
        private static String jsonRoot = "name";
        private static String jsonMainName = "mainName";
        private static String jsonAlsoKnownAs = "alsoKnownAs";
        private static String jsonPlaceOrigin = "placeOfOrigin";
        private static String jsonDescription = "description";
        private static String jsonImageUrl = "image";
        private static String jsonIngredients = "ingredients";

        public static String getJsonRoot() {
            return jsonRoot;
        }

        public static String getJsonMainName() {
            return jsonMainName;
        }

        public static String getJsonAlsoKnownAs() {
            return jsonAlsoKnownAs;
        }

        public static String getOrigin() {
            return jsonPlaceOrigin;
        }

        public static String getJsonDescription() {
            return jsonDescription;
        }

        public static String getJsonImageUrl() {
            return jsonImageUrl;
        }

        public static String getJsonIngredients() {
            return jsonIngredients;
        }
    }


    public static class SandwichBuilder {
        private String mainName;
        private List<String> alsoKnownAs;
        private String placeOfOrigin;
        private String description;
        private String image;
        private List<String> ingredients;

        public SandwichBuilder setName(String mainName) {
            this.mainName = mainName;
            return this;
        }

        public SandwichBuilder setAlsoKnownAs(List<String> alsoKnownAs) {
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

        public SandwichBuilder setIngredients(List<String> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Sandwich makeMeASandwich() {
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image,
                    ingredients);
        }
    }
}
