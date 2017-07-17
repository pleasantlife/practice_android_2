package com.kimjinhwan.android.getjson;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XPS on 2017-06-26.
 */

public class ItemLoader {

    //서버에서 데이터를 가져오기 위해 AsyncTask 실행.



    public void getData(String url, final CallBack callBack) {
        new AsyncTask<String, Void, List<Item>>(){



            @Override
            protected List<Item> doInBackground(String... params) {
                String url = params[0];
                String result = dataFromUrl(url);

                Gson gson = new Gson();
                Bridge bridge = gson.fromJson(result, Bridge.class);
                return bridge.itemList;

            }

                @Override
                protected void onPostExecute(List<Item> items) {
                    callBack.setData(items);
                }
        }.execute(url);
    }

    public interface CallBack {
        public void setData(List<Item> items);
    }

    public String dataFromUrl(String url){
        StringBuilder result = new StringBuilder();
        try{
            Log.e("URL","" + url);

            URL serverUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String temp = "";
                while( (temp = br.readLine()) != null) {
                    result.append(temp + "\n");
                }
            }


        } catch (Exception e) {
           e.printStackTrace();
        }
        return result.toString();
    }

}
