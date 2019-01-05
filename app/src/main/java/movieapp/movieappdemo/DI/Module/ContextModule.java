package movieapp.movieappdemo.DI.Module;

import android.content.Context;


import dagger.Module;
import dagger.Provides;
import movieapp.movieappdemo.DI.qualifier.ApplicationContext;
import movieapp.movieappdemo.DI.scopes.ApplicationScope;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
