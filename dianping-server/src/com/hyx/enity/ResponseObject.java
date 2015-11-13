package com.hyx.enity;

public class ResponseObject {

	private String msg;// ������Ϣ
	private int state = 1;// ״̬ 0��ʧ�� 1���ɹ�
	private Object datas;// ��Ž�������
	private int page;
	private int count;
	private int size;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public ResponseObject(String msg, int state, Object datas) {
		this.msg = msg;
		this.state = state;
		this.datas = datas;
	}

	// ʧ��
	public ResponseObject(int state, Object datas) {
		this.state = state;
		this.datas = datas;
	}

	// chengg
	public ResponseObject(String msg, int state) {

		this.msg = msg;
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Object getDatas() {
		return datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}

}
