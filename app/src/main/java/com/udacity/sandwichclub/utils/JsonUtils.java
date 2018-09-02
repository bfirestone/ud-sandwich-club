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
        JSONObject sandwichJson = new JSONObject(jsonStr);
        JSONObject sandwichNameDetails = sandwichJson.getJSONObject("name");

        return new Sandwich.SandwichBuilder()
                .setMainName(sandwichNameDetails.getString("mainName"))
                .setAlsoKnownAs(sandwichNameDetails.getJSONArray("alsoKnownAs"))
                .setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"))
                .setDescription(sandwichJson.getString("description"))
                .setImage(sandwichJson.getString("image"))
                .setIngredients(sandwichJson.getJSONArray("ingredients"))
                .makeMeASandwich();
    }
}
