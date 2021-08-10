package com.dog.knowthedog;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface apiInterface {
    @GET("breeds")
    Call<List<ModelClass>> inputDogs();

}
