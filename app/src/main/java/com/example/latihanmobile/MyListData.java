package com.example.latihanmobile;

public class MyListData {
    private String description;
    private Integer imgId;
    public MyListData(String description, int imgId){
        this.description = description;
        this.imgId = imgId;
    }
    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}
    public int getImgId(){return imgId;}
    public void setImgId(int imgId){this.imgId = imgId;}
}
