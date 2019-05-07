package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InfoModule extends AppCompatActivity {

    int requestCodeForC302 = 1;
    int requestCodeForC347  = 2;

    ListView lvInfo;
    ArrayAdapter aaInfo;
    ArrayList<DailyGrade> alDG;

    Button btnInfo, btnAdd, btnEmail;
    private Intent dataIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_module);
        setTitle("Info for " );

        lvInfo = findViewById(R.id.listViewDailyGrade);
        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);

        Intent i = getIntent();
        ModuleStructure selected = (ModuleStructure) i.getSerializableExtra("selected");
        setTitle("Info for " + selected.getModuleCode());
        if (selected.getModuleCode().equals("C302")){
            alDG = new ArrayList<DailyGrade>();
            alDG.add(new DailyGrade("B", "C302",1));
            alDG.add(new DailyGrade("C", "C302",2));
            alDG.add(new DailyGrade("A", "C302",3));

            aaInfo = new DailyGradeAdapter(this,R.layout.rowdg, alDG);
            lvInfo.setAdapter(aaInfo);

            btnInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent to display data
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    // Set the URL to be used.
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C302"));
                    startActivity(rpIntent);
                }
            });

            btnEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // The action you want this intent to do;
                    // ACTION_SEND is used to indicate sending text
                    Intent email = new Intent(Intent.ACTION_SEND);
                    //Put essentials like email address, subject & boyd text
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                    email.putExtra(Intent.EXTRA_SUBJECT, "");
                    String grade = "";
                    for (int i = 0; i < alDG.size(); i ++){
                        grade += "Week " + alDG.get(i).getWeek() + ": DG: " + alDG.get(i).getDailyGrade()+ "\n";
                    }
                    email.putExtra(Intent.EXTRA_TEXT, "Hi faci, \n\nI am... \nPlease see my remarks for C302 so far, thank you!\n" + grade);
                    email.setType("message/rfc822");
                    // createChooser shows user a list of app that can handle
                    // this MIME type, which is, email
                    startActivity(Intent.createChooser(email, "Choose an Email client :"));
                }
            });

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(InfoModule.this, AddDailyGrade.class);
                    int weekNo = alDG.get(alDG.size()-1).getWeek() + 1 ;
                    i.putExtra("weekNo", weekNo);
                    startActivityForResult(i, requestCodeForC302);
                }
            });

        } else {
            alDG = new ArrayList<DailyGrade>();
            alDG.add(new DailyGrade("A", "C347",1));
            alDG.add(new DailyGrade("A", "C347",2));
            alDG.add(new DailyGrade("A", "C347",3));

            aaInfo = new DailyGradeAdapter(this,R.layout.rowdg, alDG);
            lvInfo.setAdapter(aaInfo);

            btnInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent to display data
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    // Set the URL to be used.
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                    startActivity(rpIntent);
                }
            });

            btnEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // The action you want this intent to do;
                    // ACTION_SEND is used to indicate sending text
                    Intent email = new Intent(Intent.ACTION_SEND);
                    //Put essentials like email address, subject & boyd text
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                    email.putExtra(Intent.EXTRA_SUBJECT, "");
                    String grade = "";
                    for (int i = 0; i < alDG.size(); i ++){
                        grade += "Week " + alDG.get(i).getWeek() + ": DG: " + alDG.get(i).getDailyGrade()+ "\n";
                    }
                    email.putExtra(Intent.EXTRA_TEXT, "Hi faci, \n\nI am... \nPlease see my remarks for C347 so far, thank you!\n" + grade);
                    email.setType("message/rfc822");
                    // createChooser shows user a list of app that can handle
                    // this MIME type, which is, email
                    startActivity(Intent.createChooser(email, "Choose an Email client :"));
                }
            });

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(InfoModule.this, AddDailyGrade.class);
                    int weekNo = alDG.get(alDG.size()-1).getWeek() + 1 ;
                    i.putExtra("weekNo", weekNo);
                    startActivityForResult(i, requestCodeForC347);
                }
            });

        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity
                String grade = data.getStringExtra("grade");
                String statement = "";
                // If it is activity started by clicking 				//  Superman, create corresponding String
                if(requestCode == requestCodeForC302){
                    alDG.add(new DailyGrade(grade,"C302",alDG.get(alDG.size() - 1).getWeek()+1));
                    aaInfo.notifyDataSetChanged();
                }
                // If 2nd activity started by clicking
                //  Batman, create a corresponding String
                if(requestCode == requestCodeForC347){
                    alDG.add(new DailyGrade(grade,"C347",alDG.get(alDG.size() - 1).getWeek()+1));
                    aaInfo.notifyDataSetChanged();

                }
            }
        }

    }
}
