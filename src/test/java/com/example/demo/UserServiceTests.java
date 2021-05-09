package com.example.demo;

import com.example.logistics.LogisticsApplication;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.LoginReq;
import com.example.logistics.domain.req.RegisterReq;
import com.example.logistics.domain.req.UpdateReq;
import com.example.logistics.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LogisticsApplication.class)
public class UserServiceTests {

	@Autowired
	private UserService userService;
	@Test
	public void registerTest() {
		RegisterReq  registerReq=new RegisterReq();
		registerReq.setPhone("13723726239");
		registerReq.setNickName("zhoujielun");
		registerReq.setConfirmPassword("111");
		registerReq.setPassword("111");
		registerReq.setVerifyCode("11111");
		registerReq.setType(1);
		CommonResult commonResult=userService.register(registerReq);
		System.out.print(commonResult);
	}
	@Test
	public void  loginTest(){
		LoginReq loginReq=new LoginReq();
		loginReq.setPhone("13723726239");
		loginReq.setPassword("111");
		loginReq.setType(1);
		CommonResult commonResult=userService.login(loginReq);
		System.out.print(commonResult);
	}

	@Test
	public void updateUserTest(){
		UpdateReq updateReq=new UpdateReq();
		updateReq.setToken("8cbe972f666448e2bd11ce18cb637ebb");
		updateReq.setPhone("13723726239");
		updateReq.setNickName("周杰伦");
		updateReq.setPassword("hxb15871976405");
 		CommonResult commonResult=userService.updateUser(updateReq);
		System.out.print(commonResult);
	}
}

