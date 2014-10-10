package org.tarena.dang.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 读取properties属性文件工具
 * 根据其key值获得其value
 * @author tarena
 *
 */
public class ConfigUtil {
	private static ClassLoader loader;
	private static Properties props=new Properties();
	static{
		loader=ConfigUtil.class.getClassLoader();
		
	}
	/**
	 * 加载指定配置文件
	 * @param configFile
	 * @return Properties
	 * @throws Exception
	 */
	public static Properties loadInput(String configFile)
		throws Exception{
		try {
			InputStream in=loader.getResourceAsStream(configFile);
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("加载配置文件失败！");
		} finally{
			
			return props;
		}
		
	}
	/**
	 * 加载指定配置文件，并根据相应configFile返回相应value
	 * @param configFile
	 * @param key
	 * @return String
	 * @throws Exception
	 */
	public static String getValue(String configFile,String key)
		throws Exception{
		loadInput(configFile);
		String value=props.getProperty(key);
		return value;
	}



}
