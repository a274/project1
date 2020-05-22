package test.itschool.samsung.ru.eco_lavka.cart;

import java.util.ArrayList;
import java.util.List;

public class ProductsHelper {
    public static List<ProductModel> getProductsList() {
        List<ProductModel> productModels = new ArrayList<>();

        ProductModel model = new ProductModel();
        model.setId((long) 1);
        model.setTitle("@string/milk");
        model.setDescription("@string/_2_5");
        model.setImage("milk");
        model.setPrice(30);
        productModels.add(model);

        model = new ProductModel();
        model.setId((long) 2);
        model.setTitle("@string/milk");
        model.setDescription("");
        model.setImage("");
        model.setPrice(200);
        productModels.add(model);

        model = new ProductModel();
        model.setId((long) 3);
        model.setTitle("@string/milk");
        model.setDescription("");
        model.setImage("");
        model.setPrice(1199);
        productModels.add(model);

        return productModels;
    }
}
