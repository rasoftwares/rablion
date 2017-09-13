package com.ra.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;




public class BaseEntity {
	
	
	
	public static Logger logger = LogManager.getLogger(BaseEntity.class);
	
	public BaseEntity(){
		
	}
	
	
	
		
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
		
	}
}
