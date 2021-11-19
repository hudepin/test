package com.deep.test.csv.cpos;

import com.deep.test.csv.stock.FastGoHomeMsgVO;
import com.deep.test.csv.stock.PushToGoHomeMsgDTO;
import com.deep.test.util.CollectionSplitUtil;
import com.deep.test.util.UuidUtils;
import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName cpos
 * @create_date 2021.08.06 17:20
 * @since
 */
public class cpos {
    private static  final String sql="select t.uuid from cpos.cpos_receive_message t where t.uuid in(%s)";
    public static void main(String[] args) throws IOException {
        String csvFilePath = "E:\\work\\迭代项目\\库存\\csv_process\\cpos.csv";
        List<String> list = redcsv(csvFilePath);

        List<List<String>> realList = CollectionSplitUtil.split(list,1000);
        BufferedWriter out = new BufferedWriter(new FileWriter("result_stock_on_shelf20210728_012025"+System.currentTimeMillis()));
        for(List<String> e:realList){


            //System.out.println(new Gson().toJson(head));
            System.out.println(String.format(sql,String.join(",", e))+" union all");
            //out.write(String.format(request,new Gson().toJson(head)));
        }
        out.close();




    }
    public static List<String>  redcsv(String csvFilePath){
        List<String>  list = new ArrayList<>();

        try {

            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream,"UTF-8");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("uuid")
                    .parse(reader);

            for (CSVRecord record : parser)
            {
                if("uuid".equals(record.get("uuid").trim())){
                    continue;
                }
                if(record.get("uuid") != null && StringUtils.isNotBlank(record.get("uuid").trim())){
                  list.add("'"+record.get("uuid")+"'");

                }


            }

            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }
}
