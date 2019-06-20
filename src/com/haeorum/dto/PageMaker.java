package com.haeorum.dto;

public class PageMaker {
	private int totalCount; // ��ü �Խù� ����
	private int pageNum; // ù �������� ǥ���ϱ� ����, ������ ��ȣ�� �ǹ�
	private int contentNum = 3; // ���������� � 
	private int startPage = 1; // ���������� ����Ʈ 1
	private int endPage = 5; // ������������ ����Ʈ 5
	private boolean prev = false; // ���� ������ ȭ��ǥ
	private boolean next; // ���� ������ ȭ��ǥ
	private int currentblock = 1;
	private int lastblock;

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int currentblock) {
		this.startPage = (currentblock * 5) - 4;
		// �� �������� 5���� �������Ƿ�
		// ���� ������ ����� ��ȣ * ��ϴ� �������� ����(5) - 4�� �ϸ� ���� ������ ��ȣ�� ���� �� �ִ�
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int getlastblock, int getcurrentblock) {
		if (getlastblock == getcurrentblock) {
			this.endPage = calcpage(getTotalcount(), getContentnum());
		} else {
			this.endPage = getStartPage() + 4;
		}
		// �⺻ ���������� +4
		// ���� , ������ ������ ����̸� ������ ������ ��ȣ
	}

	public int getCurrentblock() {
		return currentblock;
	}

	public void setCurrentblock(int pagenum) {// ���� ������ ����� ��ȣ�� ������� �������ִ� �Լ�
//        ��������ȣ / ������ �׷� ���� ������ ����(5)
//        ->������ ������ ���ϱ� 1�Ѵ�. -> �� ����� ���� ��� ��ȣ��� �θ���. current block

		this.currentblock = pagenum / 5;
		if (pagenum % 5 > 0) {
			this.currentblock++;
		}
	}

	public int getLastblock() {
		return lastblock;
	}

	public void setLastblock(int totalcount) {// ������ ������ ����� ��ȣ�� ���� �������ִ� �Լ�
		// ��ü �� ������ ����ؼ� �����Ѵ�
		this.lastblock = totalcount / (5 * this.contentNum);
		if (totalcount % (5 * this.contentNum) > 0) {
			this.lastblock++;
		}
		// ��ü �� ����(128) / ������ �׷� ���� ������ ����(5) * ���������� �� ����(10)
		// ->������ ������ ���ϱ� 1�Ѵ�. -> �� ����� ������ ��� ��ȣ��� �θ���. last block
	}

	public void prevnext(int pagenum) {
		// 5���� �������� �׷��ȣ�� �����Ѵ�.
		// �׷� ��ȣ�� 3�̶�� ���� �ش� ������ �׷��� �������̶�� ���̱⿡ ���� ȭ��ǥ�� Ȱ��ȭ�Ѵ�
		// �� �ΰ��� ���ٸ� ������ ����̹Ƿ� ������ �ְ� ���İ� ����.

		if (pagenum > 0 && pagenum < 6) {
			setPrev(false);
			setNext(true);
		} else if (getLastblock() == getCurrentblock()) {
			setPrev(true);
			setNext(false);
		} else {
			setPrev(true);
			setNext(true);
		}
	}

	public int calcpage(int totalcount, int contentnum) {// ��ü ������������ ������ �Լ��� ����Ѵ�
		int totalpage = totalcount / contentnum;// ��ü �Խù� ���� �� �������� � ���̴����� ������
		if (totalcount % contentnum > 0) {// �׸��� �������� �ִٸ� 1�� ���ؼ� �� ������ ���� ��Ų��
			totalpage++;
		}
		if (totalpage < this.pageNum) {
			this.pageNum = totalpage;
		}
		return totalpage;// ������ ������ �����Ѵ�
	}

	public int getTotalcount() {
		return totalCount;
	}

	public void setTotalcount(int totalcount) {
		this.totalCount = totalcount;
	}
	
	public int getPagenum() {
		return pageNum;
	}

	public void setPagenum(int pagenum) {
		this.pageNum = pagenum;
	}

	public int getContentnum() {
		return contentNum;
	}

	public void setContentnum(int contentnum) {
        this.contentNum = contentnum;
    }
}
