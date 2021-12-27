package com.kim.controller;

import com.kim.mapper.UserMapper;
import com.kim.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import static com.kim.Utils.AES.*;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/queryUserList")
    //@ResponseBody //也可以省略
    public List<User> queryUserList() {
        //System.out.println(userMapper.queryUserList());
        List<User> users = userMapper.queryUserList();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    @GetMapping("/selectUserById")
    public User selectUserById() {
        return userMapper.selectUserById(1);
    }

    @GetMapping("/addUser/{id}/{name}")
    public int addUser(@PathVariable("id") int id,@PathVariable("name") String name) {
        return userMapper.addUser(new User(id, name, "nbkls"));

    }

    @GetMapping("/updateUser")
    public int updateUser() {
        return userMapper.updateUser(new User(4, "king", "nbkls"));
    }

    @GetMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable int id) {
        return userMapper.deleteUser(id);
    }

    @RequestMapping("/selectPubKey/{name}")
    public int selectPubKey(@PathVariable("name") String name) throws Exception {
        String user_pubKey = userMapper.selectPubKey(name);
        System.out.println("user_pubKey: " + user_pubKey);

        int rand = (int) ((Math.random() * 9 + 1) * 100000);

        int encryptedText = user_pubKey.hashCode() + rand;
        System.out.println("用户标识的hashCode:"+user_pubKey.hashCode()+"随机数:"+rand);
        /*// 128位密钥 = 16 bytes Key:
        byte[] key = "1234567890abcdef".getBytes("UTF-8");
        // 加密:
        byte[] data = user_pubKey.getBytes("UTF-8");
        byte[] encrypted = encrypt(key, data);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密:
        byte[] decrypted = decrypt(key, encrypted);
        System.out.println("Decrypted: " + new String(decrypted, "UTF-8"));

        return Base64.getEncoder().encodeToString(encrypted);*/
        System.out.println("encryptedText:"+encryptedText);
        int mingWen = jieMi(encryptedText, rand);
        System.out.println("decode后的明文:"+mingWen);
        if (user_pubKey.hashCode() == mingWen) {
            System.out.println("解密成功");
        }
        return encryptedText;
    }
}
