package com.hp.quartz.task;

import com.hp.activity.domain.HdActivity;
import com.hp.activity.service.IHdActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 *
 * @author hp
 */
@Component("hpTask")
public class HpTask {

    @Autowired
    private IHdActivityService hdActivityService;

    public void ryParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void activityOverdue(String params) {
        System.out.println("执行有参方法：" + params);
        HdActivity hdActivity = new HdActivity();
        hdActivity.setId(Integer.valueOf(params));
        hdActivity.setExtend1(-1);
        hdActivityService.updateHdActivity(hdActivity);
    }

}
