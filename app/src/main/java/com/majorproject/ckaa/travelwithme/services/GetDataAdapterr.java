package com.majorproject.ckaa.travelwithme.services;

import java.util.List;

/**
 * Created by Buddy on 8/11/2016.
 */
public class GetDataAdapterr {
    String serviceName;
    String serviceAddress;
    String serviceInfo;
    int service_type;
    double serviceLatitude;
    double serviceLongitude;
    public List<GetDataAdapterr> invisibleChildren;
    String serviceHeaderName;
    int serviceHeaderImage;
    String childType;
    String[]  childArray;

    public String[] getChildArray() {
        return childArray;
    }

    public void setChildArray(String[] childArray) {
        this.childArray = childArray;
    }

    public String getChildType() {
        return childType;
    }

    public void setChildType(String childType) {
        this.childType = childType;
    }

    public double[] getServiceArray() {
        return serviceArray;
    }

    public void setServiceArray(double[] serviceArray) {
        this.serviceArray = serviceArray;
    }

    double[] serviceArray;


    double[]serviceLongArray;

    public double[] getServiceLongArray() {
        return serviceLongArray;
    }

    public void setServiceLongArray(double[] serviceLongArray) {
        this.serviceLongArray = serviceLongArray;
    }

    String serviceAddress1;
    String serviceInfo1;
    String serviceAddress2;
    String serviceInfo2;
    String serviceAddress3;
    String serviceInfo3;

    public GetDataAdapterr(int service_type,int serviceHeaderImage, String serviceHeaderName ) {
        this.service_type = service_type;
        this.serviceHeaderName = serviceHeaderName;
        this.serviceHeaderImage = serviceHeaderImage;
    }

    public GetDataAdapterr(int service_type, String serviceName, String serviceAddress1, String serviceInfo1, String serviceAddress2, String serviceInfo2, String serviceAddress3, String serviceInfo3, double serviceLatitude, double serviceLongitude,double[] serviceArray,double[] serviceLongArray,String childType, String[] childArray) {
        this.service_type = service_type;
        this.serviceName = serviceName;
        this.serviceAddress1 = serviceAddress1;
        this.serviceInfo1 = serviceInfo1;
        this.serviceAddress2 = serviceAddress2;
        this.serviceInfo2 = serviceInfo2;
        this.serviceAddress3 = serviceAddress3;
        this.serviceInfo3 = serviceInfo3;
        this.serviceLatitude = serviceLatitude;
        this.serviceLongitude = serviceLongitude;
        this.serviceArray = serviceArray;
        this.serviceLongArray = serviceLongArray;
        this.childType = childType;
        this.childArray = childArray;

    }
    public GetDataAdapterr(int service_type, String serviceName, String serviceAddress1, String serviceInfo1, String serviceAddress2, String serviceInfo2, String serviceAddress3, String serviceInfo3, double serviceLatitude, double serviceLongitude) {
        this.service_type = service_type;
        this.serviceName = serviceName;
        this.serviceAddress1 = serviceAddress1;
        this.serviceInfo1 = serviceInfo1;
        this.serviceAddress2 = serviceAddress2;
        this.serviceInfo2 = serviceInfo2;
        this.serviceAddress3 = serviceAddress3;
        this.serviceInfo3 = serviceInfo3;
        this.serviceLatitude = serviceLatitude;
        this.serviceLongitude = serviceLongitude;
    }

    public GetDataAdapterr(int service_type, String serviceName, String serviceAddress, String serviceInfo, double serviceLatitude, double serviceLongitude,double serviceArray[],double serviceLongArray[],String childType, String[] childArray) {
        this.service_type = service_type;
        this.serviceName = serviceName;
        this.serviceAddress = serviceAddress;
        this.serviceInfo = serviceInfo;
        this.serviceLatitude=serviceLatitude;
        this.serviceLongitude=serviceLongitude;
        this.serviceArray=serviceArray;
        this.serviceLongArray = serviceLongArray;
        this.childType = childType;
        this.childArray = childArray;
    }
    public GetDataAdapterr(int service_type, String serviceName, String serviceAddress, String serviceInfo, double serviceLatitude, double serviceLongitude) {
        this.service_type = service_type;
        this.serviceName = serviceName;
        this.serviceAddress = serviceAddress;
        this.serviceInfo = serviceInfo;
        this.serviceLatitude=serviceLatitude;
        this.serviceLongitude=serviceLongitude;
    }

    public int getServiceHeaderImage() {
        return serviceHeaderImage;
    }

    public void setServiceHeaderImage(int serviceHeaderImage) {
        this.serviceHeaderImage = serviceHeaderImage;
    }

    public String getServiceHeaderName() {
        return serviceHeaderName;
    }

    public void setServiceHeaderName(String serviceHeaderName) {
        this.serviceHeaderName = serviceHeaderName;
    }



    public int getService_type() {
        return service_type;
    }

    public void setService_type(int service_type) {
        this.service_type = service_type;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public double getServiceLatitude() {
        return serviceLatitude;
    }

    public void setServiceLatitude(double serviceLatitude) {
        this.serviceLatitude = serviceLatitude;
    }

    public double getServiceLongitude() {
        return serviceLongitude;
    }

    public void setServiceLongitude(double serviceLongitude) {
        this.serviceLongitude = serviceLongitude;
    }


    public String getServiceAddress1() {
        return serviceAddress1;
    }

    public void setServiceAddress1(String serviceAddress1) {
        this.serviceAddress1 = serviceAddress1;
    }

    public String getServiceInfo1() {
        return serviceInfo1;
    }

    public void setServiceInfo1(String serviceInfo1) {
        this.serviceInfo1 = serviceInfo1;
    }

    public String getServiceAddress2() {
        return serviceAddress2;
    }

    public void setServiceAddress2(String serviceAddress2) {
        this.serviceAddress2 = serviceAddress2;
    }

    public String getServiceInfo2() {
        return serviceInfo2;
    }

    public void setServiceInfo2(String serviceInfo2) {
        this.serviceInfo2 = serviceInfo2;
    }

    public String getServiceAddress3() {
        return serviceAddress3;
    }

    public void setServiceAddress3(String serviceAddress3) {
        this.serviceAddress3 = serviceAddress3;
    }

    public String getServiceInfo3() {
        return serviceInfo3;
    }

    public void setServiceInfo3(String serviceInfo3) {
        this.serviceInfo3 = serviceInfo3;
    }
}
