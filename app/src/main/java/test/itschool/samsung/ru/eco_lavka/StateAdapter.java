package test.itschool.samsung.ru.eco_lavka;

import java.util.List;

import android.content.Context;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StateAdapter extends ArrayAdapter<Categories> {

    private LayoutInflater inflater;
    private int layout;
    private List<Categories> states;

    public StateAdapter(Context context, int resource, List<Categories> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView nameView = (TextView) view.findViewById(R.id.name);

        Categories categorie= states.get(position);

        imageView.setImageResource(categorie.getImageResource());
        nameView.setText(categorie.getName());

        return view;
    }
}

