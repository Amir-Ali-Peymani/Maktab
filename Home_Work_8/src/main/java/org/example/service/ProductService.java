package org.example.service;

import org.example.entity.Product;
import org.example.repostitory.ProductRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

public class ProductService {
    ProductRepository productRepository = new ProductRepository();
    public void register(String name, Date date, int cat_id, int bra_id) throws SQLException {
        Product product = new Product(name, date, cat_id, bra_id);
        productRepository.saveProduct(product);
    }
    public void load(int id) throws SQLException {
        System.out.println("------------------------------------------------------------");
        System.out.println("The name: "+productRepository.loadProduct(id).getName());
        System.out.println("The created date: "+productRepository.loadProduct(id).getCreated_date());
        System.out.println("The category id: "+productRepository.loadProduct(id).getCategory_id());
        System.out.println("The product id: "+productRepository.loadProduct(id).getBrand_id());
        System.out.println("------------------------------------------------------------");
    }
    public void update(int id0, int input1, String input2) throws SQLException, ParseException {
        productRepository.updateProduct(id0, input1, input2);
    }
    public void delete(int id) throws SQLException {
        productRepository.productDelete(id);
    }
}
