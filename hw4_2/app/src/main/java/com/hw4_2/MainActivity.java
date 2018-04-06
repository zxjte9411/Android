package com.hw4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtComPlay, mTxtResult;
    private Button mBtnScissors, mBtnStone, mBtnPaper;
    private ArrayList<String> resources = new ArrayList<>();
    MoraHandler mh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtComPlay = (TextView) findViewById(R.id.txtComPlay);
        mTxtResult = (TextView) findViewById(R.id.txtResult);
        mBtnScissors = (Button) findViewById(R.id.btnScissors);
        mBtnStone = (Button) findViewById(R.id.btnStone);
        mBtnPaper = (Button) findViewById(R.id.btnPaper);

        resources.add(getString(R.string.play_scissors));//0
        resources.add(getString(R.string.play_stone));//1
        resources.add(getString(R.string.play_paper));//2

        mBtnScissors.setOnClickListener(btnOnClick);
        mBtnStone.setOnClickListener(btnOnClick);
        mBtnPaper.setOnClickListener(btnOnClick);

        mh = new MoraHandler();
    }

    private View.OnClickListener btnOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3);//0 ~ 2
            int player = 0;
            mTxtComPlay.setText(resources.get(iComPlay));
            switch(v.getId()){
                case R.id.btnScissors:
                    player = 0;
                    break;
                case R.id.btnStone:
                    player = 1;
                    break;
                case R.id.btnPaper:
                    player = 2;
                    break;
            }
            String result = mh.Mora(player,iComPlay);
            // 0 – 剪刀, 1 – 石頭, 2 – 布.
            switch (result){
                case "win":
                    mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
                    break;
                case "lose":
                    mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
                    break;
                case "draw":
                    mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
                    break;
            }
        }
    };
}