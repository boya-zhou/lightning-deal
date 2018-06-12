package com.seckillhigh.utils;

import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.service.Impl.SecKillHighService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileWriter;
import java.io.IOException;

public class UserUtil {

    @Autowired
    SecKillHighService secKillHighService;

    static final String filename = "/Users/boyazhou/Desktop/seckillhigh/fakeUserConfig.txt";

    static FileWriter fw;

    static {

        try {
            fw = new FileWriter(filename,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertAndCreateFakeConfig(int num){

        for (int i = 0; i < num; i++) {

            SecKillHighUser secKillHighUser = new SecKillHighUser();
            secKillHighUser.setSalt("1a2b3d4b");
            secKillHighUser.setPassword(Md5.inputPassToDB("chimantou", secKillHighUser.getSalt()));
            secKillHighService.insertUser(secKillHighUser);

            fw.write();

        }

    }

    public static void main(String[] args) {


    }

}
