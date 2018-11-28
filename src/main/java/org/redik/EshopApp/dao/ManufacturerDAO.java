package org.redik.EshopApp.dao;

import java.util.List;

import org.redik.EshopApp.entity.Manufacturer;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerDAO {

	public List<Manufacturer> getAllManufacturer();
	
	public Manufacturer getManufacturer(int id);
	
	public void saveManufacturer(Manufacturer manufacturer);
	
	public void deleteManfucturer(int id);
	
	}
