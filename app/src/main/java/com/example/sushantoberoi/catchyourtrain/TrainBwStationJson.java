package com.example.sushantoberoi.catchyourtrain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sushant oberoi on 24-03-2017.
 */
public class TrainBwStationJson {

    /**
     * response_code : 200
     * total : 1
     * train : [{"no":1,"name":"RAPTI SAGAR EXP","number":"12511","src_departure_time":"06:35","dest_arrival_time":"03:50","travel_time":"21:15","from":{"name":"GORAKHPUR JN","code":"GKP"},"to":{"name":"NAGPUR","code":"NGP"},"classes":[{"class-code":"FC","available":"N"},{"class-code":"3E","available":"N"},{"class-code":"CC","available":"N"},{"class-code":"SL","available":"Y"},{"class-code":"2S","available":"N"},{"class-code":"2A","available":"Y"},{"class-code":"3A","available":"Y"},{"class-code":"1A","available":"N"}],"days":[{"day-code":"MON","runs":"N"},{"day-code":"TUE","runs":"N"},{"day-code":"WED","runs":"N"},{"day-code":"THU","runs":"Y"},{"day-code":"FRI","runs":"Y"},{"day-code":"SAT","runs":"N"},{"day-code":"SUN","runs":"Y"}]}]
     */

    private int response_code;
    private int total;
    private List<TrainBean> train;

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

    public List<TrainBean> getTrain() {
        return train;
    }

    public void setTrain(List<TrainBean> train) {
        this.train = train;
    }

    public static class TrainBean {
        /**
         * no : 1
         * name : RAPTI SAGAR EXP
         * number : 12511
         * src_departure_time : 06:35
         * dest_arrival_time : 03:50
         * travel_time : 21:15
         * from : {"name":"GORAKHPUR JN","code":"GKP"}
         * to : {"name":"NAGPUR","code":"NGP"}
         * classes : [{"class-code":"FC","available":"N"},{"class-code":"3E","available":"N"},{"class-code":"CC","available":"N"},{"class-code":"SL","available":"Y"},{"class-code":"2S","available":"N"},{"class-code":"2A","available":"Y"},{"class-code":"3A","available":"Y"},{"class-code":"1A","available":"N"}]
         * days : [{"day-code":"MON","runs":"N"},{"day-code":"TUE","runs":"N"},{"day-code":"WED","runs":"N"},{"day-code":"THU","runs":"Y"},{"day-code":"FRI","runs":"Y"},{"day-code":"SAT","runs":"N"},{"day-code":"SUN","runs":"Y"}]
         */

        private int no;
        private String name;
        private String number;
        private String src_departure_time;
        private String dest_arrival_time;
        private String travel_time;
        private FromBean from;
        private ToBean to;
        private List<ClassesBean> classes;
        private List<DaysBean> days;

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getSrc_departure_time() {
            return src_departure_time;
        }

        public void setSrc_departure_time(String src_departure_time) {
            this.src_departure_time = src_departure_time;
        }

        public String getDest_arrival_time() {
            return dest_arrival_time;
        }

        public void setDest_arrival_time(String dest_arrival_time) {
            this.dest_arrival_time = dest_arrival_time;
        }

        public String getTravel_time() {
            return travel_time;
        }

        public void setTravel_time(String travel_time) {
            this.travel_time = travel_time;
        }

        public FromBean getFrom() {
            return from;
        }

        public void setFrom(FromBean from) {
            this.from = from;
        }

        public ToBean getTo() {
            return to;
        }

        public void setTo(ToBean to) {
            this.to = to;
        }

        public List<ClassesBean> getClasses() {
            return classes;
        }

        public void setClasses(List<ClassesBean> classes) {
            this.classes = classes;
        }

        public List<DaysBean> getDays() {
            return days;
        }

        public void setDays(List<DaysBean> days) {
            this.days = days;
        }

        public static class FromBean {
            /**
             * name : GORAKHPUR JN
             * code : GKP
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

        public static class ToBean {
            /**
             * name : NAGPUR
             * code : NGP
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

        public static class ClassesBean {
            /**
             * class-code : FC
             * available : N
             */

            @SerializedName("class-code")
            private String classcode;
            private String available;

            public String getClasscode() {
                return classcode;
            }

            public void setClasscode(String classcode) {
                this.classcode = classcode;
            }

            public String getAvailable() {
                return available;
            }

            public void setAvailable(String available) {
                this.available = available;
            }
        }

        public static class DaysBean {
            /**
             * day-code : MON
             * runs : N
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
    }
}

