package org.redik.EshopApp.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.EshopApp.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;

public class ManufacturerDAOImpl implements ManufacturerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Manufacturer> getAllManufacturer() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Manufacturer> thisQuery=session.createQuery("from Manufacturer order by manufacturer_id",Manufacturer.class);
		List<Manufacturer> manufacturer = thisQuery.getResultList();
		return manufacturer;
		
	}

	@Override
	@Transactional
	public Manufacturer getManufacturer(int id) {
	Session session = sessionFactory.getCurrentSession();
	Manufacturer manufacturer = session.get(Manufacturer.class, id);
		return manufacturer;
	}

	@Override
	@Transactional
	public void saveManufacturer(Manufacturer manufacturer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(manufacturer);
	}

	@Override
	@Transactional
	public void deleteManfucturer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete from Manufacturer where manufacturer_id = :toDelete");
		theQuery.setParameter("toDelete", id);
		theQuery.executeUpdate();
		
	}
	
	
	
}
