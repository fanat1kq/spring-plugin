package ru.n.springplugin.notification.impl;

import java.util.Map;
import org.springframework.stereotype.Component;
import ru.n.springplugin.model.NotificationTypeEnum;
import ru.n.springplugin.notification.ReportPlugin;

@Component
public class WhatsappReportPlugin implements ReportPlugin {

    @Override
    public String generateReport(Map<String, String> recipientDetails) {
        return "вотсап!";
    }

    @Override
    public boolean supports(NotificationTypeEnum  delimiter) {
        return delimiter.equals(NotificationTypeEnum.WHATSAPP);
    }
}
