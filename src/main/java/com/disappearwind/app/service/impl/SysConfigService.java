package com.disappearwind.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.disappearwind.app.mapper.SysConfigMapper;
import com.disappearwind.app.model.SysConfig;
import com.disappearwind.app.service.ISysConfigService;

@Service
@Repository
public class SysConfigService implements ISysConfigService {
	
	@Autowired
	private  SysConfigMapper sysConfigMapper;

	@Override
	public List<SysConfig> selectSysConfig() {
		return sysConfigMapper.selectAllSysConfigs();
	}
}
