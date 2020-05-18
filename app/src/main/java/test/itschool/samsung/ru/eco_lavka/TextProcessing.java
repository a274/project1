package test.itschool.samsung.ru.eco_lavka;

import android.content.Context;
import android.widget.EditText;

public interface TextProcessing {

    // вывод ошибки о пустой строке
    public default void printError(Context context, EditText editText) {
        editText.setHintTextColor(context.getColor(R.color.error));
        editText.setHint(R.string.fill_the_field);
    }

    //проверка пустой строки
    public default boolean isFieldEmpty (Context context, EditText...field) {
        boolean p = false;
        for (int i = 0; i < field.length; i++) {
            String value = getValue(field[i]);
            if (value.equals("")) {
                printError(context, field[i]);
                p = true;
            }
        }
        return p;
    }

    public default String getValue (EditText field) {
        String value = field.getText().toString().trim();
        return value;
    }

}
