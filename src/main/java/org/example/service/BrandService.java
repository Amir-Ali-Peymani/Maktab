package org.example.service;

import org.example.entity.Brand;
import org.example.repostitory.BrandRepository;

import java.sql.SQLException;

public class BrandService {
    BrandRepository brandRepository = new BrandRepository();
    public void register(String name, String website, String description) throws SQLException {
        Brand brand = new Brand(name, website, description);
        brandRepository.saveBrand(brand);
    }
    public void load(int id)throws SQLException{
        System.out.println("------------------------------------------------------------");
        System.out.println("The name: "+ brandRepository.loadBrand(id).getName());
        System.out.println("The website: "+brandRepository.loadBrand(id).getWebsite());
        System.out.println("The description: "+brandRepository.loadBrand(id).getDescription());
        System.out.println("------------------------------------------------------------");
    }
    public void update(int id, int which, String input) throws SQLException {
        brandRepository.updateBrand(id, which, input);
    }
    public void delete(int id) throws SQLException {
        brandRepository.brandDelete(id);
    }
}

