package com.cosmiccandi.recipes.models;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class MeasureTest {

	@Test
	public void testMeasure() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(Measure.class);
	}
	
}
