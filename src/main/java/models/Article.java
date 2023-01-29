package models;

public class Article {
    private String title;
    private String body;
    private String UserId;

    public Article(){
        title = "default title";
        body = "default body";
        UserId = "default user";
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}