package com.deep.test.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hudepin
 * @Description
 * @ClassName psvm
 * @create_date 2020.08.27 13:24
 * @since 1.2.0
 */
public class PermissionExcelReader {
    public static String fileName="E:\\work\\迭代项目\\MP商户\\2020\\202007履约中心\\permission.xlsx";
    public static void main(String[] args) {
        ExcelReader excelReader = null;
        try {
//            DemoDataListener demoDataListener = new DemoDataListener();
//            // 这里 需要指定读用哪个class去读，然后读取第一个sheet
//            EasyExcel.read(fileName, CellDataReadDemoData.class, new CellDataDemoHeadDataListener()).sheet().doRead();
            DemoDataListener demoDataListener = new DemoDataListener();
            try {
                excelReader = EasyExcel.read(fileName, DemoData.class, demoDataListener).build();
                ReadSheet readSheet = EasyExcel.readSheet(0).build();
                excelReader.read(readSheet);
            } finally {
                if (excelReader != null) {
                    // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                    excelReader.finish();
                }
            }
//            PermissionTreeResDTO parent = new PermissionTreeResDTO();
//
//            List<PermissionTreeResDTO> childs = new ArrayList<>();
//            parent.setChilds(childs);
//            demoDataListener.list.stream().forEach(e->{
//                if(StringUtils.isNotEmpty(e.getP1())){
//                    parent.setName(e.getP1());
//                }else if(StringUtils.isNotEmpty(e.getP2())){
//                    PermissionTreeResDTO child2 = new PermissionTreeResDTO();
//                    child2.setName(e.getP2());
//                    childs.add(child2);
//                }else if(StringUtils.isNotEmpty(e.getP3())){
//
//                }
//            });

        } finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();
            }
        }
    }
}
