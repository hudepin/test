package com.deep.test.lock;

import com.deep.test.lock.CposMessageConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName CposFileNameAnalizer
 * @create_date 2021.10.13 11:21
 * @since
 */
public class CposFileNameAnalizer {
    final static Logger LOG = LoggerFactory.getLogger(CposFileNameAnalizer.class);
    private String fileType;

    private String dataType;   //FTP文件储存类型(F或D)
    private String branchCode;
    private String storeCode; //FTP文件的门店编码
    private String storeGrpCode;
    private String timestr; //FTP的时间

    private Date time;

    private static Map<String, String> nameRegMap = new HashMap<String, String>();

    static {
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOCK + "." + CposMessageConstants.BRANCH_CODE_2010, "CPOS_STOCK_[D|F]{1}_2010_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOCK + "." + CposMessageConstants.BRANCH_CODE_2020, "CPOS_STOCK_[D|F]{1}_2020_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOCK + "." + CposMessageConstants.BRANCH_CODE_2030, "CPOS_STOCK_[D|F]{1}_(2030||2032||2033)_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOCK + "." + CposMessageConstants.BRANCH_CODE_1000, "CPOS_STOCK_[D|F]{1}_10[1|2|3]0_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_RECEIPT + "." + CposMessageConstants.BRANCH_CODE_2010, "CPOS_RECEI_[D|F]{1}_2010_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_RECEIPT + "." + CposMessageConstants.BRANCH_CODE_2020, "CPOS_RECEIPT_[D|F]{1}_2020_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_RECEIPT + "." + CposMessageConstants.BRANCH_CODE_2030, "CPOS_RECEIPT_[D|F]{1}_(2030||2032||2033)_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_RECEIPT + "." + CposMessageConstants.BRANCH_CODE_1000, "CPOS_RECEIPT_[D|F]{1}_10[1|2|3]0_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_PRICE + "." + CposMessageConstants.BRANCH_CODE_2010, "CPOS_PRICE_[D|F]{1}_2010_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        //2070-规则同2010
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOCK + "." + CposMessageConstants.BRANCH_CODE_2070, "CPOS_STOCK_[D|F]{1}_2070_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_PRICE + "." + CposMessageConstants.BRANCH_CODE_2070, "CPOS_PRICE_[D|F]{1}_2070_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MD + "." + CposMessageConstants.BRANCH_CODE_2070, "CPOS_MD_[D|F]{1}_2070_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");

        //-- 标超  文件名组成 CPOS_PRICE_F_2020_[店组编码 4-6 位 字母+数字 ]_年月日时分秒_序列号
        //@2016-08-16 标超去掉 店组关系  文件直接到 门店
//		nameRegMap.put( CposMessageConstants.MSG_TYPE_PRICE +"." + CposMessageConstants.BRANCH_CODE_2020 , "CPOS_PRICE_[D|F]{1}_2020_[A-Za-z0-9]{4,6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3,4}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_PRICE + "." + CposMessageConstants.BRANCH_CODE_2020, "CPOS_PRICE_[D|F]{1}_2020_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3,4}.(txt|csv|xml|zip)");
        //全渠道 文件名正则
        nameRegMap.put(CposMessageConstants.MSG_TYPE_PRICE + "." + CposMessageConstants.BRANCH_CODE_3060, "CPOS_PRICE_[D|F]{1}_[3][0][6][0-9]{1}_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3,4}.(txt|csv|xml|zip)");
        //全渠道未来店库存
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOCK + "." + CposMessageConstants.BRANCH_CODE_3060, "CPOS_STOCK_[D|F]{1}_[3][0][6][0-9]{1}_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");

        //@2016-08-16  快客价格 是按照 店组 传送的  :快客的店组是 一个字符或者数字
        nameRegMap.put(CposMessageConstants.MSG_TYPE_PRICE + "." + CposMessageConstants.BRANCH_CODE_2030, "CPOS_PRICE_[D|F]{1}_(2030||2032||2033)_[A-Za-z0-9]{1,3}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_PRICE + "." + CposMessageConstants.BRANCH_CODE_1000, "CPOS_PRICE_[D|F]{1}_10[1|2|3]0_[A-Za-z0-9]{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MASTERINFO + "." + CposMessageConstants.BRANCH_CODE_2010, "CPOS_MD_[D|F]{1}_2010_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MASTERINFO + "." + CposMessageConstants.BRANCH_CODE_2020, "CPOS_MD_[D|F]{1}_2020_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MASTERINFO + "." + CposMessageConstants.BRANCH_CODE_2030, "CPOS_MD_[D|F]{1}_(2030||2032||2033)_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MD + "." + CposMessageConstants.BRANCH_CODE_1000, "CPOS_MD_[D|F]{1}_1\\d{3}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MD + "." + CposMessageConstants.BRANCH_CODE_2010, "CPOS_MD_[D|F]{1}_2010_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MD + "." + CposMessageConstants.BRANCH_CODE_2020, "CPOS_MD_[D|F]{1}_2020_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_([0-9]{3}||[0-9]{5}).(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MD + "." + CposMessageConstants.BRANCH_CODE_2030, "CPOS_MD_[D|F]{1}_(2030||2032||2033)_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MD + "." + CposMessageConstants.BRANCH_CODE_3060, "CPOS_MD_[D|F]{1}_3060_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MD + "." + CposMessageConstants.BRANCH_CODE_3090, "CPOS_MD_[D|F]{1}_3090_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        //nameRegMap.put( CposMessageConstants.MSG_TYPE_STOREGRPREL +"." + CposMessageConstants.BRANCH_CODE_2010 , "CPOS_STOREGRPREL_[D|F]{1}_2010_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOREGRPREL + "." + CposMessageConstants.BRANCH_CODE_2020, "CPOS_STOREREL_[D|F]{1}_2020_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOREGRPREL + "." + CposMessageConstants.BRANCH_CODE_2030, "CPOS_STOREREL_[D|F]{1}_(2030||2032||2033)_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        //nameRegMap.put( CposMessageConstants.MSG_TYPE_STOREGRPREL +"." + CposMessageConstants.BRANCH_CODE_1000 , "CPOS_STOREGRPREL_[D|F]{1}_1000_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");

        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOREMERREL + "." + CposMessageConstants.BRANCH_CODE_2010, "CPOS_PSREL_[D|F]{1}_2010_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOREMERREL + "." + CposMessageConstants.BRANCH_CODE_2020, "CPOS_PRDSTOREREL_[D|F]{1}_2020_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOREMERREL + "." + CposMessageConstants.BRANCH_CODE_2030, "CPOS_PRDSTOREREL_[D|F]{1}_(2030||2032||2033)_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOREMERREL + "." + CposMessageConstants.BRANCH_CODE_1000, "CPOS_PRDSTOREREL_[D|F]{1}_1\\d{3}_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOREMERREL + "." + CposMessageConstants.BRANCH_CODE_3060, "CPOS_PRDSTOREREL_[D|F]{1}_306\\d{1}_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        //TODO: add other types.

        nameRegMap.put(CposMessageConstants.MSG_TYPE_CATEGORY + "." + CposMessageConstants.BRANCH_CODE_3060, "CPOS_CATEGORY_[D|F]{1}_306\\d{1}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_BRAND + "." + CposMessageConstants.BRANCH_CODE_3060, "CPOS_BRAND_[D|F]{1}_306\\d{1}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_SUPPLIER + "." + CposMessageConstants.BRANCH_CODE_3060, "CPOS_SUPPLIER_[D|F]{1}_306\\d{1}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}_[0-9]{3}.(txt|csv|xml|zip)");

        //2050文件名称规则
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOCK + "." + CposMessageConstants.BRANCH_CODE_2050, "CPOS_STOCK_[D|F]{1}_2050_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_PRICE + "." + CposMessageConstants.BRANCH_CODE_2050, "CPOS_PRICE_[D|F]{1}_2050_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MD + "." + CposMessageConstants.BRANCH_CODE_2050, "CPOS_MD_[D|F]{1}_2050_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        //2060文件名称规则
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOCK + "." + CposMessageConstants.BRANCH_CODE_2060, "CPOS_STOCK_[D|F]{1}_2060_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_PRICE + "." + CposMessageConstants.BRANCH_CODE_2060, "CPOS_PRICE_[D|F]{1}_2060_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MD + "." + CposMessageConstants.BRANCH_CODE_2060, "CPOS_MD_[D|F]{1}_2060_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        //2080文件名称规则
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOCK + "." + CposMessageConstants.BRANCH_CODE_2080, "CPOS_STOCK_[D|F]{1}_2080_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_PRICE + "." + CposMessageConstants.BRANCH_CODE_2080, "CPOS_PRICE_[D|F]{1}_2080_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        //0000文件名称规则
        nameRegMap.put(CposMessageConstants.MSG_TYPE_STOCK + "." + CposMessageConstants.BRANCH_CODE_7500, "CPOS_STOCK_[D|F]{1}_75\\d{2}_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_PRICE + "." + CposMessageConstants.BRANCH_CODE_7500, "CPOS_PRICE_[D|F]{1}_75\\d{2}_\\d{6}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
        nameRegMap.put(CposMessageConstants.MSG_TYPE_MD + "." + CposMessageConstants.BRANCH_CODE_7500, "CPOS_MD_[D|F]{1}_75\\d{2}_20[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}.(txt|csv|xml|zip)");
    }

    public static boolean isConfigReg(String msgType, String branchCode) {
        return nameRegMap.get(msgType + "." + branchCode) != null;
    }

    /**
     * 方法描述：   方法总结
     * 业务逻辑说明  ：根据文件名得到实例
     * 1、处理…………<br/>
     * 2、处理…………<br/>
     * 3、处理…………<br/>
     *
     * @param filePathName
     * @return
     * @Title: newInstance
     * @date May 25, 2016 10:11:08 AM
     * @author azhang
     * @modifier
     * @modifydate
     */
    public static CposFileNameAnalizer newInstance(String filePathName, String msgType, String branchCode) {

        String regVal = nameRegMap.get(msgType + "." + branchCode);
        return newInstanceNew(filePathName, branchCode, regVal);

    }

    public static CposFileNameAnalizer newInstanceNew(String filePathName, String branchCode, String regVal) {

        String filename = filePathName;
        if (filePathName.indexOf("/") != -1) {
            filename = filePathName.substring(filePathName.lastIndexOf("/") + 1);
        } else if (filePathName.indexOf("\\") != -1) {
            filename = filePathName.substring(filePathName.lastIndexOf("\\") + 1);
        }
        Pattern pattern = Pattern.compile(regVal);
        Matcher m = pattern.matcher(filename);

        if (!m.matches()) {
            LOG.info("filePathName={} branchCode={} regVal={}", filePathName, branchCode, regVal);
            return null;
        }

        CposFileNameAnalizer ana = new CposFileNameAnalizer();

        String[] nameArr = filename.split("_");
        if (nameArr.length > 1) {
            ana.fileType = nameArr[1];
        }

        if (nameArr.length > 2) {
            ana.dataType = nameArr[2];
        }

        if (nameArr.length > 3) {
            ana.branchCode = nameArr[3];
        }

        if (nameArr.length > 4) {
            if (CposMessageConstants.MSG_TYPE_STOCK.equals(ana.fileType)
                    || CposMessageConstants.MSG_TYPE_PRICE.equals(ana.fileType)
                    || CposMessageConstants.MSG_TYPE_RECEIPT.equals(ana.fileType)
                    || CposMessageConstants.MSG_TYPE_PSREL.equals(ana.fileType)
                    || CposMessageConstants.MSG_TYPE_STOREMERREL.equals(ana.fileType)
            ) {

                //如果是 标超  价格
                // 保存为店组
                //@2016-08-16 标超去掉 店组关系  文件直接到 门店
//				if(CposMessageConstants.MSG_TYPE_PRICE.equals( ana.fileType) && CposMessageConstants.BRANCH_CODE_2020.equals( branchCode ) ){
//					ana.setStoreGrpCode(  nameArr[4] );
//				}else{//其他为门店
//					ana.storeCode = nameArr[4];
//				}
                //快客的 价格 是按照 店组传递的
                if (CposMessageConstants.MSG_TYPE_PRICE.equals(ana.fileType) && CposMessageConstants.BRANCH_CODE_2030.equals(branchCode)) {
                    ana.setStoreGrpCode(nameArr[4]);
                } else {//其他为门店
                    ana.storeCode = nameArr[4];
                }
//				ana.storeCode = nameArr[4];

            } else if (CposMessageConstants.MSG_TYPE_MD.equals(ana.fileType)) {
                ana.timestr = nameArr[4];
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                try {
                    ana.time = sdf.parse(ana.timestr);
                } catch (ParseException e) {
                    ana.time = new Date();
                }
            }
        }

        if (nameArr.length > 5) {
            if (CposMessageConstants.MSG_TYPE_STOCK.equals(ana.fileType)
                    || CposMessageConstants.MSG_TYPE_PRICE.equals(ana.fileType)
                    || CposMessageConstants.MSG_TYPE_RECEIPT.equals(ana.fileType)
                    || CposMessageConstants.MSG_TYPE_PSREL.equals(ana.fileType)
                    || CposMessageConstants.MSG_TYPE_STOREMERREL.equals(ana.fileType)
            ) {

                String ts = nameArr[5];
                if (ts != null && ts.indexOf(".") > 0) {
                    ts = ts.substring(0, ts.indexOf("."));
                }

                ana.timestr = ts;

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                try {
                    ana.time = sdf.parse(ana.timestr);
                } catch (ParseException e) {
                    ana.time = new Date();
                }
            }
        }
        return ana;

    }

    /**
     * @param @param  fileName
     * @param @return 设定文件
     * @return String[]
     * <ul>
     * <li>prams[0] example:CPOS</li>
     * <li>prams[1] Function example:receipt</li>
     * <li>prams[2] actType example:F/D</li>
     * <li>prams[3] yetaiId example:2030</li>
     * <li>prams[4] storeCode example:123456</li>
     * <li>prams[5] time example:20150525120101</li>
     * <li>prams[6] squ example:001</li>
     * </ul>
     * @throws
     * @Title: cposFilePathTofields
     * @Description: 根据文件名解析成字段数组
     */
    public static String[] cposFilePathTofields(String filePathName) {
        Assert.notNull(filePathName, "The fileName must not be null.");
        String filename = filePathName;
        if (filePathName.indexOf("/") != -1) {
            filename = filePathName.substring(filePathName.lastIndexOf("/") + 1);
        } else if (filePathName.indexOf("\\") != -1) {
            filename = filePathName.substring(filePathName.lastIndexOf("\\") + 1);
        }
        String fileNameSub = filename.substring(0, filename.indexOf("."));
        String[] fields = fileNameSub.split("_");
        return fields;
    }


    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreGrpCode() {
        return storeGrpCode;
    }

    public void setStoreGrpCode(String storeGrpCode) {
        this.storeGrpCode = storeGrpCode;
    }

    public String getTimestr() {
        return timestr;
    }

    public void setTimestr(String timestr) {
        this.timestr = timestr;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "{\"CposFileNameAnalizer\":{"
                + "\"fileType\":\""
                + fileType + '\"'
                + ",\"dataType\":\""
                + dataType + '\"'
                + ",\"branchCode\":\""
                + branchCode + '\"'
                + ",\"storeCode\":\""
                + storeCode + '\"'
                + ",\"storeGrpCode\":\""
                + storeGrpCode + '\"'
                + ",\"timestr\":\""
                + timestr + '\"'
                + ",\"time\":\""
                + time + '\"'
                + "}}";

    }
}
