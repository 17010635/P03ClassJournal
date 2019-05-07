package sg.edu.rp.c346.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DailyGradeAdapter extends ArrayAdapter<DailyGrade>{
    private ArrayList<DailyGrade> dg;
    private Context context;
    private TextView tvGrade,tvWeek;
    private ImageView ivDG;

    public DailyGradeAdapter(Context context, int resource, ArrayList<DailyGrade> objects) {
        super(context, resource, objects);
        dg = objects;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowdg, parent, false);
        tvWeek = rowView.findViewById(R.id.textViewWeek);
        tvGrade = rowView.findViewById(R.id.textViewGrade);
        ivDG = rowView.findViewById(R.id.imageView);
        DailyGrade currentGrade = dg.get(position);
        tvWeek.setText("Week" + String.valueOf(currentGrade.getWeek()));
        tvGrade.setText(currentGrade.getDailyGrade());
        ivDG.setImageResource(R.drawable.dg);
        return rowView;
    }
}
