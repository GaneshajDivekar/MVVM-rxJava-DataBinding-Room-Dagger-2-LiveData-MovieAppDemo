package movieapp.movieappdemo.HomeModule;

import android.app.ProgressDialog;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import movieapp.movieappdemo.HomeModule.JSONModel.MovieListHeaderResponse;
import movieapp.movieappdemo.Network.ApiClient;
import movieapp.movieappdemo.Network.ApiService;
import movieapp.movieappdemo.Network.WebServiceAPI;

public class HomeViewModel extends ViewModel {
    Context context;
    ApiService apiServicee;

    private CompositeDisposable disposable = new CompositeDisposable();

    private MutableLiveData<MovieListHeaderResponse> movieListHeaderResponseMutableLiveData;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LiveData<MovieListHeaderResponse> getResponseModelLiveData(Context context, ApiService apiService) {
        //if the list is null
        this.context = context;
        movieListHeaderResponseMutableLiveData = new MutableLiveData<MovieListHeaderResponse>();
        this.apiServicee = apiService;
        movieListTask();
        return movieListHeaderResponseMutableLiveData;
    }

    private void movieListTask() {
        disposable.add(
                apiServicee
                        .getMovieList()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<MovieListHeaderResponse>() {
                            @Override
                            public void onSuccess(MovieListHeaderResponse user) {

                                movieListHeaderResponseMutableLiveData.setValue(user);

                            }

                            @Override
                            public void onError(Throwable e) {
                                String s = e.getMessage();
                            }
                        }));

    }

}
