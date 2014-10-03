/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wiremock.poc.test.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wiremock.poc.HomeController;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration("VisitsViewTests-config.xml")
@ContextHierarchy({
	@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
	
	}),
	@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
	})
	})
@ActiveProfiles("local")
public class TestHelloController {

    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private HomeController homeController;
    
    private MockMvc mockMvc;
    
    @Autowired
	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}

	@Before
    public void setup() {
    	//this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    	 this.mockMvc = MockMvcBuilders
    	            .standaloneSetup(homeController).build();
    }
    
    @Test
    public void testHelloController() throws Exception {
        ResultActions actions = this.mockMvc.perform(get("/"));
        actions.andDo(print()); // action is logged into the console
        actions.andExpect(status().isBadGateway());
    }
}
