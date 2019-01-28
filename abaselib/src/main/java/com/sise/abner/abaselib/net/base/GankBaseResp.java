package com.sise.abner.abaselib.net.base;

/**
 * @author zhangduntai
 * @date 2019/1/28
 */
public class GankBaseResp<T> {

    /**
     * error : false
     * results : T
     */

    private boolean error;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
