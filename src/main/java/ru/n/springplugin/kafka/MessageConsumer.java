package ru.n.springplugin.kafka;

import java.util.Map;
import org.springframework.stereotype.Component;
import ru.n.springplugin.model.NotificationTypeEnum;
import ru.n.springplugin.notification.NotificationProcessor;

@Component
public class MessageConsumer {

    private NotificationProcessor notificationProcessor;

    public MessageConsumer(NotificationProcessor notificationProcessor) {
        this.notificationProcessor = notificationProcessor;
    }

    public void consumeMessage(NotificationTypeEnum reportType,
        Map<String, String> recipientDetails) {

        notificationProcessor.processNotification(reportType, recipientDetails);
    }
}
