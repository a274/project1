package test.itschool.samsung.ru.eco_lavka.cart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.itschool.samsung.ru.eco_lavka.R;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ProductModel> catalogModels;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public ProductRecyclerAdapter(Context context, List<ProductModel> catalogModels) {
        this.context = context;
        this.catalogModels = catalogModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ReceiveViewHolder(view);
    }

    @SuppressLint("StringFormatInvalid")
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ReceiveViewHolder viewHolder = (ReceiveViewHolder) holder;
        viewHolder.title.setText(catalogModels.get(position).getTitle());
        viewHolder.description.setText(catalogModels.get(position).getDescription());
        viewHolder.price.setText(String.format(context.getString(R.string.rub_format), catalogModels.get(position).getPrice()));
        Picasso.with(context).load(catalogModels.get(position).getImage()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return catalogModels.size();
    }

    public class ReceiveViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.buyButton)
        Button buyButton;

        public ReceiveViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            buyButton.setOnClickListener(view -> {
                onItemClickListener.onItemClick(catalogModels.get(getAdapterPosition()));
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(ProductModel productModel);
    }
}
