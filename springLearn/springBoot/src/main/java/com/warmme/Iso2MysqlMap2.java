package com.warmme;

public class Iso2MysqlMap2 {

	private String[][] iso2Array = new String[4][64];
	private long[] fieldValues = new long[4];

	/**
	 * ӳ��iso2
	 * 
	 * @param iso2
	 * @param fieldNum�ֶα��
	 * @param valueOrder�ֶ�ֵ���ֶ��е����
	 */
	public void addIso2(String iso2, int fieldNum, int valueOrder) {
		alert(iso2, fieldNum, valueOrder);
		iso2Array[fieldNum][valueOrder] = iso2;
		fieldValues[fieldNum] += (1L << valueOrder);
	}

	public String[][] getIso2Array() {
		return iso2Array;
	}

	public void setIso2Array(String[][] iso2Array) {
		this.iso2Array = iso2Array;
	}

	public long[] getFieldValues() {
		return fieldValues;
	}

	public void setFieldValues(long[] fieldValues) {
		this.fieldValues = fieldValues;
	}

	private void alert(String iso2, int fieldNum, int valueOrder) {
		if (iso2 != null && !iso2.equals("")) {
			if (fieldNum >= 1 && fieldNum <= 4) {
				if (valueOrder >= 0 && valueOrder <= 62) {
					return;
				}
			}
		}

		throw new Error("param error");
	}

}
