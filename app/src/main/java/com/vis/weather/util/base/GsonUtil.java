package com.vis.weather.util.base;


import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonUtil {

	// �Ѷ���ת����String����

	public static String ObjectToString(Object obj) {
		String rlt = null;

		Gson gs = new Gson();
		rlt = gs.toJson(obj);
		return rlt;
	}

	public static Object StringToObject(String str, Class<?> cls) {
		Object obj = null;

		Gson gs = new Gson();
		obj = gs.fromJson(str, cls);

		return obj;
	}

	public static Object StringToObject(String str, Type cls) {
		Object obj = null;

		Gson gs = new Gson();
		obj = gs.fromJson(str, cls);

		return obj;
	}

}
