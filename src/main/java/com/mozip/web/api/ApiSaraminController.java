package com.mozip.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
public class ApiSaraminController {

    @Value("${saramin.key}")
    private String key;

    private final RestTemplate restTemplate;

    @GetMapping("/job-search")
    public ResponseEntity<?> saramin(@RequestParam(value = "keywords", required = false, defaultValue = "") String keywords,
                                     @RequestParam(value = "start", required = false) String start,
                                     @RequestParam(value = "count", required = false) String count,
                                     @RequestParam(value = "job_mid_cd", required = false) String job_mid_cd,
                                     @RequestParam(value = "loc_cd", required = false, defaultValue = "") String loc_cd,
                                     @RequestParam(value = "job_cd", required = false, defaultValue = "") String job_cd,
                                     @RequestParam(value = "fields") String fields
    ) {
        String url = "https://oapi.saramin.co.kr/job-search?access-key=" + key
                + "&keywords=" + keywords
                + "&start=" + start
                + "&count=" + count
                + "&job_mid_cd=" + job_mid_cd
                + "&loc_cd=" + loc_cd
                + "&job_cd=" + job_cd
                + "&fields=" + fields;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok().body(response);
    }
}
