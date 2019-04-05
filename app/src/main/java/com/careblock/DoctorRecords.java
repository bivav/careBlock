package com.careblock;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;

public class DoctorRecords extends AppCompatActivity {

        private static String TAG = "UserRecords";

        private RecyclerView recyclerView;
        private FloatingActionButton fab;
        private RecyclerViewAdapter mAdapter;

        private ArrayList<UserRecordsModel> modelList = new ArrayList<>();

        Web3j web3;
        Web3ClientVersion web3ClientVersion;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_doctor_records);

            findViews();
            setAdapter();

            com.careblock.DoctorRecords.DoctorRecordsAsyncTask asyncTask = new com.careblock.DoctorRecords.DoctorRecordsAsyncTask();
            asyncTask.execute();

            fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.careblock.DoctorRecords.this,AddDoctorRecords.class);
                    startActivity(intent);
                }
            });

        }

        @SuppressLint("StaticFieldLeak")
        public class DoctorRecordsAsyncTask extends AsyncTask<Void,Void,Void> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                web3 = Web3jFactory.build(new HttpService("http://192.168.137.207:8545"));

            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    web3ClientVersion = web3.web3ClientVersion().send();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                String clientVersion = web3ClientVersion.getWeb3ClientVersion();

                Log.i(TAG,"First: " +  String.valueOf(clientVersion));

                Migrations contract = null;

                // THE ONLY THING THAT MATTERS!!!!
                Credentials credentials = Credentials.create("8bd6d7380d883b46c779ba051ec25498b6a0bbed79c728329fc2da8d6b69dffb");

                Log.i(TAG, "Second: " + String.valueOf(credentials.getAddress()));


                // Previous Contract
//            contract = Migrations.load("0xb953082A7df1F45fFe40367E8f0BE6A1272526D7",
//                    web3, credentials, new BigInteger("2000000000"), new BigInteger("6721975"));

                try {

                    // Creating Contract Instance
                    contract = Migrations.deploy(web3, credentials, new BigInteger("20000000000"),
                            new BigInteger("6721975")).send();

                    String test = contract.owner().send();

                    Log.i(TAG, "Owner" + test);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    Log.i(TAG, String.valueOf(Objects.requireNonNull(contract).getGasPrice()));
                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }

        private void findViews() {
            recyclerView = findViewById(R.id.recycler_view);
            fab = findViewById(R.id.fab);
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

            mAdapter = new RecyclerViewAdapter(com.careblock.DoctorRecords.this, modelList);

            recyclerView.setHasFixedSize(true);

            // use a linear layout manager
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(mAdapter);

            mAdapter.SetOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position, UserRecordsModel model) {
                    //handle item click events here
                    Toast.makeText(com.careblock.DoctorRecords.this, "Hey " + model.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });

        }

}
