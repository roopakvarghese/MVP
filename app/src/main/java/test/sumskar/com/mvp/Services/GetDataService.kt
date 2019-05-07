package test.sumskar.com.mvp.Services

import retrofit2.http.GET
import retrofit2.Call

import retrofit2.http.Query
import test.sumskar.com.mvp.model.BaseResponce

interface GetDataService {
    @GET("api.php")
     fun getWikiData(
        @Query("action") action: String, @Query("format") format: String, @Query("list") list: String, @Query(
            "srsearch") srsearch: String): Call<BaseResponce>

}