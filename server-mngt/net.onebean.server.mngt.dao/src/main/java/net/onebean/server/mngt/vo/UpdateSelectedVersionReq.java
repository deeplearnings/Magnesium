package net.onebean.server.mngt.vo;

public class UpdateSelectedVersionReq {

    private String selectedVersion;
    private String upsteamNodeName;

    public String getSelectedVersion() {
        return selectedVersion;
    }

    public void setSelectedVersion(String selectedVersion) {
        this.selectedVersion = selectedVersion;
    }

    public String getUpsteamNodeName() {
        return upsteamNodeName;
    }

    public void setUpsteamNodeName(String upsteamNodeName) {
        this.upsteamNodeName = upsteamNodeName;
    }
}
