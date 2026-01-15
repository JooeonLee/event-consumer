package com.graypick.notification.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BillStatusChangedEvent {
    private Long billId;
    private String stepName;
    private String createdAt;
}
