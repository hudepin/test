package com.deep.test.csv;

import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hudepin
 * @Description
 * @ClassName SaasStoreCsvRead
 * @create_date 2020.07.03 10:39
 * @since 1.2.0
 */
public class SaasStoreCsvRead {
    public static void main(String[] args) {
        List<SaasStore> list = redcsvPrd();
        SaasStoreWrap saasStoreWrap = new SaasStoreWrap();
        saasStoreWrap.setStores(list);
        System.out.println(new Gson().toJson(saasStoreWrap));

    }

    /**
     * 2010-联华上海卖场，2020-联华上海标超，2030-联华上海快客
     * @return
     */
    public static  List<SaasStore> redcsv(){
        try {
            String csvFilePath = "E:\\store.csv";
            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream,"GBK");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("STORE_TYPE", "STORE_CODE","STORE_NAME","PROVINCE","CITY","AREA","ADDR","STATE","XC_STORE_TYPE","STORE_DESC","FUNTIONS")
                    .parse(reader);
            List<SaasStore> stores = new ArrayList<>();
            for (CSVRecord record : parser)
            {
                if("STORE_TYPE".equals(record.get("STORE_TYPE"))){
                    continue;
                }
                if(record.get("STORE_TYPE") != null && StringUtils.isNotBlank(record.get("STORE_TYPE").trim())){
                    SaasStore store = new SaasStore();
                    if(record.get("STORE_TYPE") !=null && StringUtils.isNotBlank(record.get("STORE_TYPE"))){
                        store.setSubBuId(record.get("STORE_TYPE").trim());
//                        if(store.getBuId().equals("2010")){
//                            store.setXcStoreType("1");
//                        }else if(store.getBuId().equals("2020")){
//                            store.setXcStoreType("2");
//                        } else if(store.getBuId().equals("2030")){
//                            store.setXcStoreType("3");
//                        }
                        store.setXcStoreCode(record.get("STORE_CODE").trim());
                        store.setStoreName(record.get("STORE_NAME").trim());
                        store.setAddrProvince(record.get("PROVINCE").trim());
                        store.setAddrCity(record.get("CITY").trim());
                        store.setAddrDistrict(record.get("AREA").trim());
                        store.setAddrDetail(record.get("ADDR").trim());
                        store.setBusinessStatus(record.get("STATE").trim());
                        store.setXcStoreType(record.get("XC_STORE_TYPE").trim());
                        store.setSysStoreCode(store.getSubBuId()+store.getXcStoreCode());
                        store.setStoreDesc(record.get("STORE_DESC").trim());
                        //store.setStoreCooperationModelSid(17L);
                        store.setMerchantSid(1l);
                        if(record.get("FUNTIONS") != null){
                            String[] arrs =record.get("FUNTIONS").trim().split(",");
                            String temps ="";
                            if(arrs !=null && arrs.length>0){
                               for(String s:arrs){
                                   if(s.equals("11")){
                                       //快到家
                                       temps=temps+s+",";
                                   }else if(s.equals("2")){
                                       //自提点
                                       temps=temps+s+",";
                                   }
                               }
                            }
                            if(temps.contains(",")){
                                store.setDeliveryMethod(temps.substring(0,temps.lastIndexOf(",")));
                            }

                        }
                        stores.add(store);
                    }
                }
            }

            reader.close();
            return stores;

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return null;
    }
    public static  List<SaasStore> redcsvPrd(){
        try {
            String csvFilePath = "E:\\data20201026prd.csv";
            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream,"GBK");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("CITY_NAME","STORE_NAME","FUNTIONS","STORE_CODE","PROVINCE","CITY","AREA","STATE","STORE_TYPE","ADDR")
                    .parse(reader);
            List<SaasStore> stores = new ArrayList<>();
            for (CSVRecord record : parser)
            {
                if("STORE_TYPE".equals(record.get("STORE_TYPE"))){
                    continue;
                }
                if(record.get("STORE_TYPE") != null && StringUtils.isNotBlank(record.get("STORE_TYPE").trim())){
                    SaasStore store = new SaasStore();
                    if(record.get("STORE_TYPE") !=null && StringUtils.isNotBlank(record.get("STORE_TYPE"))){
                        store.setSubBuId(record.get("STORE_TYPE").trim());
//                        if(store.getBuId().equals("2010")){
//                            store.setXcStoreType("1");
//                        }else if(store.getBuId().equals("2020")){
//                            store.setXcStoreType("2");
//                        } else if(store.getBuId().equals("2030")){
//                            store.setXcStoreType("3");
//                        }

                        store.setXcStoreCode(record.get("STORE_CODE").trim());
                        store.setStoreName(record.get("STORE_NAME").trim());
                        store.setAddrProvince(record.get("PROVINCE").trim());
                        store.setAddrCity(record.get("CITY").trim());
                        store.setAddrDistrict(record.get("AREA").trim());
                        store.setAddrDetail(record.get("ADDR").trim());
                        store.setBusinessStatus(record.get("STATE").trim());
                        //store.setXcStoreType(record.get("XC_STORE_TYPE").trim());
                        store.setSysStoreCode(store.getSubBuId()+store.getXcStoreCode());
                        //store.setStoreDesc(record.get("STORE_DESC").trim());
                        //store.setStoreCooperationModelSid(17L);
                        store.setMerchantSid(1l);
                        if(record.get("FUNTIONS") != null){
                            String[] arrs =record.get("FUNTIONS").trim().split(",");
                            String temps ="";
                            if(arrs !=null && arrs.length>0){
                                for(String s:arrs){
                                    if(s.equals("11")){
                                        //快到家
                                        temps=temps+s+",";
                                    }else if(s.equals("2")){
                                        //自提点
                                        temps=temps+s+",";
                                    }
                                }
                            }
                            if(temps.contains(",")){
                                store.setDeliveryMethod(temps.substring(0,temps.lastIndexOf(",")));
                            }

                        }
                        stores.add(store);
                    }
                }
            }

            reader.close();
            return stores;

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return null;
    }
}
