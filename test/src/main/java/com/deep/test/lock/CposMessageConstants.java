package com.deep.test.lock;

import java.util.Arrays;
import java.util.List;

/**
 *
 * 常量类
 *
 * @ClassName: CposMessageType
 * @author azhang
 * @date May 27, 2016 10:40:58 AM
 * @version V2.0
 *
 */
public class CposMessageConstants {
    public static final String MSG_TYPE_HEAD                     = "CPOS";
    public static final String MSG_UNDERLINE                     = "_";
    public static final int    MSG_STORE_SIZE                    = 1000;
    public static int          MSG_SELECTPRD_SIZE                = 500;
    /**
     * Message Type
     */
    public static final String MSG_TYPE_SELECTEDPD               = "KDJ101";
    public static final String MSG_TYPE_SENDMASTER               = "KDJ205";
    public static final String MSG_TYPE_SENDSTORE                = "KDJ206";
    public static final String MSG_TYPE_SENDPRICE                = "KDJ202";
    public static final String MSG_TYPE_SENDSTOCK                = "CPS101";
    public static final String MSG_TYPE_STOCK                    = "STOCK";
    public static final String MSG_TYPE_PRICE                    = "PRICE";
    public static final String MSG_TYPE_RECEIPT                  = "RECEIPT";
    public static final String MSG_TYPE_MASTERINFO               = "MASTERINFO";
    public static final String MSG_TYPE_MD                       = "MD";
    public static final String MSG_TYPE_STOREGRPREL              = "STOREREL";           //商圈门店对应关系
    public static final String MSG_TYPE_STOREMERREL              = "PRDSTOREREL";        //门店商品关系
    public static final String MSG_TYPE_PSREL                    = "PSREL";              //门店商品关系缩写
    public static final String MSG_TYPE_CATEGORY3060             = "G104";
    public static final String MSG_TYPE_SELECTPRD                = "SELECTPRD";
    public static final String MSG_TYPE_AUTOADDPRD               = "AUTOADDPRD";         //自动补货

    public static final String MSG_TYPE_VENDOR                   = "VENDOR";
    public static final String MSG_TYPE_BRAND                    = "BRAND";
    public static final String MSG_TYPE_CATEGORY                 = "CATEGORY";
    public static final String MSG_TYPE_SUPPLIER                 = "SUPPLIER";

    public static final String MSG_TYPE_S101                    = "S101";
    /**
     * integration Type
     */
    public static final String INT_TYPE_FTP                      = "FTP";
    public static final String INT_TYPE_MQ                       = "MQ";

    /**
     * actType
     */
    public static final String TYPE_RESTFULL                     = "RESTFULL";

    /**
     * message code
     */
    public static final String MQ_MD_CATEGORY_CODE               = "MD101";
    public static final String MQ_MD_BRAND_CODE                  = "MD102";
    public static final String MQ_MD_VENDOR_CODE                 = "MD103";

    /**
     * Branch Code
     */
    public static final String BRANCH_CODE_2010                  = "2010";
    public static final String BRANCH_CODE_2020                  = "2020";
    public static final String BRANCH_CODE_2030                  = "2030";
    public static final String BRANCH_CODE_3060                  = "3060";
    public static final String BRANCH_CODE_1000                  = "1000";
    public static final String BRANCH_CODE_1010                  = "1010";
    public static final String BRANCH_CODE_1020                  = "1020";
    public static final String BRANCH_CODE_1030                  = "1030";
    public static final String BRANCH_CODE_2070                  = "2070";
    public static final String BRANCH_CODE_3090                  = "3090";//云商
    public static final String BRANCH_CODE_2050                  = "2050";
    public static final String BRANCH_CODE_2060                  = "2060";
    public static final String BRANCH_CODE_2080                  = "2080";
    public static final String BRANCH_CODE_7500                  = "7500";

    /**
     * status
     */
    public static final String STATUS_COMPLETED                  = "COMPLETED";
    public static final String STUTUS_EXIST_FAILURE              = "EXIST_FAILURE";
    public static final String STATUS_FAILED                     = "FAILED";

    public static final String STATUS_MQ_FAIL_PARSING            = "PARSING.FAILED";
    public static final String STATUS_MQ_FAIL_SAVING             = "SAVING.FAILED";
    public static final String STATUS_MQ_FAIL_MERGING            = "MERGING.FAILED";
    public static final String STATUS_MQ_SUCCESS                 = "COMPLETED";
    public static final String STATUS_MQ_FAIL_SEND               = "SEND.FAILED";
    public static final String STATUS_MQ_FAIL_UPDATE             = "UPDATE.FAILED";
    public static final String STATUS_MQ_FAIL_DELETE             = "DELETE.FAILED";
    public static final String STATUS_MQ_FAIL_SAVERECORD         = "SAVEREC.FAILED";     //SAVERECORD.FAILED

    /**
     * 处理阶段
     */
    public static final String BATCH_READ_STAGE                  = "01200001";
    public static final String BATCH_PROCESS_STAGE               = "01200002";
    public static final String BATCH_WRITE_STAGE                 = "01200003";
    /**
     * 错误类型
     */
    public static final String BATCH_READ                        = "Read";
    public static final String BATCH_PROCESS                     = "Process";
    public static final String BATCH_WRITE                       = "Write";
    public static final String ERRORS_MAP                        = "errorsMap";

    //文件pram
    public static final String CPOS_INPUT_PRAM                   = "input.file.name";
    //日期格式
    public static final String CPOS_DATE_FORMAT                  = "yyyy-MM-dd HH:mm:ss";

    //日期格式无分隔
    public static final String CPOS_DATE_NOSPLIT_FORMAT          = "yyyyMMddHHmmss";

    //跳过总数
    public static final int    SKIP_COUNT                        = 100;
    //	CPOS_PRICE_BUFF 表状态

    /**
     * 	 未处理 -- 价格接口临时数据状态
     * @Fields CPOS_PRICE_BUFF_STATUS_BASE : 未处理
     */
    public static final int    CPOS_PRICE_BUFF_STATUS_BASE       = 2016001001;

    /**
     *  过时的:未处理时已经比数据库版本低  -- 价格接口临时数据状态
     * @Fields CPOS_PRICE_BUFF_STATUS_DEPRECATED
     */
    public static final int    CPOS_PRICE_BUFF_STATUS_DEPRECATED = 2016001002;

    /**
     *  新插入 -- 价格接口临时数据状态
     * @Fields CPOS_PRICE_BUFF_STATUS_INSERT
     */
    public static final int    CPOS_PRICE_BUFF_STATUS_INSERT     = 2016001003;

    /**
     *  更新 -- 价格接口临时数据状态
     * @Fields CPOS_PRICE_BUFF_STATUS_UPDATE
     */
    public static final int    CPOS_PRICE_BUFF_STATUS_UPDATE     = 2016001004;

    /**
     *  错误 -- 价格接口临时数据状态
     * @Fields CPOS_PRICE_BUFF_STATUS_ERROR
     */
    public static final int    CPOS_PRICE_BUFF_STATUS_ERROR      = 2016001010;

    /**
     *  正在处理中-- 价格接口临时数据状态
     * @Fields CPOS_PRICE_BUFF_STATUS_PROCESSING
     */
    public static final int    CPOS_PRICE_BUFF_STATUS_PROCESSING = 2016001011;

    public static final String EXIT_STATUS                       = "EXITSTATUS";

    /**
     * 文件解析REOD操作标识KEY
     */
    public static final String CPOS_BATCH_REDO_KEY               = "CPOS_BATCH_REDO_KEY";

    /**
     * 文件从doing目录移动到远程FTP处理目录标识KEY
     */
    public static final String CPOS_BATCH_MOVE_DOING_FILE_KEY    = "CPOS_BATCH_MOVE_DOING_FILE_KEY";

    /**
     * 快客业态编码
     */
    public static List<String> KUAIKE_BRANCHIDS = Arrays.asList(new String[]{"2030", "2032", "2033"});
}
