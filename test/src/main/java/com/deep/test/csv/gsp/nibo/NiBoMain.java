package com.deep.test.csv.gsp.nibo;

import com.deep.test.csv.gsp.PartDTO;
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
 * @ClassName NiBoMain
 * @create_date 2021.10.27 14:52
 * @since
 */
public class NiBoMain {
    private static final String sql="update  shopping.E_PORT_GOODSREFLECT E1 set E1.Ht_Productid='%s' where E1.PRODUCTID='%s';";
    private static final String sql1="update shopping.t_ngsp_goods_sub t set t.goods_warehouse_code='%s' where t.parent_sid=(select sid from shopping.t_ngsp_goods g where g.sku='%s');";

    public static void main(String[] args) {
        String csvFilePath = "E:\\work\\迭代项目\\全球购\\宁波仓\\gsp.csv";
        List<NingboDTo> list = redcsv(csvFilePath);
        for(NingboDTo dto:list){
            System.out.println(String.format(sql,dto.getHtCode(),dto.getSku()));
        }
        for(NingboDTo dto:list){
            System.out.println(String.format(sql1,dto.getHtCode(),dto.getSku()));
        }
    }

    public static List<NingboDTo> redcsv(String csvFilePath){
        List<NingboDTo>  list = new ArrayList<>();

        try {

            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream,"UTF-8");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("htCode", "sku")
                    .parse(reader);

            for (CSVRecord record : parser)
            {
                if("htCode".equals(record.get("htCode").trim())){
                    continue;
                }
                if(record.get("htCode") != null && StringUtils.isNotBlank(record.get("htCode").trim())){
                    if(record.get("sku") !=null && StringUtils.isNotBlank(record.get("sku"))){
                        NingboDTo category = new NingboDTo();
                        try{
                            category.setHtCode(record.get("htCode").trim());
                            category.setSku(record.get("sku").trim());
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
