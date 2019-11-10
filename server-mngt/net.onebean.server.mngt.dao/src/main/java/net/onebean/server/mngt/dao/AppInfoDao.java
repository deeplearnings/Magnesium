package net.onebean.server.mngt.dao;

import net.onebean.server.mngt.api.model.AppInfoSyncCloudResp;
import net.onebean.server.mngt.api.model.FindBasicMenuListResp;
import net.onebean.server.mngt.api.model.FindUagUserAppListResp;
import net.onebean.server.mngt.model.AppInfo;
import net.onebean.core.base.BaseDao;

import java.util.List;

/**
* @author 0neBean
* @description 应用信息 Dao
* @date 2019-01-03 16:14:09
*/
public interface AppInfoDao extends BaseDao<AppInfo> {
    /**
     * 查找绑定了接口的app信息
     * @return list
     */
    List<AppInfoSyncCloudResp>findBindAppInfo();

    List<FindBasicMenuListResp> findBasicMenuList();

    List<FindUagUserAppListResp> findUagUserAppList();

}