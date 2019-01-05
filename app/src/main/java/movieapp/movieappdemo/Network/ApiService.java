package movieapp.movieappdemo.Network;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import movieapp.movieappdemo.HomeModule.JSONModel.MovieListHeaderResponse;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Ganesh Divekar on 20/02/18.
 */

public interface ApiService {
    // Register new user
    @GET(WebServiceAPI.Movie_URL)
    Single<MovieListHeaderResponse> getMovieList();

   /* // Create note
    @FormUrlEncoded
    @POST("notes/new")
    Single<Note> createNote(@Field("note") String note);

    // Fetch all notes
    @GET("notes/all")
    Single<List<Note>> fetchAllNotes();

    // Update single note
    @FormUrlEncoded
    @PUT("notes/{id}")
    Completable updateNote(@Path("id") int noteId, @Field("note") String note);

    // Delete note
    @DELETE("notes/{id}")
    Completable deleteNote(@Path("id") int noteId);*/
}
