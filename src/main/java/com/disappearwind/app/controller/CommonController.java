package com.disappearwind.app.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.disappearwind.app.Config;
import com.disappearwind.app.Constant;
import com.disappearwind.app.model.AppUser;
import com.disappearwind.app.model.AppVersion;
import com.disappearwind.app.service.IAppUserService;
import com.disappearwind.app.service.IAppVersionService;
import com.disappearwind.app.util.json.ResultMsg;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/common")
public class CommonController {
	@Autowired
	private IAppUserService appUserService;
	@Autowired
	private IAppVersionService appVersionService;
	@Autowired
	private Config config;

	
	Logger logger = Logger.getLogger(CommonController.class);

	/*
	 * 客户端加载 1. 首次打开客户端的注册 2. 取最新客户端的版本信息 3. 账号密码的登录 4. 首页的数据版本
	 */
	@RequestMapping("/load")
	@ResponseBody
	public JSONObject load(HttpServletRequest request) {
		logger.info("CommonController/load"+request);
		try {
			// 接收客户端的参数
			String version = request.getParameter("version");
			String apptoken = request.getParameter("apptoken");
			@SuppressWarnings("unused")
			String net = request.getParameter("net");
			String imei = request.getParameter("imei");
			String model = request.getParameter("model");
			String os = request.getParameter("os");
			String resolution = request.getParameter("resolution");
			String jailbroken = request.getParameter("jailbroken");
			String appuserid = request.getParameter("appuserid");
			
			int userinfoid = -1;
			/*
			if(!StringUtil.isNullOrEmpty(request.getParameter("userinfoid"))){
				userinfoid = Integer.valueOf(request.getParameter("userinfoid"));
			}
			*/

			// 根据imei是否在库判断用户是否是首次使用客户端
			if (StringUtils.isNullOrEmpty(appuserid)) {
				Integer appUserID = appUserService.getAppUserID(imei);
				if (null != appUserID) {
					appuserid = String.valueOf(appUserID);
				}
			}
			// 对首次使用客户端的用户做设备注册，得到设备的唯一id：appuserid
			if (StringUtils.isNullOrEmpty(appuserid)||appuserid.equals("-1")) {
				AppUser user = new AppUser();
				user.setApptoken(apptoken);
				user.setAppversion(version);
				user.setCreatedate(new Date());
				user.setDevicemodel(model);
				user.setDevicenum(imei);
				user.setDeviceresolution(resolution);
				user.setJailbroken(Boolean.valueOf(jailbroken));
				user.setOsversion(os);

				appuserid = String.valueOf(appUserService.AddAppUser(user));
			}
			
			// 获取客户端的版本号
			AppVersion appVersion = appVersionService.getAppVersion(apptoken);

			String sid = RandomStringUtils.randomAlphanumeric(Constant.SID_LENGTH);
			// 构造返回的数据
			Map<String,Object> result = new HashMap<String,Object>();
			result.put("appuserid", appuserid);
			result.put("userinfoid", userinfoid);
			result.put("sid", sid);
			if (null != appVersion) {
				result.put("appversion", appVersion.getClientversion());
				result.put("versiontype", appVersion.getType());
				result.put("versionurl", appVersion.getUrl());
			}

			//媒体资源的相对地址
			result.put("serverimageurl", config.getServerImageURL());
			return ResultMsg.resultSuccess(result);
		} catch (Exception ex) {
			logger.info("CommonController/load : "+ex.getMessage());
			ex.printStackTrace();
			return ResultMsg.resultFailed(ex);
		}
	}

	/*
	 * 
	 */
	@RequestMapping("/index")
	@ResponseBody
	public JSONObject index(HttpServletRequest request) {
		try {
			Map<String,Object> result = new HashMap<String, Object>();
			return ResultMsg.resultSuccess(result);
		} catch (Exception ex) {
			logger.info("CommonController/index : "+ex.getMessage());
			ex.printStackTrace();
			return ResultMsg.resultFailed(ex);
		}
	}	
}
