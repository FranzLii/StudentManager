/*
 * Created by JFormDesigner on Tue Jun 14 08:27:18 CST 2022
 */

package cn.ingachi.gui;

import java.awt.event.*;
import cn.ingachi.dto.ClassesDto;
import cn.ingachi.dto.StudentDto;
import cn.ingachi.entity.Major;
import cn.ingachi.service.ClassesService;
import cn.ingachi.service.GradeService;
import cn.ingachi.service.MajorService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
@Component
public class ClassesManager extends JFrame {
    @Autowired
    private ClassesService classesService;

    @Autowired
    private ClassesAdd classesAdd;


    int selectedRows[] = {};

    public ClassesManager() {
        initComponents();
//        setVisible(true);
    }




    public void initTable(){
        Vector columnNames = new Vector();

        Vector rowData = new Vector();
        scrollPane1 = new JScrollPane();


        columnNames = new Vector<>();
        columnNames.add("id");
        columnNames.add("年级");
        columnNames.add("班级");
        columnNames.add("专业");

        List<ClassesDto> classesDtoList = classesService.getClassesDtoList();
        System.out.println(classesDtoList);
        for (ClassesDto classesDto : classesDtoList) {
            Vector<java.io.Serializable> row = new Vector<>();
            row.add(classesDto.getId());
            row.add(classesDto.getGrade().getGrade());
            row.add(classesDto.getClassName());
            row.add(classesDto.getMajor().getName());
            rowData.add(row);
        }

        table1.setModel(new DefaultTableModel(rowData, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    private void button1MouseReleased(MouseEvent e) {
        initTable();
    }

    private void table1MouseReleased(MouseEvent e) {
        selectedRows = table1.getSelectedRows();
    }

    private void button3MouseReleased(MouseEvent e) {
        for (int selectedRow : selectedRows) {
            classesService.removeById((Serializable) table1.getValueAt(selectedRow,0));
        }
        initTable();
    }

    private void button2MouseReleased(MouseEvent e) {
        classesAdd.setVisible(true);
        classesAdd.initComboxBox2();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    table1MouseReleased(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("\u5237\u65b0\u6570\u636e");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button1MouseReleased(e);
            }
        });

        //---- button2 ----
        button2.setText("\u6dfb\u52a0\u73ed\u7ea7");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button2MouseReleased(e);
            }
        });

        //---- button3 ----
        button3.setText("\u5220\u9664\u9009\u4e2d\u73ed\u7ea7");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button3MouseReleased(e);
                button3MouseReleased(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(93, 93, 93)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(button3)
                        .addComponent(button1, GroupLayout.Alignment.LEADING)
                        .addComponent(button2, GroupLayout.Alignment.LEADING))
                    .addContainerGap(102, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(button1)
                            .addGap(24, 24, 24)
                            .addComponent(button2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button3)))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
