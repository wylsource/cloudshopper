package org.star4j.cloudshopper.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NginxInfo {
	
	@Value("${nginx.ip}")
	private String NginxIp;
	
	@Value("${nginx.port}")
	private String NginxPort;

	public String getAddress() {
		//http://47.93.16.239:8888/group1/M00/00/00/rBFKNloNMtSAdtqSAABAjMQehsw917_150x150.jpg
		return "http://" + this.NginxIp + ":" + this.NginxPort;
	}

}
