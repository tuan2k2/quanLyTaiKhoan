/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.UserDao;
import Model.User;
import java.util.List;

/**
 *
 * @author tuanta
 */
public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }
    
     public void addUser(User user){
        userDao.addUser(user);
    }
    public void deleteUser(int id){
        userDao.deleteUser(id);
    }
    
   public void updateUser(User user){
        userDao.updateUser(user);
    }
    public void editUser(User user){
        userDao.editUser(user);
    }
   
   public User getUserById(int id){
        return userDao.getUserById(id);
    }
    public  List<User> getAllUers(){
        return userDao.getAllUsers();
    }
   
   
}
