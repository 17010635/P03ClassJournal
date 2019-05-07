package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ArrayList<ModuleStructure> module;
    ArrayAdapter<ModuleStructure> aaModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = findViewById(R.id.listViewModules);

        module = new ArrayList<ModuleStructure>();
        module.add(new ModuleStructure("C302","Web Services"));
        module.add(new ModuleStructure("C347", "Android Programming II"));
        aaModule = new ModuleAdapter(this,R.layout.row, module);
        lvModule.setAdapter(aaModule);

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, InfoModule.class);
                ModuleStructure selected = module.get(position);
                intent.putExtra("selected", selected);
                startActivity(intent);
            }
        });
    }
}
