package com.bin.fish.bitoperation;

public class BitUtil {
    //手机号
    private static int phone = 1;            // 0000 0000 0000 0000 0000 0000 0000 0001
    //邮箱
    private static int email = 2;            // 0000 0000 0000 0000 0000 0000 0000 0010
    //实名
    private static int certification = 4;    // 0000 0000 0000 0000 0000 0000 0000 0100

    /**
     * 获取当前状态的字符串拼接
     *
     * @param verify 当前状态的int值
     */
    public static String getCurrentState(int verify) {
        StringBuilder sb = new StringBuilder();
        if ((phone & verify) == phone) {
            sb.append("手机号，");
        }
        if ((email & verify) == email) {
            sb.append("邮箱，");
        }
        if ((certification & verify) == certification) {
            sb.append("实名，");
        }
        if (sb.length() == 0) {
            return "无";
        } else {
            return sb.substring(0, sb.length() - 1);
        }
    }

    /**
     * 添加一个状态值
     *
     * @param verify 当前状态的int值
     * @param type   0--添加手机状态，1--添加邮箱状态， 2--添加实名状态
     * @return 返回操作后的状态的int值
     */
    public static int addState(int verify, int type) {
        if (type == 0) {
            //先判断是否已添加手机,没有则添加
            if ((phone & verify) != phone) {
                verify = verify | phone;
            }
        }
        if (type == 1) {
            //先判断是否已添加邮箱,没有则添加
            if ((email & verify) != email) {
                verify = verify | email;
            }
        }
        if (type == 2) {
            //先判断是否已添加实名,没有则添加
            if ((certification & verify) != certification) {
                verify = verify | certification;
            }
        }
        return verify;
    }

    /**
     * 删除一个状态值
     *
     * @param verify 当前状态的int值
     * @param type   0--添加手机状态，1--添加邮箱状态， 2--添加实名状态
     * @return 返回操作后的状态的int值
     */
    public static int delState(int verify, int type) {
        if (type == 0) {
            //先判断是否已添加手机,有则删除
            if ((phone & verify) == phone) {
                verify = verify ^ phone;
            }
        }
        if (type == 1) {
            //先判断是否已添加邮箱,有则删除
            if ((email & verify) == email) {
                verify = verify ^ email;
            }
        }
        if (type == 2) {
            //先判断是否已添加实名,有则删除
            if ((certification & verify) == certification) {
                verify = verify ^ certification;
            }
        }
        return verify;
    }

}
