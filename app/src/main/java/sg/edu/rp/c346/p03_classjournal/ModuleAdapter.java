package sg.edu.rp.c346.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<ModuleStructure> {
    private ArrayList<ModuleStructure> modules;
    private Context context;
    private TextView tvModuleCode,tvModuleName;

    public ModuleAdapter(Context context, int resource, ArrayList<ModuleStructure> objects){
        super(context, resource, objects);
        modules = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvModuleName = rowView.findViewById(R.id.textViewModuleName);
        tvModuleCode = rowView.findViewById(R.id.textViewModuleCode);
        ModuleStructure current = modules.get(position);
        tvModuleName.setText(current.getModuleName());
        tvModuleCode.setText(current.getModuleCode());


        return rowView;
    }
}
