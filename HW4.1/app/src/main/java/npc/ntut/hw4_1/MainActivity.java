package npc.ntut.hw4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //宣告變數
    private Spinner mSpnAge;
    private RadioGroup mRadGrp;
    private RadioButton mMale;
    private RadioButton mFemale;
    private RadioButton mRadBtnAgeRange3;
    private Button mBtnOk;
    private TextView mTxtSug;
    private String selectedSex;
    private ArrayAdapter<CharSequence> arrAdapSpnMaleAge;
    private ArrayAdapter<CharSequence> arrAdapSpnFemaleAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      //預設會跑出來的東西
        setContentView(R.layout.activity_main);     //預設會跑出來的東西
        //為變數指定ID
        mSpnAge = (Spinner) findViewById(R.id.spnAge);
        arrAdapSpnMaleAge = ArrayAdapter.createFromResource(MainActivity.this, R.array.maleAgeRange,R.layout.support_simple_spinner_dropdown_item);//設定下拉選單內容
        arrAdapSpnFemaleAge = ArrayAdapter.createFromResource(MainActivity.this, R.array.femaleAgeRange,R.layout.support_simple_spinner_dropdown_item);
        mSpnAge.setAdapter(arrAdapSpnMaleAge);//預設下拉選單
        mRadGrp = (RadioGroup) findViewById(R.id.radGrpAge);
        mMale = (RadioButton) findViewById(R.id.male);
        mFemale = (RadioButton) findViewById(R.id.female);
        mBtnOk = (Button) findViewById(R.id.btnOk);
        mTxtSug = (TextView) findViewById(R.id.txtSug);
        //設置監聽
        mBtnOk.setOnClickListener(btnOKOnClick);
        mRadGrp.setOnCheckedChangeListener(radioOnClick);
    }

    private RadioGroup.OnCheckedChangeListener radioOnClick = new RadioGroup.OnCheckedChangeListener() {//以所選的 RadioButton 來改變 Spinner 的內容
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Log.v("waaa", String.valueOf(checkedId));
            switch (checkedId){
                case R.id.male:
                    mSpnAge.setAdapter(arrAdapSpnMaleAge);
                    break;
                case R.id.female:
                    mSpnAge.setAdapter(arrAdapSpnFemaleAge);
                    break;
            }
        }
    };

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MarriageSuggestion objms = new MarriageSuggestion();

            String strSex = mSpnAge.getSelectedItem().toString();
            //mSpnAge.setAdapter(arrAdapSpnMaleAge);
            int iAgeRange = 0;

            switch(mRadGrp.getCheckedRadioButtonId()){
                case R.id.male:
                    iAgeRange = 1;
                    break;
                case R.id.female:

                    iAgeRange = 2;
                    break;
            }
            mTxtSug.setText(objms.getSuggestion(strSex,iAgeRange));
        }
    };
}
