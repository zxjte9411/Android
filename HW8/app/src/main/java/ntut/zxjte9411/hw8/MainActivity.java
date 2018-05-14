package ntut.zxjte9411.hw8;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<CharSequence> arrayAdapter;
    private Spinner spinnerItem;
    private DatePicker datePicker;
    private CalendarView calendarView;
    private EditText editDate, editCost;
    private Button btnInput, btnRecord;
    private Intent intent;
    private ArrayList<String> data;
    private int counts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerItem = (Spinner) findViewById(R.id.spinnerItem);
        datePicker = (DatePicker) findViewById(R.id.DatePicker);
        calendarView = (CalendarView) findViewById(R.id.CalendarView);
        editDate = (EditText) findViewById(R.id.editDate);
        editCost = (EditText) findViewById(R.id.editCost);
        btnInput = (Button) findViewById(R.id.btnInput);
        btnRecord = (Button) findViewById(R.id.btnRecord);

        btnInput.setOnClickListener(onBtnClick);
        btnRecord.setOnClickListener(onBtnClick);
        datePicker.setOnDateChangedListener(onDpkchange);
        calendarView.setOnDateChangeListener(onDateChangeListener);

        arrayAdapter = ArrayAdapter.createFromResource(this,R.array.item,android.R.layout.simple_spinner_dropdown_item);
        spinnerItem.setAdapter(arrayAdapter);
        String result = String.valueOf(datePicker.getYear()) + "/"  + String.valueOf(datePicker.getMonth() + 1) + "/" + String.valueOf(datePicker.getDayOfMonth());
        editDate.setText(result);
        data = new ArrayList();
        counts = 0;
        intent = new Intent();
        intent.setClass(MainActivity.this,RecordActivity.class);

    }

    public View.OnClickListener onBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btnInput){
                if(editCost.length() == 0){
                    Toast.makeText(MainActivity.this, "金額不能為空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String cost = editCost.getText().toString();
                String item = spinnerItem.getSelectedItem().toString();
                String date = editDate.getText().toString();

                String result = "項目" + String.valueOf(counts++) + "  " + date + "  " +item + "  " + cost;
                data.add(result);
                Toast.makeText(MainActivity.this, cost, Toast.LENGTH_SHORT).show();
            }
            else if (v.getId() == R.id.btnRecord){
                intent.putStringArrayListExtra("data",data);
                startActivity(intent);
            }
        }
    };

    public DatePicker.OnDateChangedListener onDpkchange = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String result = String.valueOf(year) + "/"  + String.valueOf(monthOfYear + 1) + "/" + String.valueOf(dayOfMonth);
            Calendar calendar = Calendar.getInstance();
            calendar.set(year,monthOfYear,dayOfMonth);
            calendarView.setDate(calendar.getTimeInMillis());
            editDate.setText(result);
        }
    };

    public CalendarView.OnDateChangeListener onDateChangeListener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            String result = String.valueOf(year) + "/"  + String.valueOf(month + 1) + "/" + String.valueOf(dayOfMonth);
            editDate.setText(result);
            datePicker.updateDate(year,month,dayOfMonth);
        }
    };

}
