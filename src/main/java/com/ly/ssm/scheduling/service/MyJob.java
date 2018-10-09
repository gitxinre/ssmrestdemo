package com.ly.ssm.scheduling.service;

import com.ly.ssm.dufy.common.util.LogUtils;
import com.ly.ssm.dufy.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
@Service
public class MyJob {

    private static final Logger logger = LoggerFactory.getLogger(MyJob.class);

    @Autowired
    private UserDao userDao;

    public void saveUserInfo() {

        String startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        logger.info(LogUtils.myLogFormat("start " + startDate));
        MyJobImplJob myJobImplJob = new MyJobImplJob();
        userDao.insertUserInfoXml(myJobImplJob.getUser());
        String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        logger.info(LogUtils.myLogFormat("end " + endDate));

    }

}
