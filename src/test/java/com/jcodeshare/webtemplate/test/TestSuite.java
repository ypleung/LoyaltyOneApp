package com.jcodeshare.webtemplate.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.jcodeshare.webtemplate.service.ActionControllerTest;
import com.jcodeshare.webtemplate.data.service.CommentsServiceTest;
import com.jcodeshare.webtemplate.data.service.UsersServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ActionControllerTest.class, UsersServiceTest.class, CommentsServiceTest.class })
public class TestSuite {
}
