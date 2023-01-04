package com.example.security.SpringSmartVehicle.dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.security.SpringSmartVehicle.Service.UserServiceImpl;

@Component
public class DaoServiceImpl implements DaoService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	/* (non-Javadoc)
	 * @see com.example.security.SpringVehicle.dao.DaoService#userUpdate(java.lang.String, int)
	 */
	@Override
	public void userUpdate(String mobNo, int id) throws Exception {
		System.out.println(mobNo + id);
		logger.info("updating user");
		String sql = "update users set mob_no = ? where driving_license_id= ?";
		jdbcTemplate.update(sql, mobNo, id);
		logger.debug("user updated id =" + id);

	}


	/* (non-Javadoc)
	 * @see com.example.security.SpringVehicle.dao.DaoService#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		System.out.println("user deleting");
		String sql="DELETE from police WHERE User_id=?";
		jdbcTemplate.update(sql,id);
	}
//
	
	
	

	
}
