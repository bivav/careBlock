package com.careblock;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import java.util.ArrayList;

import android.widget.Toast;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple5;

import android.support.design.widget.FloatingActionButton;


public class UserRecords extends AppCompatActivity {

    private static String TAG = "UserRecords";

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private RecyclerViewAdapter mAdapter;
    String name,id,pass,summary;

    private ArrayList<UserRecordsModel> modelList = new ArrayList<>();

    Web3j web3;
    Web3ClientVersion web3ClientVersion;

    Tuple5<BigInteger, BigInteger, String, String, byte[]> tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_records);

        Intent receivedIntent = getIntent();
        name = receivedIntent.getStringExtra("name");
        id = receivedIntent.getStringExtra("id");
        pass = receivedIntent.getStringExtra("pass");
        summary = receivedIntent.getStringExtra("summary");

        UserRecordsAsyncTask asyncTask = new UserRecordsAsyncTask();
        asyncTask.execute();

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserRecords.this,AddRecordsActivity.class);
                startActivity(intent);
            }
        });

    }

    @SuppressLint("StaticFieldLeak")
    public class UserRecordsAsyncTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            web3 = Web3jFactory.build(new HttpService("http://172.20.10.4:8545"));


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

            Records contract = null;

            // THE ONLY THING THAT MATTERS!!!!
            Credentials credentials = Credentials.create("59c51ad34997b7229d193bf950fc3cdb39e0145a1da5f27f37120187a9b97c69");

            Log.i(TAG, "Second: " + String.valueOf(credentials.getAddress()));


            // Previous Contract
//            contract = Migrations.load("0x327586aF6a14Ee05c6D2E0424a5Bbb3097CE3909",
//                    web3, credentials, new BigInteger("2000000000"), new BigInteger("6721975"));

            try {

                // Creating Contract Instance
                String string = "0x123456";

                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(string.getBytes(StandardCharsets.UTF_8));


                contract = Records.deploy(web3, credentials, new BigInteger("20000000000"),
                        new BigInteger("6721975"), "bivav", string.getBytes(), new BigInteger("1")).send();

                RemoteCall<TransactionReceipt> addRecord = contract.addRecord(new BigInteger("1"), "sick", hash);
                addRecord.send();

                RemoteCall<Tuple5<BigInteger, BigInteger, String, String, byte[]>> remoteCall = contract.Patients(new BigInteger("1"));

                tt =  remoteCall.send();

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Log.i(TAG, String.valueOf(Objects.requireNonNull(contract).getGasPrice()));
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }

            Log.i(TAG, "Owner: " + tt.getValue1() + " " + tt.getValue2() + " " + tt.getValue3() + " " + tt.getValue4());


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            findViews();
            setAdapter();

        }
    }

    private void findViews() {
        recyclerView = findViewById(R.id.recycler_view);
        fab = findViewById(R.id.fab);
    }


    private void setAdapter() {

        modelList.add(new UserRecordsModel("Patient ID: " + String.valueOf(tt.getValue1()), "Doctor ID: "  + String.valueOf(tt.getValue2()), "Name: " + tt.getValue3(), "Summary: "+ tt.getValue4()));
        modelList.add(new UserRecordsModel("Patient ID: " + String.valueOf(tt.getValue1()), "Doctor ID: "  + String.valueOf(tt.getValue2()), "Name: " + tt.getValue3(), "Summary: "+ tt.getValue4()));
        modelList.add(new UserRecordsModel("Patient ID: "+name,"Doctor ID: "+id,"Password: "+ pass,"Summary: "+summary));
//        modelList.add(new UserRecordsModel("Cupcake", "Hello " + " Cupcake"));
//        modelList.add(new UserRecordsModel("Donut", "Hello " + " Donut"));
//        modelList.add(new UserRecordsModel("Eclair", "Hello " + " Eclair"));
//        modelList.add(new UserRecordsModel("Froyo", "Hello " + " Froyo"));
//        modelList.add(new UserRecordsModel("Gingerbread", "Hello " + " Gingerbread"));
//        modelList.add(new UserRecordsModel("Honeycomb", "Hello " + " Honeycomb"));
//        modelList.add(new UserRecordsModel("Ice Cream Sandwich", "Hello " + " Ice Cream Sandwich"));

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
