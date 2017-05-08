package com.sounds.bvs.data.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;

import com.sounds.bvs.data.configuration.HibernateUtil;

/**
 * @author Vikram
 *
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractDao<T, ID extends Serializable> implements Dao<T, ID>  {

	private final Class<T> persistentClass;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}


	public Class<T> getPersistentClass(){
		return persistentClass;
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#findById(java.lang.Object)
	 */
	@Override
	public T findById(final ID id) {
		this.getSession().getTransaction().begin();
		return (T) this.getSession().load(this.getPersistentClass(), id);
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#findAll()
	 */
	@Override
	public List<T> findAll() {
		return this.findByCriteria();
	}

	/**
	 * @param criterion
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion ... criterion){
		this.getSession().getTransaction().begin();
		Criteria crit = this.getSession().createCriteria(this.getPersistentClass());

		for(Criterion c: criterion){
			crit.add(c);
		}
		return (List<T>) crit.list();

	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public T save(final T entity) {
		this.getSession().getTransaction().begin();
		this.getSession().persist(entity);
		this.getSession().getTransaction().commit();
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public T update(final T entity) {
		this.getSession().getTransaction().begin();
		this.getSession().update(entity);
		this.getSession().getTransaction().commit();
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public T saveOrUpdate(final T entity) {
		this.getSession().getTransaction().begin();
		this.getSession().saveOrUpdate(entity);
		this.getSession().getTransaction().commit();
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(final ID  id) {
		this.getSession().getTransaction().begin();
		this.getSession().delete(findById(id));
		this.getSession().getTransaction().commit();
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#flush()
	 */
	@Override
	public void flush() {
		this.getSession().flush();
	}

	/* (non-Javadoc)
	 * @see com.sounds.bvs.data.dao.Dao#clear()
	 */
	@Override
	public void clear() {
		this.getSession().clear();
	}


}
