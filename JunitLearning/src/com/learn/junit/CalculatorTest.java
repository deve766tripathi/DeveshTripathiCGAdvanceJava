package com.learn.junit;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class CalculatorTest {
  @Test
  void testAdd() {
	  Calculator c=new Calculator();
	  int result =c.add(2, 3);
	  assertEquals(5,result);
  }
  @Test
  void testSub() {
	  Calculator c=new Calculator();
	  int result =c.sub(2, 3);
	  assertEquals(-1,result);
  }
  @Test
  void testMull() {
	  Calculator c=new Calculator();
	  int result =c.mul(2, 3);
	  assertEquals(6,result);
  }
  @Test
  void testDiv() {
	  Calculator c=new Calculator();
	  int result =c.div(6, 3);
	  assertEquals(2,result);
	  //assertTrue(2>2);
  }
  void divideByZero() {
	  Calculator c=new Calculator();
	  assertThrows(IllegalArgumentException.class, () ->{
		  c.div(10,0);
	  });
  }
}
