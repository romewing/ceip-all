package com.ghca.ceip.web.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by gh on 2017/4/17.
 */

@FeignClient("security")
public interface SecurityService {
}
