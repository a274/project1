package test.itschool.samsung.ru.eco_lavka.cart;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import butterknife.ButterKnife;
import test.itschool.samsung.ru.eco_lavka.R;

public abstract class Base {


    public abstract int getViewId();

    public abstract class BaseActivity extends AppCompatActivity {

        private TextView textCartItemCount;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(getViewId());
            ButterKnife.bind(this);
            onCreateView();
        }

        @Override
        public boolean onOptionsItemSelected(final MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    onBackPressed();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        private void setupBadge() {
            if (textCartItemCount != null) {
                if (CartHelper.getCartItems().size() == 0) {
                    if (textCartItemCount.getVisibility() != View.GONE) {
                        textCartItemCount.setVisibility(View.GONE);
                    }
                } else {
                    textCartItemCount.setText(String.valueOf(Math.min(CartHelper.getCartItems().size(), 99)));
                    if (textCartItemCount.getVisibility() != View.VISIBLE) {
                        textCartItemCount.setVisibility(View.VISIBLE);
                    }
                }
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_products, menu);
            final MenuItem menuItem = menu.findItem(R.id.cart);

            View actionView = MenuItemCompat.getActionView(menuItem);
            textCartItemCount = actionView.findViewById(R.id.cart_badge);

            setupBadge();
            actionView.setOnClickListener(v -> onOptionsItemSelected(menuItem));

            return true;
        }

        public abstract int getViewId();
        public abstract void onCreateView();
    }
}
