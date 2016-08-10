package com.razor.shoshiinterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.razor.shoshiinterview.utils.YoutubeUtil;

public class PlayActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private YouTubePlayerView youTubeView;
    private String tag = "YouTube Video";
    private String ytUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ytUrl = getIntent().getStringExtra("youtubeUrl");
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(getResources().getString(R.string.youtube_api_key), this);
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!TextUtils.isEmpty(ytUrl)) {
            youTubePlayer.cueVideo(YoutubeUtil.extractYTId(ytUrl)); //Play video with extracted video id
            youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener); ///Add playerStateChangeListener to YouTubePlayer instance
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.e(tag, getResources().getString(R.string.player_error));
    }

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {

        @Override
        public void onAdStarted() {
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason arg0) {
        }

        @Override
        public void onLoaded(String arg0) {
        }

        @Override
        public void onLoading() {
        }

        @Override
        public void onVideoEnded() {
            finish(); //Go back to video list (Main Activity)
        }

        @Override
        public void onVideoStarted() {
            Log.i(tag, getResources().getString(R.string.player_started));
        }
    };

}
