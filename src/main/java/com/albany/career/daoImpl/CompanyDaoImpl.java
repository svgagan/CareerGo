package com.albany.career.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateAccessor;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.albany.career.dao.CompanyDao;
import com.albany.career.dto.CompanyDto;
import com.albany.career.dto.CounselorDto;
import com.albany.career.entity.ApplicantGrade;
import com.albany.career.entity.CompanyDescription;
import com.albany.career.entity.CounsellorDescription;
import com.albany.career.entity.JobPosts;
import com.albany.career.entity.JobType;
import com.albany.career.entity.JobsApplied;
import com.albany.career.entity.Rating;
import com.albany.career.utility.FunctionResponse;

@Repository
public class CompanyDaoImpl extends HibernateDaoSupport implements CompanyDao {
	
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

	public CompanyDto getCompanyDescription(Long id) {
		String hql = "SELECT new com.albany.career.dto.CompanyDto(company.id,register.id,company.domain,company.website,company.description,company.status,company.logo,company.logoType) FROM CompanyDescription as company "
				+" left outer join company.register as register where register.id = :rId and company.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		if(results != null && results.size() > 0){
			return (CompanyDto) results.get(0);
		}
		return null;
	}
	
	public CompanyDescription getComDescription(Long id){
		CompanyDescription des = (CompanyDescription) getHibernateTemplate().getSessionFactory().getCurrentSession().get(CompanyDescription.class, id);
		return des;
	}
	
	public FunctionResponse updateCompanyDescription(CompanyDescription com) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(com);
			response.setFlag(true);
			response.setMessage("Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}

	public List<JobType> getJobTypes() {
		String hql = "SELECT new com.albany.career.entity.JobType(job.id,job.jobType) FROM JobType as job where job.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		List results = query.list();
		return results;
	}

	public List<CompanyDto> getJobsList(Long id) {
		String hql = "SELECT new com.albany.career.dto.CompanyDto(work.id,jType.id,register.id,work.title,work.jobDescription,work.jobLocation,work.salary,work.phone,work.email,jType.jobType,work.date,work.status) FROM JobPosts as work"
				+" left outer join work.jobs as jType left outer join work.register as register where work.status = "+true+" and register.id = :rId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		return results;
	}

	public JobType getJobTypes(Long jobTypeId) {
		JobType type = (JobType) getHibernateTemplate().getSessionFactory().getCurrentSession().get(JobType.class, jobTypeId);
		return type;
	}

	public FunctionResponse updateJobDetails(JobPosts jobs) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(jobs);
			response.setFlag(true);
			response.setMessage("Job Post Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}

	public JobPosts getJobs(Long jobId) {
		JobPosts job = (JobPosts) getHibernateTemplate().getSessionFactory().getCurrentSession().get(JobPosts.class, jobId);
		return job;
	}

	public List<CompanyDto> getJobsList() {
		String hql = "SELECT new com.albany.career.dto.CompanyDto(work.id,jType.id,register.id,register.lastname,work.title,work.jobDescription,work.jobLocation,work.salary,work.phone,work.email,jType.jobType,work.date,work.status) FROM JobPosts as work"
				+" left outer join work.jobs as jType left outer join work.register as register where work.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		//query.setParameter("rId", id);
		List results = query.list();
		return results;
	}

	public List<CompanyDto> getJobsApplicationReceivedList(Long companyId) {
		String hql = "SELECT new com.albany.career.dto.CompanyDto(work.id,jobPost.id,applicant.id,applicant.lastname,jobPost.title,jobPost.jobDescription,jobPost.jobLocation,jobPost.salary,jobPost.phone,jobPost.email,jType.jobType,work.companyResponse,work.date,work.status) FROM JobsApplied as work"
				+" left outer join work.job as jobPost"
				+" left outer join jobPost.register as company"
				+" left outer join jobPost.jobs as jType"
				+" left outer join work.register as applicant where company.id = :rId and work.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", companyId);
		List results = query.list();
		return results;
	}

	public JobsApplied getJobApplied(Long jobId) {
		JobsApplied job = (JobsApplied) getHibernateTemplate().getSessionFactory().getCurrentSession().get(JobsApplied.class, jobId);
		return job;
	}

	public List<CompanyDto> getReviewList(Long id) {
		String hql = "SELECT new com.albany.career.dto.CompanyDto(rate.id,company.id,applicant.id,applicant.firstname,applicant.lastname,rate.comments,rate.stars,rate.verified,rate.status) FROM Rating as rate"
				+" left outer join rate.company as company"
				+" left outer join rate.applicant as applicant where company.id = :rId and rate.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		return results;
	}
	
	public Rating getRatings(Long id) {
		Rating rate = (Rating) getHibernateTemplate().getSessionFactory().getCurrentSession().get(Rating.class, id);
		return rate;
	}

}
