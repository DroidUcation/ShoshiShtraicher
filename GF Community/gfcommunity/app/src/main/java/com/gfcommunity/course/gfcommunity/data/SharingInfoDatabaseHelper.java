package com.gfcommunity.course.gfcommunity.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;

/**
 * Sharing Information DatabaseHelper : products, recipes and tips
 */
public class SharingInfoDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1; // Database Version
    // Table Create Statements

    //Products table create statement
    private static final String CREATE_TABLE_PRODUCTS =
            "CREATE TABLE IF NOT EXISTS "
            + SharingInfoContract.ProductsEntry.TABLE_NAME + "("
            + SharingInfoContract.ProductsEntry._ID + " INTEGER PRIMARY KEY, "
            + SharingInfoContract.ProductsEntry.PRODUCT_NAME + " TEXT, "
            + SharingInfoContract.ProductsEntry.STORE_NAME + " TEXT, "
            + SharingInfoContract.ProductsEntry.STORE_URL + " TEXT, "
            + SharingInfoContract.ProductsEntry.CITY + " TEXT, "
            + SharingInfoContract.ProductsEntry.STREET + " TEXT, "
            + SharingInfoContract.ProductsEntry.HOUSE_NO + " INTEGER, "
            + SharingInfoContract.ProductsEntry.COMMENT + " TEXT, "
            + SharingInfoContract.ProductsEntry.PHONE + " TEXT, "
            + SharingInfoContract.ProductsEntry.CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
            + SharingInfoContract.ProductsEntry.IMAGE_URI + " TEXT, "
            + SharingInfoContract.ProductsEntry.USER_ID + " TEXT, "
            + SharingInfoContract.ProductsEntry.USER_NAME + " TEXT"+");";

    //Recipes table create statement
    private static final String CREATE_TABLE_RECIPES =
            "CREATE TABLE IF NOT EXISTS "
                    + SharingInfoContract.RecipesEntry.TABLE_NAME + "("
                    + SharingInfoContract.RecipesEntry._ID + " INTEGER PRIMARY KEY, "
                    + SharingInfoContract.RecipesEntry.RECIPE_NAME + " TEXT, "
                    + SharingInfoContract.RecipesEntry.INGREDIENTS + " TEXT, "
                    + SharingInfoContract.RecipesEntry.INSTRUCTIONS + " TEXT, "
                    + SharingInfoContract.RecipesEntry.RECIPE_IMAGE_URl + " TEXT, "
                    + SharingInfoContract.RecipesEntry.PREPARATION_TIME + " TEXT, "
                    + SharingInfoContract.RecipesEntry.DINERS_NUMBER + " INTEGER, "
                    + SharingInfoContract.RecipesEntry.DIFFICULTY_PREPARATION + " TEXT, "
                    + SharingInfoContract.RecipesEntry.RECIPE_STORY + " TEXT, "
                    + SharingInfoContract.RecipesEntry.CATEGORY + " TEXT, "
                    + SharingInfoContract.RecipesEntry.CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                    + SharingInfoContract.ProductsEntry.USER_ID + " TEXT, "
                    + SharingInfoContract.RecipesEntry.USER_NAME + " TEXT"+");";

    public SharingInfoDatabaseHelper(Context context){
        super(context,"SharingInfoDB",null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_PRODUCTS);
        db.execSQL(CREATE_TABLE_RECIPES);

        insertFakeProductsData(db);
		insertFakeRecipesData(db);
    }

    /**
     * Insert fake products data
     * @param db
     */
    private void insertFakeProductsData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(SharingInfoContract.ProductsEntry.STORE_NAME, "Mazon min hateva");
        values.put(SharingInfoContract.ProductsEntry.PRODUCT_NAME, "Rye flour");
        values.put(SharingInfoContract.ProductsEntry.HOUSE_NO, 147);
        values.put(SharingInfoContract.ProductsEntry.STREET, "Rabi Akiva");
        values.put(SharingInfoContract.ProductsEntry.CITY, "Bnei Brak");
        db.insert(SharingInfoContract.ProductsEntry.TABLE_NAME,null, values);

        values.put(SharingInfoContract.ProductsEntry.STORE_NAME, "Super Sal Market");
        values.put(SharingInfoContract.ProductsEntry.PRODUCT_NAME, "Gluten free cookies");
        values.put(SharingInfoContract.ProductsEntry.HOUSE_NO, 25);
        values.put(SharingInfoContract.ProductsEntry.STREET, "Herzel");
        values.put(SharingInfoContract.ProductsEntry.CITY, "Eilat");
        values.put(SharingInfoContract.ProductsEntry.PHONE, "0526984458");
        values.put(SharingInfoContract.ProductsEntry.IMAGE_URI, "http://www.lance.com/assets/img/temp/snacks/gf_pb_8pk_crtn.png?1431482040");
        values.put(SharingInfoContract.ProductsEntry.COMMENT, "Moist and delicious cookies");
        db.insert(SharingInfoContract.ProductsEntry.TABLE_NAME,null, values);

        values = new ContentValues();
        values.put(SharingInfoContract.ProductsEntry.STORE_NAME, "Teva Banachala");
        values.put(SharingInfoContract.ProductsEntry.PRODUCT_NAME, "Gluten free pasta");
        values.put(SharingInfoContract.ProductsEntry.HOUSE_NO, 98);
        values.put(SharingInfoContract.ProductsEntry.STREET, "Nakhalat Yitskhak");
        values.put(SharingInfoContract.ProductsEntry.CITY, "Jerusalem");
        values.put(SharingInfoContract.ProductsEntry.PHONE, "02-696-7474");
        values.put(SharingInfoContract.ProductsEntry.IMAGE_URI, "https://milkandeggs.files.wordpress.com/2013/12/photo-2.jpg");
        values.put(SharingInfoContract.ProductsEntry.COMMENT, "Reasonable Prices");
        db.insert(SharingInfoContract.ProductsEntry.TABLE_NAME,null, values);

        values = new ContentValues();
        values.put(SharingInfoContract.ProductsEntry.STORE_NAME, "Nizat haduvdevan");
        values.put(SharingInfoContract.ProductsEntry.PRODUCT_NAME, "Gluten free crispy");
        values.put(SharingInfoContract.ProductsEntry.HOUSE_NO, 58);
        values.put(SharingInfoContract.ProductsEntry.STREET, "Ibn Gabirol");
        values.put(SharingInfoContract.ProductsEntry.CITY, "Tel aviv");
        values.put(SharingInfoContract.ProductsEntry.PHONE, "03-696-5174");
        values.put(SharingInfoContract.ProductsEntry.IMAGE_URI,"http://www.miltonsbaking.com/assets/Uploads/GlutenFreeSeaSaltLARGE.jpg");
        values.put(SharingInfoContract.ProductsEntry.COMMENT, "Ample parking");
        db.insert(SharingInfoContract.ProductsEntry.TABLE_NAME,null, values);

        values = new ContentValues();
        values.put(SharingInfoContract.ProductsEntry.STORE_NAME, "Shkedia");
        values.put(SharingInfoContract.ProductsEntry.PRODUCT_NAME, "Gluten free kornfleks");
        values.put(SharingInfoContract.ProductsEntry.HOUSE_NO, 56);
        values.put(SharingInfoContract.ProductsEntry.STREET, "Katzenelson");
        values.put(SharingInfoContract.ProductsEntry.CITY, "Ramat gan");
        values.put(SharingInfoContract.ProductsEntry.PHONE, "03-731-9958");
        values.put(SharingInfoContract.ProductsEntry.IMAGE_URI,"https://nyoobserver.files.wordpress.com/2015/09/screen-shot-2015-09-22-at-11-02-05-am-e1442935619503.png?w=242&h=300");
        values.put(SharingInfoContract.ProductsEntry.COMMENT, "Excellent service");
        db.insert(SharingInfoContract.ProductsEntry.TABLE_NAME,null, values);
    }


    /**
     * Insert fake recipes data
     * @param db
     */
    private void insertFakeRecipesData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(SharingInfoContract.RecipesEntry.CATEGORY, "Breads &amp; Rolls");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_NAME, "Bread");
        values.put(SharingInfoContract.RecipesEntry.INGREDIENTS, "3 cups lukewarm water;" +
                "6 1/2 to 7 1/2 cups Organic Flour;" +
                "1 tablespoon salt;" +
                "1 1/2 tablespoons instant or active dry yeast");
        values.put(SharingInfoContract.RecipesEntry.INSTRUCTIONS, "he flour/liquid ratio is important in this recipe. If you measure flour by sprinkling it into your measuring cup, then gently sweeping off the excess, use 7 1/2 cups. If you measure flour by dipping your cup into the canister, then sweeping off the excess, use 6 1/2 cups. Most accurate of all, and guaranteed to give you the best results, if you measure flour by weight, use 32 ounces.;" +
                "Combine all of the ingredients in a large mixing bowl, or a large (6-quart), food-safe plastic bucket. For first-timers, \"lukewarm\" means about 105°F, but don't stress over getting the temperatures exact here. Comfortably warm is fine; \"OUCH, that's hot!\" is not. Yeast is a living thing; treat it nicely.;" +
                "Mix and stir everything together to make a very sticky, rough dough. If you have a stand mixer, beat at medium speed with the beater blade for 30 to 60 seconds. If you don't have a mixer, just stir-stir-stir with a big spoon or dough whisk until everything is combined.;" +
                "Next, you're going to let the dough rise. If you've made the dough in a plastic bucket, you're all set — just let it stay there, covering the bucket with a lid or plastic wrap; a shower cap actually works well here. If you've made the dough in a bowl that's not at least 6-quart capacity, transfer it to a large bowl; it's going to rise a lot. There's no need to grease the bowl, though you can if you like; it makes it a bit easier to get the dough out when it's time to bake bread.;" +
                "Cover the bowl or bucket, and let the dough rise at room temperature for 2 hours. Then refrigerate it for at least 2 hours, or for up to about 7 days. (If you're pressed for time, skip the room-temperature rise, and stick it right into the fridge). The longer you keep it in the fridge, the tangier it'll get; if you chill it for 7 days, it will taste like sourdough. Over the course of the first day or so, it'll rise, then fall. That's OK; that's what it's supposed to do.;" +
                "When you're ready to make bread, sprinkle the top of the dough with flour; this will make it easier to grab a hunk. Grease your hands, and pull off about 1/4 to 1/3 of the dough — a 14-ounce to 19-ounce piece, if you have a scale. It'll be about the size of a softball, or a large grapefruit.;" +
                "Plop the sticky dough onto a floured work surface, and round it into a ball, or a longer log. Don't fuss around trying to make it perfect; just do the best you can.;" +
                "Place the loaf on a piece of parchment (if you're going to use a baking stone); or onto a lightly greased or parchment-lined baking sheet. Sift a light coating of flour over the top; this will help keep the bread moist as it rests before baking.;" +
                "Let the loaf warm to room temperature and rise; this should take about 60 minutes (or longer, up to a couple of hours, if your house is cool). It won't appear to rise upwards that much; rather, it'll seem to settle and expand. Preheat your oven to 450°F while the loaf rests. If you're using a baking stone, position it on a middle rack while the oven preheats. Place a shallow metal or cast iron pan (not glass, Pyrex, or ceramic) on the lowest oven rack, and have 1 cup of hot water ready to go.;" +
                "When you're ready to bake, take a sharp knife and slash the bread 2 or 3 times, making a cut about 1/2\" deep. The bread may deflate a bit; that's OK, it'll pick right up in the hot oven.\n" +
                "Place the bread in the oven — onto the baking stone, if you're using one, or simply onto a middle rack, if it's on a pan — and carefully pour the 1 cup hot water into the shallow pan on the rack beneath. It'll bubble and steam; close the oven door quickly.\n" +
                "Bake the bread for 25 to 35 minutes, until it's a deep, golden brown.;" +
                "Remove the bread from the oven, and cool it on a rack. Store leftover bread in a plastic bag at room temperature.");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_IMAGE_URl, "http://images.media-allrecipes.com/userphotos/250x250/910644.jpg");
        values.put(SharingInfoContract.RecipesEntry.PREPARATION_TIME, "30 mins. to 40 mins.");
        values.put(SharingInfoContract.RecipesEntry.DIFFICULTY_PREPARATION, "Easy");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_STORY,"The most basic of all no-knead loaves, this is a wonderful way to get into yeast-bread baking.;" +
                " The easy stir-together dough rests in your refrigerator, developing flavor all the time, till you're ready to bake.;" +
                " About 90 minutes before you want to serve bread, grab a handful of dough, shape it, let it rise, then bake for 30 minutes.; " +
                "The result? Incredible, crusty artisan-style bread.;" +
                " If you're a first-time bread-baker, you'll never believe this bread came out of your own oven.;" +
                " And even if you're a seasoned bread baker,;" +
                " you'll love this recipe's simplicity.");
        db.insert(SharingInfoContract.RecipesEntry.TABLE_NAME, null, values);


        values = new ContentValues();
        values.put(SharingInfoContract.RecipesEntry.CATEGORY, "Cakes");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_NAME, "Chocolate chip cake");
        values.put(SharingInfoContract.RecipesEntry.INGREDIENTS, "1 box gluten-free chocolate;" +
                "2/3 cup vegetable oil;" +
                "2 teaspoons vanilla extract;" +
                "4 large eggs;" +
                "1 1/3 cups water;" +
                "2 cups chocolate chips;" +
                "1 cup chopped walnuts or pecans");
        values.put(SharingInfoContract.RecipesEntry.INSTRUCTIONS, "Preheat the oven to 350°F. Grease a full size (12-cup) Bundt or tube pan.;" +
                "To make the cake: Place the cake mix in a bowl. Beat in the oil, vanilla, and 1 egg.;" +
                "Add the remaining eggs one at a time, beating well after each addition.;" +
                "Add the water 1/3 at a time, beating until smooth and scraping the bowl after each addition.;" +
                "Stir in the chocolate chips and nuts.;" +
                "Bake the cake for 50 to 55 minutes, until a cake tester or toothpick inserted into the center comes out with perhaps crumbs clinging to it, but no wet batter.;" +
                "Remove the cake from the oven, and after 15 minutes turn it out onto a rack.;" +
                "To make the glaze: Melt the butter in a medium-sized saucepan set over low heat.;" +
                "Stir in the corn syrup, cocoa, water, vanilla, espresso powder, and salt. Heat and stir until the salt dissolves.;" +
                "Mix in enough confectioners' sugar to make a glaze with the consistency of thick molasses; you may not need the entire 2 cups.;" +
                "Transfer the cake to a serving plate; if it's still a bit warm, that's OK.;" +
                "Spoon the glaze over the cake, covering it as thoroughly as possible. Reheat the glaze briefly if it becomes too thick to pour");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_IMAGE_URl, "http://www.coca-colacompany.com/stories/food/2012/coca-cola-cake-with-chocolate-ganache/_jcr_content/lead/smartslides1/slide1.resize.w_596.h_334.jpg/TIiYFOWZpDtapgE4NA/0.jpg");
        values.put(SharingInfoContract.RecipesEntry.PREPARATION_TIME, "1 hrs 27 mins");
        values.put(SharingInfoContract.RecipesEntry.DIFFICULTY_PREPARATION, "Hard");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_STORY,"Are you looking forward to making a delicious chocolate cake?; " +
                "There are so many variations that it might be difficult to choose a single recipe;"+
                "Here's a simple one to get you started along with several variations to suit the occasion.");
        db.insert(SharingInfoContract.RecipesEntry.TABLE_NAME, null, values);


        values = new ContentValues();
        values.put(SharingInfoContract.RecipesEntry.CATEGORY, "Cakes");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_NAME, "Lemon cake");
        values.put(SharingInfoContract.RecipesEntry.INGREDIENTS, "4 large eggs, separated;" +
                "1/2 cup + 2 tablespoons sugar, divided;" +
                "1 teaspoon vanilla extract;" +
                "1 1/4 cups almond flour;" +
                "1 tablespoon coconut flour;" +
                "1 teaspoon baking powder;" +
                "1/4 teaspoon salt;" +
                "1 1/2 to 2 cups sliced strawberries, for topping;");
        values.put(SharingInfoContract.RecipesEntry.INSTRUCTIONS, "Preheat the oven to 350°F. Lightly grease an 8;"+
                "round pan with butter (dairy-free if desired) or coconut oil. Swirl it in the pan and make sure it goes up the sides.; " +
                "Sprinkle 2 tablespoons of the sugar listed in the ingredients into the bottom of the pan.;" +
                "In a large mixing bowl, beat together the egg yolks, 1/4 cup of the sugar, and the vanilla until smooth.;" +
                "Using an electric mixer or stand mixer, whip the egg whites until they form soft peaks.;" +
                "Slowly beat in the remaining 1/4 cup sugar. Set aside.;" +
                "Whisk together the dry ingredients — flours, baking powder and salt — and add to the egg yolks. Stir together to form a thick dough.;" +
                "Fold in the egg whites, 1/2 cup at a time, incorporating them fully between each addition. The final addition should result in a smooth, fluffy batter.;" +
                "Pour the cake batter into the prepared pan. Bake the cake on the center rack for 30 to 35 minutes, ;" +
                "until it's golden brown and a toothpick inserted into the center comes out clean.;" +
                "Remove the cake from the oven and allow it to cool in the pan for 5 minutes. ;" +
                "Run a knife around the edge of the pan to loosen the sides, then turn the cake out onto a serving plate.;" +
                "Allow the cake to cool fully before topping with sliced strawberries, or the fruit of your choice.;");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_IMAGE_URl, "http://img.sndimg.com/food/image/upload/w_555,h_416,c_fit,fl_progressive,q_95/v1/img/recipes/71/34/4/khbtXM1UQSWmQl55v3i5_DSC_0144.jpg");
        values.put(SharingInfoContract.RecipesEntry.PREPARATION_TIME, "45 mins to 55 mins");
        values.put(SharingInfoContract.RecipesEntry.DIFFICULTY_PREPARATION, "Medium");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_STORY,"Whether you need a healthy dessert or a decadent breakfast,; " +
                "this moist, tender, and perfectly fluffy almond-flour cake is sure to be a crowd-pleaser. ;" +
                "Topped with fresh strawberries, it's everything we love in a summer treat.; " +
                "Not only that — it's naturally gluten free, the nut flour stepping in for any wheat.");
        db.insert(SharingInfoContract.RecipesEntry.TABLE_NAME, null, values);



        values = new ContentValues();
        values.put(SharingInfoContract.RecipesEntry.CATEGORY, "Fish Recipes");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_NAME, "Smoked Salmon and Spinach Goat Cheese Strata Recipe");
        values.put(SharingInfoContract.RecipesEntry.INGREDIENTS, "8 plain gluten-free waffles, lightly toasted;" +
                "3 cups hand torn pieces of smoked salmon;" +
                "1 20 oz. bag chopped frozen spinach, thawed, drained well;" +
                "6 cloves of garlic, chopped;" +
                "Sea salt and ground pepper, to taste;" +
                "A pinch of nutmeg, to taste;" +
                "1 15-oz jar organic red and yellow roasted peppers, drained, seeded, cut into strips;" +
                "12 medium to large organic free-range eggs;" +
                "1 cup Half and Half;" +
                "Nutmeg or Old Bay Seasoning, to taste;" +
                "8 oz. fresh goat cheese;" +
                "2 tablespoons shredded Parmesan;");
        values.put(SharingInfoContract.RecipesEntry.INSTRUCTIONS, "Prepare a large lasagna-style baking pan- say, 12 x 15 inches- by schmearing it with extra virgin olive oil.;" +
                "Tear the cooled waffles into two or three pieces and line the bottom and sides of the oiled pan to make a crust.;" +
                "Dump the thawed spinach into a warm skillet, add the garlic, season with sea salt and pepper.; " +
                "Stir and cook it down over medium to low heat until all the liquid is reduced, about ten minutes. " +
                "Press with paper towels, if needed, to remove all the moisture. ;" +
                "You don't want a soggy strata, now do you? Remove from heat and set aside.;" +
                "In a large mixing bowl, beat the heck out of the dozen eggs and add the milk.; " +
                "Add a dash of nutmeg or Old Bay Seasoning, to taste.;" +
                "Assemble the strata:;" +
                "Scatter the smoked salmon all over the waffles. Cut and layer the goat cheese evenly over the salmon.; " +
                "Spread the garlicky spinach evenly over the goat cheese. Press the spinach with a flat spatula;" +
                "Add a layer of red and yellow pepper strips. Pat gently with the spatula to flatten.; " +
                "Slowly pour the egg custard all over the layers, and allow the mixture to seep in and around all the nooks and crannies, without disturbing the layers. ;" +
                "You want the egg custard to reach the bottom crust and soak in. Sprinkle some shredded Parmesan all over the top- but not too much- let the beautiful red and green colors of the spinach and peppers show through.;" +
                "Cover the strata with plastic wrap and chill overnight (or at least eight hours).;" +
                "Remove the strata from the fridge thirty minutes before baking. Pre-heat the oven to 350ºF. " +
                "Take off the plastic wrap and bake the strata in the center of the oven till set and slightly golden. For me, that was about 45 to 50 minutes, but it can cook for up to an hour, " +
                "depending upon the size and depth of your dish, your altitude, etc.. Just keep an eye on it. Test the center with a wooden pick to make sure it is cooked all the way through.\n" +
                "Set the strata on a wire rack for ten minutes before slicing and serving.;" +
                "Serves 6 hearty appetites or 8 as a light meal or side dish.");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_IMAGE_URl, "http://cdn.sheknows.com/articles/crave/salmon_orange.jpg");
        values.put(SharingInfoContract.RecipesEntry.PREPARATION_TIME, "15 mins to 25 mins");
        values.put(SharingInfoContract.RecipesEntry.DIFFICULTY_PREPARATION, "Medium");
        values.put(SharingInfoContract.RecipesEntry.RECIPE_STORY,"Serving strata makes entertaining so easy. ;" +
                "And the colors are so festive. Make it a day ahead to let the custard seep in and get happy.;" +
                "I use gently toasted gluten-free waffles instead--- and Babycakes! ;" +
                "Such a golden pastry-like crust they make. It melts in your mouth. Like buttah.;");
        db.insert(SharingInfoContract.RecipesEntry.TABLE_NAME, null, values);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
