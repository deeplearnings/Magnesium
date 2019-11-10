package net.onebean.api.adapter.provider.mq;

import com.alibaba.fastjson.JSON;
import net.onebean.api.adapter.api.model.DevOpsK8sNotificationVo;
import net.onebean.api.adapter.common.MqQueueNameEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DevopsK8sNotificationAddSender {

    private final static Logger LOGGER = LoggerFactory.getLogger(DevopsK8sNotificationAddSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Boolean send(DevOpsK8sNotificationVo req){
        this.rabbitTemplate.convertAndSend(MqQueueNameEnum.DEVOPS_K8S_NOTIFICATION_ADD.getName(), JSON.toJSONString(req));
        LOGGER.info("send message devops.k8s.notification.add = "+req);
        return true;
    }



}
