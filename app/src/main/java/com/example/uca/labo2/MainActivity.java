package com.example.uca.labo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonPlayer1, buttonPlayer2;
    TextView player1Points, player2Points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlayer1=findViewById(R.id.boton_player1);
        buttonPlayer2=findViewById(R.id.boton_player2);

        player1Points=findViewById(R.id.points_player1);
        player2Points=findViewById(R.id.points_player2);
    }
    public void changePointsPlayer1View(View v){

        try{

            if(Integer.parseInt(player1Points.getText().toString())<40){
                player1Points.setText(changePoints(player1Points.getText().toString())+"");
                if(Integer.parseInt(player1Points.getText().toString())==40 && Integer.parseInt(player2Points.getText().toString())==40){
                    setDeuce();
                }
            }else{
                setWinner(player1Points);
                player2Points.setText("-");
                enableFalse();
            }

        }catch(NumberFormatException e){
            if(player1Points.getText().toString().matches("DEUCE")){
                setAdvantage(player1Points);
                player2Points.setText("-");
            }else if(player1Points.getText().toString().matches("-")){
                setDeuce();
            }else{
                setWinner(player1Points);
                enableFalse();
            }

        }


    }

    public void changePointsPlayer2View(View v){

        try{
            if(Integer.parseInt(player2Points.getText().toString())<40){
                player2Points.setText(changePoints(player2Points.getText().toString())+"");
                if(Integer.parseInt(player2Points.getText().toString())==40 && Integer.parseInt(player1Points.getText().toString())==40){
                    setDeuce();
                }
            }else{
                setWinner(player2Points);
                enableFalse();
            }
        }catch(NumberFormatException e){

            if(player2Points.getText().toString().matches("DEUCE")){
                setAdvantage(player2Points);
                player1Points.setText("-");
            }else if(player2Points.getText().toString().matches("-")){
                setDeuce();
            }
            else{
                setWinner(player2Points);
                enableFalse();
            }

        }


    }

    private int changePoints(String points){
        return Integer.parseInt(points)<=15?Integer.parseInt(points)+15:Integer.parseInt(points)+10;
    }

    private void setDeuce(){
        player1Points.setText(R.string.deuce);
        player2Points.setText(R.string.deuce);
    }

    private void setAdvantage(TextView player){
        player.setText(R.string.advantage);
    }

    public void resetButton(View v){
        player1Points=findViewById(R.id.points_player1);
        player2Points=findViewById(R.id.points_player2);

        player1Points.setText(R.string.points_default);
        player2Points.setText(R.string.points_default);

        enableTrue();
    }

    private void setWinner(TextView player){
        player.setText(R.string.wins);
    }

    private void enableFalse(){
        buttonPlayer1.setEnabled(false);
        buttonPlayer2.setEnabled(false);
    }

    private void enableTrue(){
        buttonPlayer1.setEnabled(true);
        buttonPlayer2.setEnabled(true);
    }


}
