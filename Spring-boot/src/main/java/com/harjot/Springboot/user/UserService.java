package com.harjot.Springboot.user;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 4;

    static{
        users.add(new User("adam",new Date(),1)) ;
        users.add(new User("eve",new Date(),2)) ;
        users.add(new User("john",new Date(),3)) ;
        users.add(new User("sam",new Date(),4)) ;

    }

    public List<User> findAll(){
        return users;
    }

    public User save (User user){
        if(user.getId()==null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne (int id){

        for(User user:users){
            if(user.getId()==id){
                return user;
            }
        }
      return null;
    }

    public User deleteById (int id){

        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
