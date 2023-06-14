package org.example.service;

import org.example.entity.Shareholder;
import org.example.repostitory.ShareholderRepository;

import java.sql.SQLException;

public class ShareholderService {
    ShareholderRepository shareholderRepository = new ShareholderRepository();
    public void register(String name, String phone_number, String national_code) throws SQLException {
        Shareholder shareholder = new Shareholder(name, phone_number, national_code);
        shareholderRepository.saveShareholder(shareholder);
    }
    public void load(int id) throws  SQLException{
        System.out.println("------------------------------------------------------------");
        System.out.println("The name: "+shareholderRepository.loadShareholder(id).getName());
        System.out.println("The phone_number: "+shareholderRepository.loadShareholder(id).getPhoneNumber());
        System.out.println("The national_code: "+shareholderRepository.loadShareholder(id).getNationalCode());
        System.out.println("------------------------------------------------------------");
    }
    public void update(int id, int which, String input) throws SQLException{
        shareholderRepository.updateShareholder(id, which , input);
    }
    public void delete(int id) throws  SQLException{
        shareholderRepository.shareholderDelete(id);
    }
}
