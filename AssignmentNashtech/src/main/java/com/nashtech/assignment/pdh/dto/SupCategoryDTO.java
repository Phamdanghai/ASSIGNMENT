package com.nashtech.assignment.pdh.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupCategoryDTO {
	private Long supCateId;
	private String supCateName;

	public SupCategoryDTO() {
		super();
	}

	public SupCategoryDTO(Long supCateId, String supCateName) {
		super();
		this.supCateId = supCateId;
		this.supCateName = supCateName;
	}

}
