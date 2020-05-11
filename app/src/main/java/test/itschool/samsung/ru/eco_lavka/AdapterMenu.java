package test.itschool.samsung.ru.eco_lavka;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.ViewHolder> {
private String[] categories1;

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public static class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView mTextView;
    public ViewHolder(TextView v) {
        super(v);
        mTextView = v;
    }
}

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterMenu(String[] categories) {
        categories1 = categories;
    }

    @Override
    public AdapterMenu.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_categories, parent, false);

        ViewHolder vh = new ViewHolder((TextView) v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
// - get element from your categories at this position
// - replace the contents of the view with that element
        holder.mTextView.setText(categories1[position]);

    }
    @Override
    public int getItemCount() {
        return categories1.length;
    }
}
