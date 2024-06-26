package com.wyk.taobao.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;

import com.wyk.taobao.model.bean.User;


public class BasicUtils {
    private static ProgressDialog eLoadingDialog;

    public static String UserInfoLegal(User user, String rePasword){
        boolean flag = true;
        /**
         * 判断身份证是否合法
         */
        if(!TextUtils.isEmpty(user.getIdCard())){
            flag = user.getIdCard().length() == 18;
            if(!flag) return "身份证信息不合法";
            for(int i = 0 ; i < 17 ; ++ i){
                char c = user.getIdCard().charAt(i);
                if (!(c >= '0' && c <= '9')) {
                    flag = false;
                    break;
                }
            }
            char ch1 = user.getIdCard().charAt(0);
            char ch2 = user.getIdCard().charAt(17);
            //如果第一位数为0或者最后一位数不为x或数字那么同样不合法
            if(ch1 == '0' || !(ch2 == 'x' || ch2 == 'X' || (ch2 >= '0' && ch2 <= '9'))) flag = false;
        }else
            flag = false;

        if(!flag) return "身份证信息不合法";

        if(TextUtils.isEmpty(user.getNickName())) return "昵称不可为空哦~";
        if(TextUtils.isEmpty(user.getUserName())) return "账号不可为空哦~";
        if(TextUtils.isEmpty(user.getPassword())) return "密码不可为空哦~";
        if(TextUtils.isEmpty(user.getRealName())) return "真实姓名不可为空哦~";
        if(TextUtils.isEmpty(user.getPhone())) return "手机号不可为空哦~";
        if(TextUtils.isEmpty(rePasword)) return "请再次输入密码哦~";
        if(!rePasword.equals(user.getPassword())) return "两次密码不相同哦~";
        return "合法";
    }

    public static boolean StringArrayEmpty(String [] set){
        for(String s : set){
            if(TextUtils.isEmpty(s)) return false;
        }
        return true;
    }

    public static void stopLoadingProgress() {
        if(eLoadingDialog != null && eLoadingDialog.isShowing()) eLoadingDialog.dismiss();
    }
    public static void startLoadingProgress(Context context) {
        eLoadingDialog = new ProgressDialog(context);
        eLoadingDialog.setMessage("加载中......");
        eLoadingDialog.show();
    }
}
