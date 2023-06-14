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
        System.out.println(shareholderRepository.loadShareholder(id));
    }
    public void update(int id, int which, String input) throws SQLException{
        shareholderRepository.updateShareholder(id, which , input);
    }
    public void delete(int id) throws  SQLException{
        shareholderRepository.shareholderDelete(id);
    }
}
