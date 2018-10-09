package com.ly.ssm.scheduling.service;

import com.ly.ssm.dufy.common.util.LogUtils;
import com.ly.ssm.dufy.dao.UserDao;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
public class MyJobExtendsQuartzJobBean extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(MyJobExtendsQuartzJobBean.class);
    @Autowired
    private UserDao userDao;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        String startData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        logger.info(LogUtils.myLogFormat("MyJobExtendsQuartzJobBean start " + startData));
        MyJobImplJob myJobImplJob = new MyJobImplJob();
        userDao.insertUserInfoAnnotation(myJobImplJob.getUser());
        String endData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        logger.info(LogUtils.myLogFormat("MyJobExtendsQuartzJobBean end " + endData));
    }
}
