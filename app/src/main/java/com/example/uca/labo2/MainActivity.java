package com.example.uca.labo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView fstTxtView, sndTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void changeText(View v){
        String aux;
        fstTxtView=findViewById(R.id.text_helloworld);
        sndTxtView=findViewById(R.id.text_hola);
        aux=fstTxtView.getText().toString();
        fstTxtView.setText(sndTxtView.getText());
        sndTxtView.setText(aux);
    }
}
