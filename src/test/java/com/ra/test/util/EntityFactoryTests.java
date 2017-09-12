package com.ra.test.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ra.domain.Catalog;
import com.ra.domain.Currency;
import com.ra.domain.Customer;
import com.ra.domain.Discount;
import com.ra.domain.Expense;
import com.ra.domain.Inventory;
import com.ra.domain.Payment;
import com.ra.domain.User;



public class EntityFactoryTests {

	/*
	 * Unit test EntityFactory class.
	 * Configure and test all of the entity objects
	 */
	@Test
	public void testGetDomainEntityForClass() {
		
		Class[] clsArray = {User.class, Catalog.class,Inventory.class, Expense.class, Payment.class, Discount.class, Currency.class, Customer.class };
		
		for(int i=0;i<clsArray.length;i++){
			Class c = clsArray[i];
			Object retObject = EntityFactory.getDomainEntityforClass(c);
			assertEquals(c.getClass().getName(), retObject.getClass().getName());
			
		}
	}

}
