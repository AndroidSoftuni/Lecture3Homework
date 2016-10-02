package homework.softuni.lecture3homework;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentTransaction;

import homework.softuni.lecture3homework.entities.BlizzardGame;
import homework.softuni.lecture3homework.communicator.GameCommunicator;

public class TaskTwoActivity extends AppCompatActivity implements GameCommunicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_two);

        ButtonsFragment buttonsFragment = new ButtonsFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container,buttonsFragment);
        ft.commit();

    }

    @Override
    public void setGame(BlizzardGame blizzardGame) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("game",blizzardGame);

        DetailedGameFragment dgf = new DetailedGameFragment();
        dgf.setArguments(bundle);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container,dgf).addToBackStack(null);
        ft.commit();
    }
}
