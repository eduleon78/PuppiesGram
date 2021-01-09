package com.leonestudios.puppiesgram;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;

import java.util.Map;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class NotificationIDTokenService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String s) {
        Log.e("NEW TOKEN", s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Map<String, String > params = remoteMessage.getData();
        JSONObject object = new JSONObject(params);
        Log.e("JSON_OBJET", object.toString());

        String NOTIFICATION_CHANNEL_ID = "Niles_channel";


    }
}
