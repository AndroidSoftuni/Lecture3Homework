package homework.softuni.lecture3homework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup;
import android.content.Context;
import android.animation.Animator;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.animation.AnimatorSet;
import android.support.v4.app.Fragment;
import android.animation.ObjectAnimator;
import android.support.v7.widget.LinearLayoutCompat;

import java.util.ArrayList;

import homework.softuni.lecture3homework.entities.BlizzardGame;
import homework.softuni.lecture3homework.communicator.GameCommunicator;

public class ButtonsFragment extends Fragment {

    private GameCommunicator gameCommunicator;

    private ArrayList<BlizzardGame> blizzardGames;

    public ButtonsFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        gameCommunicator = (GameCommunicator) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_buttons, container, false);

        blizzardGames = new ArrayList<>();
        blizzardGames.add(new BlizzardGame("Starcraft", 1998, "RTS"));
        blizzardGames.add(new BlizzardGame("Heroes of the Storm", 2015, "MOBA"));
        blizzardGames.add(new BlizzardGame("Overwatch", 2016, "FPS"));

//        dynamically add buttons
        for (int j = 0; j < blizzardGames.size(); j++) {
            final Button btnGame = new Button(getContext());
            btnGame.setLayoutParams(new LinearLayoutCompat.LayoutParams(
                    LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                    LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                    LinearLayoutCompat.VERTICAL));
            btnGame.setText(blizzardGames.get(j).getTitle());
            btnGame.setId(j);
            ((LinearLayout) root.findViewById(R.id.buttons_fragment_container)).addView(btnGame);
            final int finalJ = j;
            btnGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animateDiagonalPan(view,finalJ);
                }
            });
        }
        return root;
    }

    /**
     * Translate view diagonally from initial position to top center
     * @param v view to be translated
     * @param counter number of element in array
     */
    private void animateDiagonalPan(View v, final int counter) {
//        Get display size
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);

        AnimatorSet animSetXY = new AnimatorSet();
//       translate to top of the screen
        ObjectAnimator y = ObjectAnimator.ofFloat(v,
                "translationY",0, - v.getY() );

//        translate to horizontal center
        ObjectAnimator x = ObjectAnimator.ofFloat(v,
                "translationX", v.getX(), metrics.widthPixels/2-v.getWidth()/2);

        animSetXY.playTogether(x, y);
        animSetXY.setDuration(300);
        animSetXY.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                gameCommunicator.setGame(blizzardGames.get(counter));
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animSetXY.start();
    }
}
