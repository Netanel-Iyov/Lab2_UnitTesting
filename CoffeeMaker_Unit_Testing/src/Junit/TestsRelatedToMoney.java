package Junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Test Suite for Money

@RunWith(Suite.class)
@SuiteClasses({ MoneyBagTest.class, MoneyTest.class })
public class TestsRelatedToMoney {

}
