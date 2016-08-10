package com.razor.shoshiinterview.recyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.razor.shoshiinterview.PlayActivity;
import com.razor.shoshiinterview.R;
import com.razor.shoshiinterview.model.PlayItem;

import java.util.List;

/**
 * Provide views to RecyclerView with data from playList.
 */
public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.PlayItemViewHolder>{
    private List<PlayItem> playList;
    static Context context;

    public VideosAdapter(Context context) {
        this.context = context;
    }

    public VideosAdapter(List<PlayItem> playList, Context context) {
        this.playList = playList;
        this.context = context;
    }

    public void setPlayList(List<PlayItem> playList){
        this.playList = playList;
    }

    @Override
    public PlayItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        PlayItemViewHolder pvh = new PlayItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PlayItemViewHolder holder, int position) {
        holder.title.setText(playList.get(position).getTitle());
        holder.link.setText(playList.get(position).getLink());
        String imgPath = playList.get(position).getThumb();
        if(!TextUtils.isEmpty(imgPath)) {
            Glide.with(context).load(imgPath)
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    //.placeholder(R.drawable.) //TODO: set place holder image
                    //.error(R.drawable.)//TODO: set place holder image
                    .centerCrop()
                    .into(holder.videoImg);
        }

    }

    @Override
    public int getItemCount() {
        if (playList != null) {
            return playList.size();
        }
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public static class PlayItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title, link;
        private ImageView videoImg;

        PlayItemViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.row_title);
            link = (TextView) view.findViewById(R.id.row_subtitle);
            videoImg = (ImageView) view.findViewById(R.id.row_img);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, PlayActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("youtubeUrl",link.getText().toString()); //send the link video parameter
            context.startActivity(intent); //Start play activity
        }
    }


}
