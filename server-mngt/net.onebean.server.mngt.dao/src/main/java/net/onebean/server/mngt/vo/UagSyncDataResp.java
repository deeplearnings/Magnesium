package net.onebean.server.mngt.vo;

import net.onebean.server.mngt.api.model.AppInfoSyncCloudResp;
import net.onebean.server.mngt.api.model.IpWhiteListVo;

import java.util.ArrayList;
import java.util.List;

public class UagSyncDataResp {

    private List<IpWhiteListVo> ipWhiteListVos = new ArrayList<>();
    private List<AppInfoSyncCloudResp> appInfoSyncCloudRespList = new ArrayList<>();
    private List<UagUnLoginAccessWhiteSyncListVo> unLoginAccessWhiteListSyncList;

    public List<UagUnLoginAccessWhiteSyncListVo> getUnLoginAccessWhiteListSyncList() {
        return unLoginAccessWhiteListSyncList;
    }
    public void setUnLoginAccessWhiteListSyncList(List<UagUnLoginAccessWhiteSyncListVo> unLoginAccessWhiteListSyncList) {
        this.unLoginAccessWhiteListSyncList = unLoginAccessWhiteListSyncList;
    }

    public List<IpWhiteListVo> getIpWhiteListVos() {
        return ipWhiteListVos;
    }
    public void setIpWhiteListVos(List<IpWhiteListVo> ipWhiteListVos) {
        this.ipWhiteListVos = ipWhiteListVos;
    }

    public List<AppInfoSyncCloudResp> getAppInfoSyncCloudRespList() {
        return appInfoSyncCloudRespList;
    }
    public void setAppInfoSyncCloudRespList(List<AppInfoSyncCloudResp> appInfoSyncCloudRespList) {
        this.appInfoSyncCloudRespList = appInfoSyncCloudRespList;
    }
}
