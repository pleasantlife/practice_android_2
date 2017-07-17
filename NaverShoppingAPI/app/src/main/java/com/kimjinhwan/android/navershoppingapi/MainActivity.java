package com.kimjinhwan.android.navershoppingapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;

    String search ="";

    static final String CLIENT_ID = "ejIxQy97fRYxlx8ODSL6";
    static final String CLIENT_SECRET = "UyIR_w9UEb";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        search = editText.toString();
        naverAPI(search);
    }

    public static void naverAPI(String inputText){
        new AsyncTask<String, Void, Void>(){

            @Override
            protected Void doInBackground(String... params) {
                inputText = getData(params[0]);
                return null;
            }
        }
        String clientId = CLIENT_ID;//애플리케이션 클라이언트 아이디값";
        String clientSecret = CLIENT_SECRET;//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(inputText, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            textView.setText(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
