package com.sounds.bvs.data.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sounds.bvs.data.dao.impl.UserDetailsDaoImpl;
import com.sounds.bvs.data.entities.UserDetails;
import com.sounds.bvs.data.utils.constants.GenericConstansts;
import com.sounds.bvs.data.vo.UserDetailsVo;

public class UserDetailsHelpler implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(UserDetailsHelpler.class);

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	final UserDetailsDaoImpl usersImpl = new UserDetailsDaoImpl();

	/**
	 * @param vo
	 * @return
	 */
	public UserDetailsVo saveUserDetails(final UserDetailsVo vo) {
		return userDetailsDOTOVOConvertor(usersImpl.save(userDetailsVOTODOConvertor(new UserDetails(), vo, vo.getUserId())), new UserDetailsVo());
	}

	/**
	 * @param vo
	 * @return
	 */
	public UserDetailsVo updateUserDetails(final UserDetailsVo vo) {
		return userDetailsDOTOVOConvertor(usersImpl.update(userDetailsVOTODOConvertor(new UserDetails(), vo, vo.getUserId())), new UserDetailsVo());
	}

	/**
	 * @return
	 */
	public List<UserDetailsVo> readUserDetails() {
		return createUserDetailsVoListFromDo(usersImpl.findAll(), new ArrayList<UserDetailsVo>());
	}

	/**
	 * @param users
	 * @return
	 */
	public UserDetailsVo findUserById(final UserDetailsVo users) {
		return userDetailsDOTOVOConvertor(usersImpl.findById(users.getUserId()), new UserDetailsVo());
	}

	/**
	 * @param users
	 */
	public void removeUserById(final UserDetailsVo users) {
		usersImpl.delete(users.getUserId());
	}
	/**
	 * @param doList
	 * @param voList
	 * @return
	 */
	private List<UserDetailsVo> createUserDetailsVoListFromDo(final List<UserDetails> doList, final List<UserDetailsVo> voList) {
		for(final UserDetails userDetails : doList) {
			voList.add(userDetailsDOTOVOConvertor(userDetails, new UserDetailsVo()));
		}
		return voList;
	}

	/**
	 * @param doObject
	 * @param voObject
	 * @param userId
	 * @return
	 */
	private UserDetails userDetailsVOTODOConvertor(final UserDetails doObject, final UserDetailsVo voObject, final String userId) {
		if(userId == null && voObject.getUserId() == null && voObject.getUserName() != null && !voObject.getUserName().equals("")) {
			doObject.setUserId(voObject.getUserName().replaceAll(" ", "_").toUpperCase().trim());
		}else {
			doObject.setUserId(voObject.getUserId());
		}
		doObject.setUserName(voObject.getUserName().trim());
		doObject.setEmailId(voObject.getEmailId().trim());
		doObject.setUserStatus(voObject.isUserStatus());
		doObject.setUserLevel(voObject.getUserLevel());
		return doObject;
	}

	private UserDetailsVo userDetailsDOTOVOConvertor(final UserDetails doObject, final UserDetailsVo voObject) {
		voObject.setUserId(doObject.getUserId().trim());
		voObject.setUserName(doObject.getUserName().trim());
		voObject.setUserLevel(doObject.getUserLevel());
		voObject.setEmailId(doObject.getEmailId().trim());
		voObject.setUserStatus(doObject.isUserStatus());
		return voObject;
	}

	/**
	 * @param voObject
	 * @return
	 */
	public UserDetailsVo resetUserDetails(final UserDetailsVo voObject) {
		voObject.setUserId(null);
		voObject.setUserName(GenericConstansts.EMPTY_STRING);
		voObject.setUserLevel(GenericConstansts.EMPTY_STRING);
		voObject.setEmailId(GenericConstansts.EMPTY_STRING);
		voObject.setUserStatus(false);
		return voObject;
	}
}
