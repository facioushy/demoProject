package com.fan.demoproject.controller;

import com.fan.demoproject.domain.Video;
import com.fan.demoproject.service.VideoService;
import com.fan.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 视频控制器
 */

@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    //@RequestMapping("list")
    @GetMapping("list")
    public Object list(){
//        Map<String, String> map = new HashMap<>();
//        map.put("1", "面试专题");
//        map.put("2", "SpringCloud微服务");
        List<Video> list = videoService.listVideo();

        return JsonData.buildSuccess(list);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video){

        System.out.println(video.toString());

        return JsonData.buildSuccess(video);
    }

}
