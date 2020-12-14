package com.example.yiliaoyinian.Beans;

import java.util.List;

public class ZhiBanssBean {


    /**
     * success : true
     * result : {"id":243,"nurseName":"陈家钦","nurseCode":"0101","idCard":"445381199410011733","nation":"","phone":"18318481915","deptName":"","headImg":"http://39.108.253.88:3002/group1/image/1607586906(1).jpg","address":"广州市海珠区兴隆中10号201房","mailbox":"","school":"","specialty":"","censusAddress":"","memo":"","createTime":1607586918000,"orgId":22,"password":"ed9e327cbd1e342851168db4377f40f3968180e8383ce79f2ea8f7cc741901b4","salt":"f4UVCN6CNDXvBNIOTs4E","status":1,"perm":2,"noteList":[],"scheduleGroup":{"id":"1338401414153617408","scheduleId":12,"nurseId":243,"nurseName":"陈家钦","options":"{\"a1\":\"护理A组(早班)\",\"a2Id\":23,\"a2\":\"休息\",\"a0shiftDate\":\"07:27~17:28\",\"a0Id\":20,\"a1Id\":20,\"a2shiftDate\":\"07:27~17:28\",\"a1shiftId\":13,\"a2shiftId\":13,\"a0shiftId\":13,\"a1shiftDate\":\"07:27~17:28\",\"a0\":\"护理A组(早班)\"}","createTime":{"month":"DECEMBER","year":2020,"dayOfMonth":14,"hour":16,"minute":32,"monthValue":12,"nano":0,"second":18,"dayOfWeek":"MONDAY","dayOfYear":349,"chronology":{"id":"ISO","calendarType":"iso8601"}},"startDate":"2020-12-01","endDate":"2020-12-17","scheduleName":"12月排班","remark":""}}
     * code : 1
     */

    private boolean success;
    private ResultDTO result;
    private int code;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultDTO {
        /**
         * id : 243
         * nurseName : 陈家钦
         * nurseCode : 0101
         * idCard : 445381199410011733
         * nation :
         * phone : 18318481915
         * deptName :
         * headImg : http://39.108.253.88:3002/group1/image/1607586906(1).jpg
         * address : 广州市海珠区兴隆中10号201房
         * mailbox :
         * school :
         * specialty :
         * censusAddress :
         * memo :
         * createTime : 1607586918000
         * orgId : 22
         * password : ed9e327cbd1e342851168db4377f40f3968180e8383ce79f2ea8f7cc741901b4
         * salt : f4UVCN6CNDXvBNIOTs4E
         * status : 1
         * perm : 2
         * noteList : []
         * scheduleGroup : {"id":"1338401414153617408","scheduleId":12,"nurseId":243,"nurseName":"陈家钦","options":"{\"a1\":\"护理A组(早班)\",\"a2Id\":23,\"a2\":\"休息\",\"a0shiftDate\":\"07:27~17:28\",\"a0Id\":20,\"a1Id\":20,\"a2shiftDate\":\"07:27~17:28\",\"a1shiftId\":13,\"a2shiftId\":13,\"a0shiftId\":13,\"a1shiftDate\":\"07:27~17:28\",\"a0\":\"护理A组(早班)\"}","createTime":{"month":"DECEMBER","year":2020,"dayOfMonth":14,"hour":16,"minute":32,"monthValue":12,"nano":0,"second":18,"dayOfWeek":"MONDAY","dayOfYear":349,"chronology":{"id":"ISO","calendarType":"iso8601"}},"startDate":"2020-12-01","endDate":"2020-12-17","scheduleName":"12月排班","remark":""}
         */

        private int id;
        private String nurseName;
        private String nurseCode;
        private String idCard;
        private String nation;
        private String phone;
        private String deptName;
        private String headImg;
        private String address;
        private String mailbox;
        private String school;
        private String specialty;
        private String censusAddress;
        private String memo;
        private long createTime;
        private int orgId;
        private String password;
        private String salt;
        private int status;
        private int perm;
        private int gender;
        private int age;
        private long entryTime;
        private ScheduleGroupDTO scheduleGroup;
        private List<NoteListBean> noteList;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public long getEntryTime() {
            return entryTime;
        }

        public void setEntryTime(long entryTime) {
            this.entryTime = entryTime;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNurseName() {
            return nurseName;
        }

        public void setNurseName(String nurseName) {
            this.nurseName = nurseName;
        }

        public String getNurseCode() {
            return nurseCode;
        }

        public void setNurseCode(String nurseCode) {
            this.nurseCode = nurseCode;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMailbox() {
            return mailbox;
        }

        public void setMailbox(String mailbox) {
            this.mailbox = mailbox;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getSpecialty() {
            return specialty;
        }

        public void setSpecialty(String specialty) {
            this.specialty = specialty;
        }

        public String getCensusAddress() {
            return censusAddress;
        }

        public void setCensusAddress(String censusAddress) {
            this.censusAddress = censusAddress;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getOrgId() {
            return orgId;
        }

        public void setOrgId(int orgId) {
            this.orgId = orgId;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getPerm() {
            return perm;
        }

        public void setPerm(int perm) {
            this.perm = perm;
        }

        public ScheduleGroupDTO getScheduleGroup() {
            return scheduleGroup;
        }

        public void setScheduleGroup(ScheduleGroupDTO scheduleGroup) {
            this.scheduleGroup = scheduleGroup;
        }

        public List<NoteListBean> getNoteList() {
            return noteList;
        }

        public void setNoteList(List<NoteListBean> noteList) {
            this.noteList = noteList;
        }
        public static class NoteListBean {
            /**
             * id : 2
             * noteTitle : 嘎嘎嘎嘎
             * noteContent : CD好的好的回到家居军聚聚聚聚聚会聚聚句聚聚句查查吃你你你你你你；噢你顿地你内你电脑睇你地忽悠花都好搞不好都好好的好的好的点解点解多大的勇气
             * createTime : 1593677172000
             * nurseId : 10
             */

            private long id;
            private String noteTitle;
            private String noteContent;
            private long createTime;
            private long nurseId;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getNoteTitle() {
                return noteTitle;
            }

            public void setNoteTitle(String noteTitle) {
                this.noteTitle = noteTitle;
            }

            public String getNoteContent() {
                return noteContent;
            }

            public void setNoteContent(String noteContent) {
                this.noteContent = noteContent;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getNurseId() {
                return nurseId;
            }

            public void setNurseId(long nurseId) {
                this.nurseId = nurseId;
            }
        }

        public static class ScheduleGroupDTO {
            /**
             * id : 1338401414153617408
             * scheduleId : 12
             * nurseId : 243
             * nurseName : 陈家钦
             * options : {"a1":"护理A组(早班)","a2Id":23,"a2":"休息","a0shiftDate":"07:27~17:28","a0Id":20,"a1Id":20,"a2shiftDate":"07:27~17:28","a1shiftId":13,"a2shiftId":13,"a0shiftId":13,"a1shiftDate":"07:27~17:28","a0":"护理A组(早班)"}
             * createTime : {"month":"DECEMBER","year":2020,"dayOfMonth":14,"hour":16,"minute":32,"monthValue":12,"nano":0,"second":18,"dayOfWeek":"MONDAY","dayOfYear":349,"chronology":{"id":"ISO","calendarType":"iso8601"}}
             * startDate : 2020-12-01
             * endDate : 2020-12-17
             * scheduleName : 12月排班
             * remark :
             */

            private String id;
            private int scheduleId;
            private int nurseId;
            private String nurseName;
            private String options;
            private CreateTimeDTO createTime;
            private String startDate;
            private String endDate;
            private String scheduleName;
            private String remark;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getScheduleId() {
                return scheduleId;
            }

            public void setScheduleId(int scheduleId) {
                this.scheduleId = scheduleId;
            }

            public int getNurseId() {
                return nurseId;
            }

            public void setNurseId(int nurseId) {
                this.nurseId = nurseId;
            }

            public String getNurseName() {
                return nurseName;
            }

            public void setNurseName(String nurseName) {
                this.nurseName = nurseName;
            }

            public String getOptions() {
                return options;
            }

            public void setOptions(String options) {
                this.options = options;
            }

            public CreateTimeDTO getCreateTime() {
                return createTime;
            }

            public void setCreateTime(CreateTimeDTO createTime) {
                this.createTime = createTime;
            }

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public String getScheduleName() {
                return scheduleName;
            }

            public void setScheduleName(String scheduleName) {
                this.scheduleName = scheduleName;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public static class CreateTimeDTO {
                /**
                 * month : DECEMBER
                 * year : 2020
                 * dayOfMonth : 14
                 * hour : 16
                 * minute : 32
                 * monthValue : 12
                 * nano : 0
                 * second : 18
                 * dayOfWeek : MONDAY
                 * dayOfYear : 349
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
                private String dayOfWeek;
                private int dayOfYear;
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

                public String getDayOfWeek() {
                    return dayOfWeek;
                }

                public void setDayOfWeek(String dayOfWeek) {
                    this.dayOfWeek = dayOfWeek;
                }

                public int getDayOfYear() {
                    return dayOfYear;
                }

                public void setDayOfYear(int dayOfYear) {
                    this.dayOfYear = dayOfYear;
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
}
