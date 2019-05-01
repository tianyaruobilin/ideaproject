package com.nonglianwang.buchong.util;

import java.util.UUID;

public class VerifyUUID {
    public static boolean checkIsUUID(String uuidStr){
        try {
            UUID.fromString(uuidStr).toString();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
