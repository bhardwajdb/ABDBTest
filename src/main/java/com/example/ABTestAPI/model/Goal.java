package com.example.ABTestAPI.model;

import com.example.ABTestAPI.dbModel.GoalEntity;

/**
 * Created by diwakar on 5/6/17.
 */
public class Goal {
    private int id;
    private String name;
    private String event;
    private String  htmlClassName;

    public Goal(GoalEntity e)
    {
        this.id = e.getId();
        this.name = e.getName();
        this.event = e.getEvent();
        this.htmlClassName = e.getHtmlclassname();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getHtmlClassName() {
        return htmlClassName;
    }

    public void setHtmlClassName(String htmlClassName) {
        this.htmlClassName = htmlClassName;
    }

    public Goal() {

    }
}
