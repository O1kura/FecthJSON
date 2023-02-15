package com.example.internetjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    List<PersonInfo> listOfInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfInfo = new ArrayList<>();
        DataAdapter adapter = new DataAdapter(listOfInfo,this);

        RecyclerView recyclerView = findViewById(R.id.main_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        new DownloadTask().execute();
    }

    @Override
    public void OnItemClick(int position) {
        Intent i = new Intent(context,DataAdapter.class);
        PersonInfo personInfo = listOfInfo.get(position);
        i.putExtra("name",personInfo.getName());
        context.startActivity(i);
    }

    class DownloadTask extends AsyncTask<Void, Integer, Boolean> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Downloading");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                URL url = new URL("https://lebavui.github.io/jsons/users.json");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                int responseCode = conn.getResponseCode();
                Log.v("TAG", "response code: " + responseCode);

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response =new StringBuilder();
                while((inputLine=in.readLine())!=null)
                {
                    response.append(inputLine);
                }

                in.close();
//                JSONArray jsonArray = new JSONArray(response.toString());
                Log.v("TAG", response.toString());

                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            Log.v("TAG", "Download failed");
            return false;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            dialog.setProgress(values[0]);
            dialog.setMax(values[1]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            dialog.dismiss();
        }
    }
}