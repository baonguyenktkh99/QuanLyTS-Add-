package com.example.quanlyts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Nhan_Vien_Add extends AppCompatActivity {
    EditText txtTenNV, txtNgaySinh, txtDiaChi, txtSDT, txtEmail, txtUser, txtPass, txtQuyen;
    Button btnThemNV, btnHuyNV;
    EditText spPhongBan;
    //String arr[] = {"Đào tạo", "Phòng thiết kế", "Phòng Tuyển nhân sự", "Phòng Kế toán"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan__vien__add);
        txtTenNV = (EditText) findViewById(R.id.txtTenNV);
        txtNgaySinh = (EditText) findViewById(R.id.txtNgaySinh);
        txtDiaChi = (EditText) findViewById(R.id.txtDiaChi);
        txtSDT = (EditText) findViewById(R.id.txtSDT);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtMatKhau);
        spPhongBan = (EditText) findViewById(R.id.spPhongBan);
        txtQuyen = (EditText) findViewById(R.id.txtQuyen);
        btnThemNV = (Button) findViewById(R.id.btnThemNV);
        btnThemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TenNV = txtTenNV.getText().toString().trim();
                String NgaySinh = txtNgaySinh.getText().toString().trim();
                String DiaChi = txtDiaChi.getText().toString().trim();
                String SDT = txtSDT.getText().toString().trim();
                String Email = txtEmail.getText().toString().trim();
                String User = txtUser.getText().toString().trim();
                String Pass = txtPass.getText().toString().trim();
                String PhongBan = spPhongBan.getText().toString().trim();
                String Quyen = txtQuyen.getText().toString().trim();
                new postServer(TenNV, NgaySinh, DiaChi, SDT, Email, User, Pass, PhongBan, Quyen).execute("http://192.168.1.7:81/qlts/insertNhanVien.php");
            }
        });
    }
    class postServer extends AsyncTask<String, Void, String>{
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        String tenNV, ngaySinh, diaChi, soDT, Email, User, pass, phongBan, quyen;

        public postServer(String tenNV, String ngaySinh, String diaChi, String soDT, String email, String user, String pass, String phongBan, String quyen) {
            this.tenNV = tenNV;
            this.ngaySinh = ngaySinh;
            this.diaChi = diaChi;
            this.soDT = soDT;
            this.Email = email;
            this.User = user;
            this.pass = pass;
            this.phongBan = phongBan;
            this.quyen = quyen;
        }

        @Override
        protected String doInBackground(String... strings) {
            RequestBody requestBody = new MultipartBody.Builder()
                    .addFormDataPart("tenNV", tenNV)
                    .addFormDataPart("ngaySinh", ngaySinh)
                    .addFormDataPart("diaChi", diaChi)
                    .addFormDataPart("soDT", soDT)
                    .addFormDataPart("Email", Email)
                    .addFormDataPart("UserName", User)
                    .addFormDataPart("matKhau", pass)
                    .addFormDataPart("phongBan", phongBan)
                    .addFormDataPart("Quyen", quyen)
                    .setType(MultipartBody.FORM)
                    .build();
            Request request = new Request.Builder()
                    .url(strings[0])
                    .post(requestBody)
                    .build();

            try {
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("AAA", s);
            super.onPostExecute(s);
        }
    }

//    private class MyProcessEvent implements AdapterView.OnItemSelectedListener {
//        @Override
//        public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
//            //spPhongBan.setSelected(Boolean.parseBoolean(arr[arg2]));
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> adapterView) {
//            //spPhongBan.setSelected(Boolean.parseBoolean(""));
//        }
//    }
}
