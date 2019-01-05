package movieapp.movieappdemo.HomeModule;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import movieapp.movieappdemo.DI.qualifier.ActivityContext;
import movieapp.movieappdemo.DI.qualifier.ApplicationContext;
import movieapp.movieappdemo.HomeModule.Adapter.MovieListAdapter;
import movieapp.movieappdemo.HomeModule.JSONModel.GenresItem;
import movieapp.movieappdemo.HomeModule.JSONModel.MovieListHeaderResponse;
import movieapp.movieappdemo.Network.ApiClient;
import movieapp.movieappdemo.Network.ApiService;
import movieapp.movieappdemo.R;
import movieapp.movieappdemo.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ApiService apiService;
   // Context context;
    ActivityHomeBinding activityHomeBinding;
    HomeViewModel homeViewModel;
    List<GenresItem> genresItems = new ArrayList<>();
    MovieListAdapter movieListAdapter;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        apiService = ApiClient.getClient(getApplicationContext()).create(ApiService.class);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        showData();
    }

    private void showData() {
        homeViewModel.getResponseModelLiveData(mContext, apiService).observe(HomeActivity.this, new Observer<MovieListHeaderResponse>() {
            @Override
            public void onChanged(@Nullable MovieListHeaderResponse movieListHeaderResponse) {
                if (movieListHeaderResponse != null)
                    genresItems = movieListHeaderResponse.getGenres();
                RecyclerView.LayoutManager instrumentRVLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
                activityHomeBinding.rcView.setLayoutManager(instrumentRVLayoutManager);
                movieListAdapter = new MovieListAdapter(mContext, genresItems);
                activityHomeBinding.rcView.setAdapter(movieListAdapter);

            }
        });
    }
}
