package com.graypick.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestNotificationEvent {

    /** 테스트 알림을 보낼 사용자 ID */
    private Long memberId;

    /** FCM 디바이스 토큰 (지금 단계에서는 이벤트에 포함) */
    private String deviceToken;

    /** 테스트용 메시지 */
    private String message;
}
