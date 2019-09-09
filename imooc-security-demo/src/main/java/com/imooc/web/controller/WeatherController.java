package com.imooc.web.controller;

import com.imooc.service.WatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 * @Title: WeatherController
 * @ProjectName imooc-security
 * @Description: TODO
 * @date 2019/9/99:34
 */
@RestController
@RequestMapping("/weather")
/**
 * @Title   获取天气接口
 * @Author  ljw
 * @Date    11:38 2019/9/9
 **/
public class WeatherController {

    @Autowired
    private WatherService watherService;

    //cityCode编码对照AboutCity.xls
    @GetMapping("/getWeather/{cityCode}")
    public List<String> getWeathers(@PathVariable int cityCode) {
        return watherService.getWeathers(cityCode);
    }
}
