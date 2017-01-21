package com.company.store;

import com.company.controller.ProductActionsController;
import com.company.exceptions.NoProductFoundException;
import com.company.exceptions.NotUniqueProductException;
import com.company.model.ProductModel;
import com.company.model.ProductTypes;
import com.company.productUtils.ProductUtils;
import com.company.productUtils.Validation;

import java.io.IOException;
import java.util.*;


public class Store implements ProductActionsController {

    private int lastKey = 0;
    public Map<Integer, ProductModel> productModelList;

    private Validation validation;

    public Store() {
        this.productModelList = new TreeMap<>();
        this.validation = new Validation();
    }

    @Override
    public boolean addProduct(ProductTypes productTypes, double price) throws NotUniqueProductException {
        ProductModel product = new ProductModel(productTypes, price);
        if (validation.checkProduct(product)) {
            product.setId(lastKey);
            product.setDate(ProductUtils.getCurrentTime());
            productModelList.put(lastKey++, product);
            return true;
        }
        return false;
    }

    @Override
    public Map<Integer, ProductModel> removeProduct(long id) throws NoProductFoundException {
        productModelList.remove(id);
        return productModelList;
    }

    @Override
    public Map<Integer, ProductModel> getProductByType(ProductTypes type) throws NoProductFoundException {
        for (Integer entry : productModelList.keySet()) {
            if (type.equals(entry.getClass().getTypeName())) {
                return (Map<Integer, ProductModel>) productModelList.get(entry);
            }
        }
        return null;
    }

    @Override
    public void saveDateToDB(Map<Integer, ProductModel> productList) throws NoProductFoundException, IOException {
        ProductUtils.writeResultTODB(productList);
    }
}
