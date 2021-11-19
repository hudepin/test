package com.deep.test.csv.flashskill;

import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p>茅台白名单初始化</p>
 * @ClassName FlashSkillMain
 * @create_date 2021.10.19 15:29
 * @since
 */
public class FlashSkillMain {
    private static  final String request="curl -H 'Content-Type:application/json'  -X POST --data '%s' http://localhost:7210/flashSkill/dataInit/v2/initBuyBmd.htm";
    private static final Long goodsSid=4248238L;
    private static final String activityCode="MT2226215";
    public static void main(String[] args) {
        String csvFilePath = "E:\\work\\迭代项目\\库存\\csv_process\\maotai\\bmd.csv";
        List<BmdDTO> list = redcsv(csvFilePath);
        BmdRequest bmdRequest =new BmdRequest();
        bmdRequest.setGoodsSid(goodsSid);
        bmdRequest.setActiveCode(activityCode);
        bmdRequest.setMaskCode("b666y6566290qe52sl2662ss90lb0byq");
        bmdRequest.setBmdList(list);
        System.out.println(list.size());
        System.out.println(String.format(request,new Gson().toJson(bmdRequest)));
    }

    public static List<BmdDTO>  redcsv(String csvFilePath){
        List<BmdDTO>  list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream,"UTF-8");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("member_id", "phone")
                    .parse(reader);

            for (CSVRecord record : parser)
            {
                if("member_id".equals(record.get("member_id").trim())){
                    continue;
                }
                if(record.get("member_id") != null && StringUtils.isNotBlank(record.get("member_id").trim())){
                    if(record.get("phone") !=null && StringUtils.isNotBlank(record.get("phone"))){
                        BmdDTO category = new BmdDTO();
                        try{
                            category.setMemberId(record.get("member_id").trim());
                            category.setPhone(record.get("phone").trim());
                            list.add(category);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
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
