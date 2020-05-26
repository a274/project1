package test.itschool.samsung.ru.eco_lavka.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.database.FirebaseListAdapter;
//import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;

import android.text.format.DateFormat;

import test.itschool.samsung.ru.eco_lavka.chat.Message1;
import test.itschool.samsung.ru.eco_lavka.R;

public class Chat extends AppCompatActivity {
    private FirebaseListAdapter<Message1> adapter;
    private RelativeLayout chat;
    private ImageButton send;
    SharedPreferences sharedPreferences;
    final String SAVED_ID = "ID";
    Integer id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_widget);

        sharedPreferences = getSharedPreferences("user_setting", MODE_PRIVATE);
        id = sharedPreferences.getInt(SAVED_ID, 0);

        chat = findViewById(R.id.chat_their_message);
        send = findViewById(R.id.send);
        send.setOnClickListener(v -> {
            EditText textField = findViewById(R.id.editTextChat);
            if (textField.getText().toString() == "") return;
            FirebaseDatabase.getInstance().getReference().child(id.toString()).push().setValue(
                    new Message1("Покупатель", textField.getText().toString()));

            textField.setText("");
        });
        displayAllMessages();
    }

    private void displayAllMessages() {

        ListView listMessages = findViewById(R.id.messages_view);
        adapter = new FirebaseListAdapter<Message1>( this, Message1.class, R.layout.my_message, FirebaseDatabase.getInstance().getReference().child(id.toString())) {
            @Override
            protected void populateView(View v, Message1 model, int position) {
                TextView text_message, message_time;

                text_message = v.findViewById(R.id.message_body);
                message_time = v.findViewById(R.id.message_time);

                text_message.setText(model.getTextMessage());
                message_time.setText(DateFormat.format("HH:mm", model.getMessageTime()));
            }
        };
        listMessages.setAdapter(adapter);
    }
}
