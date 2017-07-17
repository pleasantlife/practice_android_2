package com.kimjinhwan.android.android30;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button, stream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //람다에서는
        //1. 객체 안에 함수가 하나여야 한다.
        //2. 함수의 파라미터 수는 상관없다.
        //3. 람다식으로 사용하는 원본 인터페이스가 껍데기만 존재한다.
        // ->객체를 코드형태로 바꿔 쓰겠다. (코드를 짧게 쓰기 위해서, RX에서 쓰기 위해서)
        String objectArray[] = { "A", "B" , "C", "DX123", "E", "F", "G", "H", "I", "J", "K"};
        button.setOnClickListener( (view) -> { view -> printOneWord(objectArray); } );
        LambdaFunction arg = p -> p * p;
        calc(arg);


        Stream<String> data =  Arrays.stream(objectArray);

        stream.setOnClickListener(view -> printStream());

        IntStream strm = IntStream.rangeClosed(1, 100000);

        strm.forEach()





    }

    public void calc(LambdaFunction param){
        int result = param.squareParameter(7);
        System.out.println("결과 : " + result);
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
    }



    private void printOneWord(String arr[]) {
        for (String item : arr) {
            if (item.length() == 1) {
                System.out.println(item);
            }
        }
    }


    private void printStream(){
        data
            .flter(item -> item.length() == 1)
                .forEach( item -> System.out.println(item) );
    }
}
