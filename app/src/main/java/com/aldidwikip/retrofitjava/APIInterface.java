package com.aldidwikip.retrofitjava;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aldidwikip on 29/12/2017.
 */

public interface APIInterface {
    @GET("users/aldidwiki")
    Call<MultipleResource> doGetListResources();
}
