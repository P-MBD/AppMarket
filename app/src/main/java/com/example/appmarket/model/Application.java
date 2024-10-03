package com.example.appmarket.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Application implements Parcelable {

    @SerializedName("Id")
    private int Id;

    @SerializedName("cat_Id")
    private int cat_Id;

    @SerializedName("title")
    private String title;

    @SerializedName("packageName")
    private String packageName;

    @SerializedName("versionCode")
    private int versionCode;

    @SerializedName("versionName")
    private String versionName;

    @SerializedName("Icon")
    private String Icon;

    @SerializedName("shortDescription")
    private String shortDescription;

    @SerializedName("fullDescription")
    private String fullDescription;

    @SerializedName("price")
    private String price;

    @SerializedName("rate")
    private Float rate;

    @SerializedName("downloadLink")
    private String downloadLink;

    @SerializedName("number_installs")
    private String number_installs;

    @SerializedName("minSDK")
    private int minSDK;

    @SerializedName("bulk")
    private String bulk;

    @SerializedName("developer")
    private int developer;

    @SerializedName("IsAnnouncement")
    private boolean isAnnouncement;

    @SerializedName("announcementUrl")
    private String announcementUrl;

    // Constructors
    public Application() {
    }

    protected Application(Parcel in) {
        Id = in.readInt();
        cat_Id = in.readInt();
        title = in.readString();
        packageName = in.readString();
        versionCode = in.readInt();
        versionName = in.readString();
        Icon = in.readString();
        shortDescription = in.readString();
        fullDescription = in.readString();
        price = in.readString();
        if (in.readByte() == 0) {
            rate = null;
        } else {
            rate = in.readFloat();
        }
        downloadLink = in.readString();
        number_installs = in.readString();
        minSDK = in.readInt();
        bulk = in.readString();
        developer = in.readInt();
        isAnnouncement = in.readByte() != 0;
        announcementUrl = in.readString();
    }

    public static final Creator<Application> CREATOR = new Creator<Application>() {
        @Override
        public Application createFromParcel(Parcel in) {
            return new Application(in);
        }

        @Override
        public Application[] newArray(int size) {
            return new Application[size];
        }
    };

    // Parcelable methods
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeInt(cat_Id);
        dest.writeString(title);
        dest.writeString(packageName);
        dest.writeInt(versionCode);
        dest.writeString(versionName);
        dest.writeString(Icon);
        dest.writeString(shortDescription);
        dest.writeString(fullDescription);
        dest.writeString(price);
        if (rate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(rate);
        }
        dest.writeString(downloadLink);
        dest.writeString(number_installs);
        dest.writeInt(minSDK);
        dest.writeString(bulk);
        dest.writeInt(developer);
        dest.writeByte((byte) (isAnnouncement ? 1 : 0));
        dest.writeString(announcementUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Getters and setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCat_Id() {
        return cat_Id;
    }

    public void setCat_Id(int cat_Id) {
        this.cat_Id = cat_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public String getNumber_installs() {
        return number_installs;
    }

    public void setNumber_installs(String number_installs) {
        this.number_installs = number_installs;
    }

    public int getMinSDK() {
        return minSDK;
    }

    public void setMinSDK(int minSDK) {
        this.minSDK = minSDK;
    }

    public String getBulk() {
        return bulk;
    }

    public void setBulk(String bulk) {
        this.bulk = bulk;
    }

    public int getDeveloper() {
        return developer;
    }

    public void setDeveloper(int developer) {
        this.developer = developer;
    }

    public boolean isAnnouncement() {
        return isAnnouncement;
    }

    public void setAnnouncement(boolean announcement) {
        isAnnouncement = announcement;
    }

    public String getAnnouncementUrl() {
        return announcementUrl;
    }

    public void setAnnouncementUrl(String announcementUrl) {
        this.announcementUrl = announcementUrl;
    }
}
