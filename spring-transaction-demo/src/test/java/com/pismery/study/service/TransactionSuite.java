package com.pismery.study.service;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RequiredServiceTest.class,
        RequireNewServiceTest.class,
        SupportsServiceTest.class,
        NestedServiceTest.class
})
public class TransactionSuite {
}
