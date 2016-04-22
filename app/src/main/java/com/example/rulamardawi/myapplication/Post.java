package com.example.rulamardawi.myapplication;

import java.security.PublicKey;
import java.util.Date;

/**
 * Created by rulamardawi on 4/4/16.
 */
public class Post {
    public String Data = null ;
    public Date Date = null;
    public String Path = null;


    public Post(String data, java.util.Date date, String path) {
        Data = data;
        Date = date;
        Path = path;
    }

    public Post(java.util.Date date, String path) {
        Date = date;
        Path = path;
    }

    public Post(String data, java.util.Date date) {

        Data = data;
        Date = date;
    }

    public String getData() {
        return Data;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public String getPath() {
        return Path;
    }

    public void setData(String data) {
        Data = data;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public void setPath(String path) {
        Path = path;
    }
   public void StudentPost(int id)
   {

   }
    public void UtilityPost(int id)
    {

    }
    public void ClubPost(int id)
    {

    }
    public void CoursePost(int id)
    {

    }
}
