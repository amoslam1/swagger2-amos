package org.amos.swagger2.gen;

public class GenCodeGenerator {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表别名
     */
    private String aliasName;

    /**
     * 模块名
     */
    private String modelName;
    
    /**
     * 表备注
     */
    private String tableRemarks;

    public String getTableRemarks() {
		return tableRemarks;
	}

	public void setTableRemarks(String tableRemarks) {
		this.tableRemarks = tableRemarks;
	}

	public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
