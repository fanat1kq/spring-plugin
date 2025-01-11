package ru.n.springplugin.notification;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.stereotype.Component;
import ru.n.springplugin.model.NotificationTypeEnum;

@Component
public class NotificationProcessor {
    private final PluginRegistry<ReportPlugin, NotificationTypeEnum> pluginRegistry;

    @Autowired
    public NotificationProcessor(PluginRegistry<ReportPlugin, NotificationTypeEnum> pluginRegistry) {
        this.pluginRegistry = pluginRegistry;
    }

    public String processNotification(NotificationTypeEnum type, Map<String, String> recipientDetails) {
        return pluginRegistry.getPluginFor(type).orElseThrow(
            () -> new IllegalArgumentException("Нет подходящего плагина для типа уведомления: " + type)
        ).generateReport(recipientDetails);
    }
}
