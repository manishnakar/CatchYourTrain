package com.example.sushantoberoi.catchyourtrain;

import java.util.List;

/**
 * Created by sushant oberoi on 24-03-2017.
 */
public class JsonObject {


    /**
     * response_code : 200
     * total : 2
     * station : [{"fullname":"MUMBAI CST","code":"CSTM"},{"fullname":"MUMBAI CENTRAL","code":"BCT"}]
     */

    private int response_code;
    private int total;
    private List<StationBean> station;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<StationBean> getStation() {
        return station;
    }

    public void setStation(List<StationBean> station) {
        this.station = station;
    }

    public static class StationBean {
        /**
         * fullname : MUMBAI CST
         * code : CSTM
         */

        private String fullname;
        private String code;

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
