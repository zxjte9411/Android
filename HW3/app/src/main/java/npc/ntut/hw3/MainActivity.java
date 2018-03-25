package npc.ntut.hw3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //宣告變數
    private Spinner mSpnSex;
    private RadioGroup mRadGrp;
    private RadioButton mRadBtnAgeRange1;
    private RadioButton mRadBtnAgeRange2;
    private RadioButton mRadBtnAgeRange3;
    private TextView mTxtNumFamily;
    private NumberPicker mNumPkrFamily;
    private Button mBtnOk;
    private TextView mTxtSug;
    private String selectedSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      //預設會跑出來的東西
        setContentView(R.layout.activity_main);     //預設會跑出來的東西
        //為變數指定ID
        mSpnSex = (Spinner) findViewById(R.id.spnSex);
        mRadGrp = (RadioGroup) findViewById(R.id.radGrpAge);
        mRadBtnAgeRange1 = (RadioButton) findViewById(R.id.radBtnAgeRange1);
        mRadBtnAgeRange2 = (RadioButton) findViewById(R.id.radBtnAgeRange2);
        mRadBtnAgeRange3 = (RadioButton) findViewById(R.id.radBtnAgeRange3);
        mTxtNumFamily = (TextView)  findViewById(R.id.txtNumFamily);
        mNumPkrFamily = (NumberPicker) findViewById(R.id.numPkrFamily);
        mNumPkrFamily.setMinValue(0);
        mNumPkrFamily.setMaxValue(20);
        mNumPkrFamily.setValue(0);
        mBtnOk = (Button) findViewById(R.id.btnOk);
        mTxtSug = (TextView) findViewById(R.id.txtSug);
        //設置監聽
        mSpnSex.setOnItemSelectedListener(spnOnItemSelect);
        mNumPkrFamily.setOnValueChangedListener(numPkrFamilyOnValueChange);
        mBtnOk.setOnClickListener(btnOKOnClick);
    }

    private AdapterView.OnItemSelectedListener spnOnItemSelect = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selectedSex = parent.getSelectedItem().toString();//取得選到的年齡範圍並轉成字串

            switch(selectedSex){//以所選的性別去變更 RadioButton 顯示的年齡範圍
                case "male":
                    mRadBtnAgeRange1.setText(getString(R.string.maleAgeRange1));
                    mRadBtnAgeRange2.setText(getString(R.string.maleAgeRange2));
                    mRadBtnAgeRange3.setText(getString(R.string.maleAgeRange3));
                    break;
                case "female":
                    mRadBtnAgeRange1.setText(getString(R.string.femaleAgeRange1));
                    mRadBtnAgeRange2.setText(getString(R.string.femaleAgeRange2));
                    mRadBtnAgeRange3.setText(getString(R.string.femaleAgeRange3));
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    public NumberPicker.OnValueChangeListener numPkrFamilyOnValueChange = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
           mTxtNumFamily.setText(String.valueOf(newVal));

        }

    };
    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MarriageSuggestion objms = new MarriageSuggestion();

            String strSex = mSpnSex.getSelectedItem().toString();
            int iAgeRange = 0;

            switch(mRadGrp.getCheckedRadioButtonId()){
                case R.id.radBtnAgeRange1:
                    iAgeRange = 1;
                    break;
                case R.id.radBtnAgeRange2:
                    iAgeRange = 2;
                    break;
                case R.id.radBtnAgeRange3:
                    iAgeRange =3;
                    break;
            }
            mTxtSug.setText(objms.getSuggestion(strSex,iAgeRange,mNumPkrFamily.getValue()));
        }
    };
}
