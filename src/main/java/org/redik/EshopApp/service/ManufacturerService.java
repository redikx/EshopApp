package org.redik.EshopApp.service;

import java.util.List;

import org.redik.EshopApp.entity.Manufacturer;

public interface ManufacturerService {

	public List<Manufacturer> getAllManufacturer();

	public Manufacturer getManufacturer(int id);

	public void saveManufacturer(Manufacturer manufacturer);

	public void deleteManufacturer(int id);

}
