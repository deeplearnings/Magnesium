package net.onebean.server.mngt.action.appinfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.onebean.core.Json.EnableEnumDeserialize;
import net.onebean.core.base.BasePaginationRequest;
import net.onebean.core.base.BasePaginationResponse;
import net.onebean.core.base.BaseResponse;
import net.onebean.core.error.BusinessException;
import net.onebean.core.extend.Sort;
import net.onebean.core.query.Pagination;
import net.onebean.server.mngt.common.ErrorCodesEnum;
import net.onebean.server.mngt.model.AppInfo;
import net.onebean.server.mngt.service.AppApiService;
import net.onebean.server.mngt.service.AppInfoService;
import net.onebean.server.mngt.service.AppServerService;
import net.onebean.server.mngt.vo.*;
import net.onebean.uag.log.annotation.UagOperationLog;
import net.onebean.util.DateUtils;
import net.onebean.util.UagSsoUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author 0neBean
 * 应用信息的CRUD
 */
@RestController
@RequestMapping("/appInfo")
public class AppInfoController {

    private final static Logger logger = LoggerFactory.getLogger(AppInfoController.class);

    @Autowired
    private AppInfoService appInfoService;
    @Autowired
    private AppApiService appApiService;
    @Autowired
    private AppServerService appServerService;


    @UagOperationLog(description = "新增应用信息")
    @PostMapping(value = "/add",produces = {"application/json"},consumes = {"application/json"})
    public BaseResponse<Long> add(@RequestBody @Validated AppInfoAddRequest request, BindingResult result) {
        logger.info("AppInfoController add method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse response = new BaseResponse();
        try {
            if (result.hasErrors()) {
                response.setErrCode(ErrorCodesEnum.REQUEST_PARAM_ERROR.code());
                response.setErrMsg(result.getAllErrors().get(0).getDefaultMessage());
                return response;
            }
            logger.debug("AppInfoController add method request = "+ JSON.toJSONString(request, SerializerFeature.WriteMapNullValue));
            AppInfo target = new AppInfo();
            BeanUtils.copyProperties(target,request);
            logger.debug("AppInfoController add method target = "+ JSON.toJSONString(target, SerializerFeature.WriteMapNullValue));
            appInfoService.addAppInfo(target);
            response = BaseResponse.ok(target.getId());
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("AppInfoController add method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("AppInfoController add method catch Exception e = ",e);
        }
        return response;
    }


    @UagOperationLog(description = "更新应用信息")
    @PostMapping(value = "/update",produces = {"application/json"},consumes = {"application/json"})
    public BaseResponse update(@RequestBody @Validated AppInfoModifyRequest request, BindingResult result) {
        logger.info("AppInfoController update method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse response = new BaseResponse();
        try {
            if (result.hasErrors()) {
                response.setErrCode(ErrorCodesEnum.REQUEST_PARAM_ERROR.code());
                response.setErrMsg(result.getAllErrors().get(0).getDefaultMessage());
                return response;
            }
            logger.debug("AppInfoController update method request = "+ JSON.toJSONString(request, SerializerFeature.WriteMapNullValue));
            AppInfo target = new AppInfo();
            BeanUtils.copyProperties(target,request);
            logger.debug("AppInfoController update method target = "+ JSON.toJSONString(target, SerializerFeature.WriteMapNullValue));
            UagSsoUtils.setUagUserInfoByHeader(target);
            response = BaseResponse.ok(appInfoService.update(target));
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("AppInfoController update method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("AppInfoController update method catch Exception e = ",e);
        }
        return response;
    }


    @UagOperationLog(description = "删除应用信息")
    @PostMapping(value = "/delete",produces = {"application/json"},consumes = {"application/json"})
    public BaseResponse delete(@RequestBody AppInfoVo appInfoVo) {
        logger.info("AppInfoController delete method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse response = new BaseResponse();
        try {
            logger.debug("AppInfoController delete method appInfoVo = "+ JSON.toJSONString(appInfoVo, SerializerFeature.WriteMapNullValue));
            Object id = Optional.ofNullable(appInfoVo).map(AppInfoVo::getId).orElse(null);
            response = BaseResponse.ok(appInfoService.deleteById(id));
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("AppInfoController delete method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("AppInfoController delete method catch Exception e = ",e);
        }
        return response;
    }

    @SuppressWarnings("unchecked")
    @EnableEnumDeserialize
    @PostMapping(value = "/find",produces = {"application/json"},consumes = {"application/json"})
    public BasePaginationResponse<AppInfoVo> find(@RequestBody BasePaginationRequest<AppInfoQueryRequest> request) {
        logger.info("AppInfoController find method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BasePaginationResponse<AppInfoVo> response = new BasePaginationResponse<>();
        try {
            AppInfoQueryRequest param = Optional.ofNullable(request).map(BasePaginationRequest::getData).orElse(null);
            Pagination page = Optional.ofNullable(request).map(BasePaginationRequest::getPage).orElse(new Pagination());
            Sort sort = Optional.ofNullable(request).map(BasePaginationRequest::getSort).orElse(new Sort(Sort.DESC,"id"));
            response = BasePaginationResponse.ok(appInfoService.findByAppInfoQueryRequest(param,page,sort),page);
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("AppInfoController find method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("AppInfoController find method catch Exception e = ",e);
        }
        return response;
    }

    @SuppressWarnings("unchecked")
    @PostMapping(value = "/findById",produces = {"application/json"},consumes = {"application/json"})
    public BaseResponse<AppInfoVo> findById(@RequestBody BasePaginationRequest<AppInfoQueryRequest> request) {
        logger.info("AppInfoController find method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse<AppInfoVo> response = new BaseResponse<>();
        try {
            Object id = Optional.ofNullable(request).map(BasePaginationRequest::getData).map(AppInfoQueryRequest::getId).orElse(null);
            response = BaseResponse.ok(appInfoService.findVoById(id));
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());

            logger.info("AppInfoController find method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("AppInfoController find method catch Exception e = ",e);
        }
        return response;
    }



    @UagOperationLog(description = "绑定API")
    @PostMapping(value = "/bindingApi",produces = {"application/json"},consumes = {"application/json"})
    public BaseResponse bindingApi(@RequestBody @Validated AppBindingApiReq request,BindingResult result){
        logger.info("AppInfoController bindApi method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse response = new BaseResponse();
        try {
            if (result.hasErrors()) {
                response.setErrCode(ErrorCodesEnum.REQUEST_PARAM_ERROR.code());
                response.setErrMsg(result.getAllErrors().get(0).getDefaultMessage());
                return response;
            }
            logger.debug("AppInfoController bindApi method request = "+ JSON.toJSONString(request, SerializerFeature.WriteMapNullValue));
            response = BaseResponse.ok(appApiService.bindApi(request));
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("AppInfoController bindApi method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("AppInfoController bindApi method catch Exception e = ",e);
        }
        return response;
    }


    @UagOperationLog(description = "取消绑定API")
    @PostMapping(value = "/unBindingApi",produces = {"application/json"},consumes = {"application/json"})
    public BaseResponse unBindingApi(@RequestBody @Validated AppBindingApiReq request,BindingResult result){
        logger.info("AppInfoController unBindApi method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse response = new BaseResponse();
        try {
            if (result.hasErrors()) {
                response.setErrCode(ErrorCodesEnum.REQUEST_PARAM_ERROR.code());
                response.setErrMsg(result.getAllErrors().get(0).getDefaultMessage());
                return response;
            }
            logger.debug("AppInfoController unBindApi method request = "+ JSON.toJSONString(request, SerializerFeature.WriteMapNullValue));
            response = BaseResponse.ok(appApiService.unBindApi(request));
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("AppInfoController unBindApi method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("AppInfoController unBindApi method catch Exception e = ",e);
        }
        return response;
    }


    @UagOperationLog(description = "同步应用和API的关联关系")
    @PostMapping(value = "/syncAppApiRelationship",produces = {"application/json"},consumes = {"application/json"})
    public BaseResponse syncAppApiRelationship(){
        logger.info("AppInfoController syncAppApiRelationship method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse response = new BaseResponse();
        try {
            response = BaseResponse.ok(appServerService.syncAppApiRelationship());
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("AppInfoController syncAppApiRelationship method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("AppInfoController syncAppApiRelationship method catch Exception e = ",e);
        }
        return response;
    }

}
