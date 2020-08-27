package com.deep.test.login;

/**
 * @author hudepin
 * @Description
 * @ClassName CasMatcher
 * @create_date 2020.03.09 15:46
 * @since 1.2.0
 */
public class CasMatcher {

    private String algorithm;
    private String salt;
    private int hashIterations;
    private int saltSize;

    public CasMatcher(String algorithm,String salt,int saltSize,int hashIterations){
        this.algorithm = algorithm;
        this.salt =salt;
        this.saltSize = saltSize;
        this.hashIterations =hashIterations;
    }

    public CasMatcher() {
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getHashIterations() {
        return this.hashIterations;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public int getSaltSize() {
        return this.saltSize;
    }

    public void setSaltSize(int saltSize) {
        this.saltSize = saltSize;
    }
}
