package com.example.latihanmobile;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

public interface RegisterAPI {
    @GET("get_mahasiswa.php")
    Call<Value> view();

    @FormUrlEncoded
    @POST("post_mahasiswa.php")
    Call<ResponseBody> insert_mahasiswa(
            @Field("nim") String nim,
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("telp") String telp
    );
}
