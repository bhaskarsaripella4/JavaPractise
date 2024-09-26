package com.protean.flakey.security;

public class toHex {
    private final static String HEX = "0123456789ABCDEF";
    private final static byte[] seed = {-14,30,42,127,-74,-58,-128,55,-6,-22,-91,82,34,-29,32,-9}; // should get F21E2A7FB6C68037FAEAA55222E320F7
//    private final static byte[] dbpass = {-50,48,-115,-96,-10,-92,-11,91,-108,77,84,59,-113,98,100,-64,54,6,55,18,18,-89,23,-62,-101,-43,61};
//    private final static byte[] dbpass = {-48,-99,-102,-117,26,78,65,-65,13,-30,7,43,-9,60,83,-55,-47,-24,63,-99,5,124,37,-128,-108,-102,-113};
    private final static byte[] dbpass = {-48, -99, -102, -117, 12, 95, 92, -22, 14, -29, -51, 65, 12, -68, -63, 59, 23, 97, -40, 4, -107, -10, 106, 113, -127, -67}; // UAT pass//D09D9A8B0C5F5CEA0EE3CD410CBCC13B1761D80495F66A7181BD

    public static byte[] hexStringToByteArray(String s){
        byte[] b = new byte[s.length()/2];
        for(int i = 0; i<b.length; i++){
            int index = i*2;
            int v = Integer.parseInt(s.substring(index,index+2),16);
            b[i] = (byte) v;
        }
        return b;
    }

    public static String toHex(String txt) {
        return toHex(txt.getBytes());
    }

    public static String toHex(byte[] buf) {
        if (buf == null)
            return "";
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (int i = 0; i < buf.length; i++) {
            appendHex(result, buf[i]);
        }
        return result.toString();
    }

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
    }

    public static void main(String[] args) {
        String s = toHex(dbpass);
        System.out.println(s);
        System.out.println(hexStringToByteArray(s));
    }
}
