package ru.n.springplugin;

import static ru.n.springplugin.model.NotificationTypeEnum.EMAIL;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.plugin.core.config.EnablePluginRegistries;
import ru.n.springplugin.kafka.MessageConsumer;
import ru.n.springplugin.notification.ReportPlugin;

@SpringBootApplication
@EnablePluginRegistries(ReportPlugin.class)
public class SpringPluginApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringPluginApplication.class,
            args);

        MessageConsumer reportPlugin = run.getBean(MessageConsumer.class);
        reportPlugin.consumeMessage(EMAIL,
            Map.of("username", "ivan", "password", "ivan"));
    }

}
