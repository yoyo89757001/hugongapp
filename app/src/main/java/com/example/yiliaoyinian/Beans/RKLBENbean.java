package com.example.yiliaoyinian.Beans;

import java.util.List;

public class RKLBENbean {


    /**
     * success : true
     * result : [{"id":"1338742587494076416","period":"5:00-7:00","projectName":"晨间护理","str1":"001","createBy":"22","createDate":{"month":"DECEMBER","year":2020,"dayOfMonth":15,"hour":15,"minute":8,"monthValue":12,"nano":0,"second":0,"dayOfYear":350,"dayOfWeek":"TUESDAY","chronology":{"id":"ISO","calendarType":"iso8601"}},"remarks":""},{"id":"1338747157488611328","period":"7:00-8:00","projectName":"早餐服务","str1":"002","createBy":"22","createDate":{"month":"DECEMBER","year":2020,"dayOfMonth":15,"hour":15,"minute":26,"monthValue":12,"nano":0,"second":10,"dayOfYear":350,"dayOfWeek":"TUESDAY","chronology":{"id":"ISO","calendarType":"iso8601"}},"remarks":""},{"id":"1338748314374467584","period":"8:00-9:00","projectName":"个人卫生","str1":"003","createBy":"22","createDate":{"month":"DECEMBER","year":2020,"dayOfMonth":15,"hour":15,"minute":30,"monthValue":12,"nano":0,"second":46,"dayOfYear":350,"dayOfWeek":"TUESDAY","chronology":{"id":"ISO","calendarType":"iso8601"}},"remarks":""},{"id":"1338748524190330880","period":"8:00-9:00","projectName":"长者居室及卫生保洁服务","str1":"004","createBy":"22","createDate":{"month":"DECEMBER","year":2020,"dayOfMonth":15,"hour":15,"minute":31,"monthValue":12,"nano":0,"second":36,"dayOfYear":350,"dayOfWeek":"TUESDAY","chronology":{"id":"ISO","calendarType":"iso8601"}},"remarks":""},{"id":"1338748679333441536","period":"8:20-10:30","projectName":"护理服务","str1":"005","createBy":"22","createDate":{"month":"DECEMBER","year":2020,"dayOfMonth":15,"hour":15,"minute":32,"monthValue":12,"nano":0,"second":13,"dayOfYear":350,"dayOfWeek":"TUESDAY","chronology":{"id":"ISO","calendarType":"iso8601"}},"remarks":""},{"id":"1338748962289577984","period":"8:20-10:30","projectName":"订餐服务","str1":"006","createBy":"22","createDate":{"month":"DECEMBER","year":2020,"dayOfMonth":15,"hour":15,"minute":33,"monthValue":12,"nano":0,"second":20,"dayOfYear":350,"dayOfWeek":"TUESDAY","chronology":{"id":"ISO","calendarType":"iso8601"}},"remarks":""},{"id":"1338749204523216896","period":"8:20-10:30","projectName":"护理医疗服务","str1":"007","createBy":"22","createDate":{"month":"DECEMBER","year":2020,"dayOfMonth":15,"hour":15,"minute":34,"monthValue":12,"nano":0,"second":18,"dayOfYear":350,"dayOfWeek":"TUESDAY","chronology":{"id":"ISO","calendarType":"iso8601"}},"remarks":""}]
     * code : 1
     */

    private boolean success;
    private int code;
    private List<ResultDTO> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResultDTO> getResult() {
        return result;
    }

    public void setResult(List<ResultDTO> result) {
        this.result = result;
    }

    public static class ResultDTO {
        /**
         * id : 1338742587494076416
         * period : 5:00-7:00
         * projectName : 晨间护理
         * str1 : 001
         * createBy : 22
         * createDate : {"month":"DECEMBER","year":2020,"dayOfMonth":15,"hour":15,"minute":8,"monthValue":12,"nano":0,"second":0,"dayOfYear":350,"dayOfWeek":"TUESDAY","chronology":{"id":"ISO","calendarType":"iso8601"}}
         * remarks :
         */

        private String id;
        private String period;
        private String projectName;
        private String str1;
        private String createBy;
        private CreateDateDTO createDate;
        private String remarks;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getStr1() {
            return str1;
        }

        public void setStr1(String str1) {
            this.str1 = str1;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public CreateDateDTO getCreateDate() {
            return createDate;
        }

        public void setCreateDate(CreateDateDTO createDate) {
            this.createDate = createDate;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public static class CreateDateDTO {
            /**
             * month : DECEMBER
             * year : 2020
             * dayOfMonth : 15
             * hour : 15
             * minute : 8
             * monthValue : 12
             * nano : 0
             * second : 0
             * dayOfYear : 350
             * dayOfWeek : TUESDAY
             * chronology : {"id":"ISO","calendarType":"iso8601"}
             */

            private String month;
            private int year;
            private int dayOfMonth;
            private int hour;
            private int minute;
            private int monthValue;
            private int nano;
            private int second;
            private int dayOfYear;
            private String dayOfWeek;
            private ChronologyDTO chronology;

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public int getDayOfMonth() {
                return dayOfMonth;
            }

            public void setDayOfMonth(int dayOfMonth) {
                this.dayOfMonth = dayOfMonth;
            }

            public int getHour() {
                return hour;
            }

            public void setHour(int hour) {
                this.hour = hour;
            }

            public int getMinute() {
                return minute;
            }

            public void setMinute(int minute) {
                this.minute = minute;
            }

            public int getMonthValue() {
                return monthValue;
            }

            public void setMonthValue(int monthValue) {
                this.monthValue = monthValue;
            }

            public int getNano() {
                return nano;
            }

            public void setNano(int nano) {
                this.nano = nano;
            }

            public int getSecond() {
                return second;
            }

            public void setSecond(int second) {
                this.second = second;
            }

            public int getDayOfYear() {
                return dayOfYear;
            }

            public void setDayOfYear(int dayOfYear) {
                this.dayOfYear = dayOfYear;
            }

            public String getDayOfWeek() {
                return dayOfWeek;
            }

            public void setDayOfWeek(String dayOfWeek) {
                this.dayOfWeek = dayOfWeek;
            }

            public ChronologyDTO getChronology() {
                return chronology;
            }

            public void setChronology(ChronologyDTO chronology) {
                this.chronology = chronology;
            }

            public static class ChronologyDTO {
                /**
                 * id : ISO
                 * calendarType : iso8601
                 */

                private String id;
                private String calendarType;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getCalendarType() {
                    return calendarType;
                }

                public void setCalendarType(String calendarType) {
                    this.calendarType = calendarType;
                }
            }
        }
    }
}
