package com.deep.test.csv;

import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hudepin
 * @Description
 * @ClassName SaasStoreCsvRead
 * @create_date 2020.07.03 10:39
 * @since 1.2.0
 */
public class SaasStoreCsvRead {
    static String stores = "000100,000102,000103,000105,000106,000108,000109,000110,000111,000118,000123,000128,000130,000131,000137,000140,000141,000144,000147,000148,000150,000152,000157,000159,000162,000164,000166,000169,000172,000173,000174,000176,000179,000188,000195,000197,000198,000199,000200,000206,000207,000209,000211,000216,000223,000226,000229,000231,000232,000234,000235,000243,000245,000246,000252,000255,000258,000260,000262,000270,000272,000274,000277,000278,000279,000280,000281,000285,000288,000290,000301,000350,000450,000501,000551,000552,000602,000603,000650,000651,000652,000653,000822,000825,000828,000834,000845,000849,000850,000857,000862,000864,000902,000921,000926,000941,000944,000945,000952,000959,000980,000984,000985,000988,000994,000996,001023,001107,001109,001120,001122,001123,001127,001128,001130,001134,001137,001139,001144,001153,001157,001175,001181,001183,001189,001191,001193,001194,001195,001202,001203,001209,001226,001229,001234,001235,001243,001250,001255,001257,001264,001266,001267,001271,001272,001273,001278,001279,001280,001286,001293,001295,001301,001304,001305,001307,001310,001312,001313,001315,001316,001317,001320,001321,001322,001323,001324,001328,001337,001338,001344,001347,001351,001354,001355,001356,001357,001361,001362,001363,001364,001365,001377,001378,001396,001398,001401,001405,001414,001417,001418,001422,001423,001424,001428,001435,001443,001445,001447,001448,001462,001464,001477,001484,001489,001492,001498,001500,001505,001506,001507,001508,001526,001532,001535,001538,001542,001544,001639,001706,001718,001755,001756,001770,001854,001863,001874,001893,001903,001907,001908,001913,001914,001919,001922,001926,001927,001931,001933,001935,001940,001948,001953,002265,002418,002419,002530,002563,002597,002611,002618,002619,002620,002624,002636,002650,002651,002654,002659,002661,002685,002706,002726,002752,002931,002992,002997,003004,003020,003021,003023,003029,003045,003051,003063,003072,003081,003106,003243,003275,003292,003347,003400,003401,003442,003467,003468,003471,003484,003493,003502,003511,003599,003684,003700,003717,003768,003777,003806,003831,003833,003839,003844,003972,004119,004143,004379,004517,004538,004813,005130,006436,007210,007301,007401,007491,007591,007607,007697,007716,007760,007780,007998,008097,008164,008173,008234,008237,008238,008244,008267,008282,008383,008390,008392,008396,008410,008411,008412,008413,008442,008491,008493,008494,008495,008527,008547,008548,008549,008644,008670,008702,008734,008795,008855,008885,008888,008988,009014,009100,009102,009120,009126,009135,009168,009205,009231,009275,009349,009358,009374,009488,009522,009531,009554,009575,009605,009643,009664,009934,011578,011733,011740,011743,011866,011867,011917,011918,011919,300006,300008,300014,300015,300016,300020,300024,300026,300030,300033,300035,300040,300045,300047,300061,300062,300064,300065,300067,300068,300073,300080,300083,300084,300087,300088,300089,300091,300092,300094,300301,300303,300305,300317,300320,300323,300325,300326,300327,300330,300331,300332,300340,300348,300351,300354,300362,300370,300374,300379,300380,300381,300692,301027,301039,301042,301046,301079,301098,302802,302803,302805,302807,302808,302809,302810,302813,302815,302819,302822,302823,309333";
    static String sit_stores="000001,000002,111222,46762,300373,007780,008411,000550,009488,300327,000651,300692,300363,003468,000164,001901,000172,009231,000105,000241,000666,000285,300310,11111A,000231,000274,000200,011781,003292,GG12131231,000211,000157,1231111111,000123,003001,93232L,000602,007781,345657,123457,300381,000601,5333,001006,001991,008491,004517,001020,000243,000243";
    private static List<String> existsStores = Arrays.asList(stores.split(","));
    private static List<String> sitExistsStores = Arrays.asList(sit_stores.split(","));
    private static final String initStore="curl -H 'Content-Type:application/json'  -X POST --data '%s' http://10.201.35.158:7210/mp-account-paas/store/add/batch.htm";
    //private static final String initStoreMerchant="curl -H 'Content-Type:application/json'  -X POST --data '%s' http://10.201.35.158:7210/mp-account-paas/store/merchantStore/add/batch";
    public static void main(String[] args) {
        List<SaasStore> list = redcsvPrd("012896.csv");
        SaasStoreWrap saasStoreWrap = new SaasStoreWrap();
        saasStoreWrap.setStores(list);
        System.out.println(String.format(initStore,new Gson().toJson(saasStoreWrap)));



    }

    /**
     * 2010-联华上海卖场，2020-联华上海标超，2030-联华上海快客
     *
     * @return
     */
    public static List<SaasStore> redcsv() {
        try {
            String csvFilePath = "E:\\store.csv";
            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("STORE_TYPE", "STORE_CODE", "STORE_NAME", "PROVINCE", "CITY", "AREA", "ADDR", "STATE", "XC_STORE_TYPE", "STORE_DESC", "FUNTIONS")
                    .parse(reader);
            List<SaasStore> stores = new ArrayList<>();
            for (CSVRecord record : parser) {
                if ("STORE_TYPE".equals(record.get("STORE_TYPE"))) {
                    continue;
                }
                if (record.get("STORE_TYPE") != null && StringUtils.isNotBlank(record.get("STORE_TYPE").trim())) {
                    SaasStore store = new SaasStore();
                    if (record.get("STORE_TYPE") != null && StringUtils.isNotBlank(record.get("STORE_TYPE"))) {
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
                        store.setSysStoreCode(store.getSubBuId() + store.getXcStoreCode());
                        store.setStoreDesc(record.get("STORE_DESC").trim());
                        //store.setStoreCooperationModelSid(17L);
                        store.setMerchantSid(1l);
                        if (record.get("FUNTIONS") != null) {
                            String[] arrs = record.get("FUNTIONS").trim().split(",");
                            String temps = "";
                            if (arrs != null && arrs.length > 0) {
                                for (String s : arrs) {
                                    if (s.equals("11")) {
                                        //快到家
                                        temps = temps + s + ",";
                                    } else if (s.equals("2")) {
                                        //自提点
                                        temps = temps + s + ",";
                                    }
                                }
                            }
                            if (temps.contains(",")) {
                                store.setDeliveryMethod(temps.substring(0, temps.lastIndexOf(",")));
                            }

                        }
                        stores.add(store);
                    }
                }
            }

            reader.close();
            return stores;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    public static List<SaasStore> redcsvSit() {
        try {
            String csvFilePath = "E:\\work\\迭代项目\\到家履约中心\\倒腾门店\\sit\\012799.csv";
            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("CITY_NAME", "STORE_NAME", "FUNTIONS", "STORE_CODE", "PROVINCE", "CITY", "AREA", "STATE", "STORE_TYPE", "ADDR")
                    .parse(reader);
            List<SaasStore> stores = new ArrayList<>();
            for (CSVRecord record : parser) {
                if ("STORE_TYPE".equals(record.get("STORE_TYPE"))) {
                    continue;
                }
                if (record.get("STORE_TYPE") != null && StringUtils.isNotBlank(record.get("STORE_TYPE").trim())) {
                    SaasStore store = new SaasStore();
                    if (record.get("STORE_TYPE") != null && StringUtils.isNotBlank(record.get("STORE_TYPE"))) {
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
                        store.setSysStoreCode(store.getSubBuId() + store.getXcStoreCode());
                        //store.setStoreDesc(record.get("STORE_DESC").trim());
                        //store.setStoreCooperationModelSid(17L);
                        store.setMerchantSid(1l);
                        if (record.get("FUNTIONS") != null) {
                            String[] arrs = record.get("FUNTIONS").trim().split(",");
                            String temps = "";
                            if (arrs != null && arrs.length > 0) {
                                for (String s : arrs) {
                                    if (s.equals("11")) {
                                        //快到家
                                        temps = temps + s + ",";
                                    } else if (s.equals("2")) {
                                        //自提点
                                        temps = temps + s + ",";
                                    }
                                }
                            }
                            if (temps.contains(",")) {
                                store.setDeliveryMethod(temps.substring(0, temps.lastIndexOf(",")));
                            }

                        }
                        if(!isExists(store.getXcStoreCode())){
                            stores.add(store);
                        }
                    }
                }
            }

            reader.close();
            return stores;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    public static boolean isExists(String storeCode) {
        List<String> s = sitExistsStores.stream().filter(e -> e.equals(storeCode)).collect(Collectors.toList());
        return (s==null || CollectionUtils.isEmpty(s)) ? false : true;
    }

    public static List<SaasStore> redcsvPrd(String fileName) {
        try {
            String csvFilePath = "E:\\work\\迭代项目\\到家履约中心\\倒腾门店\\prd\\"+fileName;
            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("CITY_NAME", "STORE_NAME", "FUNTIONS", "STORE_CODE", "PROVINCE", "CITY", "AREA", "STATE", "STORE_TYPE", "ADDR")
                    .parse(reader);
            List<SaasStore> stores = new ArrayList<>();
            for (CSVRecord record : parser) {
                if ("STORE_TYPE".equals(record.get("STORE_TYPE"))) {
                    continue;
                }
                if (record.get("STORE_TYPE") != null && StringUtils.isNotBlank(record.get("STORE_TYPE").trim())) {
                    SaasStore store = new SaasStore();
                    if (record.get("STORE_TYPE") != null && StringUtils.isNotBlank(record.get("STORE_TYPE"))) {
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
                        store.setSysStoreCode(store.getSubBuId() + store.getXcStoreCode());
                        //store.setStoreDesc(record.get("STORE_DESC").trim());
                        //store.setStoreCooperationModelSid(17L);
                        store.setMerchantSid(1l);
                        if (record.get("FUNTIONS") != null) {
                            String[] arrs = record.get("FUNTIONS").trim().split(",");
                            String temps = "";
                            if (arrs != null && arrs.length > 0) {
                                for (String s : arrs) {
                                    if (s.equals("11")) {
                                        //快到家
                                        temps = temps + s + ",";
                                    } else if (s.equals("2")) {
                                        //自提点
                                        temps = temps + s + ",";
                                    }
                                }
                            }
                            if (temps.contains(",")) {
                                store.setDeliveryMethod(temps.substring(0, temps.lastIndexOf(",")));
                            }

                        }
                        if(!isExists(store.getXcStoreCode())){
                            stores.add(store);
                        }
                    }
                }
            }

            reader.close();
            return stores;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }
}
