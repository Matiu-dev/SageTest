package org.openjfx;

import org.openjfx.model.ResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

        @GET("top-headlines")
        Call<ResponseModel> getNews(@Query("country") String source,@Query("category") String category, @Query("apiKey") String apiKey);
}
