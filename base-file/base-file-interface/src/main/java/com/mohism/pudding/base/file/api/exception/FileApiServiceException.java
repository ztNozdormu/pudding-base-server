package com.mohism.pudding.base.file.api.exception;


import com.mohism.pudding.kernel.model.exception.AbstractBaseExceptionEnum;
import com.mohism.pudding.kernel.model.exception.ApiServiceException;

/**
 * 文件远程调的业务异常
 *
 * @author fengshuonan
 * @date 2018-08-06-上午11:21
 */
public class FileApiServiceException extends ApiServiceException {

    public FileApiServiceException(AbstractBaseExceptionEnum exception) {
        super(exception);
    }

    @Override
    public String getExceptionClassName() {
        return FileApiServiceException.class.getName();
    }

}
