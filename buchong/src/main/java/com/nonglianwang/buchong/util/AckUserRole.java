package com.nonglianwang.buchong.util;

import java.util.List;

/**
 * 用于判断用户身份
 */
public class AckUserRole {

    /**
     * @param roleNames
     * @return
     */
    public static String getRole(List<String> roleNames) {
            if (roleNames.contains("管理员")) {
                return "管理员";
            } else if (roleNames.contains("商家")) {
                return "商家";
            } else if (roleNames.contains("会员用户")) {
                return "会员用户";
            } else if (roleNames.contains("普通用户")) {
                return "普通用户";
            }
        return "unknow";
    }
}
