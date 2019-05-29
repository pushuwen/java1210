package com.offcn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.offcn.utils.SMSUtil;

@Component
public class MyConsumer {

	
	// 系统自带的mq接收消息
//	public void getMst(String text){
//		System.out.println(text);
//	}
	
	@JmsListener(destination="sms")
	public void getMsg(String json){
		List<Object> list = JSON.parseArray(json);
		String phone = (String) list.get(0);
		String code = (String) list.get(1);
		SMSUtil.sendSms(phone, code);
	}
	
}
