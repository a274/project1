package test.itschool.samsung.ru.eco_lavka.cart;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import test.itschool.samsung.ru.eco_lavka.R;
public class CartFragment extends BaseFragment implements CartRecyclerAdapter.OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private CartRecyclerAdapter productRecyclerAdapter;

    @Override
    public int getViewId() {
        return R.layout.fragment_cart;
    }

    @Override
    public void onViewCreated(View view) {
        onUpdateList();
    }

    @Override
    public void onItemClick(CartItemsEntityModel cartItemsEntityModel) {
        // open details of product
    }

    @Override
    public void onItemPlusClicked(int position, CartItemsEntityModel cartItemsEntityModel) {
        int quantity = cartItemsEntityModel.getQuantity();
        CartItemsEntityModel cartModel = new CartItemsEntityModel();
        cartModel.setProduct(cartItemsEntityModel.getProduct());
        quantity++;
        cartModel.setQuantity(quantity);
        productRecyclerAdapter.updateItem(position, cartModel);
    }

    @Override
    public void onItemMinusClicked(int position, CartItemsEntityModel cartItemsEntityModel) {
        int quantity = cartItemsEntityModel.getQuantity();
        CartItemsEntityModel cartModel = new CartItemsEntityModel();
        cartModel.setProduct(cartItemsEntityModel.getProduct());
        quantity--;
        cartModel.setQuantity(quantity);
        productRecyclerAdapter.updateItem(position, cartModel);
    }

    @Override
    public void onUpdateList() {
        productRecyclerAdapter = new CartRecyclerAdapter(context, CartHelper.getCartItems());
        productRecyclerAdapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(productRecyclerAdapter);
    }
}
