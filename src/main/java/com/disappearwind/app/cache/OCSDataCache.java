package com.disappearwind.app.cache;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.ConnectionFactoryBuilder.Protocol;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;
import net.spy.memcached.internal.OperationFuture;

/***
 * 阿里云的缓存服务
 * 
 * @author zhaowh
 * @createdate 2015-06-23
 */
@Component
public class OCSDataCache implements IDataCache {
	/**
	 * 配置
	 */
	@Autowired
	CacheConfig cacheConfig;

	/**
	 * 缓存
	 */
	static MemcachedClient cache = null;
	
	/***
	 * 缓存是否可用
	 */
	private Boolean usable = false;
	public Boolean getUsable(){
		return usable;
	}
		
	public OCSDataCache() {
		
		
	}
	
	@Override
	public void set(String key, int exp, Object value) {
		try {
			OperationFuture future = cache.set(key, exp, value);
			future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object get(String key) {
		return cache.get(key);
	}

	@Override
	public void delete(String key) {
		cache.delete(key);
	}

	@Override
	public void deleteAll() {
		cache.delete(CacheConfig.KEY_CLIENTVERSION);
		cache.delete(CacheConfig.KEY_DATAVERSION);
		cache.delete(CacheConfig.KEY_EXPLORE);
		cache.delete(CacheConfig.KEY_GREATUSERLIST);
		cache.delete(CacheConfig.KEY_LABELS);
	}

	@PostConstruct
	public void init() {
		try {
			System.out.println("begin init cache server..");
			if (cache == null && null != cacheConfig && cacheConfig.getEnable()) {
				System.out.println("host=" + cacheConfig.getHost());
				AuthDescriptor ad = new AuthDescriptor(
						new String[] { "PLAIN" }, new PlainCallbackHandler(
								cacheConfig.getUserName(), cacheConfig.getPassword()));
				cache = new MemcachedClient(new ConnectionFactoryBuilder()
						.setProtocol(Protocol.BINARY).setAuthDescriptor(ad)
						.build(), AddrUtil.getAddresses(cacheConfig.getHost() + ":" + cacheConfig.getPort()));
				System.out.println("init cache server successfully!");				
			}else{
				System.out.println("cache server is not available!");
				usable = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
