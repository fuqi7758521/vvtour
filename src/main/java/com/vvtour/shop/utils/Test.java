package com.vvtour.shop.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;




public class Test {
	
	private String id;
	
	private List<TestVisit> visit;
	
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<TestVisit> getVisit() {
		return visit;
	}

	public void setVisit(List<TestVisit> visit) {
		this.visit = visit;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {

    	
    	
    	TestVisit v = new TestVisit();
    	v.setId("1001");
    	v.setName("九寨沟");
    	
    	TestVisit v2 = new TestVisit();
    	v2.setId("1002");
    	v2.setName("四川");
    	
    	List<TestVisit> l = new ArrayList<TestVisit>();
    	l.add(v);
    	l.add(v2);
    	
    	Test t = new Test();
    	t.setId("1");
    	t.setVisit(l);
    	
    	List<Test> list = new ArrayList<Test>();
    	list.add(t);

    	
    	//==============JAVA对象转化为JSON字符串====================//
    	String jsonString = JSON.toJSONString(list);
    	System.out.println(jsonString);
    	
    	//==============JSON字符串转化为JAVA对象====================//
/*    	String str = "[{\"id\":\"1\",\"visit\":[{\"id\":\"1002\",\"name\":\"四川\"}]}]";
    	list = (List<Test>)JSONArray.parseArray(str, Test.class);
    	for(Test t1 : list){
    		System.out.println("id:"+t1.getId());
    		List<TestVisit> vl = (List<TestVisit>)t1.getVisit();
    		for(TestVisit vv: vl){
    			System.out.println("visitObject:");
    			System.out.println("\t vid:"+vv.getId());
    			System.out.println("\t vname:"+vv.getName());
    		}
    		
    	}*/

    }


    private static final char[] hexDigit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',

            'B', 'C', 'D', 'E', 'F' };


    private static char toHex(int nibble) {

        return hexDigit[(nibble & 0xF)];

    }




    /**

     * 将字符串编码成 Unicode 形式的字符串. 如 "黄" to "\u9EC4"

     * Converts unicodes to encoded \\uxxxx and escapes

     * special characters with a preceding slash

     * 

     * @param theString

     *        待转换成Unicode编码的字符串。

     * @param escapeSpace

     *        是否忽略空格，为true时在空格后面是否加个反斜杠。

     * @return 返回转换后Unicode编码的字符串。

     */

    public static String toEncodedUnicode(String theString, boolean escapeSpace) {

        int len = theString.length();

        int bufLen = len * 2;

        if (bufLen < 0) {

            bufLen = Integer.MAX_VALUE;

        }

        StringBuffer outBuffer = new StringBuffer(bufLen);




        for (int x = 0; x < len; x++) {

            char aChar = theString.charAt(x);

            // Handle common case first, selecting largest block that

            // avoids the specials below

            if ((aChar > 61) && (aChar < 127)) {

                if (aChar == '\\') {

                    outBuffer.append('\\');

                    outBuffer.append('\\');

                    continue;

                }

                outBuffer.append(aChar);

                continue;

            }

            

            switch (aChar) {

            case ' ':

                if (x == 0 || escapeSpace) outBuffer.append('\\');

                outBuffer.append(' ');

                break;

            case '\t':

                outBuffer.append('\\');

                outBuffer.append('t');

                break;

            case '\n':

                outBuffer.append('\\');

                outBuffer.append('n');

                break;

            case '\r':

                outBuffer.append('\\');

                outBuffer.append('r');

                break;

            case '\f':

                outBuffer.append('\\');

                outBuffer.append('f');

                break;

            case '=': // Fall through

            case ':': // Fall through

            case '#': // Fall through

            case '!':

                outBuffer.append('\\');

                outBuffer.append(aChar);

                break;

            default:

                if ((aChar < 0x0020) || (aChar > 0x007e)) {

                    // 每个unicode有16位，每四位对应的16进制从高位保存到低位

                    outBuffer.append('\\');

                    outBuffer.append('u');

                    outBuffer.append(toHex((aChar >> 12) & 0xF));

                    outBuffer.append(toHex((aChar >> 8) & 0xF));

                    outBuffer.append(toHex((aChar >> 4) & 0xF));

                    outBuffer.append(toHex(aChar & 0xF));

                } else {

                    outBuffer.append(aChar);

                }

            }

        }

        return outBuffer.toString();

    }




    /**

     * 从 Unicode 形式的字符串转换成对应的编码的特殊字符串。 如 "\u9EC4" to "黄".

     * Converts encoded \\uxxxx to unicode chars

     * and changes special saved chars to their original forms

     * 

     * @param in

     *        Unicode编码的字符数组。

     * @param off

     *        转换的起始偏移量。

     * @param len

     *        转换的字符长度。

     * @param convtBuf

     *        转换的缓存字符数组。

     * @return 完成转换，返回编码前的特殊字符串。

     */

    public static String fromEncodedUnicode(char[] in, int off, int len) {

        char aChar;

        char[] out = new char[len]; // 只短不长

        int outLen = 0;

        int end = off + len;




        while (off < end) {

            aChar = in[off++];

            if (aChar == '\\') {

                aChar = in[off++];

                if (aChar == 'u') {

                    // Read the xxxx

                    int value = 0;

                    for (int i = 0; i < 4; i++) {

                        aChar = in[off++];

                        switch (aChar) {

                        case '0':

                        case '1':

                        case '2':

                        case '3':

                        case '4':

                        case '5':

                        case '6':

                        case '7':

                        case '8':

                        case '9':

                            value = (value << 4) + aChar - '0';

                            break;

                        case 'a':

                        case 'b':

                        case 'c':

                        case 'd':

                        case 'e':

                        case 'f':

                            value = (value << 4) + 10 + aChar - 'a';

                            break;

                        case 'A':

                        case 'B':

                        case 'C':

                        case 'D':

                        case 'E':

                        case 'F':

                            value = (value << 4) + 10 + aChar - 'A';

                            break;

                        default:

                            throw new IllegalArgumentException("Malformed \\uxxxx encoding.");

                        }

                    }

                    out[outLen++] = (char) value;

                } else {

                    if (aChar == 't') {

                        aChar = '\t';

                    } else if (aChar == 'r') {

                        aChar = '\r';

                    } else if (aChar == 'n') {

                        aChar = '\n';

                    } else if (aChar == 'f') {

                        aChar = '\f';

                    }

                    out[outLen++] = aChar;

                }

            } else {

                out[outLen++] = (char) aChar;

            }

        }

        return new String(out, 0, outLen);

    }

}

