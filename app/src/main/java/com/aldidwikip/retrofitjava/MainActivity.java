package com.aldidwikip.retrofitjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvname, tvlocation, tvid;
    ImageView avatarimg;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvname = findViewById(R.id.name);
        tvid = findViewById(R.id.id);
        tvlocation = findViewById(R.id.location);
        avatarimg = findViewById(R.id.avatarimg);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<MultipleResource> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {

                Log.d("TAG", response.code() + "");

                MultipleResource resource = response.body();
                String name = resource.name;
                String location = resource.location;
                String id = resource.id;
                String avatar = resource.avatar_url;

                Glide.with(MainActivity.this).load(avatar).into(avatarimg);
                tvid.setText(id);
                tvname.setText(name);
                tvlocation.setText(location);
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {
                call.cancel();
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
