package com.davidinnocent.terrasoft;

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
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.labo.kaji.fragmentanimations.MoveAnimation;

import java.util.ArrayList;
import java.util.List;

public class OverviewFragment extends Fragment {


    private NavController navController;

    public OverviewFragment() {
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
        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.textView13).setBackground(null);
        view.findViewById(R.id.textView14).setBackground(null);

        Button home_button=view.findViewById(R.id.home_button);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.innerHomeFragment);
            }
        });

        final PieChart pieChart=view.findViewById(R.id.piechart);

        pieChart.setUsePercentValues(false);
        Description description=new Description();
        description.setText("");
        description.setTextSize(16.0f);
        pieChart.setDescription(description);

        List<PieEntry> pieEntries=new ArrayList<>();
        pieEntries.add(new PieEntry(1500f,"Money Out"));
        pieEntries.add(new PieEntry(15000f,"Money In"));

        PieDataSet pieDataSet=new PieDataSet(pieEntries,"Business Health");
        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateXY(700,1400);
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
//                double mathRandom=Math.random();
//                if(mathRandom>1000)
//                {
//                    pieChart.animateXY(300,0);
//
//                }
//                else
//                {
//                    pieChart.animateXY(500,300);
//
//                }

            }

            @Override
            public void onNothingSelected() {

            }
        });
    }
    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            return MoveAnimation.create(MoveAnimation.RIGHT, enter, 700);
        } else {
//            return CubeAnimation.create(CubeAnimation.UP, enter, 500);
            return MoveAnimation.create(MoveAnimation.UP, enter, 700);
        }
    }
}