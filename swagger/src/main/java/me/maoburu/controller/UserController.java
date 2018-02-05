package me.maoburu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.maoburu.entity.User;
/**
 * 
* @ClassName: UserController 
* @Description: swagger2构建restful接口文档
* @author xiejian 
* @date 2018年2月5日 下午5:27:46 
*
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	static Map<Long, User> map = new HashMap<>();
	
	@ApiOperation(value="用户首页")
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	/**
	* @Title: getUser 
	* @Description: 注意点：
	* 			dataType:数据类型
	* 			paramType：参数类型，path说明参数在url中，spring restfulUrl中的动态参数使用该参数，默认为body，说明参数在请求请求体中
	* @param: @param id
	* @param: @return    
	* @return User    
	* @throws
	 */
	@ApiOperation(value="查询用户")
	@ApiImplicitParam(name = "id", value="用户id", required = true, dataType = "Long", paramType="path")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable long id) {
		User user = new User();
		user.setId(id);
		user.setName("谢健");
		user.setAge(12);
		user.setDesc("欧皇");
		map.put(id, user);
		return map.get(id);
	}
	
}
