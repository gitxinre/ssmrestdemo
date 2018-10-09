package com.ly.ssm.dufy.common.bean;

import com.ly.ssm.dufy.common.util.LogUtils;
import org.apache.ibatis.transaction.TransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author mfl
 */

public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {

    private static final Logger logger = LoggerFactory.getLogger(MySqlSessionFactoryBean.class);

    private DataSource dataSource;

    private Resource[] mapperLocations;

    @SuppressWarnings("unused")
    private TransactionFactory transactionFactory;

    @Override
    public void setTransactionFactory(TransactionFactory transactionFactory) {
        super.setTransactionFactory(transactionFactory);
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        if (dataSource instanceof TransactionAwareDataSourceProxy) {
            this.dataSource = ((TransactionAwareDataSourceProxy) dataSource)
                    .getTargetDataSource();
        } else {
            this.dataSource = dataSource;
        }
        super.setDataSource(this.dataSource);
    }

    @Override
    public void setMapperLocations(Resource[] mapperLocations) {
        this.mapperLocations = mapperLocations;
        Resource[] currentDatabaseResources = this.getCurrentDatabaseResources();
        super.setMapperLocations(currentDatabaseResources);
    }

    private Resource[] getCurrentDatabaseResources() {

        Resource[] currentDatabaseResources = new Resource[this.mapperLocations.length];
        String databaseLogo = DatabaseLogoEnum.ORACLE.toString();
        try {
            databaseLogo = this.getDatabaseIdProvider().getDatabaseId(dataSource);
        } catch (SQLException e) {
            logger.error(LogUtils.myLogFormat("获取数据库类型错误！"));
            e.printStackTrace();
        }
        this.printDatabaseLogo(databaseLogo);
        for (int i = 0; i < mapperLocations.length; i++) {
            File file = null;
            String path;
            try {
                file = mapperLocations[i].getFile();
            } catch (IOException e) {
                logger.error(LogUtils.myLogFormat("获取mapper.xml文件信息错误！"));
                e.printStackTrace();
            }
            if (file != null) {
                path = file.getPath();
                if (this.myApp(path)) {
                    if (path.contains(databaseLogo.toLowerCase())) {
                        currentDatabaseResources[i] = mapperLocations[i];
                    }
                }else{
                    currentDatabaseResources[i] = mapperLocations[i];
                }
            }
        }
        return currentDatabaseResources;
    }



    private void printDatabaseLogo(String databaseLogo) {
        System.out.println("##" + "database " + "type " + "is " + databaseLogo);
    }

    private boolean myApp(String mapperXmlPath) {
        logger.info("hqbpmn *Mapper.xml path is <===> {}", mapperXmlPath);
        return true;
    }


}
