package com.zanin.maksim.rest_service.entity.registrator;

import com.zanin.maksim.rest_service.entity.entity.MessageMapping;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class MessageMappingRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(MessageMapping item) {
        logger.info("Created message mapping: " + item);
        entityManager.merge(item);
    }

    public void  update (MessageMapping item){
        logger.info("Updated message mapping: " + item);
        entityManager.merge(item);
    }

    public void delete (MessageMapping item){
        logger.info("Deleted message mapping: " + item);
        entityManager.remove(item);
    }
}