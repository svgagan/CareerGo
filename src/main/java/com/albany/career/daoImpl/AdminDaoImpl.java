package com.albany.career.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateAccessor;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.albany.career.dao.AdminDao;
import com.albany.career.dto.ApplicantDto;
import com.albany.career.dto.CompanyDto;
import com.albany.career.dto.CounselorDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.Registration;
import com.albany.career.entity.TestInfo;

@Repository
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

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

	public List<ApplicantDto> getApplicantList() {
		String hql = "SELECT new com.albany.career.dto.ApplicantDto(register.id,register.firstname,register.lastname,register.email,register.location,register.gender,register.phone,register.verified,register.date,role.id) FROM Registration as register"
				+" left outer join register.role as role where register.status = "+true+" and role.id = :roleId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("roleId", (long)1);
		List results = query.list();
		return results;
	}
	
	public List<CompanyDto> getCompanyList() {
		String hql = "SELECT new com.albany.career.dto.CompanyDto(register.id,register.lastname,register.email,register.location,register.phone,register.verified,register.date,role.id) FROM Registration as register"
				+" left outer join register.role as role where register.status = "+true+" and role.id = :roleId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("roleId", (long)2);
		List results = query.list();
		return results;
	}
	
	public List<CounselorDto> getCounselorList() {
		String hql = "SELECT new com.albany.career.dto.CounselorDto(register.id,register.firstname,register.lastname,register.email,register.location,register.gender,register.phone,register.verified,register.date,role.id) FROM Registration as register"
				+" left outer join register.role as role where register.status = "+true+" and role.id = :roleId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("roleId", (long)3);
		List results = query.list();
		return results;
	}

	public KeyValueDto getRegistrationDetails(Long id, Long roleId) {
		String hql = "SELECT new com.albany.career.dto.KeyValueDto(register.id,register.firstname,register.lastname,register.email,register.phone,register.location,register.gender,register.verified,register.date,role.id,register.hits) FROM Registration as register"
				+" left outer join register.role as role where register.status = "+true+" and role.id = :roleId and register.id = :id";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("roleId", roleId);
		query.setParameter("id", id);
		List results = query.list();
		if(results != null && results.size() > 0){
			return (KeyValueDto) results.get(0);
		}
		return null;
	}

	public List<KeyValueDto> getTestList() {
		String hql = "SELECT new com.albany.career.dto.KeyValueDto(test.id,test.testName,test.testType,test.date,test.status,register.id) FROM TestInfo as test"
				+" left outer join test.register as register where test.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		//query.setParameter("registerId", (long)4);
		List results = query.list();
		return results;
	}
	
	public Registration getRegistrationDetails(Long id){
		Registration user = (Registration) getHibernateTemplate().getSessionFactory().getCurrentSession().get(Registration.class, id);
		return user;
	}

	public Boolean saveTestDetails(TestInfo test) {
		try{
			getHibernateTemplate().saveOrUpdate(test);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public TestInfo getTestInfo(Long testId) {
		TestInfo test = (TestInfo) getHibernateTemplate().getSessionFactory().getCurrentSession().get(TestInfo.class, testId);
		return test;
	}

	public List<KeyValueDto> getTestInfoToGrade() {
		String hql = "SELECT new com.albany.career.dto.KeyValueDto(grade.id,register.id,testInfo.id,test.testName,register.firstname,register.lastname,grade.url,grade.marks,grade.status,grade.date) FROM ApplicantGrade as grade"
				+" left outer join grade.register as register "
				+" left outer join grade.testInfo as testInfo "
				+" left outer join testInfo.test as test where grade.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		//query.setParameter("registerId", (long)4);
		List results = query.list();
		return results;
	}

	public List<CompanyDto> getAbusiveReviewList() {
		String hql = "SELECT new com.albany.career.dto.CompanyDto(rate.id,company.id,applicant.id,applicant.firstname,applicant.lastname,company.lastname,rate.comments,rate.stars,rate.verified,rate.status) FROM Rating as rate"
				+" left outer join rate.company as company"
				+" left outer join rate.applicant as applicant where rate.verified = "+false+" and rate.status ="+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		List results = query.list();
		return results;
	}
}
