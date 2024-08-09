package com.tenco.bank.repository.interpaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tenco.bank.repository.model.Account;

public interface AccountRepository {
	public int insert(Account account);
	public int updateById(Account account);
	public int deleteById(Integer id, String name);
	
	public List<Account> findByUserId(@Param("userId") Integer principalId);
	
	public Account findfByNumber(@Param("number") String id);
}
