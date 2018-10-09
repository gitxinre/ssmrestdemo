package com.ly.ssm.scheduling.service;

import com.ly.ssm.dufy.common.util.LogUtils;
import com.ly.ssm.dufy.dao.UserDao;
import com.ly.ssm.dufy.entity.User;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Administrator
 */
@Service
public class MyJobImplJob implements Job{
    /**
        MethodInvokingJobDetailFactoryBean,implements Job,extends QuartzJobBean
        1、定义工作任务的JobDetail
                    MethodInvokingJobDetailFactoryBean与JobDetailFactoryBean
        2、定义触发器Trigger，并将工作任务与触发器绑定
            一个触发器只能绑定一个任务，一个任务可以被多个触发器绑定
        3、定义调度器Scheduler，并将trigger注册到Scheduler
    */
    private static final Logger logger = LoggerFactory.getLogger(MyJobImplJob.class);

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        String newDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("jobExecutionContext = " + "777 ### " + newDate);
        logger.info(LogUtils.myLogFormat(newDate));
        userDao.insertUserInfoAnnotation(getUser());
        System.out.println("jobExecutionContext = " + "888 ### " + newDate);

    }

    public User getUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setName("flyf");
        user.setAge(30);
        user.setAddress("高家庄");
        return user;
    }

}
