/*
 * Created by JFormDesigner on Tue May 31 08:02:58 CST 2022
 */

package cn.ingachi.gui;

import cn.ingachi.entity.Manager;
import cn.ingachi.service.ManagerService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
@Component
@Slf4j
public class LoginGui extends JFrame {


    @Autowired//依赖注入，通过spring框架实现控制反转
    ManagerService managerService;

    @Autowired
    StudentManagerGui studentManagerGui;

    public LoginGui() {
        initComponents();
        this.setVisible(true);
    }


    public void login(){
        try {
            Manager loginManager = new Manager();
            loginManager.setUserName(textField1.getText());
            loginManager.setPassword(String.valueOf(passwordField1.getPassword()));
            //构造查询条件
            LambdaQueryWrapper<Manager> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Manager::getUserName,loginManager.getUserName());
            queryWrapper.eq(Manager::getPassword,loginManager.getPassword());

//            根据查询条件去获取数据库中是否有此用户
            Manager one = managerService.getOne(queryWrapper);

            if(Objects.isNull(one)){
                JOptionPane.showMessageDialog(this,"用户名或密码错误","提示",JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"登录成功!", "提示",JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                studentManagerGui.initTable();
                studentManagerGui.setVisible(true);
            }

        }catch (Exception exception){
            JOptionPane.showMessageDialog(this,"程序异常，异常原因" + exception.getMessage(),"提示",JOptionPane.ERROR_MESSAGE);
            exception.printStackTrace();
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        login();

    }

    private void button1KeyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            login();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();

        //======== this ========
        setIconImage(null);
        setTitle("BooksManager");
        Container contentPane = getContentPane();

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        button1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                button1KeyPressed(e);
            }
        });

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d:");

        //---- label2 ----
        label2.setText("\u5bc6\u7801:");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(18, 18, 18)
                                    .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(135, 135, 135)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(70, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addGap(29, 29, 29)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addGap(78, 78, 78))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JPasswordField passwordField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
