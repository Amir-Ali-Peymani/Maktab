package org.example.service;

import org.example.entity.ShareholderBrand;
import org.example.repostitory.ShareholderBrandRepository;

import java.sql.SQLException;

public class ShareholderBrandService {
    ShareholderBrandRepository shareholderBrandRepository = new ShareholderBrandRepository();
    public void register(int share_id, int brand_id) throws SQLException {
        ShareholderBrand shareholderBrand = new ShareholderBrand(share_id, brand_id);
        shareholderBrandRepository.saveShareholderBrandRepository(shareholderBrand);
    }
    public void load(int id) throws SQLException {
        System.out.println("------------------------------------------------------------");
        System.out.println("The shareholderBrand id: "+shareholderBrandRepository.loadShareholderBrand(id).getShareholder());
        System.out.println("The brand id: "+shareholderBrandRepository.loadShareholderBrand(id).getBrandId());
        System.out.println("------------------------------------------------------------");
    }
    public void update(int id, int shar_id, int brand) throws SQLException {
        shareholderBrandRepository.updateShareholderBrand(id,shar_id, brand);
    }
    public void delete(int id) throws SQLException{
        shareholderBrandRepository.shareholderDelete(id);
    }
}
