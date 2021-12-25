package com.quangcao.bai4.Delete;

import android.widget.TextView;

import com.quangcao.bai4.Update.ProductsUpdate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FunctionDelete {
    public void delete_SP(TextView tv_kq , String pid){
        // 1. Tạo đối tượng
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://batdongsanabc.000webhostapp.com/mob403lab5/")
                .addConverterFactory(GsonConverterFactory.create() )
                .build();
        // 2. Đưa dữ liệu vào request
        RequestDelete requestDelete = new RequestDelete();
        requestDelete.setProducts(new ProductDelete(pid) );
        // 3. Gọi Interface
        InterfaceDelete interfaceDelete = retrofit.create(InterfaceDelete.class);
        Call<ResponseDelete> call = interfaceDelete.delete_Product(  pid );
        // 4. Thực thi hàm
        call.enqueue(new Callback<ResponseDelete>() {
            @Override
            public void onResponse(Call<ResponseDelete> call, Response<ResponseDelete> response) {
                // get data
                ResponseDelete responseDelete = response.body();
                tv_kq.setText( responseDelete.getMessage() );
            }

            @Override
            public void onFailure(Call<ResponseDelete> call, Throwable t) {
                tv_kq.setText(t.getMessage());
            }
        });
    }
}
