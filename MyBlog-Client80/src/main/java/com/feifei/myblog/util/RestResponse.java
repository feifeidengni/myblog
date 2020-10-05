package com.feifei.myblog.util;

import org.omg.CORBA.Object;

import java.util.HashMap;
/**
 *      一般用于ajax、rest等类型web服务
 * */
public class RestResponse extends HashMap<String, Object>
{
//    public static RestResponse success(){
//        return success("成功");
//    }

//    public static RestResponse success(String message){
//        RestResponse restResponse = new RestResponse();
//        restResponse.setSuccess(true);
//        restResponse.setMessage(message);
//        restResponse.setCode(0);
//        return restResponse;
//    }
//
//    public static RestResponse failure(String message){
//        RestResponse restResponse = new RestResponse();
//        restResponse.setSuccess(false);
//        restResponse.setMessage(message);
//        restResponse.setCode(0);
//        return restResponse;
//    }
//
//    public RestResponse setSuccess(Boolean success){
//        if(success != null ) {
//            put("success",success);
//        }
//        return this;
//    }
//    public RestResponse setMessage(String message){
//        if(message != null ) {
//            put("success",message);
//        }
//        return this;
//    }


}
