package com.shingo.taskmaster;

class Tasks {

    String title;
    String body;
    String state;


    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getState() {
        return state;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Tasks(String title, String body, String state) {
        this.title = title;
        this.body = body;
        this.state = state;
    }


}
