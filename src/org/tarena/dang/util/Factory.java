package org.tarena.dang.util;


public class Factory {
	/**
	 * 获得指定daoconfig文件中指定dao的实例
	 * @param daoConfig
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static Object getInstance(String daoConfig,String type)
		throws Exception{
		Object obj=null;
		String className=ConfigUtil.getValue(daoConfig, type);
		try {
			obj=Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("实例化类出现问题！");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("实例化类出现问题！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("实例化类出现问题！");
		} finally{
			return obj;
		}
	}
	/**
	 * 获得已指定了的daoconfig文件中指定dao的实例
	 * @param daoConfig
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static Object getInstance(String type)
	throws Exception{
	Object obj=null;
	String className=ConfigUtil.getValue("dao.properties", type);
	try {
		obj=Class.forName(className).newInstance();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new Exception("实例化类出现问题！");
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new Exception("实例化类出现问题！");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new Exception("实例化类出现问题！");
	} finally{
		return obj;
	}
	}



}
