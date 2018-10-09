package com.ly.ssm.dufy.controller;

import com.ly.ssm.dufy.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


/**
 * @author Administrator
 * @date 2018/9/30 17:22
 */
public class UserControllerTest {

    private String targetURL = "http://localhost:9005/ssm_Web_exploded/user";

    private String path = "";
    private String requestMethod = "";


    @Test
    public void testSaveUser() throws IOException {
        requestMethod = "post";
        this.clientMethod(path, requestMethod, this.getUserList(1), null);
    }

    @Test
    public void testSaveUserBatch() throws IOException {
        path = "batch";
        requestMethod = "post";
        this.clientMethod(path, requestMethod, this.getUserList(50000), null);

    }

    @Test
    public void testRemoveUserById() throws IOException {
        path = "00009f22452c480a8e53fd45eb0bd639";
        requestMethod = "delete";
        this.clientMethod(path, requestMethod, null, path);
    }

    @Test
    public void testRemoveUser() throws IOException {
        requestMethod = "delete";
        this.clientMethod(path, requestMethod, null, null);
    }

    @Test
    public void testListUser() throws IOException {
        requestMethod = "get";
        this.clientMethod(path, requestMethod, null, null);
    }


    @Test
    public void testRemoveUserBatch() throws IOException {

        String path = "";
        String requestMenthod = "delete";
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 50000; i++) {
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setName("yyyfff" + i);
            user.setAddress("地址00" + i);
            userList.add(user);
        }
        //this.clientMethod(path, requestMenthod, userList,"");
        this.clientMethod("0088526512674633b4b3925547523249", requestMenthod, userList,"0088526512674633b4b3925547523249");

    }

    private User newUser(int i) {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setName("nihaoa_" + i + "_" + new Date());
        user.setAddress("高家庄_" + i + "_" + new Date());
        user.setAge(i);
        return user;
    }

    private List<User> getUserList(int size) {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < size; i++) {
            User user = this.newUser(i);
            userList.add(user);
        }
        return userList;
    }

    private void clientMethod(String path, String requestMethod, List<User> userlist, String id) throws IOException {
        targetURL = targetURL + "/" + path;
        URL targetUrl = new URL(targetURL);
        HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();

        if(!"get".equalsIgnoreCase(requestMethod)){
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod(requestMethod.toUpperCase());
            httpConnection.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = httpConnection.getOutputStream();
            if(userlist != null && !userlist.isEmpty()){
                if (userlist.size() == 1) {
                    JSONObject jsonObject = JSONObject.fromObject(userlist.get(0));
                    outputStream.write(jsonObject.toString().getBytes());
                } else {
                    JSONArray jsonArray = JSONArray.fromObject(userlist);
                    outputStream.write(jsonArray.toString().getBytes());
                }
            }
            if (id != null && StringUtils.isNotEmpty(id)) {
                outputStream.write(id.getBytes());
            }
            outputStream.flush();
        }
        if (httpConnection.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + httpConnection.getResponseCode());
        }
        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));
        String output;
        System.out.println("Output from Server:\n");
        while ((output = responseBuffer.readLine()) != null) {
            System.out.println(output);
        }
        httpConnection.disconnect();
    }

}