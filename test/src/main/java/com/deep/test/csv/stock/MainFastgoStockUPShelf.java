package com.deep.test.csv.stock;

import com.deep.test.csv.GoodInfo;
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
 * @ClassName FastgoStockUPShelf
 * @create_date 2021.05.24 13:56
 * @since
 */
public class MainFastgoStockUPShelf {
    private static  final String request="curl -H 'Content-Type:application/json'  -X POST --data '%s' http://fmsopenapi.bl.com:7010/fmsOpenapi/goodsOnSale/updateChanSaleByStock.htm";
    public static void main(String[] args) throws IOException {
        String csvFilePath = "E:\\work\\迭代项目\\库存\\csv_process\\stock_on_shelf.csv";
        List<PushToGoHomeMsgDTO> list = redcsv(csvFilePath);
        list=list.stream().filter(e->e.getSaleStockSum()>0L).collect(Collectors.toList());
        List<List<PushToGoHomeMsgDTO>> realList = CollectionSplitUtil.split(list,99);
        BufferedWriter out = new BufferedWriter(new FileWriter("result_stock_on_shelf20210728_012025"+System.currentTimeMillis()));
        for(List<PushToGoHomeMsgDTO> e:realList){
            FastGoHomeMsgVO head = new FastGoHomeMsgVO();
            head.setPushToHome(e);
            long systime = System.currentTimeMillis();
            head.setSendTime(systime);
            head.setUuid("KDJ"+UuidUtils.uuidStr()+"_"+(systime));
            //System.out.println(new Gson().toJson(head));
            System.out.println(String.format(request,new Gson().toJson(head)));
            //out.write(String.format(request,new Gson().toJson(head)));
        }
        out.close();




    }
    public static List<PushToGoHomeMsgDTO>  redcsv(String csvFilePath){
        List<PushToGoHomeMsgDTO>  list = new ArrayList<>();

        try {

            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream,"UTF-8");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("GOODS_SID", "SALE_STOCK_SUM","SHOP_MERCHANT_CODE","SHOP_SID")
                    .parse(reader);

            for (CSVRecord record : parser)
            {
                if("GOODS_SID".equals(record.get("GOODS_SID").trim())){
                    continue;
                }
                if(record.get("GOODS_SID") != null && StringUtils.isNotBlank(record.get("GOODS_SID").trim())){
                    if(record.get("SALE_STOCK_SUM") !=null && StringUtils.isNotBlank(record.get("SALE_STOCK_SUM"))){
                        PushToGoHomeMsgDTO category = new PushToGoHomeMsgDTO();
                        try{
                        category.setGoodsSid(Long.valueOf(record.get("GOODS_SID").trim()));
                        category.setSaleStockSum(Long.valueOf(record.get("SALE_STOCK_SUM").trim()));
                        category.setShopAndStoreCode(record.get("SHOP_MERCHANT_CODE"));
                        category.setShopSid(record.get("SHOP_SID"));
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
