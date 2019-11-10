server {


    listen ${hostNode.listenPort};
<#if hostNode.isSsl == '1'>
    listen ${hostNode.sslListenPort};
</#if>
    server_name ${hostNode.serverHost};
<#if hostNode.isSsl == '1'>
    ssl_certificate ${hostNode.sslCrtPath};
    ssl_certificate_key ${hostNode.sslCrtKeyPath};
</#if>

    access_log /usr/local/openresty/nginx/uag/logs/front/${hostNode.upsteamNodeName}-access.log;
    error_log  /usr/local/openresty/nginx/uag/logs/front/${hostNode.upsteamNodeName}-error.log debug;
    error_page 497 https://$server_name$request_uri;

    location / {
        proxy_pass http://${hostNode.upsteamNodeName};
    }

}
