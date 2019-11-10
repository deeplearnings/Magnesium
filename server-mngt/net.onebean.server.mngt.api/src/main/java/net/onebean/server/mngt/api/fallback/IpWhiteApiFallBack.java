package net.onebean.server.mngt.api.fallback;

import net.onebean.server.mngt.api.model.IpWhiteListVo;
import net.onebean.server.mngt.api.service.IpWhiteApi;
import net.onebean.core.base.BasePaginationResponse;

public class IpWhiteApiFallBack implements IpWhiteApi {

    @Override
    public BasePaginationResponse<IpWhiteListVo> find() {
        BasePaginationResponse<IpWhiteListVo> baseResponse = new BasePaginationResponse<>();
        baseResponse.setErrCode("999");
        baseResponse.setErrMsg("fall back");
        return baseResponse;
    }
}
