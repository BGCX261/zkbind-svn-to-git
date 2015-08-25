package org.zkoss.bind.unitest2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses( { LoadTestCase.class, FormTestCase.class,LoadSaveTestCase.class,ChildrenTestCase.class,
	CollectionTestCase.class,ParamTestCase.class,MiscTestCase.class,
	ComponentTestCase.class})
public class AllBasicTests {

}
