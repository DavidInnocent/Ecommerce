package com.davidinnocent.e_commerce;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;

import com.labo.kaji.fragmentanimations.MoveAnimation;

public class InnerHomeFragment extends Fragment {


    private NavController navController;

    public InnerHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        navController= NavHostFragment.findNavController(this);
        return inflater.inflate(R.layout.fragment_inner_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button home_button=view.findViewById(R.id.home_button);
        Button overview_button=view.findViewById(R.id.overview_button);

        overview_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_innerHomeFragment_to_overviewFragment);
            }
        });
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            return MoveAnimation.create(MoveAnimation.DOWN, enter, 700);
        } else {
//            return CubeAnimation.create(CubeAnimation.UP, enter, 500);
            return MoveAnimation.create(MoveAnimation.DOWN, enter, 700);

        }
    }
}