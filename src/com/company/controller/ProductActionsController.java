package com.company.controller;

import com.company.exceptions.NoProductFoundException;
import com.company.exceptions.NotUniqueProductException;
import com.company.model.ProductModel;
import com.company.model.ProductTypes;

import java.io.IOException;
import java.util.Map;

public interface ProductActionsController {

    boolean addProduct(ProductTypes product, double price) throws NotUniqueProductException;

    Map<Integer, ProductModel> removeProduct(long id) throws NoProductFoundException;

    Map<Integer, ProductModel> getProductByType(ProductTypes type) throws NoProductFoundException;

    void saveDateToDB(Map<Integer, ProductModel> productList) throws NoProductFoundException, IOException;
}
