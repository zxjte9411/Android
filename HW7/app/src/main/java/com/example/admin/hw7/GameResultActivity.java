package com.example.admin.hw7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GameResultActivity extends AppCompatActivity {

    // 宣告有哪些元件
    private Button btnReturn;
    private EditText edtCountSet, edtCountPlayerWin, edtCountComWin, edtCountDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);
        // 幫元件找ID
        btnReturn = (Button) findViewById(R.id.butReturn);
        btnReturn.setOnClickListener(btnOnReturn);
        edtCountSet = (EditText) findViewById(R.id.edtCountSet);
        edtCountPlayerWin = (EditText) findViewById(R.id.edtCountPlayerWin);
        edtCountComWin = (EditText) findViewById(R.id.edtCountComWin);
        edtCountDraw = (EditText) findViewById(R.id.edtCountDraw);
        // 本次作業重點  先接收MainActivity傳過來的 Intent， 再存入 Bundle，再依傳過來的 Key 尋找對應的 Data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            edtCountSet.setText(String.valueOf(bundle.getInt("miCountSet")));
            edtCountPlayerWin.setText(String.valueOf(bundle.getInt("miCountPlayerWin")));
            edtCountComWin.setText(String.valueOf(bundle.getInt("miCountComWin")));
            edtCountDraw.setText(String.valueOf(bundle.getInt("miCountDraw")));
        } else {
            Toast.makeText(this, "資料不能為空！", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private View.OnClickListener btnOnReturn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //返回
            finish();
        }
    };
}
