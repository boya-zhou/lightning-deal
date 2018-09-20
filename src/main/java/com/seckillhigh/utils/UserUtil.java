package com.seckillhigh.utils;

import com.seckillhigh.entity.SecKillHighUser;
import com.seckillhigh.redis.RedisDao;
import com.seckillhigh.redis.keyprefix.SeckillKeyPrefix;
import com.seckillhigh.service.Impl.SecKillHighService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class UserUtil {

    @Autowired
    SecKillHighService secKillHighService;

    @Autowired
    RedisDao<SecKillHighUser> redisDao;

    static final String filename = "/Users/boyazhou/Desktop/seckillhigh/fakeUserConfig2.txt";

    public void insertAndCreateFakeConfig(int num) {

        for (int i = 0; i < num; i++) {

            SecKillHighUser secKillHighUser = new SecKillHighUser();
            secKillHighUser.setSalt("1a2b3d4b");
            secKillHighUser.setPhoneId("1" + RandomStringUtils.random(10,
                    new char[] {'1','2','3','4','5','6','7','8','9'}));
            secKillHighUser.setPassword(Md5.inputPassToDB("chimantou", secKillHighUser.getSalt()));
            secKillHighService.insertUser(secKillHighUser);

            String cookieToken = UUIDUtil.uuid();

            redisDao.saveSingleEle(SeckillKeyPrefix.token, cookieToken, secKillHighUser);

            try(FileWriter fw = new FileWriter(filename, true)) {
                fw.write("1" + "," + cookieToken + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


//    public static void main(String[] args) {
//
//        UserUtil userUtil = new UserUtil();
//        userUtil.insertAndCreateFakeConfig(1);
//
//    }

}
