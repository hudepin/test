package com.deep.test.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hudepin
 * @Description
 * @ClassName CategoryInsertSql
 * @create_date 2020.09.22 10:46
 * @since 1.2.0
 */
public class CategoryInsertSql {
    private static final String sq1 = "insert into shopping.t_ngsp_mp_category_rel (SID, MP_CATEGORY_CODE, ERP_CATEGORY_CODE, BUYER, ERP_COST_CENTER, CREATE_DATE, UPDATE_DATE, IS_DELETED)values (MP_CATEGORY_REL_SEQ.NEXTVAL, '%s', '%s', %s, '%s', sysdate, sysdate, 0);";

    public static void main(String[] args) {
        List<MPCategoryRel> list = redcsv();
        System.out.println("before size:"+list.size());
        list  =list.stream().distinct().collect(Collectors.toList());
        System.out.println("after size:"+list.size());
        for(MPCategoryRel rel :list){
            System.out.println(String.format(sq1, rel.getMpCategoryCode(),rel.getErpCategoryCode(),rel.getBuyer(),rel.getErpCostCenter()));
        }
    }
    public static List<MPCategoryRel> redcsv(){
        List<MPCategoryRel> list = new ArrayList<>();
        try {
            String csvFilePath = "E:\\category.csv";
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = CSVFormat.DEFAULT.withHeader("v1", "v2","v3", "v4","v5")
                    .parse(reader);

            for (CSVRecord record : parser)
            {
                if("v1".equals(record.get("v1"))){
                    continue;
                }
                if(record.get("v1") != null && StringUtils.isNotBlank(record.get("v1").trim())){
                    if(record.get("v2") !=null && StringUtils.isNotBlank(record.get("v2"))){
                        MPCategoryRel category = new MPCategoryRel();
                        category.setMpCategoryCode(record.get("v1"));
                        category.setErpCategoryCode(record.get("v2"));
                        category.setBuyer(Long.valueOf(record.get("v3")));
                        category.setErpCostCenter(record.get("v5"));
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
