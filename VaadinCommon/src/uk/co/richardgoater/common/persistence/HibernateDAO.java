package uk.co.richardgoater.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateDAO {

	protected HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	protected void bulkRemove(String[] tables, String whereClause) {
		for(String table : tables) {
			hibernateTemplate.deleteAll(
				hibernateTemplate.find(
					"from " + table + " " + whereClause
				)
			);
		}
	}
}
