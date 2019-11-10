package net.onebean.spring.config;

import net.onebean.server.mngt.common.MqQueueNameEnum;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqQueueDefined {


    @Bean
    public Queue devopsK8sNotificationAdd() {
        return new Queue(MqQueueNameEnum.DEVOPS_K8S_NOTIFICATION_ADD.getName());
    }



    @Bean
    public Queue devopsUpdateServerApi() {
        return new Queue(MqQueueNameEnum.DEVOPS_UPDATE_OPENRESTY_UPSTEAM_NODE.getName());
    }

    @Bean
    public Queue devopsUpdateServerOrApi() {
        return new Queue(MqQueueNameEnum.DEVOPS_UPDATE_SERVER_OR_API.getName());
    }

    @Bean
    public Queue authSetAccessTokenCache() {
        return new Queue(MqQueueNameEnum.AUTH_SET_ACCESS_TOKEN_CACHE.getName());
    }

}
