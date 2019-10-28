package com.deep.test.algorithm;

import java.util.*;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-7-24 10:59
 */
public abstract class KNNClassification<T> {
    private List<KNNValueBean<T>> datas = new ArrayList<>();
    int K=3;

    public int getK() {
        return K;
    }

    public void setK(int K) {
        this.K = K;
    }

    /**
     *
     * @param value
     * @param classifyId
     */
    public void add(T value,String classifyId){
        datas.add(new KNNValueBean<T>(value,classifyId));
    }

    /**
     *
     * @param value
     * @return
     */
    public String getClassifyId(T value){
        KNNValueSort[] knnValueSorts = getKNNValueSort(value);
        HashMap<String, Integer> map = new HashMap<String, Integer>(K);
        for (KNNValueSort bean : knnValueSorts) {
            if (bean != null) {
                if (map.containsKey(bean.getClassifyId())) {
                    map.put(bean.getClassifyId(), map.get(bean.getClassifyId()) + 1);
                } else {
                    map.put(bean.getClassifyId(), 1);
                }
            }
        }
        String maxTypeId = null;
        int maxCount = 0;
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if (maxCount < entry.getValue()) {
                maxCount = entry.getValue();
                maxTypeId = entry.getKey();
            }
        }
        return maxTypeId;

    }

    /**
     *
     * @param value
     * @return
     */
    public KNNValueSort[] getKNNValueSort(T value){
        int k = 0;
        KNNValueSort[] topK = new KNNValueSort[K];
        for(KNNValueBean<T> e :datas){
            double score = similarScore(e.getValue(),value);
            if(k==0){
                topK[0]=new KNNValueSort(e.getClassifyId(),score);
                k++;
            }else{
                if (!(k == K && score < topK[k -1].getScore())){
                    int i = 0;
                    //找到要插入的点
                    for (; i < k && score < topK[i].getScore(); i++);
                    int j = k - 1;
                    if (k < K) {
                        j = k;
                        k++;
                    }
                    for (; j > i; j--) {
                        topK[j] = topK[j - 1];
                    }
                    topK[i] = new KNNValueSort(e.getClassifyId(), score);
                }

            }
        }
        return topK;

    }

    protected abstract double similarScore(T o1, T o2);
}
