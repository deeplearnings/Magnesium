package net.onebean.server.mngt.consumer.mq;

import com.rabbitmq.client.Channel;
import net.onebean.core.error.BusinessException;
import net.onebean.server.mngt.common.ErrorCodesEnum;
import net.onebean.server.mngt.service.AppServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DevOpsUpdateServerApiConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(DevOpsUpdateServerApiConsumer.class);
    @Autowired
    private AppServerService appServerService;

    @RabbitListener(queues = "devops.update.server.or.api")
    @RabbitHandler
    public void process(String text, Channel channel, Message message) {
        LOGGER.info("DevOpsUpdateServerApiConsumer process access  text = "+ text);
        try {
            appServerService.syncAppApiRelationship();
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            LOGGER.error("DevOpsUpdateServerApiConsumer get err ,e = ",e);
            throw new BusinessException(ErrorCodesEnum.RABBIT_MQ_BUSSINES_ERR.code(),ErrorCodesEnum.RABBIT_MQ_BUSSINES_ERR.msg());
        }
    }
}