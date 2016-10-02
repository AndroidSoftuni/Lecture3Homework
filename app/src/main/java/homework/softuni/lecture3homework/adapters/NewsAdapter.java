package homework.softuni.lecture3homework.adapters;

import android.view.View;
import android.app.Activity;
import android.view.ViewGroup;
import android.graphics.Color;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import homework.softuni.lecture3homework.R;
import homework.softuni.lecture3homework.entities.News;
import homework.softuni.lecture3homework.communicator.NewsCommunicator;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.CustomVH> {

    private Activity         activity;
    private ArrayList<News>  news;
    private NewsCommunicator nc;

    private ArrayList<Boolean> marker;

    public NewsAdapter(Activity activity, ArrayList<News> news, NewsCommunicator nc) {
        this.nc       = nc;
        this.news     = news;
        this.marker   = new ArrayList<>();
        this.activity = activity;
    }

    @Override
    public CustomVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();

        View row = inflater.inflate(R.layout.news_element, parent, false);

        return new CustomVH(row);
    }

    @Override
    public void onBindViewHolder(final CustomVH holder, final int position) {
        if (marker.size() <= news.size() && position == marker.size()) {
            marker.add(false);
        }
        holder.txtNews.setText(news.get(position).getNewsTitle());
        final ViewGroup row = (ViewGroup) holder.txtNews.getParent();
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nc.setNews(news.get(position));
                marker.add(position, true);
//                set initial coloring
                row.setBackgroundColor(Color.YELLOW);
            }
        });
        if (marker.get(position)){
//            persist color
            row.setBackgroundColor(Color.YELLOW);
        }
        else {
//            if not selected remove color
            if (position%2==0)
                row.setBackgroundColor(Color.parseColor("#aaaaaa"));
            else
                row.setBackgroundColor(Color.parseColor("#cccccc"));
        }
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    class CustomVH extends RecyclerView.ViewHolder {
        TextView txtNews;

        public CustomVH(View itemView) {
            super(itemView);
            this.txtNews = (TextView) itemView.findViewById(R.id.txt_news);
        }
    }
}
