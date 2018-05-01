package com.warmme;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Iso2MysqlTransform {

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
				int index = ((i << 8) + j);// ��8λ��ʾ��������8λ��ʾ����
				iso2IndexMap.put(iso2Array[i][j], index);
			}
		}
	}

	public static Iso2MysqlMap map(String iso2s) {

		Iso2MysqlMap iso2MysqlMap = new Iso2MysqlMap();
		if (iso2s == null || iso2s.equals("")) {
			return iso2MysqlMap;
		}
		String[] iso2Arra = iso2s.split(",");
		if (iso2Arra != null && iso2Arra.length != 0) {
			for (int i = 0; i < iso2Arra.length; i++) {
				String iso2 = iso2Arra[i];
				Integer index = iso2IndexMap.get(iso2);
				if (index != null) {
					int row = (index.intValue() >> 8);// ���ƶ�8λ�õ�����
					int column = index.intValue() & 0x00FF;// �Ե�8λ��λ��õ�����
					iso2MysqlMap.addIso2(iso2, row+1, column);
					
				}
			}

		}
		return iso2MysqlMap;
	}

	public static void main(String[] args) {
		System.err.println(Long.toBinaryString(524289));

		System.err.println(1L << 62);
		
		Iso2MysqlMap result = null;
		long now = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
		 result = map("AD,CV,EE");
		}
		System.err.println("��ʱ��"+(System.currentTimeMillis()-now));
		System.err.println(JSONObject.toJSON(result));
	}

}
