package org.star4j.cloudshopper.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.gson.Gson;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.star4j.cloudshopper.enums.ResultState;
import org.star4j.cloudshopper.result.ObjectResult;

@Component
public class UserFallbackProvider implements ZuulFallbackProvider {
	@Override
	public String getRoute() {
		return "cloudshopper-user";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			
			/** 下面三个方法是一套 都是返回 http 状态码 */
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST;  //返回 http 状态码
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST.value();
			}

			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}
			/** 上面三个方法是一套 都是返回 http 状态码 */
			

			@Override
			public void close() {
			}

			@Override
			public InputStream getBody() throws IOException {

				//默认返回ObjectResult 类型的 结果集 json 字符串
				ObjectResult result = new ObjectResult();
				result.setCode(ResultState.RESULT_ERROR.getCode());
				result.setMsg(ResultState.RESULT_ERROR.getMessage());
				result.setResult(null);
				String resultJson = new Gson().toJson(result);
				return new ByteArrayInputStream(resultJson.getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}
		};
	}
}