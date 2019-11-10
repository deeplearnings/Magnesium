package net.onebean.server.mngt.api.service;

import net.onebean.core.base.BaseResponse;
import net.onebean.server.mngt.api.fallback.SendSmsCloudApiFallBack;
import net.onebean.server.mngt.api.model.SendLoginSmsReq;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "server-mngt" ,fallback = SendSmsCloudApiFallBack.class)
public interface SendSmsCloudApi {

    @PostMapping(value = "/sendSmsCloudController/setLoginSmsCheckCache",produces = {"application/json"},consumes = {"application/json"})
    BaseResponse<Boolean> setLoginSmsCheckCache(@RequestBody SendLoginSmsReq request);
}
