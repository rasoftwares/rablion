package com.ra.test.util;

import java.lang.reflect.Method;
import java.sql.Date;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/*
 * 1. Create Domain Entities dynamically based on the class name
 * 2. Populate dummy data into the dynamic class from external data file 
*/

public class EntityFactory {
	
	public static Logger logger = LogManager.getLogger(EntityFactory.class);
	
	public static EntityFactory ef = new EntityFactory();
	private boolean setAttributes = false;
	
	
	public static Object getDomainEntityforClass(Class obj, boolean setAttributes){
		ef.setAttributes = setAttributes;
		
		Object entity = null;
		logger.debug("Fetching Entity for class " + obj.getName());
		try {
			entity = ef.getEntity(obj);
		} catch (Exception e) {
			logger.error("Could not fetch entity for the expected class " + obj.getName());
			e.printStackTrace();
		}
		return entity;
		
		
	}
	
	// Create and return a domain entity for the requested class
	public static Object getDomainEntityforClass(Class obj) {
		
		return getDomainEntityforClass(obj, true);
	}

	public Object getEntity(Class cls) throws Exception {
		
		Object o = cls.newInstance();
		// System.out.println( "==> " + o.getClass().getName());
		Class c = o.getClass();
		Method[] methods = c.getMethods();
		for (Method method : methods) {
			logger.trace("Property - setattributes : " + setAttributes);
			if(setAttributes && method.getName().startsWith("set") != method.getName().startsWith("setId")) {
				logger.trace("Invoking Method :" + method.getName() + method.getParameterTypes());
				method.invoke(o, getParamValues(method.getParameterTypes()));
			}
		}
		return o;
	}
	
	 /*
	  * get ParamValues - dynamically identifies parameter type and populates the dummy value for the same
	  */
	
	public Object[] getParamValues(Class cls[]) {
		int index = 0;
		Object[] retVal = new Object[cls.length];
		//System.out.println("cls.length" + cls[0]);
		for (int i = 0; i < cls.length; i++) {
			retVal[index++] = getDummyValues(cls[i].getSimpleName());
		}
		return retVal;
	}

	public Object getDummyValues(String type) {
		Object retVal = null;
		switch (type) {
		case "String":
			retVal = new String("");
			break;
		case "Long":
			retVal = new Long(1L);
			break;
		case "Double":
			retVal = new Double(1D);
			break;
		case "boolean":
			retVal = false;
			break;	
		case "Date":
			retVal = new Date(System.currentTimeMillis());
			break;
		default:
			retVal = "";
			break;
		}
		
		return retVal;
	}

	public static void main(String[] args) {
		System.out.println("A-------");

	}

}
