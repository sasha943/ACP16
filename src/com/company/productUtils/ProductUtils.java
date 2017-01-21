package com.company.productUtils;

import com.company.model.ProductModel;
import org.omg.CORBA.portable.InputStream;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ProductUtils {

    private static final String DB_PATH = "/IdeaProjects/StoreShop/src/com/company/DB.txt";
    public static Date getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return new Date();
    }

    public static void writeResultTODB(Map<Integer, ProductModel> productModelMap) throws IOException {
        FileWriter fileWriter = new FileWriter(DB_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(mapToString(productModelMap));
    }

    private static String mapToString(Map<Integer, ProductModel> productModelMap){
        return productModelMap.toString();
    }

}
