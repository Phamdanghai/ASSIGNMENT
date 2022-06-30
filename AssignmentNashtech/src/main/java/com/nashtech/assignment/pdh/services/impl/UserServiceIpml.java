package com.nashtech.assignment.pdh.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nashtech.assignment.pdh.entities.Information;
import com.nashtech.assignment.pdh.entities.Users;
import com.nashtech.assignment.pdh.repositories.UserRepository;
import com.nashtech.assignment.pdh.services.IUserService;

public class UserServiceIpml implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Users addAccount(Users account, Information information) {
		// TODO Auto-generated method stub
		return userRepository.save(account);
	}

	@Override
	public Users updateAccount(long id, Users users) {
		if (users != null) {
			Users reAccount = userRepository.getById(id);
			if (reAccount != null) {
				reAccount.setUserPassword(users.getUserPassword());
				reAccount.setRoles(users.getRoles());
				return userRepository.save(reAccount);
			}
		}
		return null;
	}

	@Override
	public boolean deleteAccount(long id) {
		if (id >= 1) {
			Users users = userRepository.getById(id);
			if (users != null) {
				userRepository.delete(users);

			}
			return true;
		}
		return false;
	}

	@Override
	public List<Users> getAllAccount() {
		return userRepository.findAll();
	}

	@Override
	public Users getOneAccount(long id) {
		// TODO Auto-generated method stub
		return userRepository.getById(id);
	}

}
