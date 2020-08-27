package com.deep.test.login;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Properties;


public class AESUtil {  
      
	
	private static String password=getPassword();
	
	private static byte[] bKey;
	
	public static void main(String[] args) throws Exception {  
        //加密  
        String text = "cmbtest1";
//        String password = getAutoCreateAESKey();
//        System.out.println(password);
        
        // 该秘钥需要通过一个key来进行生产
       // password = "";
        System.out.println("key:"+password);
        String dKey=getAutoCreateAESKey(password);
        System.out.println("生成的秘钥:"+dKey);
        		
        String b = getAESEncode(dKey,text); 
        System.out.println("加密密文："+b);
//        System.out.println(byteArr2HexStr(b));
       
        String a = getAESDecode(dKey,b);
        System.out.println("解密明文:"+a);

//		String xxxx = "{\"member_token\":\"962cd706acf4c8262b72582f0eed3a98eeeb9bc5dd12e08756f2277708d701be02662c2015b77909\"}";
//		System.out.println(AESUtil.getAESEncode(AnfbaoConstants.AES_SECRET_KEY,xxxx));
//
//		String up ="{\"member_token\":\"962cd706acf4c8262b72582f0eed3a98eeeb9bc5dd12e08756f2277708d701be02662c2015b77909\",\"gender\":\"0\"}";
//		System.out.println(AESUtil.getAESEncode(AnfbaoConstants.AES_SECRET_KEY,up));
//
//		System.out.println(AESUtil.getAESDecode(AnfbaoConstants.AES_SECRET_KEY,AESUtil.getAESEncode(AnfbaoConstants.AES_SECRET_KEY,up)));
//		String xx ="04ff1dd6589ec31adf32c381ed28a7e8458c933e8fc9c9dc5a450dccc3af496117cd4eec63b7dcb6fd1538877043f3ac";
//		System.out.println(AESUtil.getAESDecode(AnfbaoConstants.AES_SECRET_KEY,xx));
	}
  
    /** 
     * 生成密钥 
     * 自动生成AES128位密钥 
     * @throws Exception 
     */  
    public static String getAutoCreateAESKey(String password) throws Exception{  
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        
        //要生成多少位，只需要修改这里即可128, 192或256  
        kg.init(128, new SecureRandom(password.getBytes()));
        SecretKey sk = kg.generateKey();  
        bKey = sk.getEncoded(); 
       
        return byteArr2HexStr(bKey);
        
    }  
      
    /** 
     * 加密 
     * 使用对称密钥进行加密 
     * keyFilePath 密钥存放路径 
     * text 要加密的字节数组 
     * 加密后返回一个字节数组 
     * @throws Exception 
     */  
    public static String getAESEncode(String dKey,String value) throws Exception{  
//    	getAutoCreateAESKey(dKey);
    	// added by HEZHEFENG@2019-09-18
    	if(StringUtils.isEmpty(dKey) || StringUtils.isEmpty(value)){
    		return "";
    	}
    	
    	byte[] text = value.getBytes("utf-8");
        SecretKeySpec sKeySpec = new SecretKeySpec(hexStr2ByteArr(dKey), "AES");  
        Cipher cipher = Cipher.getInstance("AES");  
        cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);  
        byte[] bjiamihou = cipher.doFinal(text);  
        
        return byteArr2HexStr(bjiamihou);  
    }  
      
    /** 
     * 解密 
     * 使用对称密钥进行解密 
     * keyFilePath 密钥存放路径 
     * text 要解密的字节数组 
     * 解密后返回一个字节数组 
     * @throws Exception 
     */  
    public static String getAESDecode(String dKey,String value) throws Exception{  
//    	byte[] text = hexStr2ByteArr(value);
//    	System.out.println(text.toString());
        SecretKeySpec sKeySpec = new SecretKeySpec(hexStr2ByteArr(dKey), "AES");  
        Cipher cipher = Cipher.getInstance("AES");  
        cipher.init(Cipher.DECRYPT_MODE, sKeySpec);  
        byte[] bjiemihou = cipher.doFinal(hexStr2ByteArr(value));
//        String result = byteArr2HexStr(bjiemihou);
        return new String(bjiemihou);  
       
    } 
    
    public static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

    public static String getPassword(){
    	Properties p = new Properties();
		ClassLoader cl = AESUtil.class.getClassLoader();
		InputStream in = null;
		if (cl != null) {
			in = cl.getResourceAsStream("config/ext.properties");
		} else {
			in = ClassLoader.getSystemResourceAsStream("config/ext.properties");
		}
		try {
			p.load(in);
		} catch (IOException e) {
			System.out.println(e+"配置文件加载报错！");
		}
		String psw = p.getProperty("password");
		return psw;
	}



}
