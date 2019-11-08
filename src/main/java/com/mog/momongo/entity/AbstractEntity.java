package com.mog.momongo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractEntity
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if (obj == null || this.id == null || !(this.getClass() == obj.getClass())){
            return false;
        }
        AbstractEntity o = (AbstractEntity) obj;
        return this.getId().equals(o.getId());
    }

    @Override
    public int hashCode() {
        return this.id == null ? 0 : this.id.hashCode();
    }
    
}