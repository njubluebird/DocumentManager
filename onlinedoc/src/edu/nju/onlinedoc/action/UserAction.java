  package edu.nju.onlinedoc.action;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.nju.onlinedoc.model.User;
import edu.nju.onlinedoc.service.UserService;
import edu.nju.onlinedoc.service.impl.UserServiceImpl;

public class UserAction extends BaseAction {

	private UserService userService; // 
	private User user;

	public String execute() throws Exception {
		
		String action = this.request().getParameter("action");
		if(action!=null&&"out".equals(action)){   //说明要退出
			this.request().getSession().setAttribute("username", null);
			return INPUT;
		}
		
		
		if(this.request().getSession().getAttribute("username")!=null){//已经登录，用于用户刷新页面时
			return SUCCESS;
		}
		String message = "";
		String username = "";
		String password = "";

		username = this.request().getParameter("username");
		password = this.request().getParameter("password");
		
		
		User dbuser = userService.validateUser(username);
		if(dbuser==null){
			message = "没有该用户";
		}else if(!password.equals(dbuser.getPassword())){
			message = "密码错误";
		}else{
			this.request().getSession().setAttribute("username", username);
			return SUCCESS;
		}
		userService.sentErrorMessage(message, this.request(), this.response());
		return INPUT;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
		System.out.println("setUserService");
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
