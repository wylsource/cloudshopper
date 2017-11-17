package org.star4j.cloudshopper.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * fastdfs 服务器信息
 * @author t460p
 *
 */

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FdfsInfo {

	@Value("${fdfs.thumbImage.width}")
	private String thumbImageWidth;
	
	@Value("${fdfs.thumbImage.height}")
	private String thumbImageHeight;
	
	private List<String> trackerList;

	public String getSize() {
		return this.thumbImageWidth + "x" +this.thumbImageHeight;
	}
	
}
