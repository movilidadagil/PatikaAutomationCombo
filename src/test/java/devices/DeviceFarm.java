package devices;

import lombok.Data;

public enum DeviceFarm {
    ANDROID_OREO("src/test/resources/capabilities/android-oreo.json"),
    ANDROID_KITKAT("src/test/resources/capabilities/android-kitkat.json");

    public  String path;
    DeviceFarm(String path) {
        this.path = path;
    }
}
