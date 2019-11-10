package net.onebean.server.mngt.service;

import net.onebean.server.mngt.api.model.SendLoginSmsReq;

/**
 * @author 0neBean
 */
public interface CacheRsSalesLoginInfoService {
    /**
     * 缓存短信信息
     * @param req 参数体
     * @return bool
     */
    Boolean cacheSmsInfo(SendLoginSmsReq req);
}
