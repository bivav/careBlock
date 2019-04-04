package com.careblock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;


import android.widget.Toast;
import android.os.Handler;


import android.support.design.widget.FloatingActionButton;


public class UserRecords extends AppCompatActivity {

    private RecyclerView recyclerView;

    // @BindView(R.id.recycler_view)
    // RecyclerView recyclerView;


    //@BindView(R.id.fab)
    //FloatingActionButton fab;
    private FloatingActionButton fab;
    private RecyclerViewAdapter mAdapter;

    private ArrayList<UserRecordsModel> modelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_records);

        // ButterKnife.bind(this);
        findViews();
        setAdapter();


    }

    private void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        ;
    }


    private void setAdapter() {


        modelList.add(new UserRecordsModel("Android", "Hello " + " Android"));
        modelList.add(new UserRecordsModel("Beta", "Hello " + " Beta"));
        modelList.add(new UserRecordsModel("Cupcake", "Hello " + " Cupcake"));
        modelList.add(new UserRecordsModel("Donut", "Hello " + " Donut"));
        modelList.add(new UserRecordsModel("Eclair", "Hello " + " Eclair"));
        modelList.add(new UserRecordsModel("Froyo", "Hello " + " Froyo"));
        modelList.add(new UserRecordsModel("Gingerbread", "Hello " + " Gingerbread"));
        modelList.add(new UserRecordsModel("Honeycomb", "Hello " + " Honeycomb"));
        modelList.add(new UserRecordsModel("Ice Cream Sandwich", "Hello " + " Ice Cream Sandwich"));
        modelList.add(new UserRecordsModel("Jelly Bean", "Hello " + " Jelly Bean"));
        modelList.add(new UserRecordsModel("KitKat", "Hello " + " KitKat"));
        modelList.add(new UserRecordsModel("Lollipop", "Hello " + " Lollipop"));
        modelList.add(new UserRecordsModel("Marshmallow", "Hello " + " Marshmallow"));
        modelList.add(new UserRecordsModel("Nougat", "Hello " + " Nougat"));
        modelList.add(new UserRecordsModel("Android O", "Hello " + " Android O"));


        mAdapter = new RecyclerViewAdapter(UserRecords.this, modelList);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(mAdapter);


        mAdapter.SetOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, UserRecordsModel model) {

                //handle item click events here
                Toast.makeText(UserRecords.this, "Hey " + model.getTitle(), Toast.LENGTH_SHORT).show();


            }
        });


    }


}
