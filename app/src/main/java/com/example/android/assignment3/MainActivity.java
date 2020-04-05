package com.example.android.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String CHANNEL_ID = "Personnal Information";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationService();
    }
    private void notificationService(){
        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID).setSmallIcon(R.drawable.notification)
                .setContentTitle("MY notification")
                .setContentText("This is example notofication")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//        Notifying
        NotificationManagerCompat notificationManagerCompat =  NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(001,builder.build());
    }
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "personnal notification";
            String description = "Example notofication";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
