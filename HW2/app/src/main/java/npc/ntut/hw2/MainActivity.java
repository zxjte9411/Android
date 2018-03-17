package npc.ntut.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSex, mEdtAge;
    Button mBtnOK;
    TextView mTxtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSex = (EditText) findViewById(R.id.edtSex);
        mEdtAge = (EditText) findViewById(R.id.edtAge);
        mBtnOK = (Button) findViewById(R.id.btnOK);
        mTxtR = (TextView) findViewById(R.id.txtR);

        mBtnOK.setOnClickListener(mBtnOKOnClick);
    }

    private View.OnClickListener mBtnOKOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            try {
                String strSex = mEdtSex.getText().toString();
                int iAge = Integer.parseInt(mEdtAge.getText().toString());

                String strSug = getString(R.string.suggestion);
                if (strSex.equals(getString(R.string.suggestion)))
                    if (iAge > 35 )
                        strSug += getString(R.string.sug_find_couple);
                    else if (iAge >= 30 && iAge <= 35)
                        strSug += getString(R.string.sug_get_married);
                    else
                        strSug += getString(R.string.sug_not_hurry);
                else
                if (iAge > 32 )
                    strSug += getString(R.string.sug_find_couple);
                else if (iAge >= 28 && iAge <= 32)
                    strSug += getString(R.string.sug_get_married);
                else
                    strSug += getString(R.string.sug_not_hurry);
                //設定建議
                mTxtR.setText(strSug);
            }
            catch (Exception e){
                mTxtR.setText(getString(R.string.error_message));
            }
        }
    };
}
