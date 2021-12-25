package com.quangcao.bai4.Update;

import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FunctionUpdate {

    public void ham_Update(TextView tv_kq , ProductsUpdate productsUpdate){
        // 1. Tạo đối tượng
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstUpdate.BASE_URL)
                .addConverterFactory( GsonConverterFactory.create() )
                .build();
        // 2. Đưa dữ liệu Update vào request
        RequestUpdate requestUpdate = new RequestUpdate();
        requestUpdate.setProducts(productsUpdate);
        // 3. Gọi hàm từ Interface
        InterfaceUpdate interfaceUpdate = retrofit.create(InterfaceUpdate.class);
        Call<ResponseUpdate> call = interfaceUpdate.updateProduct(
                productsUpdate.getPid(),
                productsUpdate.getName(),
                productsUpdate.getPrice(),
                productsUpdate.getDescription()
        );
        // Thực thi
        call.enqueue(new Callback<ResponseUpdate>() {
            // khi thành công
            @Override
            public void onResponse(Call<ResponseUpdate> call, Response<ResponseUpdate> response) {
                // Get Data
                ResponseUpdate responseUpdate = response.body();
                tv_kq.setText( responseUpdate.getMessage() );
            }

            // khi thất bại
            @Override
            public void onFailure(Call<ResponseUpdate> call, Throwable t) {
                tv_kq.setText( t.getMessage() );
            }
        });
    }

}
