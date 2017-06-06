package com.example.ABTestAPI.model;

import com.example.ABTestAPI.dbModel.ExperimentEntity;

/**
 * Created by diwakar on 5/6/17.
 */
public class Experiment {

    private long id;
    private String name;
    private String  htmlClassName;
    private int goalId;
    private String  cssAttributeKey;

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public String getCssAttributeKey() {
        return cssAttributeKey;
    }

    public void setCssAttributeKey(String cssAttributeKey) {
        this.cssAttributeKey = cssAttributeKey;
    }

    public String getHtmlClassName() {
        return htmlClassName;
    }

    public void setHtmlClassName(String htmlClassName) {
        this.htmlClassName = htmlClassName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String content) {
        this.name = content;
    }

    public Experiment() {
    }

    public Experiment(ExperimentEntity e)
    {
        this.id = e.getId();
        this.name = e.getName();
        this.htmlClassName = e.getHtmlclassname();
        this.goalId = e.getGoalid();
    }

    public Experiment(long id, String content) {
        this.id = id;
        this.name = content;
    }

}