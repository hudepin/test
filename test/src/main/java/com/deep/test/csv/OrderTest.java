package com.deep.test.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hudepin
 * @Description
 * @ClassName OrderTest
 * @create_date 2020.05.23 11:26
 * @since 1.2.0
 */
public class OrderTest {
    public static final String sql="update mp_admin.mp_order t set t.customer_name='%s',t.credentials_no='%s' where t.order_no='%s';";
    public static final String sql2="update shopping.t_ngsp_mp_order t set t.name_id='%s' where t.mp_order_no='%s';";
    public static void main(String[] args) {
        redcsv1();
    }
    public static  void redcsv(){
        try {
            String csvFilePath = "E:\\maotai3.csv";
            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream,"GBK");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("var_1", "var_2","var_3")
                    .parse(reader);
            List<OrderInfo> orderInfoList = new ArrayList<>();
            for (CSVRecord record : parser)
            {
                if("var_1".equals(record.get("var_1"))){
                    continue;
                }
                if(record.get("var_1") != null && StringUtils.isNotBlank(record.get("var_1").trim())){
                    OrderInfo gspInfo = new OrderInfo();
                    if(record.get("var_1") !=null && StringUtils.isNotBlank(record.get("var_1"))){
                        gspInfo.setOrderNo(record.get("var_1").trim());
                        gspInfo.setCustomerName(record.get("var_2").trim());
                        gspInfo.setIdCard(record.get("var_3"));
                        orderInfoList.add(gspInfo);
                    }

                }
            }
            orderInfoList.forEach(e->{
                System.out.print(String.format(sql,e.getCustomerName(),e.getIdCard(),e.getOrderNo()));
            });
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  void redcsv1(){
        try {
            String csvFilePath = "E:\\cer.csv";
            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream,"GBK");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("var_1", "var_2","var_3")
                    .parse(reader);
            List<OrderInfo> orderInfoList = new ArrayList<>();
            for (CSVRecord record : parser)
            {
                if("var_1".equals(record.get("var_1"))){
                    continue;
                }
                if(record.get("var_1") != null && StringUtils.isNotBlank(record.get("var_1").trim())){
                    OrderInfo gspInfo = new OrderInfo();
                    if(record.get("var_1") !=null && StringUtils.isNotBlank(record.get("var_1"))){
                        gspInfo.setOrderNo(record.get("var_2").trim());
                        gspInfo.setCustomerName(record.get("var_1").trim());

                        orderInfoList.add(gspInfo);
                    }

                }
            }
            orderInfoList.forEach(e->{
                System.out.println(String.format(sql2,e.getCustomerName(),e.getOrderNo()));
            });
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
