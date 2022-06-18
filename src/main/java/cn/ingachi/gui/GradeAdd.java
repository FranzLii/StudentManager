/*
 * Created by JFormDesigner on Fri Jun 17 09:50:45 CST 2022
 */

package cn.ingachi.gui;

import cn.ingachi.entity.Grade;
import cn.ingachi.entity.MajGrad;
import cn.ingachi.entity.Major;
import cn.ingachi.service.GradeService;
import cn.ingachi.service.MajGradService;
import cn.ingachi.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
@Component
public class GradeAdd extends JFrame {
    public GradeAdd() {
        initComponents();
    }

    @Autowired
    private MajorService majorService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private MajGradService majGradService;

    @Autowired
    private GradeManager gradeManager;
    private List<Major> majorList;

    private String comboxSelectItem2[] = {};


    public void initCcb(){
        majorList = majorService.list();
        comboxSelectItem2 = majorList.stream().map(Major::getName).toArray(String[]::new);
        comboBox2.setModel(new DefaultComboBoxModel(comboxSelectItem2));
    }

    private void button1MouseReleased(MouseEvent e) {
        String gradeName = textField1.getText();
        Integer majorId = majorList.stream().filter(iter -> iter.getName().equals(comboBox2.getSelectedItem())).findFirst().get().getId();
        Grade grade = new Grade();
        grade.setGrade(gradeName);
        gradeService.save(grade);
        Integer gradeId = grade.getId();
        MajGrad majGrad = new MajGrad();
        majGrad.setGid(gradeId);
        majGrad.setMid(majorId);
        majGradService.save(majGrad);
        setVisible(false);
        gradeManager.initTable();
    }

    private void comboBox2(ActionEvent e) {
        // TODO add your code here
    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        button1 = new JButton();
        comboBox2 = new JComboBox();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5e74\u7ea7\u540d\u79f0");

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
                    .addGap(56, 56, 56)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(124, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(label1))
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(label3))
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addComponent(button1)
                    .addContainerGap(134, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label3;
    private JButton button1;
    private JComboBox comboBox2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
