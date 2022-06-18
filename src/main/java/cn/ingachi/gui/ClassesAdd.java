/*
 * Created by JFormDesigner on Tue Jun 14 09:02:17 CST 2022
 */

package cn.ingachi.gui;

import java.awt.event.*;

import cn.ingachi.entity.*;
import cn.ingachi.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
@Component
@Slf4j
public class ClassesAdd extends JFrame {
    public ClassesAdd() {
        initComponents();
    }



    @Autowired
    private GradeService gradeService;


    @Autowired
    private MajorService majorService;


    @Autowired
    private ClassesService classesService;


    @Autowired
    private ClasGradService clasGradService;


    @Autowired
    private MajGradService majGradService;

    @Autowired
    private ClassesManager classesManager;


    private String comboxSelectItem1[] = {};

    private String comboxSelectItem2[] = {};

    private List<Grade> gradeList;

    private List<Major> majorList;



    public void initComboxBox2() {
        majorList = majorService.list();
        comboxSelectItem2 = majorList.stream().map(Major::getName).toArray(String[]::new);
        comboBox2.setModel(new DefaultComboBoxModel(comboxSelectItem2));
        initCombox1((String) comboBox2.getSelectedItem());
    }

    public void initCombox1(String majorName){
        Integer majorId = majorList.stream().filter(iter -> iter.getName().equals(majorName)).findFirst().get().getId();
        LambdaQueryWrapper<MajGrad> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MajGrad::getMid,majorId);
        List<MajGrad> list = majGradService.list(queryWrapper);
        gradeList = new ArrayList<>();
        for (MajGrad majGrad : list) {
            gradeList.add(gradeService.getById(majGrad.getGid()));
        }
        comboxSelectItem1 = gradeList.stream().map(Grade::getGrade).toArray(String[]::new);
        comboBox1.setModel(new DefaultComboBoxModel(comboxSelectItem1));
    }

    private void button1MouseReleased(MouseEvent e) {
        String className = textField1.getText();
        String gradeName = (String) comboBox1.getSelectedItem();
        String majorName = (String) comboBox2.getSelectedItem();
        Integer gradeId = gradeList.stream().filter(iter -> iter.getGrade().equals(gradeName)).findFirst().get().getId();
        Integer majorId = majorList.stream().filter(iter -> iter.getName().equals(majorName)).findFirst().get().getId();
        Classes classes = new Classes();
        classes.setClassName(className);
        classesService.save(classes);
        log.info( "grade id" + gradeId +"major id" + majorId + "classs id " + classes.getId());
        ClasGrad clasGrad = new ClasGrad();
        clasGrad.setCid(classes.getId());
        clasGrad.setGid(gradeId);
        clasGradService.save(clasGrad);
        setVisible(false);
        classesManager.initTable();
    }

    private void comboBox2(ActionEvent e) {
        // TODO add your code here
    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        String majorname = (String) comboBox2.getSelectedItem();
        initCombox1(majorname);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u73ed\u7ea7\u540d\u79f0");

        //---- label2 ----
        label2.setText("\u5e74\u7ea7");

        //---- label3 ----
        label3.setText("\u4e13\u4e1a");

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button1MouseReleased(e);
            }
        });

        //---- comboBox2 ----
        comboBox2.addActionListener(e -> comboBox2(e));
        comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                        .addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(183, 183, 183)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(242, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(118, 118, 118))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
