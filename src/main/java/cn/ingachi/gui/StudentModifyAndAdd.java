/*
 * Created by JFormDesigner on Fri Jun 03 20:11:46 CST 2022
 */

package cn.ingachi.gui;

import java.awt.event.*;

import cn.ingachi.dto.StudentDto;
import cn.ingachi.entity.Classes;
import cn.ingachi.entity.Student;
import cn.ingachi.service.ClassesService;
import cn.ingachi.service.MajorService;
import cn.ingachi.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */

@Component
@Slf4j
public class StudentModifyAndAdd extends JFrame {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private StudentManagerGui studentManagerGui;

    @Autowired
    private ClassesService classesService;


    String comboBox1selectitems[] = {"男", "女"};

    List<String> comboBox2selectitems = new ArrayList<>();

    private String defalutClasses = "";

    public void initInformation(Long id) {
        comboBox2selectitems.clear();
        label2.setText(String.valueOf(id));
        StudentDto student = studentService.getStudentDtoById(id);
        textField1.setText(student.getName());
        textField2.setText(String.valueOf(student.getAge()));
        comboBox1.setModel(new DefaultComboBoxModel(comboBox1selectitems));
        comboBox1.setSelectedItem(student.getSex());
        comboBox2selectitems.addAll(classesService.list().stream().map(Classes::getClassName).collect(Collectors.toList()));
        comboBox2.setModel(new DefaultComboBoxModel(comboBox2selectitems.toArray(new String[0])));
        comboBox2.setSelectedItem(student.getMajor());
        defalutClasses = student.getClasses().getClassName();
    }


    public StudentModifyAndAdd() {
        initComponents();
    }


    public void initComboBox() {
        comboBox1.setModel(new DefaultComboBoxModel(comboBox1selectitems));
        comboBox2selectitems.addAll(classesService.list().stream().map(Classes::getClassName).collect(Collectors.toList()));
        comboBox2.setModel(new DefaultComboBoxModel(comboBox2selectitems.toArray(new String[0])));
    }

    private void button1MouseClicked(MouseEvent e) {

        try{
            Student student = new Student();
            student.setId(Integer.valueOf(label2.getText()));
            student.setName(textField1.getText());
            student.setAge(Integer.valueOf(textField2.getText()));
            student.setSex((String) comboBox1.getSelectedItem());

            String classesName = (String) comboBox2.getSelectedItem();
            LambdaQueryWrapper<Classes> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Classes::getClassName, classesName);
            Classes one = classesService.getOne(queryWrapper);
            Integer cid = one.getId();

            student.setCid(cid);
            studentService.updateById(student);

            studentManagerGui.initTable();
            this.setVisible(false);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "输入信息格式有误 , 错误原因 " + ex.getMessage(), "错误提示", JOptionPane.ERROR_MESSAGE);
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label6 = new JLabel();
        comboBox1 = new JComboBox();
        button1 = new JButton();
        comboBox2 = new JComboBox();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5b66\u53f7:");

        //---- label2 ----
        label2.setText("NaN");

        //---- label3 ----
        label3.setText("\u59d3\u540d:");

        //---- label4 ----
        label4.setText("\u5e74\u9f84");

        //---- label5 ----
        label5.setText("\u73ed\u7ea7");

        //---- label6 ----
        label6.setText("\u6027\u522b");

        //---- button1 ----
        button1.setText("\u4fdd\u5b58");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup().addGap(50, 50, 50).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(contentPaneLayout.createSequentialGroup().addComponent(label4, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(textField2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)).addGroup(contentPaneLayout.createSequentialGroup().addComponent(label3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(textField1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)).addGroup(contentPaneLayout.createSequentialGroup().addComponent(label1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(label2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)).addGroup(contentPaneLayout.createSequentialGroup().addComponent(label6, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(comboBox1)).addGroup(contentPaneLayout.createSequentialGroup().addComponent(label5, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE).addGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(button1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE).addGap(53, 53, 53)).addGroup(contentPaneLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE))))).addContainerGap(147, Short.MAX_VALUE)));
        contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE).addComponent(label2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE).addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE).addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label6, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE).addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE).addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(button1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE).addContainerGap(21, Short.MAX_VALUE)));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label6;
    private JComboBox comboBox1;
    private JButton button1;
    private JComboBox comboBox2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
