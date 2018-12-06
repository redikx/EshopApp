package org.redik.EshopApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.redik.EshopApp.dao.ManufacturerDAO;
import org.redik.EshopApp.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	
	@Autowired 
	private ManufacturerDAO manufacturerDAO;
	
	 @Override
	@Transactional
	public List<Manufacturer> getAllManufacturer() {
		return manufacturerDAO.getAllManufacturer();
	}

	@Override
	@Transactional
	public Manufacturer getManufacturer(int id) {
		return manufacturerDAO.getManufacturer(id);
	}

	@Override
	@Transactional
	public void saveManufacturer(Manufacturer manufacturer) {
		manufacturerDAO.saveManufacturer(manufacturer);
		
	}

	@Override
	@Transactional
	public void deleteManufacturer(int id) {
		manufacturerDAO.deleteManfucturer(id);
	}

}
