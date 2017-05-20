package io.imagineer.diary;

import io.realm.RealmObject;

/**
 * Created by marco on 5/20/17.
 */

public class Article extends RealmObject {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
