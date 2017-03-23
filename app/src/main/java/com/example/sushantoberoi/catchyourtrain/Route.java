package com.example.sushantoberoi.catchyourtrain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sushant oberoi on 22-03-2017.
 */
public class Route {

    /**
     * train : {"number":"12487","name":"SEEMANCHAL EXP","days":[{"day-code":"SUN","runs":"Y"},{"day-code":"MON","runs":"Y"},{"day-code":"TUE","runs":"Y"},{"day-code":"WED","runs":"Y"},{"day-code":"THU","runs":"Y"},{"day-code":"FRI","runs":"Y"},{"day-code":"SAT","runs":"Y"}],"classes":[{"available":"N","class-code":"3E"},{"available":"N","class-code":"2S"},{"available":"N","class-code":"FC"},{"available":"N","class-code":"1A"},{"available":"Y","class-code":"SL"},{"available":"Y","class-code":"3A"},{"available":"Y","class-code":"2A"},{"available":"N","class-code":"CC"}]}
     * route : [{"distance":0,"lat":26.4027544,"state":"Nepal","schdep":"20:00","scharr":"Source","code":"JBN","fullname":"JOGBANI","route":1,"no":1,"halt":0,"day":1,"lng":87.2638537},{"distance":14,"lat":26.2993116,"state":"Bihar 854318","schdep":"20:18","scharr":"20:17","code":"FBG","fullname":"FORBESGANJ","route":1,"no":2,"halt":1,"day":1,"lng":87.2621437},{"distance":42,"lat":26.13036,"state":"Bihar 854311","schdep":"20:42","scharr":"20:41","code":"ARQ","fullname":"ARARIYA COURT","route":1,"no":3,"halt":1,"day":1,"lng":87.4634653},{"distance":81,"lat":25.7891622,"state":"Bihar 854326","schdep":"21:20","scharr":"21:15","code":"PRNA","fullname":"PURNIA JN","route":1,"no":4,"halt":5,"day":1,"lng":87.5189832},{"distance":109,"lat":25.547924,"state":"Bihar 854105","schdep":"23:10","scharr":"22:30","code":"KIR","fullname":"KATIHAR JN","route":1,"no":5,"halt":40,"day":1,"lng":87.5651329},{"distance":165,"lat":25.3849532,"state":"Bihar 853204","schdep":"23:57","scharr":"23:56","code":"NNA","fullname":"NAUGACHIA","route":1,"no":6,"halt":1,"day":1,"lng":87.0936924},{"distance":232,"lat":25.5061504,"state":"Bihar 851204","schdep":"01:06","scharr":"01:05","code":"KGG","fullname":"KHAGARIA JN.","route":1,"no":7,"halt":1,"day":2,"lng":86.46703579999999},{"distance":273,"lat":0,"state":"","schdep":"01:33","scharr":"01:32","code":"BGS","fullname":"BEGU SARAI","route":1,"no":8,"halt":1,"day":2,"lng":0},{"distance":398,"lat":25.6033028,"state":"Bihar 800001","schdep":"05:20","scharr":"05:10","code":"PNBE","fullname":"PATNA JN","route":1,"no":9,"halt":10,"day":2,"lng":85.137137},{"distance":552,"lat":25.4193326,"state":"Uttar Pradesh 232326","schdep":"07:42","scharr":"07:40","code":"DLN","fullname":"DILDARNAGAR JN","route":1,"no":10,"halt":2,"day":2,"lng":83.6682914},{"distance":610,"lat":25.2783436,"state":"Uttar Pradesh 232101","schdep":"09:37","scharr":"09:17","code":"MGS","fullname":"MUGHAL SARAI JN","route":1,"no":11,"halt":20,"day":2,"lng":83.1197011},{"distance":673,"lat":24.423487,"state":"West Bengal 742227","schdep":"10:32","scharr":"10:31","code":"MZP","fullname":"MIRZAPUR","route":1,"no":12,"halt":1,"day":2,"lng":88.06794049999999},{"distance":762,"lat":25.4455992,"state":"Uttar Pradesh 211001","schdep":"11:55","scharr":"11:50","code":"ALD","fullname":"ALLAHABAD JN","route":1,"no":13,"halt":5,"day":2,"lng":81.82595529999999},{"distance":957,"lat":28.8365997,"state":"Uttar Pradesh 244235","schdep":"14:40","scharr":"14:30","code":"CNB","fullname":"KANPUR CENTRAL","route":1,"no":14,"halt":10,"day":2,"lng":78.24845739999999},{"distance":1186,"lat":27.2079996,"state":"Uttar Pradesh 283204","schdep":"17:10","scharr":"17:07","code":"TDL","fullname":"TUNDLA JN","route":1,"no":15,"halt":3,"day":2,"lng":78.2332144},{"distance":1264,"lat":27.8973944,"state":"Uttar Pradesh 202001","schdep":"18:08","scharr":"18:06","code":"ALJN","fullname":"ALIGARH JN","route":1,"no":16,"halt":2,"day":2,"lng":78.0880129},{"distance":1370,"lat":28.6530862,"state":"Uttar Pradesh 201009","schdep":"20:22","scharr":"20:20","code":"GZB","fullname":"GHAZIABAD","route":1,"no":17,"halt":2,"day":2,"lng":77.4279899},{"distance":1383,"lat":0,"state":"","schdep":"Destination","scharr":"21:00","code":"ANVT","fullname":"ANAND VIHAR TRM","route":1,"no":18,"halt":0,"day":2,"lng":0}]
     * response_code : 200
     */

    private TrainBean train;
    private int response_code;
    private List<RouteBean> route;

    public TrainBean getTrain() {
        return train;
    }

    public void setTrain(TrainBean train) {
        this.train = train;
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

    public static class TrainBean {
        /**
         * number : 12487
         * name : SEEMANCHAL EXP
         * days : [{"day-code":"SUN","runs":"Y"},{"day-code":"MON","runs":"Y"},{"day-code":"TUE","runs":"Y"},{"day-code":"WED","runs":"Y"},{"day-code":"THU","runs":"Y"},{"day-code":"FRI","runs":"Y"},{"day-code":"SAT","runs":"Y"}]
         * classes : [{"available":"N","class-code":"3E"},{"available":"N","class-code":"2S"},{"available":"N","class-code":"FC"},{"available":"N","class-code":"1A"},{"available":"Y","class-code":"SL"},{"available":"Y","class-code":"3A"},{"available":"Y","class-code":"2A"},{"available":"N","class-code":"CC"}]
         */

        private String number;
        private String name;
        private List<DaysBean> days;
        private List<ClassesBean> classes;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<DaysBean> getDays() {
            return days;
        }

        public void setDays(List<DaysBean> days) {
            this.days = days;
        }

        public List<ClassesBean> getClasses() {
            return classes;
        }

        public void setClasses(List<ClassesBean> classes) {
            this.classes = classes;
        }

        public static class DaysBean {
            /**
             * day-code : SUN
             * runs : Y
             */

            @SerializedName("day-code")
            private String daycode;
            private String runs;

            public String getDaycode() {
                return daycode;
            }

            public void setDaycode(String daycode) {
                this.daycode = daycode;
            }

            public String getRuns() {
                return runs;
            }

            public void setRuns(String runs) {
                this.runs = runs;
            }
        }

        public static class ClassesBean {
            /**
             * available : N
             * class-code : 3E
             */

            private String available;
            @SerializedName("class-code")
            private String classcode;

            public String getAvailable() {
                return available;
            }

            public void setAvailable(String available) {
                this.available = available;
            }

            public String getClasscode() {
                return classcode;
            }

            public void setClasscode(String classcode) {
                this.classcode = classcode;
            }
        }
    }

    public static class RouteBean {
        /**
         * distance : 0
         * lat : 26.4027544
         * state : Nepal
         * schdep : 20:00
         * scharr : Source
         * code : JBN
         * fullname : JOGBANI
         * route : 1
         * no : 1
         * halt : 0
         * day : 1
         * lng : 87.2638537
         */

        private int distance;
        private double lat;
        private String state;
        private String schdep;
        private String scharr;
        private String code;
        private String fullname;
        private int route;
        private int no;
        private int halt;
        private int day;
        private double lng;

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
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

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public int getRoute() {
            return route;
        }

        public void setRoute(int route) {
            this.route = route;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public int getHalt() {
            return halt;
        }

        public void setHalt(int halt) {
            this.halt = halt;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }
}
