package com.czareg.senders;

import com.czareg.common.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationSender {

    private final ApplicationEventPublisher events;

    public void send(Notification notification) {
        events.publishEvent(notification);
    }
}
