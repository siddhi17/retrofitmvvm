package com.example.retrofitmvvm.ViewModel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitmvvm.Interfaces.Api;
import com.example.retrofitmvvm.Model.Comments;
import com.example.retrofitmvvm.Model.PostResponse;
import com.example.retrofitmvvm.Model.Venue;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VenueViewModel extends ViewModel {

        //this is the data that we will fetch asynchronously
        private MutableLiveData<List<Venue>> venueList;
        private MutableLiveData<List<Comments>> commentsList;
        private LiveData<PostResponse> postResponse;
        private Context mContext;

        //we will call this method to get the data
        public LiveData<List<Venue>> getVenues() {
            //if the list is null
            if (venueList == null) {
                venueList = new MutableLiveData<List<Venue>>();
                //we will load it asynchronously from server in this method
                loadVenues();
            }

            //finally we will return the list
            return venueList;
        }


    //we will call this method to get the data
    public LiveData<List<Comments>> getComments() {
        //if the list is null
        if (commentsList == null) {
            commentsList = new MutableLiveData<List<Comments>>();
            //we will load it asynchronously from server in this method
            loadComments();
        }

        //finally we will return the list
        return commentsList;
    }


    //This method is using Retrofit to get the JSON data from URL
        private void loadVenues() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Api api = retrofit.create(Api.class);
            Call<List<Venue>> call = api.getVenues();


            call.enqueue(new Callback<List<Venue>>() {
                @Override
                public void onResponse(Call<List<Venue>> call, Response<List<Venue>> response) {

                    //finally we are setting the list to our MutableLiveData
                    venueList.setValue(response.body());

                    Log.d("List",response.body().toString());

                }

                @Override
                public void onFailure(Call<List<Venue>> call, Throwable t) {

                }
            });
        }

    //This method is using Retrofit to get the JSON data from URL
    private void loadComments() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Comments>> call = api.doGetSingleIdComments("1");


        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {

                //finally we are setting the list to our MutableLiveData
                commentsList.setValue(response.body());

                Log.d("List", response.body().toString());

            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

            }
        });
    }

}
