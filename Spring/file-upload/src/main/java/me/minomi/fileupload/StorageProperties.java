package me.minomi.fileupload;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-14.
 */

@ConfigurationProperties("storage")
public class StorageProperties {

    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
