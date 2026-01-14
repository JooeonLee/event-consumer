package com.graypick.notification.service;

import com.graypick.notification.dto.BillStatusChangedEvent;
import com.graypick.notification.dto.TestNotificationEvent;
import com.graypick.notification.fcm.FcmSender;
import com.graypick.notification.fcm.PushMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final FcmSender fcmSender;

    @Transactional(readOnly = true)
    public void sendNotification(BillStatusChangedEvent event) {
        log.info("[검증] 1. 서비스 도달 완료 - 의안 ID: {}", event.getBillId());

        // DB 조회 대신 하드코딩된 가상 데이터 사용
        List<String> mockTokens = List.of("mock_token_12345");
        log.info("[검증] 2. 가상 토큰 생성 완료: {}", mockTokens);

        // FCM 발송 대신 로그로 대체
        log.info("[검증] 3. 최종 알림 내용: [{}] 의안이 [{}] 상태로 변경됨", event.getBillId(), event.getStepName());
    }

    public void sendTest(TestNotificationEvent event) {
        String title = "테스트 알림";
        String body = event.getMessage() != null
                ? event.getMessage()
                : "푸시 연동 테스트입니다";

        fcmSender.send(
                event.getDeviceToken(),
                title,
                body,
                Map.of("type", "TEST")
        );
    }
}
