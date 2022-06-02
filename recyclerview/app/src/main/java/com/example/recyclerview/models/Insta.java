package com.example.recyclerview.models;

import java.io.Serializable;
import java.util.ArrayList;

// 직렬화 --> OBJDECT --> Byte
// 역직렬화 Byte --> OBJECT
public class Insta implements Serializable {

    private String thumbnail;
    private String tilte;
    private String subTitle;
    private String detail;
    private String viewCount;
    private String datgle;

    public Insta(String thumbnail, String tilte, String subTitle, String detail, String viewCount, String datgle) {
        this.thumbnail = thumbnail;
        this.tilte = tilte;
        this.subTitle = subTitle;
        this.detail = detail;
        this.viewCount = viewCount;
        this.datgle = datgle;
    }


    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getDatgle() {
        return datgle;
    }

    public void setDatgle(String datgle) {
        this.datgle = datgle;
    }

    public static ArrayList<Insta> getSampleData(){
        ArrayList<Insta> insta = new ArrayList<>();
        insta.add(new Insta("https://cdn.pixabay.com/photo/2016/11/30/15/23/apples-1873078__480.jpg","사과는 빨갛다","Jenny","#사과#같은#내얼굴","조회수 : 30만회","댓글 : 102개"));
        insta.add(new Insta("https://media.istockphoto.com/photos/london-bridge-aerial-view-from-the-porthole-picture-id585626202?k=20&m=585626202&s=612x612&w=0&h=TDolLenB827J6nuTKcWOjF0kBhpdYJL6GL37XjA3il8=","Good Bye London","jisoo","#United Kingdom","조회수 : 52만회","댓글 : 305개"));
        insta.add(new Insta("https://media.istockphoto.com/photos/friends-cheering-sport-at-bar-together-picture-id945387466?k=20&m=945387466&s=612x612&w=0&h=QOKDVsFE8dGRwX0TESDcTs-qOFxG9ljl_Y_4CorON9Q=","Winner","Kevin","#우승했다#축하해","조회수 : 60만회","댓글 : 12개"));
        return insta;
    }
}
