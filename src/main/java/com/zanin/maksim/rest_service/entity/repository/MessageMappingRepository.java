package com.zanin.maksim.rest_service.entity.repository;

import com.zanin.maksim.rest_service.entity.entity.MessageMapping;
import com.zanin.maksim.rest_service.entity.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class MessageMappingRepository {

    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public List<MessageMapping> getAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteria = criteriaBuilder.createQuery(MessageMapping.class);
        Root<MessageMapping> element = criteria.from(MessageMapping.class);
        return entityManager.createQuery(criteria).getResultList();
    }

    public MessageMapping getById(long id){
        logger.info("Get message mapping by id: " + id);
        return entityManager.find(MessageMapping.class, id);
    }

    public List<MessageMapping> getByFromId(User from_id){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteria = criteriaBuilder.createQuery(MessageMapping.class);
        Root<MessageMapping> element = criteria.from(MessageMapping.class);
        return entityManager.createQuery(criteria).getResultList();
    }
}