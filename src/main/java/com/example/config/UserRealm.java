package com.example.config;

import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了->授权doGetAuthorizationInfo");

//        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
////        info.addStringPermission("user:add");  赋予权限
//
//        //拿到当前登录的对象！
//        Subject subject=SecurityUtils.getSubject();
//        User currentUser=(User) subject.getPrincipal();
//
//        //设置当前用户权限
//        info.addStringPermission(currentUser.getPerms());
//        return info;
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了->认证doGetAuthorizationInfo");

        UsernamePasswordToken userToken= (UsernamePasswordToken)token;//获取到登录的名称密码
         //连接真实数据库
        User user= userService.queryUserByName(userToken.getUsername());
        if(user==null)//无此人
        {
            return null;//Unknow
        }
//        这是给index页面判断登录的用户是否为空 为空才显示登录按钮
        Subject currentSubject=SecurityUtils.getSubject();
        Session session=currentSubject.getSession();
        session.setAttribute("loginUser",user);

        //密码加密 md5盐值加密
//        return new SimpleAuthenticationInfo("",user.getPwd(),"");
        return new SimpleAuthenticationInfo(user,user.getPwd(),""); //返回user对象 给上面那个方法使用！
    }
}
