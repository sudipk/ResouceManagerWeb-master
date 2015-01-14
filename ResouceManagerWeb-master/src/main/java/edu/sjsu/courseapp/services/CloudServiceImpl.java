package edu.sjsu.courseapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.courseapp.dao.CloudDAO;
import edu.sjsu.courseapp.dao.jdbc.CloudDaoJdbcImpl;
import edu.sjsu.courseapp.domain.Cloud;


@Transactional(rollbackFor={java.io.IOException.class},noRollbackFor = ArithmeticException.class)
@Service
public class CloudServiceImpl implements CloudService {
	@Qualifier("CloudDaoJdbcImpl")
	@Autowired
	private CloudDAO  cloudDao=new CloudDaoJdbcImpl();

	@Override
	public void deleteCloud(Integer id) {
		// TODO Auto-generated method stub
		cloudDao.deleteCloud(id);
	}


	@Override
	public List<Cloud> getCloudList() {
		List<Cloud> clouds = cloudDao.getCloudallList();
		return clouds;
	}


	@Override
	public List<Cloud> getCloudByName(String name) {
		List<Cloud>cloudList=(List<Cloud>) cloudDao.findCloudByName(name);
		return cloudList;
	}
	
	@Override
	public void insertCloud(List<Cloud> cloud) {
		 cloudDao.insertCloud(cloud);
	}


	@Override
	public String getCloudbyId(int id) {
		// TODO Auto-generated method stub
		return cloudDao.findCloudNameById(id);
	}

}
