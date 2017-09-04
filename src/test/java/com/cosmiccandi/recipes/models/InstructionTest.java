package com.cosmiccandi.recipes.models;

import static org.assertj.core.api.Assertions.*;
import org.junit.*;
import org.meanbean.test.BeanTester;

public class InstructionTest {

	private Instruction instruction;

	@Before
	public void setup() {
		instruction = new Instruction(2L, "Put some stuff into the pot.");
	}
	
	@Test
	public void testInstruction() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(Instruction.class);
	}
	
	@Test
	public void testAnInstructionHasADescription() {
		assertThat(instruction.getInstructionText()).isNotNull();
		assertThat(instruction.getInstructionText()).isEqualTo("Put some stuff into the pot.");
	}
}
