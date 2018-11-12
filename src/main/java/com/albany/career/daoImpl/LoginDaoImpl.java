package com.albany.career.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateAccessor;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.albany.career.dao.LoginDao;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.Registration;
import com.albany.career.entity.Roles;
import com.albany.career.utility.FunctionResponse;

@Repository
public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao {

	@Autowired
	public void setDaoSessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	private HibernateTemplate getHibernate() {
		HibernateTemplate template = getHibernateTemplate();
		template.setAllowCreate(false);
		template.setFlushMode(HibernateAccessor.FLUSH_COMMIT);

		return template;
	}

	public Roles getRoles(Long id) {
		Roles role = (Roles) getHibernateTemplate().getSessionFactory().getCurrentSession().get(Roles.class, id);
		return role;
	}
	
	public Registration getProfile(Long id){
		Registration user = (Registration) getHibernateTemplate().getSessionFactory().getCurrentSession().get(Registration.class, id);
		return user;
	}

	public FunctionResponse saveProfileInfo(Registration register) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(register);
			response.setFlag(true);
			response.setMessage("Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}
	
	public List<KeyValueDto> getProfileDetails(){
		String hql = "select new com.albany.career.dto.KeyValueDto(register.id,register.email, register.password, role.id) from Registration as register left outer join register.role as role where register.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		List results = query.list();
		return results;
	}

	public KeyValueDto getProfileInfo(String email) {
		String hql = "select new com.albany.career.dto.KeyValueDto(register.id,register.email,register.password) from Registration as register where register.status = "+true+" and register.email = :email";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("email", email);
		List results = query.list();
		if(results != null && results.size() > 0){
			return (KeyValueDto)results.get(0);
		}
		return null;
	}
}
