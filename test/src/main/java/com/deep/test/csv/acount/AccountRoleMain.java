package com.deep.test.csv.acount;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName AccountRoleMain
 * @create_date 2021.08.16 11:11
 * @since
 */
public class AccountRoleMain {
    public static final String baseSql = " insert into saas_account_role_rel (account_id, role_id) values";
    private static List<Long> roleIds1 = new ArrayList<>(Arrays.asList(14L));
    //private static List<Long> roleIds2 = new ArrayList<>(Arrays.asList(3L, 4L, 8L, 13L));

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(baseSql);
        String csvFilePath = "E:\\无标题.csv";
        List<Long> list = redcsv(csvFilePath);
        System.out.println("before"+list.size());
        list= list.stream().distinct().collect(Collectors.toList());
        System.out.println("after"+list.size());

        for (Long accountId : list) {
            for (Long roleId : roleIds1) {
                sb.append("(").append(accountId).append(",");
                sb.append(roleId).append("),");
            }
        }
        System.out.println(sb.toString());
    }

    public static List<Long> redcsv(String csvFilePath) {
        List<Long> list = new ArrayList<>();

        try {

            FileInputStream fileInputStream = new FileInputStream(new File(csvFilePath));
            InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
            CSVParser parser = CSVFormat.DEFAULT.withHeader("id")
                    .parse(reader);

            for (CSVRecord record : parser) {
                if ("id".equals(record.get("id").trim())) {
                    continue;
                }
                if (record.get("id") != null && StringUtils.isNotBlank(record.get("id").trim())) {
                    list.add(Long.valueOf(record.get("id")));
                }
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
