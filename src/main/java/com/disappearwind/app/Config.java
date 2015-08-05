package com.disappearwind.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.disappearwind.app.service.ISysConfigService;
import com.disappearwind.app.model.SysConfig;

/** 
 * @description 系统配置，读取config.properties
 */
@Component
public class Config {
	
	@Autowired
	private  ISysConfigService sysCongfigService;
	private static Map<String, String> sysConfigMap;


	/**
	 * 获取库中相关的配置信息
	 */
	private void getConfigList() {
		List<SysConfig> sysConfigList = sysCongfigService.selectSysConfig();
		if (null == sysConfigMap) {
			sysConfigMap = new HashMap<String, String>();
		}
		for (SysConfig config : sysConfigList) {
			sysConfigMap.put(config.getConfigkey(), config.getConfigvalue());
		}
	}

	/**
	 * 获取配置信息
	 * 
	 * @param key
	 * @return
	 */
	public String getConfig(String key) {
		if (null == sysConfigMap) {
			getConfigList();
		}
		return sysConfigMap.get(key);
	}

	/**
	 * 资源HTTP访问地址
	 */
	public String getServerImageURL() {
		return getConfig("ResourceUrl");
	}
	/**
	 * 资源存储的物理路径
	 * 
	 * @return
	 */
	public String getResourcePath() {
		return getConfig("ResourcePath");
	}

}
