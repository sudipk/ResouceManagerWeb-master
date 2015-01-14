package edu.sjsu.courseapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.courseapp.dao.InstanceDAO;
import edu.sjsu.courseapp.dao.jdbc.InstanceDaoJdbcImpl;
import edu.sjsu.courseapp.domain.Instance;


@Transactional(rollbackFor={java.io.IOException.class},noRollbackFor = ArithmeticException.class)
@Service
public class InstanceServiceImpl implements InstanceService {
	@Qualifier("InstanceDaoJdbcImpl")
	@Autowired
	private InstanceDAO  instanceDao=new InstanceDaoJdbcImpl();

	@Override
	public void deleteInstance(Integer id) {
		// TODO Auto-generated method stub
		instanceDao.deleteInstance(id);
	}


	@Override
	public List<Instance> getInstanceList() {
		List<Instance> instances = instanceDao.getInstanceallList();
		return instances;
	}


	@Override
	public List<Instance> getInstanceByName(String name) {
		List<Instance>instanceList=(List<Instance>) instanceDao.findInstanceByName(name);
		return instanceList;
	}
	
	@Override
	public void insertInstance(List<Instance> instance) {
		instanceDao.insertInstance(instance);
	}


	@Override
	public String getInstancebyId(int id) {
		// TODO Auto-generated method stub
		return instanceDao.findInstanceNameById(id);
	}

}
