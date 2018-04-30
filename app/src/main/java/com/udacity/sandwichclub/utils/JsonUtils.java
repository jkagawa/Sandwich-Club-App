package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject details = new JSONObject(json);
        JSONObject name = details.getJSONObject("name");

        String mainName = name.getString("mainName");

        List<String> alsoKnownAs = new ArrayList<>();
        JSONArray alsoKnownAsList = name.getJSONArray("alsoKnownAs");
        for(int i = 0; i<alsoKnownAsList.length(); i++) {
            alsoKnownAs.add(alsoKnownAsList.getString(i));
        }

        String placeOfOrigin = details.getString("placeOfOrigin");
        String description = details.getString("description");
        String image = details.getString("image");

        List<String> ingredients = new ArrayList<>();
        JSONArray ingredientsList = details.getJSONArray("ingredients");
        for(int i = 0; i<ingredientsList.length(); i++) {
            ingredients.add(ingredientsList.getString(i));
        }

        Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        return sandwich;

    }
}
