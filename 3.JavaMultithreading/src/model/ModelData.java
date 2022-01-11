package model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;


public class ModelData {//объект, который будет хранить необходимые данные для отображения на клиенте

     List<User> users;//список пользователей для отображения.

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }




}
