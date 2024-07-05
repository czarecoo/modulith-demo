package com.czareg.receivers;

import com.czareg.common.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationReceiverA {

    @Async
    @ApplicationModuleListener
    public void notificationEvent(Notification notification) {
        log.info("NotificationReceiverA received {}.", notification);
    }
}
