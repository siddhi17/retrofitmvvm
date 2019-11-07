package com.example.retrofitmvvm.Interfaces;

import com.example.retrofitmvvm.Model.Comments;

import com.example.retrofitmvvm.Model.PostResponse;
import com.example.retrofitmvvm.Model.Venue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("users")
    Call<List<Venue>> getVenues();

    @GET("comments?")
    Call<List<Comments>> doGetSingleIdComments(@Query("postId") String page);

    @FormUrlEncoded
    @PUT("posts/{id}")
    Call<PostResponse> postData(
            @Path("id") String id,
            @Field("title") String title,
            @Field("body") String body,
            @Field("userId") String userId);
}