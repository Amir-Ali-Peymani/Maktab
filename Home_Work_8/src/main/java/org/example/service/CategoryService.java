package org.example.service;

import org.example.entity.Category;
import org.example.repostitory.CategoryRepository;

import java.sql.SQLException;

public class CategoryService {
    CategoryRepository categoryRepository = new CategoryRepository();
    public void register(String name, String description) throws SQLException {
        Category category = new Category(name, description);
        categoryRepository.saveCategory(category);
    }
    public void load(int Id) throws SQLException {
        System.out.println("------------------------------------------------------------");
        System.out.println("The name: "+ categoryRepository.loadCategory(Id).getName());
        System.out.println("The description: "+ categoryRepository.loadCategory(Id).getDescription());
        System.out.println("------------------------------------------------------------");
    }
    public void update(int id , int which, String input) throws SQLException{
        categoryRepository.updateCategory(id, which, input);
    }
    public void delete(int id) throws SQLException {
        categoryRepository.categoryDelete(id);
    }
}
