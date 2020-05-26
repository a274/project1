package test.itschool.samsung.ru.eco_lavka.server_connect;

import android.content.Context;
import android.widget.EditText;

import test.itschool.samsung.ru.eco_lavka.R;

public interface TextProcessing {

    // вывод ошибки о пустой строке
    default void printError(Context context, EditText editText) {
        editText.setHintTextColor(context.getColor(R.color.error));
        editText.setHint(R.string.fill_the_field);
    }

    //проверка пустой строки
    default boolean isFieldEmpty(Context context, EditText... field) {
        boolean p = false;
        for (EditText editText : field) {
            String value = getValue(editText);
            if (value.equals("")) {
                printError(context, editText);
                p = true;
            }
        }
        return p;
    }

    default String getValue(EditText field) {
        return field.getText().toString().trim();
    }

}
