package org.zkoss.bind.examples.spring.search.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("itemDao")
public class ItemDao{
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void newOrder(Item item) {
		
		em.persist(item);
	}

	public List<Item> findAll(){
		return em.createQuery("select I from Item I").getResultList();
	}
	
	@Transactional
	public void save(Item item) {
		em.merge(item);
	}
	
	@Transactional
	public void remove(Item item) {
		em.remove(em.merge(item));
	}
	
	public List<Item> findByFilter(String keyword){
		String jql = "select I from Item I ";
		if (keyword != null){
			jql += "where I.name like '%"+keyword+"%'";
		}
		return em.createQuery(jql).getResultList();
	}
	
	public List<Item> findByRange(int begin, int max, String filter){
		String jql = "select I from Item I ";
		if (filter != null){
			jql += "where I.name like '%"+filter+"%'";
		}
		return em.createQuery(jql).setFirstResult(begin).setMaxResults(max).getResultList();
	}
	
	public List<Item> findByRangeOrder(int begin, int max, boolean ascending, String orderBy,String filter){
		String jql = "select I from Item I " ;

		if (filter != null){
			jql += "where I.name like '%"+filter+"%'";
		}
		jql += " order by I."+orderBy;
		if (ascending){
			jql += " asc";
		}else{
			jql += " desc";
		}
		return em.createQuery(jql).setFirstResult(begin).setMaxResults(max).getResultList();
	}

}
