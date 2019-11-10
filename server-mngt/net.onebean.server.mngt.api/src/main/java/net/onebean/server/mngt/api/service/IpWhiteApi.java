package net.onebean.server.mngt.api.service;

import net.onebean.server.mngt.api.fallback.IpWhiteApiFallBack;
import net.onebean.server.mngt.api.model.IpWhiteListVo;
import net.onebean.core.base.BasePaginationResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "server-mngt",fallback = IpWhiteApiFallBack.class)
public interface IpWhiteApi {

    @PostMapping(value = "/cloud/ipWhtieList/find",produces = {"application/json"},consumes = {"application/json"})
    BasePaginationResponse<IpWhiteListVo> find();
}
