package ru.n.springplugin.notification;
import org.springframework.plugin.core.Plugin;


import java.util.Map;
import ru.n.springplugin.model.NotificationTypeEnum;

public interface ReportPlugin extends Plugin<NotificationTypeEnum> {
    String generateReport(Map<String, String> recipientDetails);

}
