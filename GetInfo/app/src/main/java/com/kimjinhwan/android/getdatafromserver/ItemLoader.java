package com.kimjinhwan.android.getdatafromserver;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by XPS on 2017-06-26.
 */

public class ItemLoader {

    public void getData(String url, final CallBack callBack) {
        new AsyncTask<String, Void, List<Item>>() {

            @Override
            protected List<Item> doInBackground(String... params) {
                String url = params[0];
                String result = getDataFromUrl(url);
                Log.e("result =", result);

                Gson gson = new Gson();
                Data data = gson.fromJson(result, Data.class);

                return data.bbsList;
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


    public String getDataFromUrl(String url){
        StringBuilder result = new StringBuilder();
        try {
            Log.e("URL", "" + url);
            //1. 요청처리
            URL serverUrl = new URL(url);
            HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();
            //OutputStream으로 데이터를 요청
            con.setRequestMethod("GET");

            //2. 응답처리
            //응답의 유효성 검사
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String temp = "";
                while ((temp = br.readLine()) != null) {
                    Log.e("temp", temp);
                    result.append(temp + "\n");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();


    }
}
