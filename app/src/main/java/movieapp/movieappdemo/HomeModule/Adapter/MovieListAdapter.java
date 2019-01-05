package movieapp.movieappdemo.HomeModule.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import movieapp.movieappdemo.HomeModule.JSONModel.GenresItem;
import movieapp.movieappdemo.R;
import movieapp.movieappdemo.Utility.CTextView;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private Context context;
    List<GenresItem> genresItems = new ArrayList<>();
    private final LayoutInflater mInflater;

    public MovieListAdapter(Context context, List<GenresItem> genresItems) {
        this.context = context;
        this.genresItems = genresItems;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.movie_layout, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final GenresItem dataItem = genresItems.get(position);
        holder.movieName.setText(dataItem.getName());

    }


    @Override
    public int getItemCount() {
        if (genresItems != null) {
            return genresItems.size();
        } else {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final CTextView movieName;

        private ViewHolder(View itemView) {
            super(itemView);
            movieName = (CTextView) itemView.findViewById(R.id.movieName);

        }
    }
}

