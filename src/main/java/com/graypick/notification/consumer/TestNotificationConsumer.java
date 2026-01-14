package com.graypick.notification.consumer;

import com.graypick.notification.dto.TestNotificationEvent;
import com.graypick.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TestNotificationConsumer {

    private final NotificationService notificationService;

    @KafkaListener(
            topics = "notification-test-topic2",
            groupId = "notification-test-group"
    )
    public void consume(TestNotificationEvent event) {
        log.info(
                "📩 테스트 알림 이벤트 수신. memberId={}, token={}",
                event.getMemberId(),
                event.getDeviceToken()
        );

        notificationService.sendTest(event);
    }
}
