package homework.softuni.lecture3homework;


import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;

import homework.softuni.lecture3homework.entities.News;

public class DetailedNewsFragment extends Fragment {

    TextView txtNewsTitle;
    TextView txtNewsContent;
    TextView txtNewsSubtitle;

    public DetailedNewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detailed_news, container, false);

        txtNewsTitle    = (TextView) v.findViewById(R.id.txt_news_title);
        txtNewsContent  = (TextView) v.findViewById(R.id.news_content);
        txtNewsSubtitle = (TextView) v.findViewById(R.id.news_subtitle);

        if (getArguments()!=null) {
            News news = (News) getArguments().getSerializable("news");

            txtNewsTitle.setText(news.getNewsTitle());
            txtNewsSubtitle.setText(news.getNewsSubtitle());
            txtNewsContent.setText(news.getNewsContent());
        }
        return v;
    }
}
