package com.deep.test.csv.gsp;

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
 * @ClassName PartSendMain
 * @create_date 2021.07.29 15:43
 * @since
 */
public class PartSendMain {
    private static  final String request="curl -H 'Content-Type:application/json'  -X POST --data '%s' http://mpapi.bl.com:7510/mp-openapi/orderApi/order/updateOrderPartialShipment";
    public static void main(String[] args) throws IOException {
        String csvFilePath = "E:\\work\\迭代项目\\全球购\\部分发货.csv";
        List<PartDTO> list = redcsv(csvFilePath);


        BufferedWriter out = new BufferedWriter(new FileWriter("result_stock_on_shelf20210728_012025"+System.currentTimeMillis()));

for(PartDTO partDTO :list){
    MPRequestDto head = new MPRequestDto();
    System.out.println(String.format(request,new Gson().toJson(head)));
}

            //out.write(String.format(request,new Gson().toJson(head)));





    }
    public static List<PartDTO>  redcsv(String csvFilePath){
        List<PartDTO>  list = new ArrayList<>();

        try {

            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream,"UTF-8");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("MP_ORDER_NO", "MP_GOODS_SID","ORDER_DETAIL_NO","LOG_CODE","LOGISTICS_NO","STORE_CODE","STORE_KEY")
                    .parse(reader);

            for (CSVRecord record : parser)
            {
                if("MP_ORDER_NO".equals(record.get("MP_ORDER_NO").trim())){
                    continue;
                }
                if(record.get("MP_ORDER_NO") != null && StringUtils.isNotBlank(record.get("MP_ORDER_NO").trim())){
                    if(record.get("MP_GOODS_SID") !=null && StringUtils.isNotBlank(record.get("MP_GOODS_SID"))){
                        PartDTO category = new PartDTO();
                        try{
                            category.setMpOrderNo(record.get("MP_ORDER_NO").trim());
                            category.setMpGoodsSid(record.get("MP_GOODS_SID").trim());
                            category.setMpOrderDetailNo(record.get("ORDER_DETAIL_NO"));
                            category.setLogCode(record.get("LOG_CODE"));
                            category.setLogisticsNo(record.get("LOGISTICS_NO"));
                            category.setStoreCode(record.get("STORE_CODE"));
                            category.setStoreKey(record.get("STORE_KEY"));
                            list.add(category);
                        }catch (Exception e){

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
