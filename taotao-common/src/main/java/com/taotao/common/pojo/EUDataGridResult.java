package com.taotao.common.pojo;

import java.util.List;

/**
 * easyui datagrid 
 * @author gui
 *
 */
public class EUDataGridResult {

	private Long total;
	private List<?> rows;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
