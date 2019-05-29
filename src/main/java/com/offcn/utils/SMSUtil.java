package com.offcn.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SMSUtil {

	public static void sendSms(String phone,String code){
		 DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIePXGd8GhIwso", "IF5gJDyuXlE4Ji0Z9Y16ntTmqO1DlY");
	        IAcsClient client = new DefaultAcsClient(profile);
	        CommonRequest request = new CommonRequest();
	        //request.setProtocol(ProtocolType.HTTPS);
	        request.setMethod(MethodType.POST);
	        request.setDomain("dysmsapi.aliyuncs.com");
	        request.setVersion("2017-05-25");
	        request.setAction("SendSms");
	        request.putQueryParameter("RegionId", "cn-hangzhou");
	        // 发�?�短�?
	        request.putQueryParameter("PhoneNumbers", phone);
	        request.putQueryParameter("SignName", "���ֹ�");
	        request.putQueryParameter("TemplateCode", "SMS_165418707");
	        request.putQueryParameter("TemplateParam", "{'code':'"+code+"'}");
	        
	        try {
	            CommonResponse response = client.getCommonResponse(request);
	            System.out.println(response.getData());
	        } catch (ServerException e) {
	            e.printStackTrace();
	        } catch (ClientException e) {
	            e.printStackTrace();
	    }
	}
}
