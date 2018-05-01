package com.warmme;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Iso2MysqlTransform3 {

	private static String[][] iso2Array = {
			{ "AD", "AE", "AF", "AG", "AI", "AL", "AM", "AO", "AQ", "AR", "AS", "AT", "AU", "AW", "AX", "AZ", "BA",
					"BB", "BD", "BE", "BF", "BG", "BH", "BI", "BJ", "BL", "BM", "BN", "BO", "BQ", "BR", "BS", "BT",
					"BV", "BW", "BY", "BZ", "CA", "CC", "CD", "CF", "CG", "CH", "CI", "CK", "CL", "CM", "CN", "CO",
					"CR", "CU", "CV", "CW", "CX", "CY", "CZ", "DE", "DJ", "DK", "DM", "DO", "DZ", "EC" },
			{ "EE", "EG", "EH", "ER", "ES", "ET", "FI", "FJ", "FK", "FM", "FO", "FR", "GA", "GB", "GD", "GE", "GF",
					"GG", "GH", "GI", "GL", "GM", "GN", "GP", "GQ", "GR", "GS", "GT", "GU", "GW", "GY", "HK", "HM",
					"HN", "HR", "HT", "HU", "ID", "IE", "IL", "IN", "IO", "IQ", "IR", "IS", "IT", "JM", "JO", "JP",
					"KE", "KG", "KH", "KI", "KM", "KN", "KP", "KR", "KW", "KY", "KZ", "LA", "LB", "LC" },
			{ "LI", "LK", "LR", "LS", "LT", "LU", "LV", "LY", "MA", "MC", "MD", "ME", "MF", "MG", "MH", "MK", "ML",
					"MM", "MN", "MO", "MP", "MQ", "MR", "MS", "MT", "MU", "MV", "MW", "MX", "MY", "MZ", "NA", "NC",
					"NE", "NF", "NG", "NI", "NL", "NO", "NP", "NR", "NU", "NZ", "OM", "PA", "PE", "PF", "PG", "PH",
					"PK", "PL", "PM", "PN", "PR", "PS", "PT", "PW", "PY", "QA", "RE", "RO", "RS", "RU" },
			{ "RW", "SA", "SB", "SC", "SD", "SE", "SG", "SH", "SI", "SJ", "SK", "SL", "SM", "SN", "SO", "SR", "SS",
					"ST", "SV", "SX", "SY", "SZ", "TC", "TD", "TF", "TG", "TH", "TJ", "TK", "TL", "TM", "TN", "TO",
					"TR", "TT", "TV", "TW", "TZ", "UA", "UG", "UM", "US", "UY", "UZ", "VA", "VC", "VE", "VG", "VI",
					"VN", "VU", "WF", "WS", "YE", "YT", "ZA", "ZM", "ZW" } };

	private static Map<String, Integer> iso2IndexMap = new HashMap<String, Integer>();

	static {
		init();
	}

	private static void init() {
		for (int i = 0; i < iso2Array.length; i++) {
			for (int j = 0; j < iso2Array[i].length; j++) {
				int index = ((i << 8) + j);// 高8位表示行数，低8位表示列数
				iso2IndexMap.put(iso2Array[i][j], index);
			}
		}
	}

	public static String[][] map(String iso2s) {

		String[][] iso2Arr = new String[4][64];
		if (iso2s == null || iso2s.equals("")) {
			return iso2Arr;
		}
		String[] iso2Arra = iso2s.split(",");
		if (iso2Arra != null && iso2Arra.length != 0) {
			for (int i = 0; i < iso2Arra.length; i++) {
				String iso2 = iso2Arra[i];
				Integer index = iso2IndexMap.get(iso2);
				if (index != null) {
					int row = (index.intValue() >> 8);// 右移动8位得到行数
					int column = index.intValue() & 0x00FF;// 对低8位按位与得到列数
					iso2Arr[row][column] = iso2;
					
				}
			}

		}
		return iso2Arr;
	}

	public static void main(String[] args) {
		System.err.println(Long.toBinaryString(524289));

		System.err.println(1L << 62);
		
		String[][] result = null;
		long now = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
		 result = map("AD,CV,EE");
		}
		System.err.println("耗时"+(System.currentTimeMillis()-now));
		System.err.println(JSONObject.toJSON(result));
	}

}
