package com.kiran.RestFileUploadDownload;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestFileUploadDownloadApplicationTests {

	@Autowired
	RestTemplate restTemplate;
	
	@Test
	void testUpload() {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("file", new ClassPathResource("abc.jpg"));
		
		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(map,httpHeaders);
		
		ResponseEntity<Boolean> response = restTemplate.postForEntity("http://localhost:8080/upload", httpEntity, Boolean.class);
		System.out.println(response.getBody());
	}

}
