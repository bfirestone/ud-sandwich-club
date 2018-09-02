package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;
import com.udacity.sandwichclub.utils.ListUtils;

import org.json.JSONException;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = DetailActivity.class.getSimpleName();

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    private TextView mAlsoKnownTv;
    private TextView mOriginTv;
    private TextView mDescriptionTv;
    private TextView mIngredientTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView mSandwichIv = findViewById(R.id.image_iv);
        mAlsoKnownTv = findViewById(R.id.also_known_tv);
        mOriginTv = findViewById(R.id.origin_tv);
        mDescriptionTv = findViewById(R.id.description_tv);
        mIngredientTv = findViewById(R.id.ingredients_tv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];

        Sandwich sandwich = null;
        try {
            sandwich = JsonUtils.parseSandwichJson(json);
            Log.v(TAG, sandwich.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);

        Picasso.with(this)
                .load(sandwich.getImage())
                .into(mSandwichIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {

        // set Text for alsoKnownTv
        if (sandwich.getAlsoKnownAs().isEmpty()) {
            mAlsoKnownTv.setText(R.string.missing_aka);
        } else {
            mAlsoKnownTv.setText(ListUtils.convertListToString(sandwich.getAlsoKnownAs()));
        }

        // set Text for originTv
        if (sandwich.getPlaceOfOrigin().isEmpty()) {
            mOriginTv.setText(R.string.missing_origin);
        } else {
            mOriginTv.setText(sandwich.getPlaceOfOrigin());
        }

        // set Text for descriptionTv
        if (sandwich.getDescription().isEmpty()) {
            mDescriptionTv.setVisibility(View.GONE);
        } else {
            mDescriptionTv.setText(sandwich.getDescription());
        }

        // set Text for ingredientTv
        if (sandwich.getIngredients().isEmpty()) {
            mIngredientTv.setVisibility(View.GONE);
        } else {
            mIngredientTv.setText(ListUtils.convertListToString(sandwich.getIngredients()));
        }
    }
}
