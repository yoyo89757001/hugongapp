package com.example.yiliaoyinian.Beans;

import java.util.List;

public class IKjdd {


    /**
     * success : true
     * result : [{"id":740,"elderImage":"","elderName":"黄计棠","elderSex":1,"elderAge":83,"elderHeight":0,"region":"广东省广州市","address":"广州市越秀区","updateTime":1607065782000,"contractNumber":"000584","nationId":"汉族","political":"群众","birthday":-1022140800000,"telPhone":"","homeTel":"","degreeEducation":8,"maritalStatus":2,"retirementUnit":"","inStatus":1,"nurseLevelId":18,"nurseLevelName":"一级B","nurseGroupName":"","buildId":8,"buildName":"康宁","floorId":35,"floorName":"3F","roomId":19,"roomName":"F303","bedId":42,"bedName":"6号","orgId":22,"isOpen":0,"doctorName":""}]
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
         * id : 740
         * elderImage :
         * elderName : 黄计棠
         * elderSex : 1
         * elderAge : 83
         * elderHeight : 0.0
         * region : 广东省广州市
         * address : 广州市越秀区
         * updateTime : 1607065782000
         * contractNumber : 000584
         * nationId : 汉族
         * political : 群众
         * birthday : -1022140800000
         * telPhone :
         * homeTel :
         * degreeEducation : 8
         * maritalStatus : 2
         * retirementUnit :
         * inStatus : 1
         * nurseLevelId : 18
         * nurseLevelName : 一级B
         * nurseGroupName :
         * buildId : 8
         * buildName : 康宁
         * floorId : 35
         * floorName : 3F
         * roomId : 19
         * roomName : F303
         * bedId : 42
         * bedName : 6号
         * orgId : 22
         * isOpen : 0
         * doctorName :
         */

        private int id;
        private String elderImage;
        private String elderName;
        private int elderSex;
        private int elderAge;
        private double elderHeight;
        private String region;
        private String address;
        private long updateTime;
        private String contractNumber;
        private String nationId;
        private String political;
        private long birthday;
        private String telPhone;
        private String homeTel;
        private int degreeEducation;
        private int maritalStatus;
        private String retirementUnit;
        private int inStatus;
        private int nurseLevelId;
        private String nurseLevelName;
        private String nurseGroupName;
        private int buildId;
        private String buildName;
        private int floorId;
        private String floorName;
        private int roomId;
        private String roomName;
        private int bedId;
        private String bedName;
        private int orgId;
        private int isOpen;
        private String doctorName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getElderImage() {
            return elderImage;
        }

        public void setElderImage(String elderImage) {
            this.elderImage = elderImage;
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

        public double getElderHeight() {
            return elderHeight;
        }

        public void setElderHeight(double elderHeight) {
            this.elderHeight = elderHeight;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getContractNumber() {
            return contractNumber;
        }

        public void setContractNumber(String contractNumber) {
            this.contractNumber = contractNumber;
        }

        public String getNationId() {
            return nationId;
        }

        public void setNationId(String nationId) {
            this.nationId = nationId;
        }

        public String getPolitical() {
            return political;
        }

        public void setPolitical(String political) {
            this.political = political;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public String getTelPhone() {
            return telPhone;
        }

        public void setTelPhone(String telPhone) {
            this.telPhone = telPhone;
        }

        public String getHomeTel() {
            return homeTel;
        }

        public void setHomeTel(String homeTel) {
            this.homeTel = homeTel;
        }

        public int getDegreeEducation() {
            return degreeEducation;
        }

        public void setDegreeEducation(int degreeEducation) {
            this.degreeEducation = degreeEducation;
        }

        public int getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(int maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public String getRetirementUnit() {
            return retirementUnit;
        }

        public void setRetirementUnit(String retirementUnit) {
            this.retirementUnit = retirementUnit;
        }

        public int getInStatus() {
            return inStatus;
        }

        public void setInStatus(int inStatus) {
            this.inStatus = inStatus;
        }

        public int getNurseLevelId() {
            return nurseLevelId;
        }

        public void setNurseLevelId(int nurseLevelId) {
            this.nurseLevelId = nurseLevelId;
        }

        public String getNurseLevelName() {
            return nurseLevelName;
        }

        public void setNurseLevelName(String nurseLevelName) {
            this.nurseLevelName = nurseLevelName;
        }

        public String getNurseGroupName() {
            return nurseGroupName;
        }

        public void setNurseGroupName(String nurseGroupName) {
            this.nurseGroupName = nurseGroupName;
        }

        public int getBuildId() {
            return buildId;
        }

        public void setBuildId(int buildId) {
            this.buildId = buildId;
        }

        public String getBuildName() {
            return buildName;
        }

        public void setBuildName(String buildName) {
            this.buildName = buildName;
        }

        public int getFloorId() {
            return floorId;
        }

        public void setFloorId(int floorId) {
            this.floorId = floorId;
        }

        public String getFloorName() {
            return floorName;
        }

        public void setFloorName(String floorName) {
            this.floorName = floorName;
        }

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

        public int getBedId() {
            return bedId;
        }

        public void setBedId(int bedId) {
            this.bedId = bedId;
        }

        public String getBedName() {
            return bedName;
        }

        public void setBedName(String bedName) {
            this.bedName = bedName;
        }

        public int getOrgId() {
            return orgId;
        }

        public void setOrgId(int orgId) {
            this.orgId = orgId;
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
