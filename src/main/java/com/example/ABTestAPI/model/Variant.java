package com.example.ABTestAPI.model;

import com.example.ABTestAPI.dbModel.VariantEntity;

/**
 * Created by diwakar on 5/6/17.
 */
public class Variant {
    private int id;
    private String name;
    private int percentage;
    private String cssAttributeValue;
    private int experimentId;
    private int successCount;

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(int experimentId) {
        this.experimentId = experimentId;
    }

    public Variant(int id, String name, int percentage, String cssAttributeValue, int experimentId, int successCount) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.cssAttributeValue = cssAttributeValue;
        this.experimentId = experimentId;
        this.successCount = successCount;
    }

    public Variant() {
    }

    public Variant(VariantEntity e)
    {
        this.id = e.getId();
        this.name = e.getName();
        this.percentage = e.getPercentage();
        this.cssAttributeValue = e.getCssattributevalue();
        this.experimentId = e.getExperimentid();
        this.successCount = e.getSuccessCount();
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

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getCssAttributeValue() {
        return cssAttributeValue;
    }

    public void setCssAttributeValue(String cssAttributeValue) {
        this.cssAttributeValue = cssAttributeValue;
    }
}
