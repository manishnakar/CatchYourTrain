package com.example.sushantoberoi.catchyourtrain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sushant oberoi on 24-03-2017.
 */
public class PnrStatusJson {

    /**
     * response_code : 200
     * error : false
     * train_name : KCG YPR EXP
     * train_num : 17603
     * pnr : 1234567890
     * failure_rate : 19.346153846153847
     * doj : 20-8-2015
     * chart_prepared : Y
     * class : SL
     * total_passengers : 2
     * train_start_date : {"month":8,"year":2015,"day":20}
     * from_station : {"code":"KCG","name":"KACHEGUDA"}
     * boarding_point : {"code":"KCG","name":"KACHEGUDA"}
     * to_station : {"code":"YPR","name":"YESVANTPUR JN"}
     * reservation_upto : {"code":"YPR","name":"YESVANTPUR JN"}
     * passengers : [{"no":1,"booking_status":"S7,58,GN","current_status":"S7,58","coach_position":9},{"no":2,"booking_status":"S7,59,GN","current_status":"S7,59","coach_position":9}]
     */

    private int response_code;
    private boolean error;
    private String train_name;
    private String train_num;
    private String pnr;
    private double failure_rate;
    private String doj;
    private String chart_prepared;
    @SerializedName("class")
    private String classX;
    private int total_passengers;
    private TrainStartDateBean train_start_date;
    private FromStationBean from_station;
    private BoardingPointBean boarding_point;
    private ToStationBean to_station;
    private ReservationUptoBean reservation_upto;
    private List<PassengersBean> passengers;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getTrain_num() {
        return train_num;
    }

    public void setTrain_num(String train_num) {
        this.train_num = train_num;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public double getFailure_rate() {
        return failure_rate;
    }

    public void setFailure_rate(double failure_rate) {
        this.failure_rate = failure_rate;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getChart_prepared() {
        return chart_prepared;
    }

    public void setChart_prepared(String chart_prepared) {
        this.chart_prepared = chart_prepared;
    }

    public String getClassX() {
        return classX;
    }

    public void setClassX(String classX) {
        this.classX = classX;
    }

    public int getTotal_passengers() {
        return total_passengers;
    }

    public void setTotal_passengers(int total_passengers) {
        this.total_passengers = total_passengers;
    }

    public TrainStartDateBean getTrain_start_date() {
        return train_start_date;
    }

    public void setTrain_start_date(TrainStartDateBean train_start_date) {
        this.train_start_date = train_start_date;
    }

    public FromStationBean getFrom_station() {
        return from_station;
    }

    public void setFrom_station(FromStationBean from_station) {
        this.from_station = from_station;
    }

    public BoardingPointBean getBoarding_point() {
        return boarding_point;
    }

    public void setBoarding_point(BoardingPointBean boarding_point) {
        this.boarding_point = boarding_point;
    }

    public ToStationBean getTo_station() {
        return to_station;
    }

    public void setTo_station(ToStationBean to_station) {
        this.to_station = to_station;
    }

    public ReservationUptoBean getReservation_upto() {
        return reservation_upto;
    }

    public void setReservation_upto(ReservationUptoBean reservation_upto) {
        this.reservation_upto = reservation_upto;
    }

    public List<PassengersBean> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengersBean> passengers) {
        this.passengers = passengers;
    }

    public static class TrainStartDateBean {
        /**
         * month : 8
         * year : 2015
         * day : 20
         */

        private int month;
        private int year;
        private int day;

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }
    }

    public static class FromStationBean {
        /**
         * code : KCG
         * name : KACHEGUDA
         */

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class BoardingPointBean {
        /**
         * code : KCG
         * name : KACHEGUDA
         */

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ToStationBean {
        /**
         * code : YPR
         * name : YESVANTPUR JN
         */

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ReservationUptoBean {
        /**
         * code : YPR
         * name : YESVANTPUR JN
         */

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class PassengersBean {
        /**
         * no : 1
         * booking_status : S7,58,GN
         * current_status : S7,58
         * coach_position : 9
         */

        private int no;
        private String booking_status;
        private String current_status;
        private int coach_position;

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getBooking_status() {
            return booking_status;
        }

        public void setBooking_status(String booking_status) {
            this.booking_status = booking_status;
        }

        public String getCurrent_status() {
            return current_status;
        }

        public void setCurrent_status(String current_status) {
            this.current_status = current_status;
        }

        public int getCoach_position() {
            return coach_position;
        }

        public void setCoach_position(int coach_position) {
            this.coach_position = coach_position;
        }
    }
}
