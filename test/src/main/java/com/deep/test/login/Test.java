package com.deep.test.login;

import javax.security.auth.login.FailedLoginException;

/**
 * @author hudepin
 * @Description
 * @ClassName 密码验证
 * @create_date 2020.03.09 15:51
 * @since 1.2.0
 */
public class Test
{
    public static void main(String[] args) {
        CasMatcher casMatcher = getCasMatcher();
        String password = "bl.com";
        String encPassword = entryptPassword(password);
        byte[] salt = Encodes.decodeHex(encPassword.substring(0, casMatcher.getSaltSize() *2 ));
        byte[]  hashPassword = Digests.digest(password.getBytes(),
                casMatcher.getAlgorithm(), salt, casMatcher.getHashIterations());
       boolean compare = encPassword.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
        System.out.println(compare);

    }
    private static CasMatcher getCasMatcher(){
        CasMatcher casMatcher = new CasMatcher("SHA-1","",8,1024);
        return casMatcher;
    }
    //p:algorithm="SHA-1"
    //p:saltSize="8"
    //p:hashIterations="1024"
    public static  String entryptPassword(String plainPassword) {
        CasMatcher casMatcher = new CasMatcher("SHA-1","",8,1024);
        byte[] salt = Digests.generateSalt(casMatcher.getSaltSize());
        byte[] hashPassword = Digests.digest(plainPassword.getBytes(), casMatcher.getAlgorithm(), salt, casMatcher.getHashIterations());
        return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
    }
}
