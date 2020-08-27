package com.deep.test.clone;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

public class SerialDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setName("serial");
        user.setAge("30");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(user);
        byte[] rs = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(rs);
        ObjectInputStream ois = new ObjectInputStream(bis);
        User user1 = (User)ois.readObject();
        System.out.println(user1);

        FileOutputStream fileOutputStream = new FileOutputStream(new File("user"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        //反序列化时 类的serialVersionUID 不能做修改，如果修改了，反序列化会失败
        FileInputStream fileInputStream= new FileInputStream(new File("user"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        User user2 = (User)objectInputStream.readObject();
        System.out.println(user2);

    }
}
