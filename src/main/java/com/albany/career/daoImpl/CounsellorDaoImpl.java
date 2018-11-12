package com.albany.career.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateAccessor;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.albany.career.dao.CounsellorDao;
import com.albany.career.dto.ApplicantDto;
import com.albany.career.dto.CounselorDto;
import com.albany.career.entity.ApplicantForum;
import com.albany.career.entity.CounsellorDescription;
import com.albany.career.entity.CounsellorForum;
import com.albany.career.entity.DocumentsDetails;
import com.albany.career.utility.FunctionResponse;

@Repository
public class CounsellorDaoImpl extends HibernateDaoSupport implements CounsellorDao{
	
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

	public ApplicantForum getApplicantForum(Long forumId) {
		ApplicantForum forum = (ApplicantForum) getHibernateTemplate().getSessionFactory().getCurrentSession().get(ApplicantForum.class, forumId);
		return forum;
	}

	public FunctionResponse saveReplyMessages(CounsellorForum cForum) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(cForum);
			response.setFlag(true);
			response.setMessage("Messages Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}

	public List<CounselorDto> getCounsellorForum(Long forumId, Long registerId) {
		String hql = "SELECT new com.albany.career.dto.CounselorDto(cForum.id,register.id,cForum.counsellorMessage,cForum.status,cForum.date) FROM CounsellorForum as cForum"
				+" left outer join cForum.register as register left outer join cForum.forum as aforum where cForum.status = "+true+" and register.id = :rId and aforum.id = :forumId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", registerId);
		query.setParameter("forumId", forumId);
		List results = query.list();
		return results;
	}

	public List<CounselorDto> getCounsellorForum(Long forumId) {
		String hql = "SELECT new com.albany.career.dto.CounselorDto(cForum.id,register.id,cForum.counsellorMessage,cForum.status,cForum.date) FROM CounsellorForum as cForum"
				+" left outer join cForum.register as register left outer join cForum.forum as aforum where cForum.status = "+true+" and aforum.id = :forumId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("forumId", forumId);
		List results = query.list();
		return results;
	}

	public CounselorDto getCounselorDescription(Long id) {
		String hql = "SELECT new com.albany.career.dto.CounselorDto(counselor.id,register.id,counselor.qualification,counselor.experience,counselor.description,counselor.status,counselor.photo,counselor.photoType) FROM CounsellorDescription as counselor "
				+" left outer join counselor.register as register where register.id = :rId and counselor.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		if(results != null && results.size() > 0){
			return (CounselorDto) results.get(0);
		}
		return null;
	}
	
	public CounsellorDescription getCounsellorDescription(Long id){
		CounsellorDescription des = (CounsellorDescription) getHibernateTemplate().getSessionFactory().getCurrentSession().get(CounsellorDescription.class, id);
		return des;
	}
	
	public FunctionResponse updateCounsellorDescription(CounsellorDescription desc) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(desc);
			response.setFlag(true);
			response.setMessage("Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}
	
}
