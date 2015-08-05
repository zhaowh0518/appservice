package com.disappearwind.app.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CacheConfig {
	/**
	 * 长缓存过期时间，1天
	 */
	public static final int EXP_LONG = 3600*24;
	/**
	 * 短缓存过期时间：1s
	 */
	public static final int EXP_SHORT = 60;
	
	/**
	 * key:客户端版本
	 */
	public static final String KEY_CLIENTVERSION = "clientversion";
	/**
	 * key:首页版本
	 */
	public static final String KEY_DATAVERSION = "dataversion";
	/**
	 * key:专题数据，以topic_开头，比如首页为topic_index
	 */
	public static final String KEY_TOPIC = "topic_";
	/**
	 * key:标签墙
	 */
	public static final String KEY_LABELS = "lables";
	/***
	 * key：随便看看
	 */
	public static final String KEY_EXPLORE = "explore";
	/**
	 * key：循迹人
	 */
	public static final String KEY_GREATUSERLIST = "greatuserlist";
	
	/***
	 * 是否允许缓存
	 */
	@Value("${cache.enable}")
	String enable;
	public Boolean getEnable(){
		return enable != null && enable.equals("true");
	}
	/***
	 * 控制台上的“内网地址”
	 */
	@Value("${cache.host}")
	String host;
	public String getHost(){
		return host;
	}
	/***
	 * 默认端口 11211，不用改
	 */
	@Value("${cache.port}")
	String port;
	public String getPort(){
		return port;
	}
	/***
	 * 控制台上的“访问账号“
	 */
	@Value("${cache.username}")
	String username;
	public String getUserName(){
		return username;
	}
	/***
	 * 邮件或短信中提供的“密码”
	 */
	@Value("${cache.password}")
	String password;
	public String getPassword(){
		return password;
	}
}
