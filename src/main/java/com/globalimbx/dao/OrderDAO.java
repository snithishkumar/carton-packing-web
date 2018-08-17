package com.globalimbx.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.globalimbx.entity.DeliveryDetailsEntity;
import com.globalimbx.entity.OrderEntity;
import com.globalimbx.entity.ProductCategoryEntity;
import com.globalimbx.entity.ProductColorEntity;
import com.globalimbx.entity.ProductDetailsEntity;
import com.globalimbx.entity.ProductGroupEntity;
import com.globalimbx.json.ProductCategoryJson;
import com.globalimbx.json.ProductColorJson;
import com.globalimbx.json.ProductDetails;
import com.globalimbx.json.ProductGroupJson;

@Repository
public class OrderDAO extends BaseDAO{
	
	
	public List<OrderEntity> getOrderList(long lastSyncTime){
		Criteria criteria = createCriteria(OrderEntity.class);
		if(lastSyncTime > 0){
			criteria.add(Restrictions.ge(OrderEntity.SERVER_TIME, lastSyncTime));
		}
		return criteria.list();
	}
	
	
	public OrderEntity getOrderEntity(String orderGuid){
		Criteria criteria = createCriteria(OrderEntity.class);
		criteria.add(Restrictions.eq(OrderEntity.ORDER_GUID, orderGuid));
		return (OrderEntity) criteria.uniqueResult();
	}
	
	
	public void updateOrderEntity(OrderEntity orderEntity){
		saveObject(orderEntity);
	}
	
	
	public void saveProductGroup(ProductGroupEntity productGroupEntity){
		saveObject(productGroupEntity);
	}
	
	
	public void updateProductGroup(ProductGroupEntity productGroupEntity){
		updateObject(productGroupEntity);
	}
	
	public List<ProductGroupEntity> getProductGroup(){
		Criteria criteria = createCriteria(ProductGroupEntity.class);
		criteria.addOrder(Order.desc(ProductGroupEntity.LAST_MODIFIED_DATE));
		return criteria.list();
	}
	
	
	public ProductGroupEntity getProductGroup(String productGroupGuid){
		Criteria criteria = createCriteria(ProductGroupEntity.class);
		criteria.add(Restrictions.eq(ProductGroupEntity.PRODUCT_GROUP_GUID, productGroupGuid));
		return (ProductGroupEntity) criteria.uniqueResult();
	}
	
	
	
	public void saveProductCategory(ProductCategoryEntity productCategoryEntity){
		saveObject(productCategoryEntity);
	}
	
	
	public void updateProductCategory(ProductCategoryEntity productCategoryEntity){
		updateObject(productCategoryEntity);
	}
	
	public List<ProductCategoryEntity> getProductCategory(){
		Criteria criteria = createCriteria(ProductCategoryEntity.class);
		criteria.addOrder(Order.desc(ProductCategoryEntity.LAST_MODIFIED_DATE));
		return criteria.list();
	}
	
	
	public ProductCategoryEntity getProductCategory(String productCategoryGuid){
		Criteria criteria = createCriteria(ProductCategoryEntity.class);
		criteria.add(Restrictions.eq(ProductCategoryEntity.PRODUCT_CATEGORY_GUID, productCategoryGuid));
		return (ProductCategoryEntity) criteria.uniqueResult();
	}
	
	
	
	public void saveProductColor(ProductColorEntity productColorEntity){
		saveObject(productColorEntity);
	}
	
	
	public void updateProductColor(ProductColorEntity productColorEntity){
		updateObject(productColorEntity);
	}
	
	public List<ProductColorEntity> getProductColor(){
		Criteria criteria = createCriteria(ProductColorEntity.class);
		criteria.addOrder(Order.desc(ProductColorEntity.LAST_MODIFIED_DATE));
		return criteria.list();
	}
	
	
	public ProductColorEntity getProductColor(String productColorGuid){
		Criteria criteria = createCriteria(ProductColorEntity.class);
		criteria.add(Restrictions.eq(ProductColorEntity.PRODUCT_COLOR_GUID, productColorGuid));
		return (ProductColorEntity) criteria.uniqueResult();
	}
	
	public ProductDetailsEntity getProductDetails(String productDetailsGuid){
		Criteria criteria = createCriteria(ProductDetailsEntity.class);
		criteria.add(Restrictions.eq(ProductDetailsEntity.PRODUCT_GUID, productDetailsGuid));
		return (ProductDetailsEntity) criteria.uniqueResult();
	}
	
	
	public void saveProductDetails(ProductDetailsEntity productDetailsEntity){
		saveObject(productDetailsEntity);
	}
	
	
	public void updateProductDetails(ProductDetailsEntity productDetailsEntity){
		updateObject(productDetailsEntity);
	}
	
	
	public List<ProductGroupJson> getProductGroupList(){
		Criteria criteria = createCriteria(ProductGroupEntity.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property(ProductGroupEntity.PRODUCT_GROUP_GUID),"productGroupGuid");
		projectionList.add(Projections.property(ProductGroupEntity.PRODUCT_GROUP),"productGroups");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(ProductGroupJson.class));
		return criteria.list();
	}
	
	
	public List<ProductCategoryJson> getProductCategoryList(){
		Criteria criteria = createCriteria(ProductCategoryEntity.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property(ProductCategoryEntity.PRODUCT_CATEGORY_GUID),"productCategoryGuid");
		projectionList.add(Projections.property(ProductCategoryEntity.PRODUCT_CATEGORY),"productCategorys");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(ProductCategoryJson.class));
		return criteria.list();
	}
	
	
	public List<ProductColorJson> getProductColorList(){
		Criteria criteria = createCriteria(ProductColorEntity.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property(ProductColorEntity.PRODUCT_COLOR_GUID),"productColorGuid");
		projectionList.add(Projections.property(ProductColorEntity.PRODUCT_COLOR),"productColors");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(ProductColorJson.class));
		return criteria.list();
	}
	
	
	
	public List<ProductDetails> getProductDetailsList(){
		Criteria criteria = createCriteria(ProductDetailsEntity.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property(ProductDetailsEntity.PRODUCT_GUID),"productGuid");
		projectionList.add(Projections.property(ProductDetailsEntity.PRODUCT_NAME),"productName");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(ProductDetails.class));
		return criteria.list();
	}
	
	public List<ProductDetailsEntity> getProductDetailsEntity(){
		Criteria criteria = createCriteria(ProductDetailsEntity.class);
		return criteria.list();
	}
	
	public List<OrderEntity> getOrderEntityDetails(){
		Criteria criteria = createCriteria(OrderEntity.class);
		criteria.add(Restrictions.ne(OrderEntity.IS_DELETED, true));
		return criteria.list();
	}
	
	
	public OrderEntity getOrderEntityDetails(String orderGuid){
		Criteria criteria = createCriteria(OrderEntity.class);
		criteria.add(Restrictions.eq(OrderEntity.ORDER_GUID, orderGuid));
		List<OrderEntity> orderEntities = criteria.list();
		return orderEntities.size() > 0 ? orderEntities.get(0) : null;
	}
	
	
	public void createDeliveryDetailsEntity(DeliveryDetailsEntity deliveryDetailsEntity){
		saveObject(deliveryDetailsEntity);
	}
	
	
	public List<DeliveryDetailsEntity> getDeliveryDetailsEntity(OrderEntity orderEntity){
		Criteria criteria = createCriteria(DeliveryDetailsEntity.class);
		criteria.add(Restrictions.eq(DeliveryDetailsEntity.ORDER_ID, orderEntity));
		List<DeliveryDetailsEntity> deliveryDetailsEntities = criteria.list();
		return deliveryDetailsEntities;
	}



	public List<DeliveryDetailsEntity> getDeliveryDetailsEntity(){
		Criteria criteria = createCriteria(DeliveryDetailsEntity.class);
		List<DeliveryDetailsEntity> deliveryDetailsEntities = criteria.list();
		return deliveryDetailsEntities;
	}
	
	public DeliveryDetailsEntity getDeliveryDetailsEntity(String deliveryDetailsUUID){
		Criteria criteria = createCriteria(DeliveryDetailsEntity.class);
		criteria.add(Restrictions.eq(DeliveryDetailsEntity.DELIVERY_UUID, deliveryDetailsUUID));
		List<DeliveryDetailsEntity> deliveryDetailsEntities = criteria.list();
		return deliveryDetailsEntities.size() > 0 ? deliveryDetailsEntities.get(0) : null;
	}

}
