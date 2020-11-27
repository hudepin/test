package com.deep.test.csv;

import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hudepin
 * @Description
 * @ClassName GoodsRead
 * @create_date 2020.10.17 11:12
 * @since 1.2.0
 */
public class GoodsRead {

    public static void main(String[] args) {
        List<GoodInfo> list = redcsv();
        System.out.println(new Gson().toJson(list));
        System.out.println("before size:"+list.size());
        list  =list.stream().distinct().collect(Collectors.toList());
        System.out.println("after size:"+list.size());

    }
    public static List<GoodInfo> redcsv(){
        List<GoodInfo> list = new ArrayList<>();
        try {
            String csvFilePath = "E:\\good.csv";

            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream,"GBK");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("GOOD_SID", "FRE_TEMP_SID","GOODS_SALES_NAME")
                    .parse(reader);

            for (CSVRecord record : parser)
            {
                if("GOOD_SID".equals(record.get("GOOD_SID"))){
                    continue;
                }
                if(record.get("GOOD_SID") != null && StringUtils.isNotBlank(record.get("GOOD_SID").trim())){
                    if(record.get("FRE_TEMP_SID") !=null && StringUtils.isNotBlank(record.get("FRE_TEMP_SID"))){
                        GoodInfo category = new GoodInfo();
                        category.setgId(record.get("GOOD_SID"));
                        category.settId(record.get("FRE_TEMP_SID"));
                        category.setgName(record.get("GOODS_SALES_NAME"));
                        list.add(category);
                    }

                }


            }

            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }
}
