package com.disappearwind.app.util.json;

import com.alibaba.fastjson.JSONObject;
import com.disappearwind.app.Constant;
import com.disappearwind.app.util.json.JSONHelper;

/**
 * 返回客户端的消息封装
 *
 */
public class ResultMsg {
	
	private int status;
	private String msg;
	private Object result;


	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	public ResultMsg(int status, String msg, Object result) {
		super();
		this.status = status;
		this.msg = msg;
		this.result = result;
	}
		
	/**
	 * 返回成功
	 * @param result
	 * @return
	 */
	public static JSONObject resultSuccess(Object result){
		ResultMsg msg = new ResultMsg(Constant.STATUS_SUCCESS,Constant.RESULT_SUCCESS_MSG,result);
		return JSONHelper.toJSONString(msg, new String[]{});
	}
	
	/**
	 * 返回失败
	 * @param result
	 * @return
	 */
	public static JSONObject resultFailed(Object result){
		ResultMsg msg = new ResultMsg(Constant.STATUS_FALIED,Constant.RESULT_FALIED_MSG,result);
		return JSONHelper.toJSONString(msg, new String[]{});
	}
}
