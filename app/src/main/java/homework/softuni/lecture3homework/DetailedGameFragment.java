package homework.softuni.lecture3homework;

import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;

import homework.softuni.lecture3homework.entities.BlizzardGame;

public class DetailedGameFragment extends Fragment {


    public DetailedGameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detailed_game, container, false);

        Button gameTitle         = (Button)   root.findViewById(R.id.detailed_game_title);
        TextView gameType        = (TextView) root.findViewById(R.id.detailed_game_type);
        TextView gameReleaseYear = (TextView) root.findViewById(R.id.detailed_game_release);

        BlizzardGame game = (BlizzardGame) getArguments().getSerializable("game");

        if (game!=null) {
            gameTitle.setText(game.getTitle());
            gameReleaseYear.append(String.valueOf(game.getYearOfRelease()));
            gameType.append(game.getType());
        }
        return root;
    }
}
