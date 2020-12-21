package com.example.yiliaoyinian.Beans;

import java.util.List;

public class Lojkdd {


    /**
     * success : true
     * result : {"page":1,"rows":15,"totalRecord":1,"data":[{"roomId":3,"roomName":"F303","elderly":{"id":740,"elderName":"黄计棠","elderSex":1,"elderAge":83,"inStatus":0,"buildName":"康宁","floorName":"3F","bedName":"6号","isOpen":0,"doctorName":""}}],"pageCount":1,"totalPage":1,"prePage":1,"nextPage":1,"firstPage":true,"lastPage":true}
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
         * page : 1
         * rows : 15
         * totalRecord : 1
         * data : [{"roomId":3,"roomName":"F303","elderly":{"id":740,"elderName":"黄计棠","elderSex":1,"elderAge":83,"inStatus":0,"buildName":"康宁","floorName":"3F","bedName":"6号","isOpen":0,"doctorName":""}}]
         * pageCount : 1
         * totalPage : 1
         * prePage : 1
         * nextPage : 1
         * firstPage : true
         * lastPage : true
         */

        private int page;
        private int rows;
        private int totalRecord;
        private int pageCount;
        private int totalPage;
        private int prePage;
        private int nextPage;
        private boolean firstPage;
        private boolean lastPage;
        private List<DataDTO> data;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public int getTotalRecord() {
            return totalRecord;
        }

        public void setTotalRecord(int totalRecord) {
            this.totalRecord = totalRecord;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isFirstPage() {
            return firstPage;
        }

        public void setFirstPage(boolean firstPage) {
            this.firstPage = firstPage;
        }

        public boolean isLastPage() {
            return lastPage;
        }

        public void setLastPage(boolean lastPage) {
            this.lastPage = lastPage;
        }

        public List<DataDTO> getData() {
            return data;
        }

        public void setData(List<DataDTO> data) {
            this.data = data;
        }

        public static class DataDTO {
            /**
             * roomId : 3
             * roomName : F303
             * elderly : {"id":740,"elderName":"黄计棠","elderSex":1,"elderAge":83,"inStatus":0,"buildName":"康宁","floorName":"3F","bedName":"6号","isOpen":0,"doctorName":""}
             */

            private int roomId;
            private String roomName;
            private ElderlyDTO elderly;

            public int getRoomId() {
                return roomId;
            }

            public void setRoomId(int roomId) {
                this.roomId = roomId;
            }

            public String getRoomName() {
                return roomName;
            }

            public void setRoomName(String roomName) {
                this.roomName = roomName;
            }

            public ElderlyDTO getElderly() {
                return elderly;
            }

            public void setElderly(ElderlyDTO elderly) {
                this.elderly = elderly;
            }

            public static class ElderlyDTO {
                /**
                 * id : 740
                 * elderName : 黄计棠
                 * elderSex : 1
                 * elderAge : 83
                 * inStatus : 0
                 * buildName : 康宁
                 * floorName : 3F
                 * bedName : 6号
                 * isOpen : 0
                 * doctorName :
                 */

                private long id;
                private String elderName;
                private int elderSex;
                private int elderAge;
                private int inStatus;
                private String buildName;
                private String floorName;
                private String bedName;
                private int isOpen;
                private String doctorName;
                private long checkInTime;
                private long bedId;

                public long getBedId() {
                    return bedId;
                }

                public void setBedId(long bedId) {
                    this.bedId = bedId;
                }

                public long getCheckInTime() {
                    return checkInTime;
                }

                public void setCheckInTime(long checkInTime) {
                    this.checkInTime = checkInTime;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getElderName() {
                    return elderName;
                }

                public void setElderName(String elderName) {
                    this.elderName = elderName;
                }

                public int getElderSex() {
                    return elderSex;
                }

                public void setElderSex(int elderSex) {
                    this.elderSex = elderSex;
                }

                public int getElderAge() {
                    return elderAge;
                }

                public void setElderAge(int elderAge) {
                    this.elderAge = elderAge;
                }

                public int getInStatus() {
                    return inStatus;
                }

                public void setInStatus(int inStatus) {
                    this.inStatus = inStatus;
                }

                public String getBuildName() {
                    return buildName;
                }

                public void setBuildName(String buildName) {
                    this.buildName = buildName;
                }

                public String getFloorName() {
                    return floorName;
                }

                public void setFloorName(String floorName) {
                    this.floorName = floorName;
                }

                public String getBedName() {
                    return bedName;
                }

                public void setBedName(String bedName) {
                    this.bedName = bedName;
                }

                public int getIsOpen() {
                    return isOpen;
                }

                public void setIsOpen(int isOpen) {
                    this.isOpen = isOpen;
                }

                public String getDoctorName() {
                    return doctorName;
                }

                public void setDoctorName(String doctorName) {
                    this.doctorName = doctorName;
                }
            }
        }
    }
}
