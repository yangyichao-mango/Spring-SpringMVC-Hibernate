package com.yyc.bo.impl;

import com.yyc.bo.ChooseBo;
import com.yyc.dao.ChooseDao;
import com.yyc.entity.Choose;

public class ChooseBoImpl implements ChooseBo{
	
	private ChooseDao chooseDao;
	
	public void setChooseDao(ChooseDao chooseDao)
	{
		this.chooseDao = chooseDao;
	}

	public ChooseBoImpl() {
		// TODO Auto-generated constructor stub
	}


	public Integer deleteCourse(Choose choose) {
		// TODO Auto-generated method stub
		return chooseDao.deleteCourse(choose);
	}


	public Integer chooseCourse(Choose choose) {
		// TODO Auto-generated method stub
		return chooseDao.chooseCourse(choose);
	}

}
