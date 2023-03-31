package com.neebal.bmicrash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtWeight , edtHeightF ,edtHeightI ;

        final TextView txtView;

        Button btn ;
        final LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightF = findViewById(R.id.edtHeightF);
        edtHeightI = findViewById(R.id.edtHeightI);

        txtView = findViewById(R.id.txtView);
        btn = findViewById(R.id.btn);

        llMain = findViewById(R.id.background);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // throw new RuntimeException("Test Crash");

                int wt = Integer.parseInt(edtWeight.getText().toString());
                int hF = Integer.parseInt(edtHeightF.getText().toString());
                int hI = Integer.parseInt(edtHeightI.getText().toString());

                int totalHeightI = hF*12 + hI;

                double tCm = totalHeightI *2.53;

                double totalM = tCm /100;

                double bmi = wt/(totalM*totalM);

                if(bmi >25){
                    txtView.setText("You are Over Weight ");
                    llMain.setBackgroundColor(getResources().getColor(R.color.redOwer));
                }else if(bmi<18){
                    txtView.setText("you are under wight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.yellowUnder));
                }else{
                    txtView.setText("You,re Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.greenH));
                }


            }
        });
    }
}