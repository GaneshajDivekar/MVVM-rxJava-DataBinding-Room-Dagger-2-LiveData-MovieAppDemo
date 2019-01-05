package movieapp.movieappdemo.HomeModule.JSONModel;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MovieListHeaderResponse implements Serializable{

	@SerializedName("genres")
	private List<GenresItem> genres;

	public void setGenres(List<GenresItem> genres){
		this.genres = genres;
	}

	public List<GenresItem> getGenres(){
		return genres;
	}

	@Override
 	public String toString(){
		return 
			"MovieListHeaderResponse{" + 
			"genres = '" + genres + '\'' + 
			"}";
		}
}