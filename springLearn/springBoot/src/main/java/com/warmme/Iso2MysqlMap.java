package com.warmme;

public class Iso2MysqlMap {

	private String[] field1 = new String[64];
	private String[] field2 = new String[64];
	private String[] field3 = new String[64];
	private String[] field4 = new String[64];
	private long fieldValues1 = 0L;
	private long fieldValues2 = 0L;
	private long fieldValues3 = 0L;
	private long fieldValues4 = 0L;

	/**
	 * Ó³Éäiso2
	 * 
	 * @param iso2
	 * @param fieldNum×Ö¶Î±àºÅ
	 * @param valueOrder×Ö¶ÎÖµÔÚ×Ö¶ÎÖÐµÄÐòºÅ
	 */
	public void addIso2(String iso2, int fieldNum, int valueOrder) {
		alert(iso2, fieldNum, valueOrder);
		switch (fieldNum) {
		case 1:
			field1[valueOrder] = iso2;
			fieldValues1 += 1L << valueOrder;
			break;
		case 2:
			field2[valueOrder] = iso2;
			fieldValues2 += 1L << valueOrder;
			break;
		case 3:
			field3[valueOrder] = iso2;
			fieldValues3 += 1L << valueOrder;
			break;
		case 4:
			field4[valueOrder] = iso2;
			fieldValues4 += 1L << valueOrder;
			break;
		}
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
	
	@Override
	public String toString() {
		
		return null;
	}

	public String[] getField1() {
		return field1;
	}

	public void setField1(String[] field1) {
		this.field1 = field1;
	}

	public String[] getField2() {
		return field2;
	}

	public void setField2(String[] field2) {
		this.field2 = field2;
	}

	public String[] getField3() {
		return field3;
	}

	public void setField3(String[] field3) {
		this.field3 = field3;
	}

	public String[] getField4() {
		return field4;
	}

	public void setField4(String[] field4) {
		this.field4 = field4;
	}

	public long getFieldValues1() {
		return fieldValues1;
	}

	public void setFieldValues1(long fieldValues1) {
		this.fieldValues1 = fieldValues1;
	}

	public long getFieldValues2() {
		return fieldValues2;
	}

	public void setFieldValues2(long fieldValues2) {
		this.fieldValues2 = fieldValues2;
	}

	public long getFieldValues3() {
		return fieldValues3;
	}

	public void setFieldValues3(long fieldValues3) {
		this.fieldValues3 = fieldValues3;
	}

	public long getFieldValues4() {
		return fieldValues4;
	}

	public void setFieldValues4(long fieldValues4) {
		this.fieldValues4 = fieldValues4;
	}

}
