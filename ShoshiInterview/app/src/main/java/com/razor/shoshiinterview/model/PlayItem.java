package com.razor.shoshiinterview.model;

/**
 * Created by razor2 on 09/08/16.
 */
public class PlayItem {
    private String title;
    private String link;
    private String thumb;

    public PlayItem(){}

    public PlayItem(String title, String link, String thumb) {
        this.title = title;
        this.link = link;
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getThumb() {
        return thumb;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
