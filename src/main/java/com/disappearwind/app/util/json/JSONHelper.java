package com.disappearwind.app.util.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;

/**
 * JSON工具类
 *
 */
public class JSONHelper {
	/**
	 * 转换成JSON字符串
	 * @param data
	 * @param filterProperty
	 * @return
	 */
	public static JSONObject toJSONString(Object data,final String[] filterProperty) {
		PropertyFilter filter = new PropertyFilter() {
			public boolean apply(Object obj, String name, Object value) {
				for(String n : filterProperty) {
					if(n.equals(name)) return false;
				}
				return true;
			}
		};		
		SerializeWriter sw = new SerializeWriter();
		JSONSerializer js = new JSONSerializer(sw);
		js.getPropertyFilters().add(filter);
		js.write(data);		
		return JSONObject.parseObject(sw.toString());
	}
	
	public static void main(String[] args) {
		String haha =  "{\"messageid\":\"89\",\"action\":\"2\",\"args\":{\"userinfoid\":6},\"senderid\":\"57\",\"receiverid\":\"6\",\"msgtype\":\"1\"}";
		JSONObject jsonObject =  JSONHelper.toJSONString(haha, new String[]{});
		System.out.println(JSONObject.toJSONString(jsonObject));
	}
	
}
