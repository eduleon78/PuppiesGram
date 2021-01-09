package com.leonestudios.puppiesgram;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService{

    private static final String TAG = "FIREBASE MENSAJE";



    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        Intent intent = new Intent();
        intent.setAction("DAR TOQUE");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        String channelId = getString(R.string.default_web_client_id);


        NotificationCompat.Action action = new NotificationCompat.Action.Builder
                (R.drawable.ic_baseline_pets_24,"Devolver toque",pendingIntent).build();

        NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();

        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this,channelId)
                .setSmallIcon(R.drawable.ic_baseline_email_24)
                .setContentTitle("Petagram")
                .setContentText(remoteMessage.getNotification().getBody())
                .setAutoCancel(true)
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .extend(wearableExtender.addAction(action));

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, notificacion.build());

    }

    @Override
    public void onNewToken(@NonNull String s) {
        //super.onNewToken(s);
        Log.d("FIREBASE TOKEN","Token Actual: "+ s);

    }
}
