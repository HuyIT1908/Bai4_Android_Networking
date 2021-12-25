package com.quangcao.bai4.Delete;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceDelete {
    @FormUrlEncoded
    @POST("delete_product.php")
    Call<ResponseDelete> delete_Product(@Field("pid") String pid);
}
