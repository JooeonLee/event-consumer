package com.graypick.notification.consumer;

import com.graypick.notification.dto.BillStatusChangedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    @KafkaListener(
            topics = "bill-status-topic",
            groupId = "notification-group"
    )
    public void consume(BillStatusChangedEvent event) {
        log.info("카프카 메시지 수신 성공");
        log.info("의안 ID: {}, 변경된 상태: {}", event.getBillId(), event.getStepName());

        try {

        } catch (Exception e) {
            log.error("❌ 알림 처리 중 오류 발생: {}", e.getMessage());

            // TODO: 재시도 로직, Dead Letter Topic 처리 고려
        }
    }
}
