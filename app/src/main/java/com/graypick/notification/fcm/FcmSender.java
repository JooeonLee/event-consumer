package com.graypick.notification.fcm;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class FcmSender {

    public void send(String deviceToken, String title, String body, Map<String, String> data) {
        try {
            Message message = Message.builder()
                    .setToken(deviceToken)
                    .setNotification(
                            Notification.builder()
                                    .setTitle(title)
                                    .setBody(body)
                                    .build()
                    )
                    .putAllData(data)
                    .build();

            String response = FirebaseMessaging.getInstance().send(message);
            log.info("✅ FCM 전송 성공. messageId={}", response);

        } catch (Exception e) {
            log.error("❌ FCM 전송 실패", e);
        }
    }
}
