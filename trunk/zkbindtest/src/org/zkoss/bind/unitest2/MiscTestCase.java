package org.zkoss.bind.unitest2;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zktc.core.junit.TestCaseBase;
import org.zkoss.zktc.core.widget.Widget;
import org.zkoss.zktc.core.widget.WidgetDriver;
/**
 * 
 * @author dennis
 *
 */
public class MiscTestCase extends TestCaseBase{

	@Test
	public void testArgs(){
		navigate(getTestCaseUrl("/bind/basic/args.zul"));
		
		Assert.assertEquals("A-Arg1",findWidget("$l1").getValue());
		Assert.assertEquals("B-myarg1",findWidget("$l2").getValue());
		Assert.assertEquals("A-Arg1",findWidget("$t1").getValue());
		Assert.assertEquals("B-myarg1",findWidget("$t2").getValue());
		
		findWidget("$t1").clear().keys("X").tab();
		Assert.assertEquals("X-Arg2-Arg1",findWidget("$l1").getValue());
		Assert.assertEquals("B-myarg1",findWidget("$l2").getValue());
		Assert.assertEquals("X-Arg2-Arg1",findWidget("$t1").getValue());
		Assert.assertEquals("B-myarg1",findWidget("$t2").getValue());
		
		findWidget("$t2").clear().keys("Y").tab();
		Assert.assertEquals("X-Arg2-Arg1",findWidget("$l1").getValue());
		Assert.assertEquals("Y-myarg2-myarg1",findWidget("$l2").getValue());
		Assert.assertEquals("X-Arg2-Arg1",findWidget("$t1").getValue());
		Assert.assertEquals("Y-myarg2-myarg1",findWidget("$t2").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("X-Arg2Dennis-Arg1",findWidget("$l1").getValue());
		Assert.assertEquals("Y-myarg2Chen-myarg1",findWidget("$l2").getValue());
		Assert.assertEquals("X-Arg2Dennis-Arg1",findWidget("$t1").getValue());
		Assert.assertEquals("Y-myarg2Chen-myarg1",findWidget("$t2").getValue());
		
		findWidget("$t3").clear().keys("ABC").tab();
		Assert.assertEquals("value have to equals V1",findWidget("$l3").getValue());
		findWidget("$t3").clear().keys("V1").tab();
		Assert.assertEquals("",findWidget("$l3").getValue());
		Assert.assertEquals("V1-Arg1",findWidget("$l1").getValue());
		
		findWidget("$t4").clear().keys("ABC").tab();
		Assert.assertEquals("",findWidget("$l4").getValue());
		findWidget("$btn2").click();
		Assert.assertEquals("value have to equals V2",findWidget("$l4").getValue());
		Assert.assertEquals("V1",findWidget("$t3").getValue());
		
		findWidget("$t4").clear().keys("V2").tab();
		findWidget("$btn2").click();
		Assert.assertEquals("execute cmd2",findWidget("$l4").getValue());
		Assert.assertEquals("V2-Arg1",findWidget("$l1").getValue());
		Assert.assertEquals("V2",findWidget("$t3").getValue());
		
		
	}
	@Test
	public void testVMInit(){
		navigate(getTestCaseUrl("/bind/basic/vm-init.zul"));
		
		Assert.assertEquals("AA",findWidget("$vm1_l1").getValue());
		Assert.assertEquals("V1-AA",findWidget("$vm1_t1").getValue());
		Assert.assertEquals("V1-AA",findWidget("$vm1_l2").getValue());
		Assert.assertEquals("V2",findWidget("$vm1_l3").getValue());
		
		findWidget("$vm1_t1").clear().keys("OO").tab();
		Assert.assertEquals("OO-AA",findWidget("$vm1_t1").getValue());
		Assert.assertEquals("OO-AA",findWidget("$vm1_l2").getValue());
		Assert.assertEquals("V2",findWidget("$vm1_l3").getValue());
		
		findWidget("$vm1_btn").click();
		Assert.assertEquals("OO-AA",findWidget("$vm1_t1").getValue());
		Assert.assertEquals("OO-AA",findWidget("$vm1_l2").getValue());
		Assert.assertEquals("do command1 AA",findWidget("$vm1_l3").getValue());
		
		//vm2
		Assert.assertEquals("BB",findWidget("$vm2_l1").getValue());
		Assert.assertEquals("V1-BB",findWidget("$vm2_t1").getValue());
		Assert.assertEquals("V1-BB",findWidget("$vm2_l2").getValue());
		Assert.assertEquals("V2",findWidget("$vm2_l3").getValue());
		
		findWidget("$vm2_t1").clear().keys("OO").tab();
		Assert.assertEquals("OO-BB",findWidget("$vm2_t1").getValue());
		Assert.assertEquals("OO-BB",findWidget("$vm2_l2").getValue());
		Assert.assertEquals("V2",findWidget("$vm2_l3").getValue());
		
		findWidget("$vm2_btn").click();
		Assert.assertEquals("OO-BB",findWidget("$vm2_t1").getValue());
		Assert.assertEquals("OO-BB",findWidget("$vm2_l2").getValue());
		Assert.assertEquals("do command1 BB",findWidget("$vm2_l3").getValue());
		
		//vm3
		Assert.assertEquals("CC",findWidget("$vm3_l1").getValue());
		Assert.assertEquals("V1-CC",findWidget("$vm3_t1").getValue());
		Assert.assertEquals("V1-CC",findWidget("$vm3_l2").getValue());
		Assert.assertEquals("V2",findWidget("$vm3_l3").getValue());
		
		findWidget("$vm3_t1").clear().keys("OO").tab();
		Assert.assertEquals("OO-CC",findWidget("$vm3_t1").getValue());
		Assert.assertEquals("OO-CC",findWidget("$vm3_l2").getValue());
		Assert.assertEquals("V2",findWidget("$vm3_l3").getValue());
		
		findWidget("$vm3_btn").click();
		Assert.assertEquals("OO-CC",findWidget("$vm3_t1").getValue());
		Assert.assertEquals("OO-CC",findWidget("$vm3_l2").getValue());
		Assert.assertEquals("do command1 CC",findWidget("$vm3_l3").getValue());
		
		//vm4
		Assert.assertEquals("XX",findWidget("$vm4_l1").getValue());
		Assert.assertEquals("V1-XX",findWidget("$vm4_t1").getValue());
		Assert.assertEquals("V1-XX",findWidget("$vm4_l2").getValue());
		Assert.assertEquals("V2",findWidget("$vm4_l3").getValue());
		
		findWidget("$vm4_t1").clear().keys("OO").tab();
		Assert.assertEquals("OO-XX",findWidget("$vm4_t1").getValue());
		Assert.assertEquals("OO-XX",findWidget("$vm4_l2").getValue());
		Assert.assertEquals("V2",findWidget("$vm4_l3").getValue());
		
		findWidget("$vm4_btn").click();
		Assert.assertEquals("OO-XX",findWidget("$vm4_t1").getValue());
		Assert.assertEquals("OO-XX",findWidget("$vm4_l2").getValue());
		Assert.assertEquals("do command1 XX",findWidget("$vm4_l3").getValue());
	}
	
	@Test
	public void testCommandIndirect(){
		navigate(getTestCaseUrl("/bind/basic/command-indirect.zul"));
		
		Assert.assertEquals("no-command",findWidget("$l1").getValue());
		
		findWidget("$btn1").click();
		Assert.assertEquals("by command1",findWidget("$l1").getValue());
		findWidget("$btn1").click();
		Assert.assertEquals("by command1",findWidget("$l1").getValue());
		
		findWidget("$cb1").click();
		
		findWidget("$btn1").click();
		Assert.assertEquals("by command2",findWidget("$l1").getValue());
		findWidget("$btn1").click();
		Assert.assertEquals("by command2",findWidget("$l1").getValue());
		
		findWidget("$cb1").click();
		
		findWidget("$btn1").click();
		Assert.assertEquals("by command1",findWidget("$l1").getValue());
		findWidget("$btn1").click();
		Assert.assertEquals("by command1",findWidget("$l1").getValue());
		
	}
	
	@Test
	public void testMVP2MVVM(){
		navigate(getTestCaseUrl("/bind/basic/mvp2mvvm_mvp.zul"));
		
		Assert.assertEquals(true,findWidget("$textA").getAttribute("disabled"));
		findWidget("$outerToggle1").click();
		Assert.assertEquals(false,findWidget("$textA").getAttribute("disabled"));
		findWidget("$outerToggle2").click();
		Assert.assertEquals(true,findWidget("$textA").getAttribute("disabled"));
		findWidget("$innerToggle").click();
		Assert.assertEquals(false,findWidget("$textA").getAttribute("disabled"));
	}
	
	@Test
	public void testFunction(){
		navigate(getTestCaseUrl("/bind/basic/function.zul"));
		
		Assert.assertEquals("foo",findWidget("$l11").getValue());
		Assert.assertEquals("foo",findWidget("$l12").getValue());
		Assert.assertEquals("foo:2bar",findWidget("$l13").getValue());
		Assert.assertEquals("foo:foo:b",findWidget("$l14").getValue());
		
		findWidget("$cmd1").click();
		Assert.assertEquals("foo0",findWidget("$l11").getValue());
		Assert.assertEquals("foo0",findWidget("$l12").getValue());
		Assert.assertEquals("foo:2bar",findWidget("$l13").getValue());
		Assert.assertEquals("foo0:foo0:b",findWidget("$l14").getValue());
		
		findWidget("$cmd2").click();
		Assert.assertEquals("foo1",findWidget("$l11").getValue());
		Assert.assertEquals("foo1",findWidget("$l12").getValue());
		Assert.assertEquals("foo1:2bar",findWidget("$l13").getValue());
		Assert.assertEquals("foo1:foo1:b",findWidget("$l14").getValue());
		
		findWidget("$cmd3").click();
		Assert.assertEquals("foo1",findWidget("$l11").getValue());
		Assert.assertEquals("foo1",findWidget("$l12").getValue());
		Assert.assertEquals("foo1:2bar",findWidget("$l13").getValue());
		Assert.assertEquals("foo2:foo2:b",findWidget("$l14").getValue());
	}
	
	@Test
	public void testDeferInit(){
		navigate(getTestCaseUrl("/bind/basic/deferinit.zul"));
		
		
		Widget w1 = findWidget("$w1");
		Widget w2 = findWidget("$w2");
		
		Widget w1l11 = w1.findWidget("$l11");
		Widget w1l12 = w1.findWidget("$l12");
		Widget w1t11 = w1.findWidget("$t11");
		Widget w1btn11 = w1.findWidget("$btn11");
		Widget w1btn12 = w1.findWidget("$btn12");
		Widget w1btn13 = w1.findWidget("$btn13");
		Widget w1l21 = w1.findWidget("$l21");
		Widget w1t21 = w1.findWidget("$t21");
		Widget w1btn21 = w1.findWidget("$btn21");
		
		
		Widget w2l11 = w2.findWidget("$l11");
		Widget w2l12 = w2.findWidget("$l12");
		Widget w2t11 = w2.findWidget("$t11");
		Widget w2btn11 = w2.findWidget("$btn11");
		Widget w2btn12 = w2.findWidget("$btn12");
		Widget w2btn13 = w2.findWidget("$btn13");
		Widget w2l21 = w2.findWidget("$l21");
		Widget w2t21 = w2.findWidget("$t21");
		Widget w2btn21 = w2.findWidget("$btn21");
		
		
		Assert.assertEquals("A", w1l11.getValue());
		Assert.assertEquals("B", w1l12.getValue());
		Assert.assertEquals("B", w1t11.getValue());
		Assert.assertEquals("C:byForm", w1l21.getValue());
		Assert.assertEquals("C:byForm", w1t21.getValue());
		
		Assert.assertEquals("X", w2l11.getValue());
		Assert.assertEquals("Y", w2l12.getValue());
		Assert.assertEquals("Y", w2t11.getValue());
		Assert.assertEquals("Z:byForm", w2l21.getValue());
		Assert.assertEquals("Z:byForm", w2t21.getValue());
		
		w1t11.replace("DD").tab();
		Assert.assertEquals("A", w1l11.getValue());
		Assert.assertEquals("DD", w1l12.getValue());
		Assert.assertEquals("DD", w1t11.getValue());
		Assert.assertEquals("C:byForm", w1l21.getValue());
		Assert.assertEquals("C:byForm", w1t21.getValue());
		Assert.assertEquals("X", w2l11.getValue());
		Assert.assertEquals("Y", w2l12.getValue());
		Assert.assertEquals("Y", w2t11.getValue());
		Assert.assertEquals("Z:byForm", w2l21.getValue());
		Assert.assertEquals("Z:byForm", w2t21.getValue());
		
		w1btn11.click();
		Assert.assertEquals("DD:cmd1", w1l11.getValue());
		Assert.assertEquals("DD:cmd1", w1l12.getValue());
		Assert.assertEquals("DD:cmd1", w1t11.getValue());
		Assert.assertEquals("C:byForm", w1l21.getValue());
		Assert.assertEquals("C:byForm", w1t21.getValue());
		Assert.assertEquals("X", w2l11.getValue());
		Assert.assertEquals("Y", w2l12.getValue());
		Assert.assertEquals("Y", w2t11.getValue());
		Assert.assertEquals("Z:byForm", w2l21.getValue());
		Assert.assertEquals("Z:byForm", w2t21.getValue());
		
		w1btn12.click();
		Assert.assertEquals("DD:cmd1", w1l11.getValue());
		Assert.assertEquals("DD:cmd1", w1l12.getValue());
		Assert.assertEquals("DD:cmd1", w1t11.getValue());
		Assert.assertEquals("C:cmd2:byForm", w1l21.getValue());
		Assert.assertEquals("C:cmd2:byForm", w1t21.getValue());
		Assert.assertEquals("X", w2l11.getValue());
		Assert.assertEquals("Y", w2l12.getValue());
		Assert.assertEquals("Y", w2t11.getValue());
		Assert.assertEquals("Z:byForm", w2l21.getValue());
		Assert.assertEquals("Z:byForm", w2t21.getValue());
		
		w1btn13.click();
		Assert.assertEquals("DD:cmd1", w1l11.getValue());
		Assert.assertEquals("DD:cmd1", w1l12.getValue());
		Assert.assertEquals("DD:cmd1", w1t11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1l21.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1t21.getValue());
		Assert.assertEquals("X", w2l11.getValue());
		Assert.assertEquals("Y", w2l12.getValue());
		Assert.assertEquals("Y", w2t11.getValue());
		Assert.assertEquals("Z:byForm", w2l21.getValue());
		Assert.assertEquals("Z:byForm", w2t21.getValue());
		
		w1btn21.click();
		Assert.assertEquals("DD:cmd1", w1l11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1l21.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1t21.getValue());
		Assert.assertEquals("X", w2l11.getValue());
		Assert.assertEquals("Y", w2l12.getValue());
		Assert.assertEquals("Y", w2t11.getValue());
		Assert.assertEquals("Z:byForm", w2l21.getValue());
		Assert.assertEquals("Z:byForm", w2t21.getValue());
		
		//test defer
		
		w2t11.replace("GG").tab();
		Assert.assertEquals("DD:cmd1", w1l11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1l21.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1t21.getValue());
		Assert.assertEquals("X", w2l11.getValue());
		Assert.assertEquals("GG", w2l12.getValue());
		Assert.assertEquals("GG", w2t11.getValue());
		Assert.assertEquals("Z:byForm", w2l21.getValue());
		Assert.assertEquals("Z:byForm", w2t21.getValue());
		
		
		w2btn11.click();
		Assert.assertEquals("DD:cmd1", w1l11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1l21.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1t21.getValue());
		Assert.assertEquals("GG:cmd1", w2l11.getValue());
		Assert.assertEquals("GG:cmd1", w2l12.getValue());
		Assert.assertEquals("GG:cmd1", w2t11.getValue());
		Assert.assertEquals("Z:byForm", w2l21.getValue());
		Assert.assertEquals("Z:byForm", w2t21.getValue());
		
		w2btn12.click();
		Assert.assertEquals("DD:cmd1", w1l11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1l21.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1t21.getValue());
		Assert.assertEquals("GG:cmd1", w2l11.getValue());
		Assert.assertEquals("GG:cmd1", w2l12.getValue());
		Assert.assertEquals("GG:cmd1", w2t11.getValue());
		Assert.assertEquals("Z:cmd2:byForm", w2l21.getValue());
		Assert.assertEquals("Z:cmd2:byForm", w2t21.getValue());
		
		w2btn13.click();
		Assert.assertEquals("DD:cmd1", w1l11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1l21.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1t21.getValue());
		Assert.assertEquals("GG:cmd1", w2l11.getValue());
		Assert.assertEquals("GG:cmd1", w2l12.getValue());
		Assert.assertEquals("GG:cmd1", w2t11.getValue());
		Assert.assertEquals("Z:cmd2:cmd3:byForm", w2l21.getValue());
		Assert.assertEquals("Z:cmd2:cmd3:byForm", w2t21.getValue());
		
		w2btn21.click();
		Assert.assertEquals("DD:cmd1", w1l11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1l12.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm:cmd4", w1t11.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1l21.getValue());
		Assert.assertEquals("C:cmd2:cmd3:byForm", w1t21.getValue());
		Assert.assertEquals("GG:cmd1", w2l11.getValue());
		Assert.assertEquals("Z:cmd2:cmd3:byForm:cmd4", w2l12.getValue());
		Assert.assertEquals("Z:cmd2:cmd3:byForm:cmd4", w2t11.getValue());
		Assert.assertEquals("Z:cmd2:cmd3:byForm", w2l21.getValue());
		Assert.assertEquals("Z:cmd2:cmd3:byForm", w2t21.getValue());
	}
	
	@Test
	public void testValidationMessages(){
		navigate(getTestCaseUrl("/bind/basic/validationmessages.zul"));
		Widget l11 = findWidget("$l11");
		Widget l12 = findWidget("$l12");
		
		Widget t21 = findWidget("$t21");
		Widget t22 = findWidget("$t22");
		
		Widget t31 = findWidget("$t31");
		Widget t32 = findWidget("$t32");
		Widget m31 = findWidget("$m31");
		Widget m32 = findWidget("$m32");
		
		Widget btn1 = findWidget("$btn1");
		
		Widget t41 = findWidget("$t41");
		Widget t42 = findWidget("$t42");
		Widget m41 = findWidget("$m41");
		Widget m42 = findWidget("$m42");
		Widget m43 = findWidget("$m43");
		Widget m44 = findWidget("$m44");
		Widget m45 = findWidget("$m45");
		Widget m46 = findWidget("$m46");
		
		Widget btn2 = findWidget("$btn2");
		Widget btn3 = findWidget("$btn3");
		
		Assert.assertEquals("ABC", l11.getValue());
		Assert.assertEquals("10", l12.getValue());
		
		Assert.assertEquals("ABC", t21.getValue());
		Assert.assertEquals(10L, t22.getValue());
		
		Assert.assertEquals("ABC", t31.getValue());
		Assert.assertEquals(10L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		t21.replace("ABCD").tab().focus(1,1000);
		t22.replace("6").tab().focus(1,1000);
		Assert.assertEquals("ABC", l11.getValue());
		
		Assert.assertEquals("10", l12.getValue());
		
		Assert.assertEquals("ABCD", t21.getValue());
		Assert.assertEquals(6L, t22.getValue());
		Assert.assertEquals("ABC", t31.getValue());
		Assert.assertEquals(10L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		
		t21.replace("Abc").tab().focus(1,1000);
		t22.replace("33").tab().focus(1,1000);//intbox has reset issue...too bad
		Assert.assertEquals("Abc", l11.getValue());
		
		Assert.assertEquals("33", l12.getValue());
		
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("Abc", t31.getValue());
		Assert.assertEquals(33L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		
		t31.replace("XXX").tab().focus(0,0);
		t32.replace("1").tab().focus(0,0);//intbox has reset issue...too bad
		Assert.assertEquals("Abc", l11.getValue());
		Assert.assertEquals("33", l12.getValue());
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("XXX", t31.getValue());
		Assert.assertEquals(1L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		btn1.click();
		Assert.assertEquals("Abc", l11.getValue());
		Assert.assertEquals("33", l12.getValue());
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("XXX", t31.getValue());
		Assert.assertEquals(1L, t32.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is XXX", m31.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 1", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		t32.replace("55").tab().focus(0,0);//intbox has reset issue...too bad
		Assert.assertEquals("Abc", l11.getValue());
		Assert.assertEquals("33", l12.getValue());
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("XXX", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is XXX", m31.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 1", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		btn1.click();
		Assert.assertEquals("Abc", l11.getValue());
		Assert.assertEquals("33", l12.getValue());
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("XXX", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is XXX", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		t31.replace("aBC").tab().focus(0,0);//intbox has reset issue...too bad
		Assert.assertEquals("Abc", l11.getValue());
		Assert.assertEquals("33", l12.getValue());
		Assert.assertEquals("Abc", t21.getValue());
		Assert.assertEquals(33L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is XXX", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		btn1.click();
		Assert.assertEquals("aBC", l11.getValue());
		Assert.assertEquals("55", l12.getValue());
		Assert.assertEquals("aBC", t21.getValue());
		Assert.assertEquals(55L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("ABC", t41.getValue());
		Assert.assertEquals(10L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		/////////
		
		t41.replace("YYY").tab().focus(0,0);
		t42.replace("1999").tab().focus(0,0);//intbox has reset issue...too bad
		Assert.assertEquals("aBC", l11.getValue());
		Assert.assertEquals("55", l12.getValue());
		Assert.assertEquals("aBC", t21.getValue());
		Assert.assertEquals(55L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("YYY", t41.getValue());
		Assert.assertEquals(1999L, t42.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is YYY", m41.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 1999", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		btn2.click();
		Assert.assertEquals("aBC", l11.getValue());
		Assert.assertEquals("55", l12.getValue());
		Assert.assertEquals("aBC", t21.getValue());
		Assert.assertEquals(55L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("YYY", t41.getValue());
		Assert.assertEquals(1999L, t42.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is YYY", m41.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 1999", m42.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m43.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m44.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m45.getValue());
		Assert.assertEquals("extra validation info ABC", m46.getValue());
		
		
		t41.replace("abc").tab().focus(0,0);
		t42.replace("77").tab().focus(0,0);//intbox has reset issue...too bad
		Assert.assertEquals("aBC", l11.getValue());
		Assert.assertEquals("55", l12.getValue());
		Assert.assertEquals("aBC", t21.getValue());
		Assert.assertEquals(55L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("abc", t41.getValue());
		Assert.assertEquals(77L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m43.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m44.getValue());
		Assert.assertEquals("value must equals 'AbC', but is ABC", m45.getValue());
		Assert.assertEquals("extra validation info ABC", m46.getValue());
		
		btn2.click();
		Assert.assertEquals("aBC", l11.getValue());
		Assert.assertEquals("55", l12.getValue());
		Assert.assertEquals("aBC", t21.getValue());
		Assert.assertEquals(55L, t22.getValue());
		Assert.assertEquals("aBC", t31.getValue());
		Assert.assertEquals(55L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("abc", t41.getValue());
		Assert.assertEquals(77L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("value must equals 'AbC', but is abc", m43.getValue());
		Assert.assertEquals("value must equals 'AbC', but is abc", m44.getValue());
		Assert.assertEquals("value must equals 'AbC', but is abc", m45.getValue());
		Assert.assertEquals("extra validation info abc", m46.getValue());
		
		t41.replace("AbC").tab().focus(0,0);
		btn2.click();
		Assert.assertEquals("AbC", l11.getValue());
		Assert.assertEquals("77", l12.getValue());
		Assert.assertEquals("AbC", t21.getValue());
		Assert.assertEquals(77L, t22.getValue());
		Assert.assertEquals("AbC", t31.getValue());
		Assert.assertEquals(77L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("", m32.getValue());
		Assert.assertEquals("AbC", t41.getValue());
		Assert.assertEquals(77L, t42.getValue());
		Assert.assertEquals("", m41.getValue());
		Assert.assertEquals("", m42.getValue());
		Assert.assertEquals("", m43.getValue());
		Assert.assertEquals("", m44.getValue());
		
		
		t31.replace("YYY").tab().focus(0,0);
		t32.replace("2").tab().focus(0,0);//intbox has reset issue...too bad
		btn1.click();
		Assert.assertEquals("YYY", t31.getValue());
		Assert.assertEquals(2L, t32.getValue());
		Assert.assertEquals("value must equals ignore case 'abc', but is YYY", m31.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 2", m32.getValue());
		
		btn3.click();
		Assert.assertEquals("AbC", t31.getValue());
		Assert.assertEquals(2L, t32.getValue());
		Assert.assertEquals("", m31.getValue());
		Assert.assertEquals("value must not < 10 or > 100, but is 2", m32.getValue());
	}
	
	@Test
	public void testELTag(){
		navigate(getTestCaseUrl("/bind/basic/eltag.zul"));
		Widget t1 = findWidget("$t1");
		Widget l1 = findWidget("$l1");
		Widget l2 = findWidget("$l2");
		
		t1.replace("AA").tab();
		Assert.assertEquals("AA:A",l1.getValue());
		Assert.assertEquals("AA-B",l2.getValue());
		
		t1.replace("BB").tab();
		Assert.assertEquals("BB:A",l1.getValue());
		Assert.assertEquals("BB-B",l2.getValue());
	}
	
	@Test
	public void testImmutable(){
		navigate(getTestCaseUrl("/bind/basic/immutable.zul"));
		Widget l1 = findWidget("$l1");
		Widget l2 = findWidget("$l2");
		Widget l3 = findWidget("$l3");
		Widget l4 = findWidget("$l4");
		Widget l5 = findWidget("$l5");
		Widget cmd1 = findWidget("$cmd1");
		Widget cmd2 = findWidget("$cmd2");
		
		Assert.assertEquals("A", l1.getValue());
		Assert.assertEquals("A-option", l2.getValue());
		Assert.assertEquals("A-option", l3.getValue());
		Assert.assertEquals("A-option", l4.getValue());
		Assert.assertEquals("A-option", l5.getValue());
		
		cmd1.click();
		Assert.assertEquals("A", l1.getValue());
		Assert.assertEquals("A-option", l2.getValue());
		Assert.assertEquals("A-option", l3.getValue());
		Assert.assertEquals("A-option", l4.getValue());
		Assert.assertEquals("A-option", l5.getValue());
		
		cmd2.click();
		Assert.assertEquals("A", l1.getValue());
		Assert.assertEquals("A-option", l2.getValue());
		Assert.assertEquals("A-option", l3.getValue());
		Assert.assertEquals("B-option", l4.getValue());
		Assert.assertEquals("B-option", l5.getValue());
		
	}
}
