package net.onebean.server.mngt.action.appinfo.cloud;

import net.onebean.core.base.BasePaginationResponse;
import net.onebean.core.base.BaseResponse;
import net.onebean.core.error.BusinessException;
import net.onebean.server.mngt.api.model.*;
import net.onebean.server.mngt.common.ErrorCodesEnum;
import net.onebean.server.mngt.service.AppInfoService;
import net.onebean.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 0neBean
 * 应用信息的CRUD
 */
@RestController
@RequestMapping("/cloud/appInfo")
public class AppInfoCloudController {

    private final static Logger logger = LoggerFactory.getLogger(AppInfoCloudController.class);

    @Autowired
    private AppInfoService appInfoService;

    @SuppressWarnings("unchecked")
    @PostMapping(value = "/findByAppIdAndSecret", produces = {"application/json"}, consumes = {"application/json"})
    public BaseResponse<AppInfoCloudVo> findByAppIdAndSecret(@RequestBody FindAppByAppIdAndSecretReq request) {
        logger.info("findByAppIdAndSecret method access" + DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse<AppInfoCloudVo> response = new BaseResponse<>();
        try {
            response = BaseResponse.ok(appInfoService.findByAppIdAndSecret(request));
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("findByAppIdAndSecret method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("findByAppIdAndSecret method catch Exception e = ", e);
        }
        return response;
    }


    @SuppressWarnings("unchecked")
    @PostMapping(value = "/findBindAppInfo", produces = {"application/json"}, consumes = {"application/json"})
    public BasePaginationResponse<AppInfoSyncCloudResp> findBindAppInfo() {
        logger.info("findBindAppInfo method access" + DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BasePaginationResponse<AppInfoSyncCloudResp> response = new BasePaginationResponse<>();
        try {
            response = BasePaginationResponse.ok(appInfoService.findBindAppInfo());
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("findBindAppInfo method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("findBindAppInfo method catch Exception e = ", e);
        }
        return response;
    }


    @SuppressWarnings("unchecked")
    @PostMapping(value = "/findBasicMenuList", produces = {"application/json"}, consumes = {"application/json"})
    public BasePaginationResponse<FindBasicMenuListResp> findBasicMenuList() {
        logger.info("findBasicMenuList method access" + DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BasePaginationResponse<FindBasicMenuListResp> response = new BasePaginationResponse<>();
        try {
            response = BasePaginationResponse.ok(appInfoService.findBasicMenuList());
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("findBasicMenuList method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("findBasicMenuList method catch Exception e = ", e);
        }
        return response;
    }


    @SuppressWarnings("unchecked")
    @PostMapping(value = "/findUagUserAppList", produces = {"application/json"}, consumes = {"application/json"})
    public BasePaginationResponse<FindUagUserAppListResp> findUagUserAppList() {
        logger.info("findUagUserAppList method access" + DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BasePaginationResponse<FindUagUserAppListResp> response = new BasePaginationResponse<>();
        try {
            response = BasePaginationResponse.ok(appInfoService.findUagUserAppList());
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("findUagUserAppList method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("findUagUserAppList method catch Exception e = ", e);
        }
        return response;
    }


}
