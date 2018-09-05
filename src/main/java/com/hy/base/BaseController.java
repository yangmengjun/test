package com.hy.base;

import com.hy.base.model.User;
import com.hy.base.web.UserHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Objects;

/**
 * Controller公共组件
 * 
 * @author theodo
 * @email 36780272@qq.com
 * @date 2017年10月9日 下午9:42:26
 */
public abstract class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserHolder userHolder;
	/**
	 * 获取当前登录用户
	 * @return
	 */
	protected User getUser(){
		return userHolder.getCurrentUser();
	}

	/**
	 * 初始化后实体创建信息
	 * @param entity
	 * @param <T>
	 */
	protected <T extends BaseEntity>void initEntityCreateInfo(T entity){
		if (Objects.nonNull(getUser())){
			entity.setCreatorId(getUser().getUserId());
			entity.setCreatorName(getUser().getUserName());
		}

		entity.setCreateTime(new Date());
	}

	/**
	 * 初始化实体更新信息
	 * @param entity
	 * @param <T>
	 */
	protected <T extends BaseEntity>void initEntityEditInfo(T entity){
		if (Objects.nonNull(getUser())){
			entity.setEditorId(getUser().getUserId());
			entity.setEditorName(getUser().getUserName());
		}

		entity.setEditTime(new Date());
	}


}
