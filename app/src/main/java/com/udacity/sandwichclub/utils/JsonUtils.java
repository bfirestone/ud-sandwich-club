package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;


public class JsonUtils {

    /**
     *
     * @param jsonStr String
     * @return Sandwich
     * @throws JSONException exception if json parsing fails
     */
    public static Sandwich parseSandwichJson(String jsonStr) throws JSONException {
        JSONObject jsonData = new JSONObject(jsonStr);
        JSONObject jsonNameChild = jsonData.getJSONObject(Sandwich.Mapper.getJsonRoot());

        return new Sandwich.SandwichBuilder()
                .setName(jsonNameChild.getString(Sandwich.Mapper.getJsonMainName()))
                .setAlsoKnownAs(jsonNameChild.getJSONArray(Sandwich.Mapper.getJsonAlsoKnownAs()))
                .setPlaceOfOrigin(jsonData.getString(Sandwich.Mapper.getOrigin()))
                .setDescription(jsonData.getString(Sandwich.Mapper.getJsonDescription()))
                .setImage(jsonData.getString(Sandwich.Mapper.getJsonImageUrl()))
                .setIngredients(jsonData.getJSONArray(Sandwich.Mapper.getJsonIngredients()))
                .makeMeASandwich();
    }
}
