package com.minorproject.krashakmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.minorproject.krashakmart.model.Articles;
import com.minorproject.krashakmart.model.Headlines;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class News_FeedFragment extends AppCompatActivity{

    RecyclerView recyclerView;
    final String API_KEY = "236c3f882ffa454ea73a9f11869e3d2a";
    Adapter adapter;
    List<Articles> articles = new ArrayList<>();

    public static News_FeedFragment newInstance() {
        News_FeedFragment news_feedFragment=new News_FeedFragment();
        return  news_feedFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news__feed);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String country = getCountry();
        retrieveJson(country,API_KEY);

    }


    public void retrieveJson(String country, String apiKey){
        Call<Headlines> call = ApiClient.getInstance().getApi().getHeadlines(country, apiKey);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {

                if(response.isSuccessful() && response.body().getArticles() != null){

                    articles.clear();
                    articles = response.body().getArticles();
                    adapter = new Adapter(News_FeedFragment.this,articles);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {

                Toast.makeText(News_FeedFragment.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }
}