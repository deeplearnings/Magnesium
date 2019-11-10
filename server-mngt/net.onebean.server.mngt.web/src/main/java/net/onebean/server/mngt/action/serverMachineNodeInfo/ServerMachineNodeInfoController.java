package net.onebean.server.mngt.action.serverMachineNodeInfo;

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
import net.onebean.server.mngt.service.ServerMachineNodeService;
import net.onebean.server.mngt.vo.ServerMachineNodeAddReq;
import net.onebean.server.mngt.vo.ServerMachineNodeInfoModifyReq;
import net.onebean.server.mngt.vo.ServerMachineNodeVo;
import net.onebean.uag.log.annotation.UagOperationLog;
import net.onebean.util.DateUtils;
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

@RestController
@RequestMapping("/serverMachineNodeInfo")
public class ServerMachineNodeInfoController {

    private final static Logger logger = LoggerFactory.getLogger(ServerMachineNodeInfoController.class);

    @Autowired
    private ServerMachineNodeService serverMachineNodeService;


    @UagOperationLog(description = "添加服务器节点")
    @PostMapping(value = "/add",produces = {"application/json"},consumes = {"application/json"})
    public BaseResponse add(@RequestBody @Validated ServerMachineNodeAddReq request, BindingResult result){
        logger.info("ServerMachineNodeInfoController add method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse response = new BaseResponse();
        try {
            if (result.hasErrors()) {
                response.setErrCode(ErrorCodesEnum.REQUEST_PARAM_ERROR.code());
                response.setErrMsg(result.getAllErrors().get(0).getDefaultMessage());
                return response;
            }
            logger.debug("add method request = "+ JSON.toJSONString(request, SerializerFeature.WriteMapNullValue));
            response = BaseResponse.ok(serverMachineNodeService.add(request));
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("ServerMachineNodeInfoController add method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("add method catch Exception e = ",e);
        }
        return response;
    }

    @SuppressWarnings("unchecked")
    @EnableEnumDeserialize
    @PostMapping(value = "/find",produces = {"application/json"},consumes = {"application/json"})
    public BasePaginationResponse<ServerMachineNodeVo> find(@RequestBody BasePaginationRequest<ServerMachineNodeAddReq> request){
        logger.info("ServerMachineNodeInfoController find method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BasePaginationResponse<ServerMachineNodeVo> response = new BasePaginationResponse<>();
        try {
            ServerMachineNodeAddReq param = Optional.ofNullable(request).map(BasePaginationRequest::getData).orElse(null);
            Pagination page = Optional.ofNullable(request).map(BasePaginationRequest::getPage).orElse(new Pagination());
            Sort sort = Optional.ofNullable(request).map(BasePaginationRequest::getSort).orElse(new Sort(Sort.DESC,"id"));
            logger.debug("find method request = "+ JSON.toJSONString(request, SerializerFeature.WriteMapNullValue));
            response = BasePaginationResponse.ok(serverMachineNodeService.findServerMachineNodeVo(param,page,sort),page);
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("ServerMachineNodeInfoController find method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("find method catch Exception e = ",e);
        }
        return response;
    }

    @UagOperationLog(description = "更新服务器节点")
    @PostMapping(value = "/update",produces = {"application/json"},consumes = {"application/json"})
    public BaseResponse update(@RequestBody @Validated ServerMachineNodeInfoModifyReq request, BindingResult result){
        logger.info("ServerMachineNodeInfoController update method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse response = new BaseResponse();
        try {
            if (result.hasErrors()) {
                response.setErrCode(ErrorCodesEnum.REQUEST_PARAM_ERROR.code());
                response.setErrMsg(result.getAllErrors().get(0).getDefaultMessage());
                return response;
            }
            logger.debug("update method request = "+ JSON.toJSONString(request, SerializerFeature.WriteMapNullValue));
            response = BaseResponse.ok(serverMachineNodeService.update(request));
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("ServerMachineNodeInfoController update method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("update method catch Exception e = ",e);
        }
        return response;
    }

    @UagOperationLog(description = "删除服务器节点")
    @PostMapping(value = "/delete",produces = {"application/json"},consumes = {"application/json"})
    public BaseResponse delete(@RequestBody @Validated ServerMachineNodeInfoModifyReq request, BindingResult result){
        logger.info("ServerMachineNodeInfoController delete method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse response = new BaseResponse();
        try {
            if (result.hasErrors()) {
                response.setErrCode(ErrorCodesEnum.REQUEST_PARAM_ERROR.code());
                response.setErrMsg(result.getAllErrors().get(0).getDefaultMessage());
                return response;
            }
            logger.debug("delete method request = "+ JSON.toJSONString(request, SerializerFeature.WriteMapNullValue));
            String id = Optional.ofNullable(request).map(ServerMachineNodeInfoModifyReq::getId).orElse(null);
            response = BaseResponse.ok(serverMachineNodeService.deleteById(id));
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("ServerMachineNodeInfoController delete method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("delete method catch Exception e = ",e);
        }
        return response;
    }

    @SuppressWarnings("unchecked")
    @PostMapping(value = "/findById",produces = {"application/json"},consumes = {"application/json"})
    public BaseResponse<ServerMachineNodeVo> findById(@RequestBody @Validated ServerMachineNodeInfoModifyReq request, BindingResult result){
        logger.info("ServerMachineNodeInfoController findById method access"+ DateUtils.getNowyyyy_MM_dd_HH_mm_ss());
        BaseResponse<ServerMachineNodeVo> response = new BaseResponse<>();
        try {
            if (result.hasErrors()) {
                response.setErrCode(ErrorCodesEnum.REQUEST_PARAM_ERROR.code());
                response.setErrMsg(result.getAllErrors().get(0).getDefaultMessage());
                return response;
            }
            logger.debug("findById method request = "+ JSON.toJSONString(request, SerializerFeature.WriteMapNullValue));
            Object id = Optional.ofNullable(request).map(ServerMachineNodeInfoModifyReq::getId).orElse(null);
            response = BaseResponse.ok(serverMachineNodeService.findVoById(id));
        } catch (BusinessException e) {
            response.setErrCode(e.getCode());
            response.setErrMsg(e.getMsg());
            logger.info("ServerMachineNodeInfoController findById method BusinessException ex = ", e);
        } catch (Exception e) {
            response.setErrCode(ErrorCodesEnum.OTHER.code());
            response.setErrMsg(ErrorCodesEnum.OTHER.msg());
            logger.error("findById method catch Exception e = ",e);
        }
        return response;
    }





}
