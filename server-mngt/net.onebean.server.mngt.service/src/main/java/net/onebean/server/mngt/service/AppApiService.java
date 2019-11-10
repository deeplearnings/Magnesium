package net.onebean.server.mngt.service;


import net.onebean.server.mngt.model.AppApi;
import net.onebean.server.mngt.vo.AppBindingApiReq;
import net.onebean.core.base.IBaseBiz;


/**
* @author 0neBean
* @description app info join api info service
* @date 2019-01-25 20:13:35
*/

public interface AppApiService extends IBaseBiz<AppApi> {
    /**
     * 绑定API
     * @param req 参数体
     * @return bool
     */
    Boolean bindApi(AppBindingApiReq req);
    /**
     * 绑定API
     * @param req 参数体
     * @return bool
     */
    Boolean unBindApi(AppBindingApiReq req);
}