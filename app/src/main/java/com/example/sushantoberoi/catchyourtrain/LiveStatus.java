package com.example.sushantoberoi.catchyourtrain;

import java.util.List;

/**
 * Created by sushant oberoi on 22-03-2017.
 */
public class LiveStatus {

    /**
     * route : [{"scharr_date":"21 Mar 2017","distance":0,"actarr":"00:00","has_arrived":true,"schdep":"20:00","scharr":"Source","actdep":"20:00","station_":{"name":"JOGBANI","code":"JBN"},"no":1,"has_departed":true,"day":0,"station":"JBN","status":"0 mins late","actarr_date":"21 Mar 2017","latemin":0},{"scharr_date":"21 Mar 2017","distance":13,"actarr":"20:20","has_arrived":true,"schdep":"20:18","scharr":"20:13","actdep":"20:25","station_":{"name":"FORBESGANJ","code":"FBG"},"no":2,"has_departed":true,"day":0,"station":"FBG","status":"7 mins late","actarr_date":"21 Mar 2017","latemin":7},{"scharr_date":"21 Mar 2017","distance":41,"actarr":"20:47","has_arrived":false,"schdep":"20:42","scharr":"20:40","actdep":"20:49","station_":{"name":"ARARIYA COURT","code":"ARQ"},"no":3,"has_departed":false,"day":0,"station":"ARQ","status":"7 mins late","actarr_date":"21 Mar 2017","latemin":7},{"scharr_date":"21 Mar 2017","distance":80,"actarr":"21:30","has_arrived":true,"schdep":"21:20","scharr":"21:15","actdep":"21:35","station_":{"name":"PURNIA JN","code":"PRNA"},"no":4,"has_departed":true,"day":0,"station":"PRNA","status":"15 mins late","actarr_date":"21 Mar 2017","latemin":15},{"scharr_date":"21 Mar 2017","distance":108,"actarr":"22:20","has_arrived":true,"schdep":"23:10","scharr":"22:20","actdep":"23:10","station_":{"name":"KATIHAR JN","code":"KIR"},"no":5,"has_departed":true,"day":0,"station":"KIR","status":"0 mins late","actarr_date":"21 Mar 2017","latemin":0},{"scharr_date":"22 Mar 2017","distance":164,"actarr":"00:47","has_arrived":true,"schdep":"00:01","scharr":"00:00","actdep":"00:49","station_":{"name":"NAUGACHIA","code":"NNA"},"no":6,"has_departed":true,"day":1,"station":"NNA","status":"47 mins late","actarr_date":"22 Mar 2017","latemin":47},{"scharr_date":"22 Mar 2017","distance":231,"actarr":"01:55","has_arrived":true,"schdep":"01:01","scharr":"00:59","actdep":"01:58","station_":{"name":"KHAGARIA JN.","code":"KGG"},"no":7,"has_departed":true,"day":1,"station":"KGG","status":"56 mins late","actarr_date":"22 Mar 2017","latemin":56},{"scharr_date":"22 Mar 2017","distance":272,"actarr":"02:28","has_arrived":true,"schdep":"01:33","scharr":"01:31","actdep":"02:30","station_":{"name":"BEGU SARAI","code":"BGS"},"no":8,"has_departed":true,"day":1,"station":"BGS","status":"57 mins late","actarr_date":"22 Mar 2017","latemin":57},{"scharr_date":"22 Mar 2017","distance":395,"actarr":"06:15","has_arrived":true,"schdep":"05:25","scharr":"05:15","actdep":"06:32","station_":{"name":"PATLIPUTRA","code":"PPTA"},"no":9,"has_departed":true,"day":1,"station":"PPTA","status":"60 mins late","actarr_date":"22 Mar 2017","latemin":60},{"scharr_date":"22 Mar 2017","distance":401,"actarr":"06:57","has_arrived":true,"schdep":"05:40","scharr":"05:38","actdep":"07:05","station_":{"name":"DANAPUR","code":"DNR"},"no":10,"has_departed":true,"day":1,"station":"DNR","status":"79 mins late","actarr_date":"22 Mar 2017","latemin":79},{"scharr_date":"22 Mar 2017","distance":545,"actarr":"09:21","has_arrived":true,"schdep":"07:42","scharr":"07:40","actdep":"09:23","station_":{"name":"DILDARNAGAR JN","code":"DLN"},"no":11,"has_departed":true,"day":1,"station":"DLN","status":"101 mins late","actarr_date":"22 Mar 2017","latemin":101},{"scharr_date":"22 Mar 2017","distance":603,"actarr":"10:12","has_arrived":true,"schdep":"09:37","scharr":"09:17","actdep":"10:31","station_":{"name":"MUGHAL SARAI JN","code":"MGS"},"no":12,"has_departed":true,"day":1,"station":"MGS","status":"55 mins late","actarr_date":"22 Mar 2017","latemin":55},{"scharr_date":"22 Mar 2017","distance":667,"actarr":"12:04","has_arrived":true,"schdep":"10:32","scharr":"10:30","actdep":"12:14","station_":{"name":"MIRZAPUR","code":"MZP"},"no":13,"has_departed":true,"day":1,"station":"MZP","status":"94 mins late","actarr_date":"22 Mar 2017","latemin":94},{"scharr_date":"22 Mar 2017","distance":757,"actarr":"14:52","has_arrived":true,"schdep":"11:55","scharr":"11:50","actdep":"15:02","station_":{"name":"ALLAHABAD JN","code":"ALD"},"no":14,"has_departed":true,"day":1,"station":"ALD","status":"182 mins late","actarr_date":"22 Mar 2017","latemin":182},{"scharr_date":"22 Mar 2017","distance":951,"actarr":"20:08","has_arrived":true,"schdep":"14:25","scharr":"14:15","actdep":"20:17","station_":{"name":"KANPUR CENTRAL","code":"CNB"},"no":15,"has_departed":true,"day":1,"station":"CNB","status":"353 mins late","actarr_date":"22 Mar 2017","latemin":353},{"scharr_date":"22 Mar 2017","distance":1182,"actarr":"22:59","has_arrived":false,"schdep":"17:10","scharr":"17:07","actdep":"23:02","station_":{"name":"TUNDLA JN","code":"TDL"},"no":16,"has_departed":false,"day":1,"station":"TDL","status":"352 mins late","actarr_date":"22 Mar 2017","latemin":352},{"scharr_date":"22 Mar 2017","distance":1260,"actarr":"23:55","has_arrived":false,"schdep":"18:05","scharr":"18:03","actdep":"23:57","station_":{"name":"ALIGARH JN","code":"ALJN"},"no":17,"has_departed":false,"day":1,"station":"ALJN","status":"352 mins late","actarr_date":"22 Mar 2017","latemin":352},{"scharr_date":"22 Mar 2017","distance":1373,"actarr":"01:57","has_arrived":false,"schdep":"20:22","scharr":"20:20","actdep":"01:59","station_":{"name":"GHAZIABAD","code":"GZB"},"no":18,"has_departed":false,"day":2,"station":"GZB","status":"337 mins late","actarr_date":"23 Mar 2017","latemin":337},{"scharr_date":"22 Mar 2017","distance":1386,"actarr":"02:21","has_arrived":false,"schdep":"Destination","scharr":"21:00","actdep":"00:00","station_":{"name":"ANAND VIHAR TRM","code":"ANVT"},"no":19,"has_departed":false,"day":1,"station":"ANVT","status":"321 mins late","actarr_date":"23 Mar 2017","latemin":321}]
     * start_date : 21 Mar 2017
     * position : Train departed from MAKKHANPUR(MNR) and late by 352 minutes.
     * error :
     * train_number : 12487
     * current_station : {"scharr_date":"22 Mar 2017","distance":1155,"actarr":"23:16","has_arrived":true,"schdep":"16:33","scharr":"16:33","actdep":"23:16","station_":{"name":"MAKKHANPUR","code":"MNR"},"no":16,"has_departed":true,"day":1,"station":"MNR","status":"403 mins late","actarr_date":"22 Mar 2017","latemin":403}
     * response_code : 200
     */

    private String start_date;
    private String position;
    private String error;
    private String train_number;
    private CurrentStationBean current_station;
    private int response_code;
    private List<RouteBean> route;

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }

    public CurrentStationBean getCurrent_station() {
        return current_station;
    }

    public void setCurrent_station(CurrentStationBean current_station) {
        this.current_station = current_station;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public List<RouteBean> getRoute() {
        return route;
    }

    public void setRoute(List<RouteBean> route) {
        this.route = route;
    }

    public static class CurrentStationBean {
        /**
         * scharr_date : 22 Mar 2017
         * distance : 1155
         * actarr : 23:16
         * has_arrived : true
         * schdep : 16:33
         * scharr : 16:33
         * actdep : 23:16
         * station_ : {"name":"MAKKHANPUR","code":"MNR"}
         * no : 16
         * has_departed : true
         * day : 1
         * station : MNR
         * status : 403 mins late
         * actarr_date : 22 Mar 2017
         * latemin : 403
         */

        private String scharr_date;
        private int distance;
        private String actarr;
        private boolean has_arrived;
        private String schdep;
        private String scharr;
        private String actdep;
        private StationBean station_;
        private int no;
        private boolean has_departed;
        private int day;
        private String station;
        private String status;
        private String actarr_date;
        private int latemin;

        public String getScharr_date() {
            return scharr_date;
        }

        public void setScharr_date(String scharr_date) {
            this.scharr_date = scharr_date;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public String getActarr() {
            return actarr;
        }

        public void setActarr(String actarr) {
            this.actarr = actarr;
        }

        public boolean isHas_arrived() {
            return has_arrived;
        }

        public void setHas_arrived(boolean has_arrived) {
            this.has_arrived = has_arrived;
        }

        public String getSchdep() {
            return schdep;
        }

        public void setSchdep(String schdep) {
            this.schdep = schdep;
        }

        public String getScharr() {
            return scharr;
        }

        public void setScharr(String scharr) {
            this.scharr = scharr;
        }

        public String getActdep() {
            return actdep;
        }

        public void setActdep(String actdep) {
            this.actdep = actdep;
        }

        public StationBean getStation_() {
            return station_;
        }

        public void setStation_(StationBean station_) {
            this.station_ = station_;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public boolean isHas_departed() {
            return has_departed;
        }

        public void setHas_departed(boolean has_departed) {
            this.has_departed = has_departed;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getStation() {
            return station;
        }

        public void setStation(String station) {
            this.station = station;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getActarr_date() {
            return actarr_date;
        }

        public void setActarr_date(String actarr_date) {
            this.actarr_date = actarr_date;
        }

        public int getLatemin() {
            return latemin;
        }

        public void setLatemin(int latemin) {
            this.latemin = latemin;
        }

        public static class StationBean {
            /**
             * name : MAKKHANPUR
             * code : MNR
             */

            private String name;
            private String code;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }
    }

    public static class RouteBean {
        /**
         * scharr_date : 21 Mar 2017
         * distance : 0
         * actarr : 00:00
         * has_arrived : true
         * schdep : 20:00
         * scharr : Source
         * actdep : 20:00
         * station_ : {"name":"JOGBANI","code":"JBN"}
         * no : 1
         * has_departed : true
         * day : 0
         * station : JBN
         * status : 0 mins late
         * actarr_date : 21 Mar 2017
         * latemin : 0
         */

        private String scharr_date;
        private int distance;
        private String actarr;
        private boolean has_arrived;
        private String schdep;
        private String scharr;
        private String actdep;
        private StationBeanX station_;
        private int no;
        private boolean has_departed;
        private int day;
        private String station;
        private String status;
        private String actarr_date;
        private int latemin;

        public String getScharr_date() {
            return scharr_date;
        }

        public void setScharr_date(String scharr_date) {
            this.scharr_date = scharr_date;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public String getActarr() {
            return actarr;
        }

        public void setActarr(String actarr) {
            this.actarr = actarr;
        }

        public boolean isHas_arrived() {
            return has_arrived;
        }

        public void setHas_arrived(boolean has_arrived) {
            this.has_arrived = has_arrived;
        }

        public String getSchdep() {
            return schdep;
        }

        public void setSchdep(String schdep) {
            this.schdep = schdep;
        }

        public String getScharr() {
            return scharr;
        }

        public void setScharr(String scharr) {
            this.scharr = scharr;
        }

        public String getActdep() {
            return actdep;
        }

        public void setActdep(String actdep) {
            this.actdep = actdep;
        }

        public StationBeanX getStation_() {
            return station_;
        }

        public void setStation_(StationBeanX station_) {
            this.station_ = station_;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public boolean isHas_departed() {
            return has_departed;
        }

        public void setHas_departed(boolean has_departed) {
            this.has_departed = has_departed;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getStation() {
            return station;
        }

        public void setStation(String station) {
            this.station = station;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getActarr_date() {
            return actarr_date;
        }

        public void setActarr_date(String actarr_date) {
            this.actarr_date = actarr_date;
        }

        public int getLatemin() {
            return latemin;
        }

        public void setLatemin(int latemin) {
            this.latemin = latemin;
        }

        public static class StationBeanX {
            /**
             * name : JOGBANI
             * code : JBN
             */

            private String name;
            private String code;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }
    }
}
