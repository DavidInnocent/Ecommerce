package com.davidinnocent.terrasoft;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;
import java.util.List;

public class OverviewFragment extends Fragment {


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
        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.textView13).setBackground(null);
        view.findViewById(R.id.textView14).setBackground(null);
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
                double mathRandom=Math.random();
                if(mathRandom>1000)
                {
                    pieChart.animateXY(300,300);
                }
                else
                {
                    pieChart.animateXY(500,300);

                }

            }

            @Override
            public void onNothingSelected() {

            }
        });
    }
}