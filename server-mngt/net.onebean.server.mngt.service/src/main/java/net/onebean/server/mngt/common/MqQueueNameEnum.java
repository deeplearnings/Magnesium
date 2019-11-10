package net.onebean.server.mngt.common;

public enum MqQueueNameEnum {
    AUTH_SET_ACCESS_TOKEN_CACHE("auth.set.access.token.cache"),
    DEVOPS_UPDATE_SERVER_OR_API("devops.update.server.or.api"),
    DEVOPS_INIT_UAG_ACCOUNT_TABLE("devops.init.uag.account.table"),
    DEVOPS_UPDATE_OPENRESTY_UPSTEAM_NODE("devops.update.openresty.upsteam.node"),
    DEVOPS_K8S_NOTIFICATION_ADD("devops.k8s.notification.add"),

            ;

    private String name;

    MqQueueNameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}