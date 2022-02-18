package com.xiaoju.framework.entity.request.cases;

import com.xiaoju.framework.entity.request.ParamValidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用例 导入文件并上传
 *
 * @author hcy
 * @date 2020/10/22
 */
@Data
// @AllArgsConstructor
public class FileImportReq implements ParamValidate {

	public MultipartFile file;

	public String creator;

	public String bizId;

	public Long productLineId;

	public String title;

	public String description;

	/**
	 * 默认为1，如果有其他需求，可以变为其他数字
	 */
	public Integer channel;

	public String requirementId;

	public FileImportReq(MultipartFile file, String creator, String bizId, Long productLineId, String title,
			String description, Integer channel, String requirementId) {
		this.file = file;
		this.creator = creator;
		this.bizId = bizId;
		this.productLineId = productLineId;
		this.title = title;
		this.description = description;
		this.channel = channel;
		this.requirementId = requirementId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public Long getProductLineId() {
		return productLineId;
	}

	public void setProductLineId(Long productLineId) {
		this.productLineId = productLineId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	public String getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}

	@Override
	public void validate() {
		if (channel == null || channel < 0) {
			throw new IllegalArgumentException("渠道为空或者非法");
		}
		if (file == null || file.isEmpty()) {
			throw new IllegalArgumentException("请先上传文件");
		}
		if (productLineId == null || productLineId < 0L) {
			throw new IllegalArgumentException("业务线id为空或者非法");
		}
		if (StringUtils.isEmpty(title)) {
			throw new IllegalArgumentException("标题为空");
		}
		if (StringUtils.isEmpty(creator)) {
			throw new IllegalArgumentException("创建人为空");
		}
		if (StringUtils.isEmpty(bizId)) {
			// 特殊点，没有传bizId就给-1，而不是报错
			throw new IllegalArgumentException("文件夹id");
		}
	}

}
