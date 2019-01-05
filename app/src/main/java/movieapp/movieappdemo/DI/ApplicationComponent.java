package movieapp.movieappdemo.DI;

import android.content.Context;

import dagger.Component;
import movieapp.movieappdemo.DI.Module.ContextModule;
import movieapp.movieappdemo.DI.qualifier.ApplicationContext;
import movieapp.movieappdemo.DI.scopes.ApplicationScope;
import movieapp.movieappdemo.Network.ApiService;
import movieapp.movieappdemo.Utility.MovieApplication;


@ApplicationScope
@Component(modules = {ContextModule.class})
public interface ApplicationComponent {


    @ApplicationContext
    public Context getContext();

    public void injectApplication(MovieApplication myApplication);
}
