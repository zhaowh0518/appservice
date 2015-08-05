package com.disappearwind.app.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 缓存处理
 * 
 * @author zhaowh
 * @createdate 2015-06-23
 */
@Component
public class CacheUtil {
	@Autowired
	IDataCache cache;

	/**
	 * 设置缓存值
	 * 
	 * @param key
	 *            键
	 * @param exp
	 *            过期时间
	 * @param value
	 *            值
	 */
	public void set(String key, int exp, Object value) {		
		if (null != cache && cache.getUsable()) {
			cache.set(key, exp, value);
		}
	}

	/***
	 * 获取缓存的值
	 * 
	 * @param key
	 *            键
	 * @return
	 */
	public Object get(String key) {
		if (null != cache && cache.getUsable()) {
			return cache.get(key);
		} else {
			return null;
		}
	}

	/**
	 * 删除某项缓存
	 * 
	 * @param key
	 *            键
	 */
	public void delete(String key) {
		if (null != cache && cache.getUsable()) {
			cache.delete(key);
		}
	}
	
}
