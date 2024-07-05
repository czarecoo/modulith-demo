package com.czareg;

import com.czareg.common.Notification;
import com.czareg.receivers.NotificationReceiverA;
import com.czareg.receivers.NotificationReceiverB;
import com.czareg.senders.NotificationSender;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.modulith.core.ApplicationModules;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;

@SpringBootTest
class MainTests {

    @Autowired
    private NotificationSender notificationSender;

    @MockBean
    private NotificationReceiverA notificationReceiverA;

    @MockBean
    private NotificationReceiverB notificationReceiverB;

    @Test
    void interactionTest() {
        Notification notification = new Notification(Instant.parse("2021-01-01T08:00:00.00Z"), "Test");
        long timeoutDuration = TimeUnit.SECONDS.toMillis(1);

        notificationSender.send(notification);

        verify(notificationReceiverA, timeout(timeoutDuration)).notificationEvent(notification);
        verify(notificationReceiverB, timeout(timeoutDuration)).notificationEvent(notification);
        verifyNoMoreInteractions(notificationReceiverA, notificationReceiverB);
    }
}
