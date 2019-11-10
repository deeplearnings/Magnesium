package net.onebean.server.mngt.service;

import net.onebean.component.jsch.remote.JschsFactory;
import net.onebean.component.jsch.remote.ShellsCommand;
import net.onebean.core.error.BusinessException;
import net.onebean.core.form.Parse;
import net.onebean.server.mngt.enumModel.AccessAuthTypeEnum;
import net.onebean.server.mngt.vo.ServerMachineNodeSyncVo;
import net.onebean.server.mngt.common.ErrorCodesEnum;
import net.onebean.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * jsch APi
 * @author 0neBean
 */
@Service
public class JschApiService {

    private final static Integer CONNECT_LINUX_TIME_OUT = 0;

    public ShellsCommand getShellsCommand(ServerMachineNodeSyncVo serverMachineNodeSyncVo) {
        /*初始化配置*/
        JschsFactory.JschConfig config = new JschsFactory.JschConfig();
        config.setHost(serverMachineNodeSyncVo.getIpAddress());
        config.setUser(serverMachineNodeSyncVo.getAccessUser());
        /*根据授权方式选择公私钥模式或密码*/
        String accessAuthType = Optional.of(serverMachineNodeSyncVo).map(ServerMachineNodeSyncVo::getAccessAuthType).orElse("");
        if (StringUtils.isEmpty(accessAuthType)) {
            throw new BusinessException(ErrorCodesEnum.GET_DATE_ERR.code(), ErrorCodesEnum.GET_DATE_ERR.msg() + " filed of accessAuthType is empty");
        }
        if (accessAuthType.equals(AccessAuthTypeEnum.RSA.getKey())) {
            config.setRsaPath(serverMachineNodeSyncVo.getAccessRsaPath());
        } else {
            config.setPassword(serverMachineNodeSyncVo.getAccessPassword());
        }
        config.setPort(Parse.toInt(serverMachineNodeSyncVo.getAccessPort()));
        config.setTimeout(CONNECT_LINUX_TIME_OUT);
        ShellsCommand shellsCommand = new ShellsCommand();
        shellsCommand.setConfig(config);
        return shellsCommand;
    }
}
