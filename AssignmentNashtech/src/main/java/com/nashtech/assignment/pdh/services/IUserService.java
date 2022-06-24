package com.nashtech.assignment.pdh.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.entities.Information;
import com.nashtech.assignment.pdh.entities.Users;


@Service
public interface IUserService {
	public Users addAccount(Users account, Information information);

	public Users updateAccount(long id, Users products);

	public boolean deleteAccount(long id);

	public List<Users> getAllAccount();

	public Users getOneAccount(long id);
}
