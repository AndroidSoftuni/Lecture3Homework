package homework.softuni.lecture3homework;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import homework.softuni.lecture3homework.entities.News;
import homework.softuni.lecture3homework.communicator.NewsCommunicator;

public class TaskOneActivity extends AppCompatActivity implements NewsCommunicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_one);

        findViewById(R.id.btn_go_to_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TaskOneActivity.this,TaskTwoActivity.class);
                startActivity(i);
            }
        });

        loadFragment(new ListNewsFragment(),R.id.news_list_container);
        loadFragment(new DetailedNewsFragment(),R.id.news_details_container);
    }

    private void loadFragment(Fragment fragment, int container){
        FragmentManager     fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(container,fragment);
        ft.commit();
    }

    @Override
    public void setNews(News news) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("news",news);

        DetailedNewsFragment dnf = new DetailedNewsFragment();
        dnf.setArguments(bundle);

        loadFragment(dnf,R.id.news_details_container);
    }
}
