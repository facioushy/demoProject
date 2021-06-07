package com.fan.demoproject;

import com.fan.demoproject.domain.Video;
import com.fan.demoproject.service.VideoService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VideoTest {

    /**
     *
     */
    @Autowired
    private VideoService videoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVideoListApi() throws Exception{


        MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);

        String result = mvcResult.getResponse().getContentAsString();

        System.out.println(result);

    }

    @Test
    public void testVideoList(){
        List<Video> videoList = videoService.listVideo();

        TestCase.assertTrue(videoList.size()>0);
    }
}
/**
 * 如何测试Controller对外提供的接口
 *
 * 增加类注解 @AutoConfigureMockMvc
 *
 * 注入一个MockMvc类
 *
 * 相关API ：
 *
 * perform执行一个RequestBuilder请求
 * andExpect：添加ResultMatcher->MockMvcResultMatchers验证规则
 * andReturn：最后返回相应的MvcResult->Response
 */

