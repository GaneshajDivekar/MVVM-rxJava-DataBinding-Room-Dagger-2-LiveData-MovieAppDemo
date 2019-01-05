package movieapp.movieappdemo.Utility;


import android.app.Activity;
import android.app.Application;
import android.content.Context;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import movieapp.movieappdemo.DI.ApplicationComponent;
import movieapp.movieappdemo.DI.DaggerApplicationComponent;
import movieapp.movieappdemo.DI.Module.ContextModule;
import movieapp.movieappdemo.Network.ApiClient;
import movieapp.movieappdemo.Network.ApiService;

public class MovieApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);

    }

    public static MovieApplication get(Activity activity){
        return (MovieApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}