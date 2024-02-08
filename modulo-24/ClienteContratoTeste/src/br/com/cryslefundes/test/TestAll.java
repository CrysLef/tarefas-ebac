package br.com.cryslefundes.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ClienteServiceTest.class,
        ContratoServiceTest.class
})
public class TestAll {
}
