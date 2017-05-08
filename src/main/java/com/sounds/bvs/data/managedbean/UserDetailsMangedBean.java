package com.sounds.bvs.data.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.log4j.Logger;

import com.sounds.bvs.data.helper.GenericBeanHelper;
import com.sounds.bvs.data.helper.UserDetailsHelpler;
import com.sounds.bvs.data.utils.constants.GenericConstansts;
import com.sounds.bvs.data.vo.UserDetailsVo;


/**
 * @author Vikram
 *
 */
@ManagedBean(name="userDetailsManagedBean")
@SessionScoped
public class UserDetailsMangedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(UserDetailsMangedBean.class);

	private UserDetailsVo users;
	private UserDetailsHelpler helpler = new UserDetailsHelpler();
	private String loadValidValues;
	private boolean readOnce;
	private List<UserDetailsVo> usersList;

	public UserDetailsMangedBean() {
		if(null == users) users = new UserDetailsVo();
	}


	public void saveUser(final ActionEvent ae) {
		LOG.info("Inside the save User");
		if(null == users.getUserId()) {
			users = helpler.saveUserDetails(users);
			if(users.getUserId() != null) {
				GenericBeanHelper.showGrowlMessages(GenericConstansts.INFO_MESSAGE, users.getUserName() + " Saved successfully");
			}else {
				GenericBeanHelper.showGrowlMessages(GenericConstansts.WARN_MESSAGE, users.getUserName() + " saving was resulted in Error");
			}
		}else {
			users = helpler.updateUserDetails(users);
			if(users.getUserId() != null) {
				GenericBeanHelper.showGrowlMessages(GenericConstansts.INFO_MESSAGE, users.getUserName() + " Updated successfully");
			}else {
				GenericBeanHelper.showGrowlMessages(GenericConstansts.WARN_MESSAGE, users.getUserName() + " updation was resulted in Error");
			}
		}
		usersList = helpler.readUserDetails();

	}

	public String cancelUser() {
		LOG.info("Inside the cancel User");
		helpler.resetUserDetails(users);
		readOnce = false;
		return "/views/index";
	}

	public void readUserDetails(final AjaxBehaviorEvent ae) {
		users = (UserDetailsVo)GenericBeanHelper.getUIComponent(users, ae);
		if(null != users) {
			LOG.info("User Id" + users.getUserId());
			users = helpler.findUserById(users);
		}
	}

	public void removeUser(final AjaxBehaviorEvent ae) {
		users = (UserDetailsVo)GenericBeanHelper.getUIComponent(users, ae);
		if(null != users) {
			helpler.removeUserById(users);
			usersList.remove(users);
			users = helpler.resetUserDetails(users);
			if(users.getUserId() == null) {
				GenericBeanHelper.showGrowlMessages(GenericConstansts.INFO_MESSAGE, "User has been removed successfully");
			}
		}
	}
	public void resetUser() {
		helpler.resetUserDetails(users);
	}
	public String getLoadValidValues() {
		if(!readOnce) {
			usersList = helpler.readUserDetails();
			readOnce = true;
		}
		return loadValidValues;
	}

	public void setLoadValidValues(final String loadValidValues) {
		this.loadValidValues = loadValidValues;
	}

	public UserDetailsVo getUsers() {
		return users;
	}

	public void setUsers(final UserDetailsVo users) {
		this.users = users;
	}

	public List<UserDetailsVo> getUsersList() {
		return usersList;
	}

	public void setUsersList(final List<UserDetailsVo> usersList) {
		this.usersList = usersList;
	}

}
