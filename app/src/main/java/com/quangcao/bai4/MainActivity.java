package com.quangcao.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.quangcao.bai4.Delete.FunctionDelete;
import com.quangcao.bai4.Update.FunctionUpdate;
import com.quangcao.bai4.Update.ProductsUpdate;

public class MainActivity extends AppCompatActivity {

    TextView tv_kq;
    EditText edt_pid ,edt_name , edt_price , edt_description;
    Button btn_delete, btn_update;
    String kq = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_pid = findViewById(R.id.edt_pid);
        edt_name = findViewById(R.id.edt_name);
        edt_price = findViewById(R.id.edt_price);
        edt_description = findViewById(R.id.edt_description);
        tv_kq = findViewById(R.id.tv_kq);
        btn_delete = findViewById(R.id.btn_delete);
        btn_update = findViewById(R.id.btn_update);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pid = edt_pid.getText().toString();
                String name = edt_name.getText().toString();
                String price = edt_price.getText().toString();
                String description = edt_description.getText().toString();

                FunctionUpdate functionUpdate = new FunctionUpdate();
                functionUpdate.ham_Update(tv_kq , new ProductsUpdate(pid , name , price , description) );
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FunctionDelete functionDelete = new FunctionDelete();
                functionDelete.delete_SP(tv_kq , edt_pid.getText().toString() );
            }
        });
    }
}