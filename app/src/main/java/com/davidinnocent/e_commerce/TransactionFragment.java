package com.davidinnocent.e_commerce;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Toast;

import com.davidinnocent.e_commerce.model.Transaction;
import com.davidinnocent.e_commerce.util.TransactionAdapter;
import com.labo.kaji.fragmentanimations.MoveAnimation;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class TransactionFragment extends Fragment {


    private LinearLayoutManager linearLayout;
    private RecyclerView transaction_recycler;
    private LineChartView chartView;
    public TransactionFragment() {
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
        return inflater.inflate(R.layout.fragment_transaction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        transaction_recycler =view.findViewById(R.id.out_of_stock);

        chartView=view.findViewById(R.id.chart);

        chartView.setInteractive(true);
        chartView.setZoomType(ZoomType.HORIZONTAL_AND_VERTICAL);
        chartView.setZoomEnabled(true);
        chartView.setOnValueTouchListener(new LineChartOnValueSelectListener() {
            @Override
            public void onValueSelected(int i, int i1, PointValue pointValue) {
                Toast.makeText(getContext(), "You pressed"+pointValue.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onValueDeselected() {

            }
        });

        List<PointValue> values = new ArrayList<PointValue>();


        values.add(new PointValue(0,10));
        values.add(new PointValue(1, 4));
        values.add(new PointValue(2, 9));
        values.add(new PointValue(3, 8));
        values.add(new PointValue(4,7));
        values.add(new PointValue(5, 10));
        values.add(new PointValue(6, 11));
        values.add(new PointValue(7, 7));
        values.add(new PointValue(8, 9));
        values.add(new PointValue(9, 8));
        values.add(new PointValue(10,7));
        values.add(new PointValue(11, 10));
        values.add(new PointValue(12, 11));

        //In most cased you can call data model methods in builder-pattern-like manner.
        Line line = new Line(values).setColor(ContextCompat.getColor(getContext(),R.color.colorMaroon)).setCubic(true);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        chartView.setLineChartData(data);


        linearLayout= new LinearLayoutManager(getContext());
        linearLayout.setOrientation(RecyclerView.VERTICAL);

        List<Transaction> items_list=new ArrayList<>();


        Transaction product1=new Transaction();
        product1.setTransaction_bank("City Bank Ltd");
        product1.setTransaction_description("Transfer to bank -Completed");
        product1.setTransaction_amount("-Ksh 500.00");
        product1.setTransaction_date("Mar 03");
        product1.setTransaction_image(ContextCompat.getDrawable(getContext(),R.drawable.ic_publish_24px));

        Transaction product2=new Transaction();
        product2.setTransaction_bank("Payment From Sam");
        product2.setTransaction_description("Transfer to bank -Completed");
        product2.setTransaction_amount("+Ksh 500.00");
        product2.setTransaction_date("Mar 03");
        product2.setTransaction_image(ContextCompat.getDrawable(getContext(),R.drawable.ic_publish_24px));

        Transaction product3=new Transaction();
        product3.setTransaction_bank("Invoice from Obare");
        product3.setTransaction_amount("+Ksh 1500.00");
        product3.setTransaction_date("Mar 03");
        product3.setTransaction_description("Transfer to bank -Completed");
        product3.setTransaction_image(ContextCompat.getDrawable(getContext(),R.drawable.ic_get_app_24px));


        items_list.add(product1);
        items_list.add(product2);
        items_list.add(product3);



        TransactionAdapter transactionAdapter=new TransactionAdapter(getContext(),items_list);
        transaction_recycler.setLayoutManager(linearLayout);
        transaction_recycler.setAdapter(transactionAdapter);
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