package NewCoder;

/**
 * @author hbx
 * @date 2021-08-05 2:31 PM
 */
/*
 * ipv4地址
     * 数字数量为4
     * 通过 “.” 划分
     * 范围为0-255
     * 开头不能为0
 * ipv6地址
     * 8组16进制数字
     * 通过 ”:” 划分
     * 字母不区分大小写
     * 可以以0开头
     * 不能有空的组
     * 不能有多余的0（字符串长度不能超过4）
 * Neither
 */

public class NC113 {
    /**
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public String solve (String IP) {
        if(IP==null || IP.length()==0){
            return "Neither";
        }
        if(IP.contains(".")){
            String[] fields = IP.split("\\.");
            if(fields.length!=4){
                return "Neither";
            }
            for(String field : fields){
                if(!isIPv4(field)){
                    return "Neither";
                }
            }


            return "IPv4";
        }else if(IP.contains(":")){
            String[] fields = IP.split(":");
            if(fields.length!=8){
                return "Neither";
            }
            for(String field : fields){
                if(!isIPv6(field)){
                    return "Neither";
                }
            }

            return "IPv6";
        }else{
            return "Neither";
        }
    }

    private boolean isIPv4(String str){
        if(str.length()==0||str.length()>3){
            return false;
        }
        if(str.startsWith("0")){
            return false;
        }
        try{
            int val = Integer.valueOf(str);
            if (val > 255 || val < 0){
                return false;
            }
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    private boolean isIPv6(String str){
        if(str.length()>4 ||str.length()==0){
            return false;
        }
        try{
            int max = Integer.valueOf("FFFF",16);
            int num = Integer.valueOf(str,16);
            if(num>max){
                return false;
            }
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
