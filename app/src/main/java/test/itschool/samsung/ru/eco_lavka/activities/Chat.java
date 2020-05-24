package test.itschool.samsung.ru.eco_lavka.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.database.FirebaseListAdapter;
//import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import android.text.format.DateFormat;
import android.widget.Toast;

import test.itschool.samsung.ru.eco_lavka.Message1;
import test.itschool.samsung.ru.eco_lavka.R;

public class Chat extends AppCompatActivity {
    private FirebaseListAdapter<Message1> adapter;
    private RelativeLayout chat;
    private ImageButton send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_widget);
        chat = findViewById(R.id.chat_their_message);
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textField = findViewById(R.id.editTextChat);
                if (textField.getText().toString() == "") return;
                FirebaseDatabase.getInstance().getReference().child("chats").push().setValue(
                        new Message1("Продавец", textField.getText().toString()));

                textField.setText("");
            }
        });
        displayAllMessages();
    }

    private void displayAllMessages() {
      /*  Query query = FirebaseDatabase.getInstance().getReference().child("chats");
        FirebaseListOptions<Message1> options = new FirebaseListOptions.Builder<Message1>()
                .setQuery(query, Message1.class)
                .setLayout(R.layout.their_message)
                .build();
*/
        ListView listMessages = findViewById(R.id.messages_view);
        adapter = new FirebaseListAdapter<Message1>( this, Message1.class, R.layout.their_message, FirebaseDatabase.getInstance().getReference().child("chats")) {
            @Override
            protected void populateView(View v, Message1 model, int position) {
                TextView user, text_message, message_time;

                user = v.findViewById(R.id.name);
                text_message = v.findViewById(R.id.message_body);
                message_time = v.findViewById(R.id.message_time);

                user.setText(model.getUserName());
                text_message.setText(model.getTextMessage());
                message_time.setText(DateFormat.format("HH:mm", model.getMessageTime()));
            }
        };
        listMessages.setAdapter(adapter);
    }
}
