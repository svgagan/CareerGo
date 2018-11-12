package com.albany.career.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateAccessor;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.albany.career.dao.ApplicantDao;
import com.albany.career.dto.ApplicantDto;
import com.albany.career.dto.CompanyDto;
import com.albany.career.dto.KeyValueDto;
import com.albany.career.entity.ApplicantForum;
import com.albany.career.entity.ApplicantGrade;
import com.albany.career.entity.ApplicantTestInfo;
import com.albany.career.entity.CertificationDetails;
import com.albany.career.entity.Degree;
import com.albany.career.entity.DocumentType;
import com.albany.career.entity.DocumentsDetails;
import com.albany.career.entity.EducationDetails;
import com.albany.career.entity.JobsApplied;
import com.albany.career.entity.Major;
import com.albany.career.entity.ProjectDetails;
import com.albany.career.entity.Rating;
import com.albany.career.entity.Roles;
import com.albany.career.entity.SkillsDetails;
import com.albany.career.entity.WorkDetails;
import com.albany.career.utility.FunctionResponse;

@Repository
public class ApplicantDaoImpl extends HibernateDaoSupport implements ApplicantDao {

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

	public List<ApplicantDto> getEducationList(Long id) {
		String hql = "SELECT new com.albany.career.dto.ApplicantDto(education.id,degree.degree,major.major,education.school,education.startDate,education.endDate,register.id,education.status,degree.id,major.id) FROM EducationDetails as education"
				+" left outer join education.register as register"
				+" left outer join education.degree as degree "
				+" left outer join education.major as major where education.status = "+true+" and register.id = :rId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		return results;
	}

	public List<Major> getMajorList() {
		String hql = "SELECT new com.albany.career.entity.Major(major.id,major.major) FROM Major as major where major.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		List results = query.list();
		return results;
	}

	public List<Degree> getDegreeList() {
		String hql = "SELECT new com.albany.career.entity.Degree(degree.id,degree.degree) FROM Degree as degree where degree.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		List results = query.list();
		return results;
	}

	public FunctionResponse updateEducation(EducationDetails education) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(education);
			response.setFlag(true);
			response.setMessage("Education Details Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}

	public Degree getDegree(Long degreeId) {
		Degree degree = (Degree) getHibernateTemplate().getSessionFactory().getCurrentSession().get(Degree.class, degreeId);
		return degree;
	}
	
	public Major getMajor(Long majorId) {
		Major major = (Major) getHibernateTemplate().getSessionFactory().getCurrentSession().get(Major.class, majorId);
		return major;
	}

	public EducationDetails getEducationDetails(Long eId) {
		EducationDetails edu = (EducationDetails) getHibernateTemplate().getSessionFactory().getCurrentSession().get(EducationDetails.class, eId);
		return edu;
	}

	public ApplicantDto getSkills(Long id) {
		String hql = "SELECT new com.albany.career.dto.ApplicantDto(skill.id,skill.skills,skill.status,register.id) FROM SkillsDetails as skill left outer join skill.register as register where skill.status = "+true+" and register.id = :rId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		if(results != null && results.size() > 0){
			return (ApplicantDto) results.get(0);
		}
		return null;
	}

	public SkillsDetails getSkillsDetails(Long sID) {
		SkillsDetails skill = (SkillsDetails) getHibernateTemplate().getSessionFactory().getCurrentSession().get(SkillsDetails.class, sID);
		return skill;
	}

	public FunctionResponse updateSkills(SkillsDetails skill) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(skill);
			response.setFlag(true);
			response.setMessage("Skills Details Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}

	public List<ApplicantDto> getCertificateList(Long id) {
		String hql = "SELECT new com.albany.career.dto.ApplicantDto(certificate.id,certificate.certificate,certificate.authority,certificate.startDate,certificate.endDate,register.id,certificate.status) FROM CertificationDetails as certificate"
				+" left outer join certificate.register as register where certificate.status = "+true+" and register.id = :rId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		return results;
	}

	public FunctionResponse updateCertificate(CertificationDetails certificates) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(certificates);
			response.setFlag(true);
			response.setMessage("Certification Details Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}

	public CertificationDetails getCertificate(Long cId) {
		CertificationDetails certificate = (CertificationDetails) getHibernateTemplate().getSessionFactory().getCurrentSession().get(CertificationDetails.class, cId);
		return certificate;
	}

	public List<ApplicantDto> getProjectsList(Long id) {
		String hql = "SELECT new com.albany.career.dto.ApplicantDto(project.id,project.title,project.description,project.members,project.url,project.startDate,project.endDate,register.id,project.status) FROM ProjectDetails as project"
				+" left outer join project.register as register where project.status = "+true+" and register.id = :rId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		return results;
	}

	public FunctionResponse updateProjects(ProjectDetails project) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(project);
			response.setFlag(true);
			response.setMessage("Projects Details Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}

	public ProjectDetails getProject(Long pId) {
		ProjectDetails project = (ProjectDetails) getHibernateTemplate().getSessionFactory().getCurrentSession().get(ProjectDetails.class, pId);
		return project;
	}

	public List<ApplicantDto> getWorkList(Long id) {
		String hql = "SELECT new com.albany.career.dto.ApplicantDto(work.id,register.id,work.position,work.company,work.description,work.location,work.startDate,work.endDate,work.status) FROM WorkDetails as work"
				+" left outer join work.register as register where work.status = "+true+" and register.id = :rId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		return results;
	}
	
	public WorkDetails getWork(Long wId) {
		WorkDetails work = (WorkDetails) getHibernateTemplate().getSessionFactory().getCurrentSession().get(WorkDetails.class, wId);
		return work;
	}
	
	public FunctionResponse updateWork(WorkDetails work) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(work);
			response.setFlag(true);
			response.setMessage("Work Experience Details Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}

	public List<DocumentType> getDocumentTypes() {
		String hql = "SELECT new com.albany.career.entity.DocumentType(doc.id,doc.documentType) FROM DocumentType as doc where doc.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		List results = query.list();
		return results;
	}

	public DocumentType getDocumentType(Long docTypeId) {
		DocumentType doc = (DocumentType) getHibernateTemplate().getSessionFactory().getCurrentSession().get(DocumentType.class, docTypeId);
		return doc;
	}

	public FunctionResponse saveDocumentDetails(DocumentsDetails documentsDetails) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(documentsDetails);
			response.setFlag(true);
			response.setMessage("Documents Details Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}

	public List<ApplicantDto> getDoumentsList(Long id) {
		String hql = "SELECT new com.albany.career.dto.ApplicantDto(docs.id,register.id,docs.documentName,docs.documentType,docs.status,documents.id,documents.documentType) FROM DocumentsDetails as docs"
				+" left outer join docs.register as register left outer join docs.documents as documents where docs.status = "+true+" and register.id = :rId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		return results;
	}

	public DocumentsDetails getDocumentDetails(Long docId) {
		DocumentsDetails doc = (DocumentsDetails) getHibernateTemplate().getSessionFactory().getCurrentSession().get(DocumentsDetails.class, docId);
		return doc;
	}

	public List<ApplicantDto> getMessagesList(Long id) {
		String hql = "SELECT new com.albany.career.dto.ApplicantDto(aForum.id,register.id,aForum.subject,aForum.applicantMessage,aForum.status,aForum.response,aForum.date) FROM ApplicantForum as aForum"
				+" left outer join aForum.register as register where aForum.status = "+true+" and register.id = :rId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		return results;
	}

	public FunctionResponse saveMessages(ApplicantForum aForum) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(aForum);
			response.setFlag(true);
			response.setMessage("Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}

	public List<ApplicantDto> getMessagesList() {
		String hql = "SELECT new com.albany.career.dto.ApplicantDto(aForum.id,register.id,aForum.subject,aForum.applicantMessage,aForum.status,aForum.response,aForum.date) FROM ApplicantForum as aForum"
				+" left outer join aForum.register as register where aForum.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		//query.setParameter("rId", id); //+" and register.id = :rId";
		List results = query.list();
		return results;
	}
	
	public ApplicantForum getApplicantForum(Long forumId) {
		ApplicantForum forum = (ApplicantForum) getHibernateTemplate().getSessionFactory().getCurrentSession().get(ApplicantForum.class, forumId);
		return forum;
	}

	public FunctionResponse saveApplicantTestDetails(ApplicantTestInfo atest) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(atest);
			response.setFlag(true);
			response.setMessage("Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}

	public ApplicantTestInfo getApplicantTest(Long testId, Long registerId) {
		String hql = "SELECT new com.albany.career.entity.ApplicantTestInfo(atest.id,atest.date) FROM ApplicantTestInfo as atest"
				+" left outer join atest.register as register"
				+" left outer join atest.test as test where test.id = :testId and register.id = :rId and atest.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("testId", testId);
		query.setParameter("rId", registerId);
		List results = query.list();
		if(results != null && results.size() > 0){
			return (ApplicantTestInfo) results.get(0);
		}
		return null;
	}

	public List<KeyValueDto> getApplicantTestList(Long id) {
		String hql = "SELECT new com.albany.career.dto.KeyValueDto(aTest.id,register.id,test.id,test.testName,aTest.status,aTest.date) FROM ApplicantTestInfo as aTest"
				+" left outer join aTest.register as register "
				+" left outer join aTest.test as test where register.id =:rId and aTest.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id); //+" and register.id = :rId";
		List results = query.list();
		return results;
	}

	public ApplicantTestInfo getApplicantTest(Long id) {
		ApplicantTestInfo test = (ApplicantTestInfo) getHibernateTemplate().getSessionFactory().getCurrentSession().get(ApplicantTestInfo.class, id);
		return test;
	}

	public FunctionResponse saveApplicantKeys(ApplicantGrade aGrade) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(aGrade);
			response.setFlag(true);
			response.setMessage("Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Updation Failed");
		}
		return response;
	}
	
	public ApplicantGrade getApplicantGradeObj(Long id) {
		ApplicantGrade test = (ApplicantGrade) getHibernateTemplate().getSessionFactory().getCurrentSession().get(ApplicantGrade.class, id);
		return test;
	}

	public ApplicantGrade getApplicantGrade(Long id, Long registerId) {
		String hql = "SELECT new com.albany.career.entity.ApplicantGrade(aGrade.id,aGrade.date,aGrade.marks) FROM ApplicantGrade as aGrade"
				+" left outer join aGrade.register as register"
				+" left outer join aGrade.testInfo as testInfo where testInfo.id = :testInfo and register.id = :rId and aGrade.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("testInfo", id);
		query.setParameter("rId", registerId);
		List results = query.list();
		if(results != null && results.size() > 0){
			return (ApplicantGrade) results.get(0);
		}
		return null;
	}

	public List<ApplicantDto> getJobsApplied(Long registerId) {
		String hql = "SELECT new com.albany.career.dto.ApplicantDto(jobs.id,jobPost.id,register.id,jobs.companyResponse,jobs.status,jobs.date) FROM JobsApplied as jobs"
				+" left outer join jobs.register as register left outer join jobs.job jobPost where register.id = :rId and jobs.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", registerId);
		List results = query.list();
		return results;
	}

	public FunctionResponse updateJobApplied(JobsApplied jobApply) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(jobApply);
			response.setFlag(true);
			response.setMessage("Job Applied Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Job Application Failed");
		}
		return response;
	}

	public List<CompanyDto> getJobsAppliedList(Long id) {
		String hql = "SELECT new com.albany.career.dto.CompanyDto(work.id,jobPost.id,applicant.id,company.lastname,jobPost.title,jobPost.jobDescription,jobPost.jobLocation,jobPost.salary,jobPost.phone,jobPost.email,jType.jobType,work.companyResponse,work.date,work.status) FROM JobsApplied as work"
				+" left outer join work.job as jobPost"
				+" left outer join jobPost.register as company"
				+" left outer join jobPost.jobs as jType"
				+" left outer join work.register as applicant where applicant.id = :rId and work.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		return results;
	}

	public List<KeyValueDto> getCompanyList() {
		String hql = "SELECT new com.albany.career.dto.KeyValueDto(register.id,register.firstname,register.lastname,register.email,register.phone,register.location,register.gender,register.verified,register.date,role.id,register.hits) FROM Registration as register"
				+" left outer join register.role as role where register.status = "+true+" and role.id = :roleId";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("roleId",(long) 2);
		//query.setParameter("id", id);
		List results = query.list();
		return results;
	}

	public List<CompanyDto> getCompanyRates(Long id) {
		String hql = "SELECT new com.albany.career.dto.CompanyDto(rate.id,company.id,applicant.id,rate.comments,rate.stars,rate.verified,rate.status) FROM Rating as rate"
				+" left outer join rate.company as company"
				+" left outer join rate.applicant as applicant where company.id = :rId and rate.status = "+true;
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		List results = query.list();
		return results;
	}
	
	public FunctionResponse updateCompanyRatings(Rating rates) {
		FunctionResponse response = new FunctionResponse();
		try{
			getHibernateTemplate().saveOrUpdate(rates);
			response.setFlag(true);
			response.setMessage("Review Updated Successfully");
		}catch(Exception e){
			e.printStackTrace();
			response.setFlag(false);
			response.setMessage("Reviewing Failed");
		}
		return response;
	}
	
	public List<ApplicantDto> getDoumentsListForPhotos(Long id) {
		String hql = "SELECT new com.albany.career.dto.ApplicantDto(docs.id,register.id,docs.documentName,docs.documentType,docs.status,documents.id,documents.documentType) FROM DocumentsDetails as docs"
				+" left outer join docs.register as register left outer join docs.documents as documents where docs.status = "+true+" and register.id = :rId and documents.id = :type";
		Query query = getHibernate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setParameter("rId", id);
		query.setParameter("type", (long)3);
		List results = query.list();
		return results;
	}
}
