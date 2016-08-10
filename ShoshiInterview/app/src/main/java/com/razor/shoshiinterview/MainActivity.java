package com.razor.shoshiinterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.razor.shoshiinterview.model.PlayItem;
import com.razor.shoshiinterview.recyclerView.VideosAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.videos_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(loadPlays());
    }

    /**
     * Load Json video list
     *
     * @return VideosAdapter
     */
    public VideosAdapter loadPlays() {
        final List<PlayItem> playItemList = new ArrayList<>();
        final VideosAdapter videosAdapter = new VideosAdapter(getApplicationContext());
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String playListurl = "http://www.razor-tech.co.il/hiring/youtube-api.json";

        JsonObjectRequest req = new JsonObjectRequest(
                playListurl,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray plays = response.getJSONArray("Playlists");


                            if (plays.length() > 0) {
                                for (int i = 0; i < plays.length(); i++) {
                                    JSONObject playListjsonObject = plays.getJSONObject(i);
                                    JSONArray listItems = playListjsonObject.getJSONArray("ListItems");
                                    for (int j = 0; j < listItems.length(); j++) {
                                        JSONObject jsonObject = listItems.getJSONObject(j);
                                        PlayItem playItem = new PlayItem();
                                        if (!jsonObject.isNull("Title")) {
                                            playItem.setTitle(jsonObject.getString("Title"));
                                        }
                                        if (!jsonObject.isNull("link")) {
                                            playItem.setLink(jsonObject.getString("link"));
                                        }
                                        if (!jsonObject.isNull("thumb")) {
                                            playItem.setThumb(jsonObject.getString("thumb"));
                                        }
                                        playItemList.add(i, playItem);
                                    }
                                }
                                videosAdapter.setPlayList(playItemList);
                                videosAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VolleyError", error.getMessage());
                    }
                });
        requestQueue.add(req);
        return videosAdapter;
    }

}
