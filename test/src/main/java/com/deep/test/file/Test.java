package com.deep.test.file;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName Test
 * @create_date 2021.06.28 17:15
 * @since
 */
public class Test {
    public static void main(String[] args) {
        readFile("E:\\work\\迭代项目\\库存\\b2c文件相关\\process\\synStock_XDWL_20210628042549720_1.txt");
    }
    public static void readFile(String stockPathBackup){
        BufferedReader reader = null;
        File file = null;
        String tempString = null;

            List<String> tempStringList = new ArrayList<String>();
            try {
                file = new File(stockPathBackup);
                reader = new BufferedReader(new FileReader(file));
                while ((tempString = reader.readLine()) != null) {
                            tempStringList.add(tempString);//LH 过滤头
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            Map<String,String> map =new TreeMap<>();
            for(String msg:tempStringList){
                String[] fields = msg.split(",", -1);
                if (StringUtils.isNotEmpty(fields[0])
                        && StringUtils.isNotEmpty(fields[1])) {
                    map.put(fields[0],fields[0]);
                }
            }
        System.out.println(map);

    }
}
