package com.disappearwind.app.cache;

/***
 * 缓存接口
 * @author zhaowh
 * @createdate 2015-06-23
 */
public interface IDataCache {
	/**
	 * 设置缓存值
	 * @param key 键
	 * @param exp 过期时间
	 * @param value 值
	 */
	void set(String key, int exp, Object value);
	/***
	 * 获取缓存的值
	 * @param key 键
	 * @return
	 */
	Object get(String key);
	/**
	 * 删除某项缓存
	 * @param key 键
	 */
	void delete(String key);
	/**
	 * 删除所有缓存
	 */
	void deleteAll();
	/**
	 * 校验缓存是否可用
	 * @return
	 */
	Boolean getUsable();
}
