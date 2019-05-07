package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class AddDailyGrade extends AppCompatActivity {

    TextView tvWeek;
    RadioGroup rgGrade;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_daily_grade);

        Intent i = getIntent();


        tvWeek = findViewById(R.id.textViewWeek);
        btnSubmit = findViewById(R.id.buttonSubmit);
        rgGrade = findViewById(R.id.rgGrade);

        final int weekNo = i.getIntExtra("weekNo", 0);
        tvWeek.setText("week " + weekNo);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = rgGrade.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);
                String grade = rb.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("grade", grade);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
