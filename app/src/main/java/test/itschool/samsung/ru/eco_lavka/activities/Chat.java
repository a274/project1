package test.itschool.samsung.ru.eco_lavka.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import test.itschool.samsung.ru.eco_lavka.Message1;
import test.itschool.samsung.ru.eco_lavka.R;

public class Chat extends AppCompatActivity {
    private FirebaseListAdapter<Message1> adapter;
    private LinearLayout chat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_widget);
        chat = findViewById(R.id.chat);

        displayAllMessages();
    }

    private void displayAllMessages() {
        Query query = FirebaseDatabase.getInstance().getReference().child("chats");
        FirebaseListOptions<Message1> options = new FirebaseListOptions.Builder<Message1>()
                .setQuery(query, Message1.class)
                .setLayout(R.layout.my_message)
                .build();

        ListView listMessages = findViewById(R.id.messages_view);
        adapter = new FirebaseListAdapter<Message1>(options) {
            @Override
            protected void populateView(View v, Message1 model, int position) {
                //TextView message = chat.findViewById();
            }
        };
    }
}
