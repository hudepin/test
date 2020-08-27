package com.deep.test.csv;

import com.sun.activation.registries.MailcapParseException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hudepin
 * @Description
 * @ClassName Test
 * @create_date 2020.04.22 17:45
 * @since 1.2.0
 */
public class Test {
    private static String sql="update t_ngsp_goods_stock t set store_num=%s ,t.update_date=sysdate,t.update_user='报损调整-old num %d' where t.goods_sid=(select g.sid from t_ngsp_goods g where g.sku='%s'); ";
    private static final String sql2="update shopping.srm_invtype t set t.nownum=%d,t. where t.productid=%s and t.inventoryid=%s;";
    private static String sql3="insert into shopping.t_ngsp_goods_stock_log (SID, GOODS_SID, STOCK_FRONT, STOCK_AFTER, REASON, CREATE_USER, CREATE_DATE, IS_DELETED) " +
            "values (S_T_NGSP_GOODS_STOCK_LOG.NEXTVAL, '%s', '%d', '%d', '报损', '报损', sysdate, 0);";
    private static List<String> excludes= new ArrayList<>();

    static {
        excludes.add("900046003");
        excludes.add("900045913");
        excludes.add("900045965");
        excludes.add("900045945");
        excludes.add("900045982");
        excludes.add("900053572");
        excludes.add("900053574");
        excludes.add("900053571");
        excludes.add("999122541");
        excludes.add("900051009");
        excludes.add("900051009");
        excludes.add("999122541");
        excludes.add("900053572");
        excludes.add("900053574");
        excludes.add("900053571");
        excludes.add("900046003");
        excludes.add("900045965");
        excludes.add("900045982");
        excludes.add("900045945");
        excludes.add("900045913");

    }

    public static void main(String[] args) {
        redcsv();
    }

    public static  void redcsv(){
        try {
            String csvFilePath = "E:\\gsp-goods.csv";
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = CSVFormat.DEFAULT.withHeader("gsp_0", "gsp_1","gsp_2", "erp_0","erp_1")
                    .parse(reader);
            Map<String,GspInfo> data1 =new HashMap<String,GspInfo>();
            Map<String,String> data2 =new HashMap<String,String>();;
            for (CSVRecord record : parser)
            {
                if("gsp_0".equals(record.get("gsp_0"))){
                    continue;
                }
                if(record.get("gsp_0") != null && StringUtils.isNotBlank(record.get("gsp_0").trim())){
                    GspInfo gspInfo = new GspInfo();
                    if(record.get("gsp_1") !=null && StringUtils.isNotBlank(record.get("gsp_1"))){
                        gspInfo.setNum(Integer.valueOf(record.get("gsp_1").trim()));
                        gspInfo.setSku(record.get("gsp_0"));
                        gspInfo.setId(record.get("gsp_2"));
                        data1.put(record.get("gsp_0"),gspInfo);
                    }

                }
                if(record.get("erp_0") != null && StringUtils.isNotBlank(record.get("erp_0").trim())){
                    data2.put(record.get("erp_0"),record.get("erp_1").trim());
//
                }


            }
            data1.forEach((key,value)->{
                if(data2.get(key)!=null){
                    if(!excludes.stream().anyMatch(e->e.equals(value.getSku()))){
                        Integer i = value.getNum();
                        Integer i2 = Integer.valueOf(data2.get(key).trim());
                        int s = (i-i2>0?i-i2:0);
                        System.out.println(String.format(sql,s,i,key));
                        System.out.println(String.format(sql3,value.getId(),i,s));
                    }

                }
            });

            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  void redcsv2(){
        try {
            String csvFilePath = "E:\\stock.csv";
            //FileReader reader = new FileReader(new FileInputStream(new File(csvFilePath),"GBK"));
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(csvFilePath),"gbk");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("erp_0", "erp_1","erp_2", "erp_3","gsp_0", "gsp_1","gsp_2", "gsp_3")
                    .parse(inputStreamReader);
            Map<String,ErpInfo> data1 =new HashMap<String,ErpInfo>();
            Map<String,String> data2 =new HashMap<String,String>();
            List<GspInfo> list = new ArrayList<>();
            for (CSVRecord record : parser)
            {
                if(record.get("erp_0") != null && StringUtils.isNotBlank(record.get("erp_0"))
                        && record.get("erp_1")!= null &&StringUtils.isNotBlank(record.get("erp_1"))){
                    ErpInfo erpInfo = new ErpInfo();
                    erpInfo.setSku(record.get("erp_0"));
                    if("erp_1".equals(record.get("erp_1"))){
                        continue;
                    }
                    erpInfo.setNum(Integer.valueOf(record.get("erp_1").trim()));
                    erpInfo.setWarehouse(record.get("erp_3"));
                    data1.put(record.get("erp_0"),erpInfo);
                }
                if(record.get("gsp_0") != null && StringUtils.isNotBlank(record.get("gsp_0"))
                        &&record.get("gsp_3") != null &&StringUtils.isNotBlank(record.get("gsp_3"))){
                 GspInfo gspInfo = new GspInfo();
                 gspInfo.setSku(record.get("gsp_0"));
                 gspInfo.setNum(Integer.valueOf(record.get("gsp_3").trim()));
                 gspInfo.setWarehouse(record.get("gsp_2"));
                 gspInfo.setInvenId(record.get("gsp_1"));
                 list.add(gspInfo);
                }
            }
            System.out.println(1);
            list.stream().forEach(e->{
                if(data1.get(e.getSku())!=null){
                    //System.out.println(e.getSku()+","+e.getWarehouse()+","+data1.get(e.getSku()).getWarehouse());
                    if(e.getWarehouse().contains("次仓") && data1.get(e.getSku()).getWarehouse().contains("次品") ){
                        int i= Integer.valueOf(data1.get(e.getSku()).getNum()) ;
                        int i2 = Integer.valueOf(e.getNum());
                        int diff=(i2-i>0?i2-i:0);
                        System.out.println(String.format(sql2,diff,e.getSku(),e.getInvenId()));
                    }
                }
            });


            inputStreamReader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
