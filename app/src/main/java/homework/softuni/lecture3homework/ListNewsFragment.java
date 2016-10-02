package homework.softuni.lecture3homework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import homework.softuni.lecture3homework.entities.News;
import homework.softuni.lecture3homework.adapters.NewsAdapter;
import homework.softuni.lecture3homework.dialogs.LegendDialog;
import homework.softuni.lecture3homework.communicator.NewsCommunicator;

public class ListNewsFragment extends Fragment {

    private NewsCommunicator nc;

    public ListNewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        nc = (NewsCommunicator) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_news, container, false);

        ArrayList<News> newsList = new ArrayList<>();
        newsList.add(new News("BOMB!", "new type of bomb", "lorem ipsum dolor"));
        newsList.add(new News("Zombies!", "are they real", "New virus is spreading ....."));
        newsList.add(new News("Android!", "is it better", "New studies turn the tables ..."));

        for (int i = 0; i < 100; i++) {
            newsList.add(new News("Title" + i, "Subtitle" + i, "Content" + i));
        }

        Button btnLegend = (Button) view.findViewById(R.id.btn_legend);
        btnLegend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LegendDialog(getContext()).show();
            }
        });

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.news_rec_view);

        NewsAdapter newsAdapter = new NewsAdapter(getActivity(), newsList, nc);

        LinearLayoutManager linLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linLayoutManager);
        recyclerView.setAdapter(newsAdapter);

        return view;
    }
}
