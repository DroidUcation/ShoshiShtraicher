package com.gfcommunity.course.gfcommunity.activities.recipes;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gfcommunity.course.gfcommunity.R;
import com.gfcommunity.course.gfcommunity.model.Recipe;


public class RecipeDetailsActivity extends AppCompatActivity{
    private Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        recipe = (Recipe) getIntent().getSerializableExtra("selected_item"); //get current recipe passed from RecipesAdapter

        setRecipeValues(); //Set recipe details in the textViews
    }

    /**
     * Set recipe details in the textViews
     */
    private void setRecipeValues() {
        TextView recipeNameTxt = (TextView) findViewById(R.id.recipe_name_txt);
        String recipeName = recipe.getRecipeName();
        recipeNameTxt.setText(!TextUtils.isEmpty(recipeName) ? recipeName : "");

        ImageView recipeImg = (ImageView) findViewById(R.id.recipe_img);
        String imgUrl = recipe.getRecipeImgUri();
        if(!TextUtils.isEmpty(imgUrl)){
            Glide.with(this).load(imgUrl)
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.recipes)
                    .error(R.drawable.recipes)
                    .into(recipeImg);
        }

        TextView ingredientsTxt = (TextView) findViewById(R.id.ingredients_txt);
        String ingredients = recipe.getIngredients();
        ingredientsTxt.setText(!TextUtils.isEmpty(ingredients) ? ingredients : "");

        TextView instructionsTxt = (TextView) findViewById(R.id.instructions_txt);
        String instructions = recipe.getInstructions();
        instructionsTxt.setText(!TextUtils.isEmpty(instructions) ? instructions : "");

        TextView preparationTimeTxt = (TextView) findViewById(R.id.preparation_time_txt);
        String preparationTime = recipe.getPreparationTime();
        preparationTimeTxt.setText(!TextUtils.isEmpty(preparationTime) ? String.format(getString(R.string.preparation_time_details),preparationTime) : "");

        TextView dinersNumberTxt = (TextView) findViewById(R.id.diners_number_txt);
        int dinersNumber = recipe.getDinersNumber();
        dinersNumberTxt.setText(dinersNumber > 0 ? String.format(getString(R.string.diners_number_details),dinersNumber) : "");

        TextView difficultyPreparationTxt = (TextView) findViewById(R.id.difficulty_preparation_txt);
        String difficultyPreparation = recipe.getDifficultyPreparation();
        difficultyPreparationTxt.setText(!TextUtils.isEmpty(difficultyPreparation) ? String.format(getString(R.string.difficulty_preparation_details),difficultyPreparation) : "");

        TextView recipeStoryTxt = (TextView) findViewById(R.id.recipe_story_txt);
        String recipeStory = recipe.getRecipeStory();
        recipeStoryTxt.setText(!TextUtils.isEmpty(recipeStory) ? recipeStory : "");

        TextView recipetUserUploadedTxt = (TextView) findViewById(R.id.added_by_txt);
        //TODO: set user name
        String recipetUserUploaded = String.format(getResources().getString(R.string.user_uploaded_text), "user name");
        recipetUserUploadedTxt.setText(!TextUtils.isEmpty(recipetUserUploaded) ? recipetUserUploaded : "");
    }

}
