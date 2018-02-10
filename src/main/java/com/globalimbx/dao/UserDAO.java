package com.globalimbx.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.globalimbx.entity.ClientDetailsEntity;
import com.globalimbx.entity.CompanyDetailsEntity;
import com.globalimbx.entity.UserDetailsEntity;
import com.globalimbx.json.CompanyDetailsJson;
import com.globalimbx.json.ProductColorJson;

@Repository
public class UserDAO extends BaseDAO{
	
	
	public UserDetailsEntity getUserDetails(String userName){
		Criteria criteria = createCriteria(UserDetailsEntity.class);
		criteria.add(Restrictions.or(Restrictions.eq(UserDetailsEntity.USER_NAME, userName),Restrictions.eq(UserDetailsEntity.MOBILE_NUMBER, userName)));
		return (UserDetailsEntity)criteria.uniqueResult();
	}
	
	
	public UserDetailsEntity getUsers(String userGuid){
		Criteria criteria = createCriteria(UserDetailsEntity.class);
		criteria.add(Restrictions.eq(UserDetailsEntity.USER_GUID, userGuid));
		return (UserDetailsEntity)criteria.uniqueResult();
	}
	
	
	public void saveClients(ClientDetailsEntity clientDetailsEntity){
		saveObject(clientDetailsEntity);	
	}
	
	
	public void updateClients(ClientDetailsEntity clientDetailsEntity){
		updateObject(clientDetailsEntity);	
	}
	
	
	public void saveCompanyDetails(CompanyDetailsEntity companyDetailsEntity){
		saveObject(companyDetailsEntity);	
	}
	
	
	public void updateCompanyDetails(CompanyDetailsEntity companyDetailsEntity){
		updateObject(companyDetailsEntity);	
	}
	
	
	public ClientDetailsEntity getClientDetailsEntity(String clientGuid){
		Criteria criteria = createCriteria(ClientDetailsEntity.class);
		criteria.add(Restrictions.eq(ClientDetailsEntity.CLIENT_GUID, clientGuid));
		return (ClientDetailsEntity) criteria.uniqueResult();
	}
	
	
	
	public List<ClientDetailsEntity> getClientList(){
		Criteria criteria = createCriteria(ClientDetailsEntity.class);
		criteria.addOrder(Order.desc(ClientDetailsEntity.LAST_MODIFIED_DATE));
		return criteria.list();
	}
	
	
	public CompanyDetailsEntity getCompanyDetailsEntity(String companyDetailsGuid){
		Criteria criteria = createCriteria(CompanyDetailsEntity.class);
		criteria.add(Restrictions.eq(CompanyDetailsEntity.COMPANY_DETAILS_GUID, companyDetailsGuid));
		return (CompanyDetailsEntity) criteria.uniqueResult();
	}
	
	
	
	public List<CompanyDetailsEntity> getCompanyList(){
		Criteria criteria = createCriteria(CompanyDetailsEntity.class);
		criteria.addOrder(Order.desc(CompanyDetailsEntity.LAST_MODIFIED_DATE));
		return criteria.list();
	}
	
	
	public List<CompanyDetailsJson> getClientListForDropDown(){
		Criteria criteria = createCriteria(ClientDetailsEntity.class);
		criteria.addOrder(Order.asc(ClientDetailsEntity.COMPANY));
		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property(ClientDetailsEntity.CLIENT_GUID),"companyDetailsGuid");
		projectionList.add(Projections.property(ClientDetailsEntity.COMPANY),"companyName");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(CompanyDetailsJson.class));
		return criteria.list();
	}
	
	
	public List<CompanyDetailsJson> getCompanyListFroDropDown(){
		Criteria criteria = createCriteria(CompanyDetailsEntity.class);
		criteria.addOrder(Order.asc(CompanyDetailsEntity.COMPANY_NAME));
		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property(CompanyDetailsEntity.COMPANY_DETAILS_GUID),"companyDetailsGuid");
		projectionList.add(Projections.property(CompanyDetailsEntity.COMPANY_NAME),"companyName");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(CompanyDetailsJson.class));
		
		return criteria.list();
	}
	
	public void saveUsers(UserDetailsEntity userDetailsEntity){
		saveObject(userDetailsEntity);	
	}
	
	
	public void updateUsers(UserDetailsEntity userDetailsEntity){
		updateObject(userDetailsEntity);	
	}
	
	public List<UserDetailsEntity> getUsersList(){
		Criteria criteria = createCriteria(UserDetailsEntity.class);
		criteria.addOrder(Order.desc(UserDetailsEntity.LAST_MODIFIED_TIME));
		return criteria.list();
	}

}
