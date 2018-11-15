package org.amos.swagger2.gen;

import java.util.List;

import org.amos.framework.generator.MySQLSwagger2CodeGenerator;

/**
 * ===============================
 * 作者：amos lam
 * 时间：2018年8月29日下午3:19:22
 * 内容：自定义生成信息
 * ===============================
 */
public class BLOWCodeGenerator extends MySQLSwagger2CodeGenerator{

	@Override
	protected List<String> saveExcludeField(List<String> saveExcludeField) {
		
		/*
			默认值
			saveExcludeField.add("id");
			saveExcludeField.add("isDisable");
			saveExcludeField.add("isDeleted");
			saveExcludeField.add("createdTime");
			saveExcludeField.add("modifedTime");
		*/
		return super.saveExcludeField(saveExcludeField);
	}

	@Override
	protected List<String> saveHoldField(List<String> saveHoldField) {
		
		return super.saveHoldField(saveHoldField);
	}

	@Override
	protected List<String> saveHoldAnnotation(List<String> saveAddAnnotation) {
		
		/*
			默认值
		*/
		return super.saveHoldAnnotation(saveAddAnnotation);
	}

	
	
	@Override
	protected List<String> saveExcludeAnnotation(List<String> saveExcludeAnnotation) {
		
		saveExcludeAnnotation.add("exclude");
		return super.saveExcludeAnnotation(saveExcludeAnnotation);
	}

	@Override
	protected List<String> updateExcludeField(List<String> updateExcludeField) {
		
		/*
			默认值
			updateExcludeField.add("createdTime");
			updateExcludeField.add("modifedTime");
		*/
		return super.updateExcludeField(updateExcludeField);
	}

	@Override
	protected List<String> updateHoldField(List<String> updateHoldField) {
		
		return super.updateHoldField(updateHoldField);
	}

	@Override
	public List<String> updateHoldAnnotation(List<String> updateAddAnnotation) {
		
		/*
			默认值
			updateAddAnnotation.add("id");
		*/
		return super.updateHoldAnnotation(updateAddAnnotation);
	}

	@Override
	public List<String> updateExcludeAnnotation(List<String> updateExcludeAnnotation) {
		
		return super.updateExcludeAnnotation(updateExcludeAnnotation);
	}

	@Override
	protected List<String> deleteExcludeField(List<String> deleteExcludeField) {
		
		return super.deleteExcludeField(deleteExcludeField);
	}

	@Override
	protected List<String> deleteHoldField(List<String> deleteHoldField) {
		
		deleteHoldField.add("id");
		return super.deleteHoldField(deleteHoldField);
	}

	@Override
	public List<String> deleteHoldAnnotation(List<String> deleteHoldAnnotation) {
		
		deleteHoldAnnotation.add("id");
		return super.deleteHoldAnnotation(deleteHoldAnnotation);
	}

	@Override
	public List<String> deleteExcludeAnnotation(List<String> deleteExcludeAnnotation) {
		
		return super.deleteExcludeAnnotation(deleteExcludeAnnotation);
	}

	@Override
	protected List<String> getByIdExcludeField(List<String> getByIdExcludeField) {
		
		return super.getByIdExcludeField(getByIdExcludeField);
	}

	@Override
	protected List<String> getByIdHoldField(List<String> getByIdHoldField) {
		
		getByIdHoldField.add("id");
		return super.getByIdHoldField(getByIdHoldField);
	}

	@Override
	protected List<String> getByIdHoldAnnotation(List<String> getByIdHoldAnnotation) {
		
		getByIdHoldAnnotation.add("id");
		return super.getByIdHoldAnnotation(getByIdHoldAnnotation);
	}

	@Override
	protected List<String> getByIdExcludeAnnotation(List<String> getByIdExcludeAnnotation) {
		
		return super.getByIdExcludeAnnotation(getByIdExcludeAnnotation);
	}

	@Override
	protected List<String> findByModelExcludeField(List<String> findByModelExcludeField) {
		
		return super.findByModelExcludeField(findByModelExcludeField);
	}

	@Override
	protected List<String> findByModelHoldField(List<String> findByModelHoldField) {
		
		return super.findByModelHoldField(findByModelHoldField);
	}

	@Override
	protected List<String> findByModelHoldAnnotation(List<String> findByModelHoldAnnotation) {
		
		findByModelHoldAnnotation.add("exclude");
		return super.findByModelHoldAnnotation(findByModelHoldAnnotation);
	}

	@Override
	protected List<String> findByModelExcludeAnnotation(List<String> findByModelExcludeAnnotation) {
		
		return super.findByModelExcludeAnnotation(findByModelExcludeAnnotation);
	}
}
