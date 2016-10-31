/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.PersistenceJPAConfig;
import config.SecurityConfig;
import config.WebConfig;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Maarten
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, PersistenceJPAConfig.class, SecurityConfig.class})
public class OverzichtUitgeleendControllerTest
{
    
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ApplicationContext applicationContext;

    private MockMvc mockMvc;

    @Before
    public void before() {
        SecurityHelper.setupSecurityContext("424698mv", "test", "HOOFDBEHEERDER");
        mockMvc = 
            MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    @Test
    public void testToonOverzichtUitgeleendeMaterialenGet() throws Exception {

        mockMvc.perform(get("/overzichtUitgeleendeMaterialen"))
                .andExpect(status().isOk())
                .andExpect(view().name("overzichtUitgeleendeMaterialen"))
                .andExpect(model().attributeExists("reservaties"));
    }
    
}
