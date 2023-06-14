package org.example.ui;

import org.example.config.MyConnection;
import org.example.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;
public class UserMain {
    Scanner scanner = new Scanner(System.in);
    private void signIn() throws SQLException, IOException {
        String user_name = "";
        String password = "";
        System.out.println("-------------------------------------------");
        System.out.println("if you want to exit press /c");
        System.out.print("user_name: ");
        user_name = scanner.next();
        if (Objects.equals(user_name, Constants.ExitCharacter)){
            return;
        }
        System.out.print("password: ");
        password = scanner.next();
        if (Objects.equals(password, Constants.ExitCharacter)){
            return;
        }
        Connection connection = MyConnection.getConnection();
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user_name);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean isNext = resultSet.next();
        resultSet.close();
        preparedStatement.close();
        if (isNext) {
            System.out.println("Valid credentials");
            System.out.println("* * * * * * * * * * * * * *");
            System.out.println("*         WELCOME!        *");
            System.out.println("* * * * * * * * * * * * * *");
        } else {
            System.out.println("Invalid credentials");
            return;
        }
        brand();
    }
    private void brand() throws SQLException, IOException {
        BrandService brandService = new BrandService();
        Connection connection = MyConnection.getConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brand_name = "";
        String website = "";
        String description = "";
        System.out.println("-input: ");
        int input = scanner.nextInt();
        if (Objects.equals(input, 0)){
            return;
        }
        System.out.println();
        System.out.println("________________________________________________");
        System.out.print("Brand_name: ");
        brand_name = br.readLine();
        if (Objects.equals(brand_name, Constants.ExitCharacter)) {
            return;
        }
        System.out.print("website: ");
        website = scanner.next();
        if (Objects.equals(website, Constants.ExitCharacter)) {
            return;
        }
        System.out.print("description: ");
        description = br.readLine();
        if (Objects.equals(description, Constants.ExitCharacter)) {
            return;
        }
        brandService.register(brand_name, website, description);
        System.out.println("Information has been added successfully!!");
//        String sql = "SELECT id FROM brand WHERE name = ? AND website = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, brand_name);
//        preparedStatement.setString(2, website);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        int brandId = 0;
//        if (resultSet.next()) {
//            brandId = resultSet.getInt("id");
//            System.out.println("User ID: " + brandId);
//        }
//        category(brandId);
    }
    private void category() throws SQLException, IOException {
        Connection connection = MyConnection.getConnection();
        CategoryService categoryService = new CategoryService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String category_name = "";
        String description = "";
        System.out.println("________________________________________________");
        System.out.println("if you press /c it will exit! ");
        System.out.print("category_name: ");
        category_name = br.readLine();
        if (Objects.equals(category_name, Constants.ExitCharacter)) {
            return;
        }
        System.out.print("description: ");
        description = br.readLine();
        if (Objects.equals(description, Constants.ExitCharacter)) {
            return;
        }
        categoryService.register(category_name, description);
        System.out.println("the information has been added successfully!!");
//        String sql = "SELECT id FROM category WHERE name = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, category_name);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        int categoryId = 0;
//        if (resultSet.next()) {
//            categoryId = resultSet.getInt("id");
//            System.out.println("User ID: " + categoryId);
//        }
    }
    private void product() throws SQLException, IOException {
        Connection connection = MyConnection.getConnection();
        ProductService productService = new ProductService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String product_name = "";
        int year = 0;
        int month = 0;
        int day = 0;
        int id_cat = 0;
        int id_br = 0;
        System.out.println("________________________________________________");
        System.out.println("if you press /c it will exit! ");
        System.out.print("product name: ");
        product_name = br.readLine();
        if (Objects.equals(product_name, Constants.ExitCharacter)) {
            return;
        }
        System.out.print("year: ");
        year = scanner.nextInt();
        if (Objects.equals(year, Constants.ExitCharacter)) {
            return;
        }
        System.out.print("month: ");
        month = scanner.nextInt();
        if (Objects.equals(month, Constants.ExitCharacter)) {
            return;
        }
        System.out.print("day: ");
        day = scanner.nextInt();
        if (Objects.equals(day, Constants.ExitCharacter)) {
            return;
        }
        Statement statement = connection.createStatement();
        String sql1 = "SELECT * FROM category";
        ResultSet resultSet1 = statement.executeQuery(sql1);
        while (resultSet1.next()){
            int id = resultSet1.getInt("id");
            String name = resultSet1.getString("name");
            String description = resultSet1.getString("description");
            System.out.println("---------------------------------------------------------");
            System.out.println("ID: "+ id + " | Name: " + name + " | Description: "+ description);
            System.out.println("---------------------------------------------------------");
        }
        System.out.print("which id do you want for category: ");
        id_cat = scanner.nextInt();
        String sql = "SELECT * FROM brand";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            System.out.println("---------------------------------------------------------");
            System.out.println("ID: " + id + "| Name: " + name + "| Description: " + description);
            System.out.println("---------------------------------------------------------");
        }
        System.out.println("which id do you want for brand: ");
        id_br = scanner.nextInt();
        java.sql.Date date = new java.sql.Date(year - 1900, month - 1, day);
        productService.register(product_name, date, id_cat, id_br);

    }
    private void signUp() throws SQLException, IOException {
        UserService userService = new UserService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        String user_name = "";
        String email = "";
        String password = "";
        System.out.println("________________________________________________");
        System.out.println("if you press /c it will exit! ");
        System.out.print("Name: ");
        name = br.readLine();
        if (Objects.equals(name, Constants.ExitCharacter)){
            return;
        }
        System.out.print("user_name: ");
        user_name = scanner.next();
        if (Objects.equals(user_name, Constants.ExitCharacter)){
            return;
        }
        System.out.print("email: ");
        email = scanner.next();
        if (Objects.equals(email, Constants.ExitCharacter)){
            return;
        }
        System.out.print("password: ");
        password = scanner.next();
        if (Objects.equals(password, Constants.ExitCharacter)){
            return;
        }
        userService.register(name, user_name, email, password);
        System.out.println("the in information has been added successfully!!");
    }
    private void shareHolder() throws SQLException, IOException {
        ShareholderService shareholderService = new ShareholderService();
        Connection connection = MyConnection.getConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        String phoneNumber = "";
        String nationalCode = "";
        System.out.println("________________________________________________");
        System.out.println("if you press /c it will exit! ");
        System.out.print("Name: ");
        name = br.readLine();
        if (Objects.equals(name, Constants.ExitCharacter)) {
            return;
        }
        System.out.print("Phone Number: ");
        phoneNumber = br.readLine();
        if (Objects.equals(phoneNumber, Constants.ExitCharacter)) {
            return;
        }
        System.out.print("National Code: ");
        nationalCode = br.readLine();
        if (Objects.equals(nationalCode,  Constants.ExitCharacter)) {
            return;
        }
        shareholderService.register(name, phoneNumber, nationalCode);
        System.out.println("the information has been added successfully!!");
        String sql = "SELECT id FROM shareholder WHERE name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        int userId_shareHolder = 0;
        if (resultSet.next()) {
            userId_shareHolder = resultSet.getInt("id");
            System.out.println("User ID: " + userId_shareHolder);
        }
        shareHolderBrand(userId_shareHolder);
    }
    private void shareHolderBrand(int id_share) throws SQLException{
        ShareholderBrandService shareholderBrandService = new ShareholderBrandService();
        int id = 0;
        System.out.println("________________________________________________");
        System.out.println("if you press /c it will exit! ");
        System.out.print("which brand do you want to be its shareholder: ");
        id = scanner.nextInt();
        if (Objects.equals(id, Constants.ExitCharacter)) {
            return;
        }
        shareholderBrandService.register(id_share, id);
        System.out.println("the information has been added successfully!!");
    }
    private void finished(){
        System.out.println("                      good bye have a nice a day                      ");
    }
    private void load() throws SQLException {
        panel3();
        System.out.print("-input: ");
        int input = scanner.nextInt();
        BrandService brandService = new BrandService();
        CategoryService categoryService = new CategoryService();
        ProductService productService = new ProductService();
        ShareholderService shareholderService = new ShareholderService();
        ShareholderBrandService shareholderBrandService = new ShareholderBrandService();
        UserService userService = new UserService();
        int id = 0;
        switch (input){
            case (1) -> {
                System.out.println("------------------------------------");
                System.out.print("please give the id: ");
                id = scanner.nextInt();
                if (Objects.equals(id, 0)){
                    break;
                }
                brandService.load(id);
            }
            case (2) -> {
                System.out.println("------------------------------------");
                System.out.print("please give the id: ");
                id = scanner.nextInt();
                if (Objects.equals(id, 0)){
                    return;
                }
                categoryService.load(id);
            }
            case (3) -> {
                System.out.println("------------------------------------");
                System.out.print("please give the id: ");
                id = scanner.nextInt();
                if (Objects.equals(id, 0)){
                    break;
                }
                productService.load(id);
            }
            case (4) -> {
                System.out.println("------------------------------------");
                System.out.print("please give the id: ");
                id = scanner.nextInt();
                if (Objects.equals(id, 0)){
                    break;
                }
                shareholderService.load(id);
            }
            case (5) ->{
                System.out.println("------------------------------------");
                System.out.print("please give the id: ");
                id = scanner.nextInt();
                if (Objects.equals(id, 0)){
                    break;
                }
                shareholderBrandService.load(id);
            }
            case (6) ->{
                System.out.println("------------------------------------");
                System.out.print("please give the id: ");
                id = scanner.nextInt();
                if (Objects.equals(id, 0)){
                    break;
                }
                userService.load(id);
            }
            default -> {
                System.out.println("in valid command");
            }
        }
    }
    private void update() throws IOException, SQLException, ParseException {
        panel3();
        System.out.println("-input: ");
        int input = scanner.nextInt();
        BrandService brandService = new BrandService();
        CategoryService categoryService = new CategoryService();
        ProductService productService = new ProductService();
        ShareholderService shareholderService = new ShareholderService();
        ShareholderBrandService shareholderBrandService = new ShareholderBrandService();
        UserService userService = new UserService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int id = 0;
        int which = 0;
        String input1 ="";
        if (input == 1){
            System.out.println("--------------------------");
            System.out.println("id: ");
            id = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.println("1.name");
            System.out.println("2.website");
            System.out.println("3.description");
            System.out.println("--------------------------");
            System.out.print("which: ");
            which = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.print("write the new one: ");
            input1 = br.readLine();
            brandService.update(id, which, input1);
        }
        if (input == 2){
            System.out.println("--------------------------");
            System.out.println("id: ");
            id = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.println("1.name");
            System.out.println("2.description");
            System.out.println("--------------------------");
            System.out.print("which: ");
            which = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.print("write the new one: ");
            input1 = br.readLine();
            categoryService.update(id, which, input1);
        }
        if (input == 3){
            System.out.println("--------------------------");
            System.out.println("id: ");
            id = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.println("1.name");
            System.out.println("2.date");
            System.out.println("3.category_id");
            System.out.println("4.brand_id");
            System.out.println("--------------------------");
            System.out.print("which: ");
            which = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.print("write the new one: ");
            input1 = br.readLine();
            productService.update(id, which, input1);
        }
        if (input == 4){
            System.out.println("--------------------------");
            System.out.println("id: ");
            id = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.println("1.name");
            System.out.println("2.phone number");
            System.out.println("3.national code");
            System.out.println("--------------------------");
            System.out.print("which: ");
            which = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.print("write the new one: ");
            input1 = br.readLine();
            shareholderService.update(id, which, input1);
        }
        if (input == 5){
            System.out.println("--------------------------");
            System.out.println("id: ");
            id = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.println("1.share holder id");
            System.out.println("2.brand id");
            System.out.println("--------------------------");
            System.out.print("which: ");
            which = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.print("write the new one: ");
            input1 = br.readLine();
            shareholderBrandService.update(id, which, Integer.parseInt(input1));
        }
        if (input == 6){
            System.out.println("--------------------------");
            System.out.println("id: ");
            id = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.println("1.name");
            System.out.println("2.username");
            System.out.println("3.email");
            System.out.println("4.password");
            System.out.println("--------------------------");
            System.out.print("which: ");
            which = scanner.nextInt();
            System.out.println("--------------------------");
            System.out.print("write the new one: ");
            input1 = br.readLine();
            userService.update(id, which,input1);
        }
    }
    private void delete() throws SQLException {
        panel3();
        System.out.println("-input: ");
        int input = scanner.nextInt();
        BrandService brandService = new BrandService();
        CategoryService categoryService = new CategoryService();
        ProductService productService = new ProductService();
        ShareholderService shareholderService = new ShareholderService();
        ShareholderBrandService shareholderBrandService = new ShareholderBrandService();
        UserService userService = new UserService();
        int id = 0;
        if (Objects.equals(input, Constants.ExitCharacter)){
            return;
        }
        if (input == 1){
            System.out.println("------------------------");
            System.out.println("which id you want to delete: ");
            id = scanner.nextInt();
            if (Objects.equals(id, Constants.ExitCharacter)){
                return;
            }
            brandService.delete(id);
        }
        if (input == 2){
            System.out.println("------------------------");
            System.out.println("which id you want to delete: ");
            id = scanner.nextInt();
            if (Objects.equals(id, Constants.ExitCharacter)){
                return;
            }
            categoryService.delete(id);
        }
        if (input == 3){
            System.out.println("------------------------");
            System.out.println("which id you want to delete: ");
            id = scanner.nextInt();
            if (Objects.equals(id, Constants.ExitCharacter)){
                return;
            }
            productService.delete(id);
        }
        if (input == 4){
            System.out.println("------------------------");
            System.out.println("which id you want to delete: ");
            id = scanner.nextInt();
            if (Objects.equals(id, Constants.ExitCharacter)){
                return;
            }
            shareholderService.delete(id);
        }
        if (input == 5){
            System.out.println("------------------------");
            System.out.println("which id you want to delete: ");
            id = scanner.nextInt();
            if (Objects.equals(id, Constants.ExitCharacter)){
                return;
            }
            shareholderBrandService.delete(id);
        }
        if (input == 6){
            System.out.println("------------------------");
            System.out.println("which id you want to delete: ");
            id = scanner.nextInt();
            if (Objects.equals(id, Constants.ExitCharacter)){
                return;
            }
            userService.delete(id);
        }
    }
    private String panel0(){
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*       Hello Welcome!                                        *");
        System.out.println("*       Would you please select which one you want to do:     *");
        System.out.println("*       1.SignUp                                              *");
        System.out.println("*       2.SignIn                                              *");
        System.out.println("*       3.exit                                                *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.print("input: ");
        String input = scanner.next();
        return input;
    }
    private void panel2(){
        System.out.println("* * * * * * * * * * * * *");
        System.out.println("* 1.brand               *");
        System.out.println("* 2.category            *");
        System.out.println("* 3.product             *");
        System.out.println("* 4.shareholder         *");
        System.out.println("* 5.shareholder brand   *");
        System.out.println("* 6.users               *");
        System.out.println("* 7.exit                *");
        System.out.println("* * * * * * * * * * * * *");
    }
    private void panel1(){
        System.out.println("* * * * * * * * * * * * *");
        System.out.println("* 1.create              *");
        System.out.println("* 2.load                *");
        System.out.println("* 3.update              *");
        System.out.println("* 4.delete              *");
        System.out.println("* 5.exit                *");
        System.out.println("* * * * * * * * * * * * *");
    }
    public void run() throws SQLException, IOException, ParseException {
        boolean flag = true;

    }
}