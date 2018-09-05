package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {
    private static final String jsonRoot = "name";
    private static final String jsonMainName = "mainName";
    private static final String jsonAlsoKnownAs = "alsoKnownAs";
    private static final String jsonPlaceOrigin = "placeOfOrigin";
    private static final String jsonDescription = "description";
    private static final String jsonImageUrl = "image";
    private static final String jsonIngredients = "ingredients";

    /**
     *
     * @param jsonStr String
     * @return Sandwich
     * @throws JSONException exception if json parsing fails
     */
    public static Sandwich parseSandwichJson(String jsonStr) throws JSONException {
        JSONObject jsonData = new JSONObject(jsonStr);
        JSONObject jsonNameChild = jsonData.getJSONObject(jsonRoot);

        return new Sandwich.SandwichBuilder()
                .setName(jsonNameChild.getString(jsonMainName))
                .setAlsoKnownAs(convertJsonArrayToList(jsonNameChild.getJSONArray(jsonAlsoKnownAs)))
                .setPlaceOfOrigin(jsonData.getString(jsonPlaceOrigin))
                .setDescription(jsonData.getString(jsonDescription))
                .setImage(jsonData.getString(jsonImageUrl))
                .setIngredients(convertJsonArrayToList(jsonData.getJSONArray(jsonIngredients)))
                .makeMeASandwich();
    }

    private static List<String> convertJsonArrayToList(JSONArray jsonArray) throws JSONException {
        List<String> conversionList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            conversionList.add(jsonArray.getString(i));
        }
        return conversionList;
    }

}
