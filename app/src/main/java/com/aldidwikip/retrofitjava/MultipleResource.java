package com.aldidwikip.retrofitjava;

import com.google.gson.annotations.SerializedName;


/**
 * Created by aldidwikip on 29/12/2017.
 */

public class MultipleResource {
    @SerializedName("name")
    public String name;

    @SerializedName("avatar_url")
    public String avatar_url;

    @SerializedName("location")
    public String location;

    @SerializedName("id")
    public String id;
}
