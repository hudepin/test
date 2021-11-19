package com.deep.test.csv.gsp.nibo;

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
 * @Description <p></p>
 * @ClassName StockMain
 * @create_date 2021.10.27 15:15
 * @since
 */
public class StockMain {
    private static final String sql="update shopping.t_ngsp_goods_stock t set t.store_num=%d,t.mp_stock_sum=%d,t.update_date=sysdate,t.update_user='nbsys1027' where t.sid=(SELECT STOCK.SID FROM shopping.T_NGSP_GOODS_STOCK STOCK LEFT JOIN shopping.T_NGSP_GOODS_SUB GS ON STOCK.GOODS_SID = GS.SID LEFT JOIN shopping.T_NGSP_GOODS GOODS ON GOODS.SID = GS.PARENT_SID WHERE GOODS.Sku='%s');";
    private static final String sql2= "update shopping.srm_invtype t set t.nownum=%d where t.productid='%s' and t.inventoryid=1689;";
    private static final String sql3="update shopping.srm_invtype_batch t set t.amount=%d where t.productid='%s' and t.inventoryno=1689;";
    public static void main(String[] args) {
        String csvFilePath = "E:\\work\\迭代项目\\全球购\\宁波仓\\stock.csv";
        List<StockDTO> list = redcsv(csvFilePath);
        for(StockDTO dto:list){
            System.out.println(String.format(sql3,dto.getNum(),dto.getSku()));
        }
    }

    public static List<StockDTO> redcsv(String csvFilePath){
        List<StockDTO>  list = new ArrayList<>();

        try {

            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream,"UTF-8");
            CSVParser parser = CSVFormat.DEFAULT.withHeader( "sku","num")
                    .parse(reader);

            for (CSVRecord record : parser)
            {
                if("sku".equals(record.get("sku").trim())){
                    continue;
                }
                if(record.get("sku") != null && StringUtils.isNotBlank(record.get("sku").trim())){
                    if(record.get("num") !=null && StringUtils.isNotBlank(record.get("num"))){
                        StockDTO category = new StockDTO();
                        try{
                            category.setSku(record.get("sku").trim());
                            category.setNum(Long.valueOf(record.get("num").trim()));
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
