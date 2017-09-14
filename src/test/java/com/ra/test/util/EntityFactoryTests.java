package com.ra.test.util;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.ra.domain.BaseEntity;
import com.ra.util.GlobalConstants;



public class EntityFactoryTests {
	
	public static Logger logger = LogManager.getLogger(EntityFactoryTests.class);
	
	/*
	 * Unit test EntityFactory class.
	 * Configure and test all of the entity objects
	 */
	@Test
	public void testGetDomainEntityForClass() {
		for(int i=0;i<GlobalConstants.clsArray.length;i++) {
			Class c = GlobalConstants.clsArray[i];
			logger.trace("" + c.getName() + ":" + c.getSimpleName());
			Object retObject = EntityFactory.getDomainEntityforClass(c);
			assertEquals(c.getName(), retObject.getClass().getName());
		}
	}
	
	@Test
	public void testGetDomainEntityForClassWithoutValues() {
		for(int i=0;i<GlobalConstants.clsArray.length;i++) {
			Class c = GlobalConstants.clsArray[i];
			Object retObject = EntityFactory.getDomainEntityforClass(c, false);
			assertEquals(c.getName(), retObject.getClass().getName());
			assertEquals(null, ((BaseEntity)retObject).getCreatedby());
			assertEquals(null, ((BaseEntity)retObject).getCreatedtimestamp());
			
		}
	}
	

}
