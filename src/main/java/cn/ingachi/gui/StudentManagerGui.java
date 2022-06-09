/*
 * Created by JFormDesigner on Tue May 31 09:05:27 CST 2022
 */

package cn.ingachi.gui;

import java.awt.event.*;


import cn.ingachi.dto.StudentDto;
import cn.ingachi.entity.Major;
import cn.ingachi.service.MajorService;
import cn.ingachi.service.StudentService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
@Component
@Slf4j
public class StudentManagerGui extends JFrame {


    int selectedRows[] = {};
    String selectedCombo1;

    Vector<String> columnNames;

    String comboBox1selectitems[] = {"", "男", "女"};

    List<String> comboBox2selectitems = new ArrayList<>();


    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private StudentModifyAndAdd studentModifyAndAdd;

    @Autowired
    private StudentAdd studentAdd;

    @Autowired
    private ScoreManager scoreManager;


    public StudentManagerGui() {
        initComponents();
        setVisible(true);
    }


    public void initTable() {
        Vector rowData = new Vector();
        scrollPane1 = new JScrollPane();


        columnNames = new Vector<>();
        columnNames.add("学号");
        columnNames.add("姓名");
        columnNames.add("性别");
        columnNames.add("年龄");
        columnNames.add("年级");
        columnNames.add("班级");
        columnNames.add("专业");

        List<StudentDto> studentDtoList = studentService.getStudentDtoList();
        for (StudentDto student : studentDtoList) {
            Vector<java.io.Serializable> row = new Vector<>();
            row.add(student.getId());
            row.add(student.getName());
            row.add(student.getSex());
            row.add(student.getAge());
            row.add(student.getGrade().getGrade());
            row.add(student.getClasses().getClassName());
            row.add(student.getMajor().getName());
            rowData.add(row);
        }

        table1.setModel(new DefaultTableModel(rowData, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        initComboBox();
    }


    public void initComboBox() {
        comboBox1.setModel(new DefaultComboBoxModel(comboBox1selectitems));
        comboBox2selectitems.clear();
        comboBox2selectitems.add("");
        comboBox2selectitems.addAll(majorService.list().stream().map(Major::getName).collect(Collectors.toList()));
        comboBox2.setModel(new DefaultComboBoxModel(comboBox2selectitems.toArray(new String[0])));

    }


    private void button2MouseClicked(MouseEvent e) {
        for (int selectedRow : selectedRows) {
            studentService.removeById(Long.valueOf(table1.getValueAt(selectedRow, 0).toString()));
            log.warn("删除 =====>" + Long.valueOf(table1.getValueAt(selectedRow, 0).toString()));
        }
        initTable();
    }

    private void button1MouseClicked(MouseEvent e) {
        initTable();
    }

    private void table1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void table1MouseReleased(MouseEvent e) {
        selectedRows = table1.getSelectedRows();
    }

    private void button1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void comboBox1MouseReleased(MouseEvent e) {
        Object selectedItem = comboBox1.getSelectedItem();
        selectedCombo1 = (String) selectedItem;
        log.info(selectedCombo1);
    }

    private void button4KeyReleased(KeyEvent e) {

    }

    private void button4MouseReleased(MouseEvent e) {
        String id = formattedTextField1.getText();
        String name = formattedTextField2.getText();
        String major = (String) comboBox2.getSelectedItem();
        String sex = (String) comboBox1.getSelectedItem();


        Vector rowData = new Vector();
        scrollPane1 = new JScrollPane();
        table1.getTableHeader().setReorderingAllowed(false);


        for (StudentDto student : studentService.getStudentDtoList()) {
            if (id != null && id.length() != 0) {
                if (!String.valueOf(student.getId()).contains(id)) {
                    continue;
                }
            }
            if (name!= null && name.length() != 0) {
                if (!student.getName().contains(name)) {
                    continue;
                }
            }
            if (major != null && major.length() != 0) {
                if (!Objects.equals(student.getMajor().getName(), major)) {
                    continue;
                }
            }
            if (sex != null && sex.length() != 0) {
                if (!Objects.equals(student.getSex(), sex)) {
                    continue;
                }
            }
            Vector<java.io.Serializable> row = new Vector<>();
            row.add(student.getId());
            row.add(student.getName());
            row.add(student.getSex());
            row.add(student.getAge());
            row.add(student.getGrade().getGrade());
            row.add(student.getClasses().getClassName());
            row.add(student.getMajor().getName());
            rowData.add(row);
        }

        table1.setModel(new DefaultTableModel(rowData, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });


    }

    private void button5MouseReleased(MouseEvent e) {

    }

    private void button5MouseClicked(MouseEvent e) {
        if (selectedRows.length > 1) {
            JOptionPane.showMessageDialog(this, "一次只能修改一个学生信息", "提示", JOptionPane.ERROR_MESSAGE);
        } else {
            int selectedRow = selectedRows[0];

            studentModifyAndAdd.initInformation(Long.valueOf(String.valueOf(table1.getValueAt(selectedRow, 0))));
            studentModifyAndAdd.setVisible(true);
        }
    }

    private void button3MouseClicked(MouseEvent e) {
        studentAdd.initcombox();
        studentAdd.setVisible(true);
    }

    private void button6MouseReleased(MouseEvent e) {
        if (selectedRows.length > 1) {
            JOptionPane.showMessageDialog(this, "一次只能修改一个学生信息", "提示", JOptionPane.ERROR_MESSAGE);
        } else {
            scoreManager.initTable((Integer) table1.getValueAt(selectedRows[0], 0));
            scoreManager.setVisible(true);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        formattedTextField1 = new JFormattedTextField();
        formattedTextField2 = new JFormattedTextField();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    table1MousePressed(e);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    table1MouseReleased(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("\u5237\u65b0\u4fe1\u606f");
        button1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                button1KeyPressed(e);
                button1KeyPressed(e);
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("\u5220\u9664\u9009\u4e2d\u5b66\u751f");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
                button2MouseClicked(e);
                button1MouseClicked(e);
            }
        });

        //---- button3 ----
        button3.setText("\u6dfb\u52a0\u5b66\u751f\u4fe1\u606f");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
                button3MouseClicked(e);
                button3MouseClicked(e);
                button1MouseClicked(e);
                button3MouseClicked(e);
            }
        });

        //---- button4 ----
        button4.setText("\u67e5\u8be2");
        button4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                button4KeyReleased(e);
            }
        });
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button4MouseReleased(e);
            }
        });

        //---- comboBox1 ----
        comboBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                comboBox1MouseReleased(e);
            }
        });

        //---- label1 ----
        label1.setText("\u5b66\u53f7");

        //---- label2 ----
        label2.setText("\u59d3\u540d");

        //---- label3 ----
        label3.setText("\u4e13\u4e1a");

        //---- label4 ----
        label4.setText("\u6027\u522b");

        //---- button5 ----
        button5.setText("\u4fee\u6539\u9009\u4e2d\u5b66\u751f\u4fe1\u606f");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button5MouseClicked(e);
                button1MouseClicked(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button5MouseReleased(e);
            }
        });

        //---- button6 ----
        button6.setText("\u67e5\u770b\u9009\u4e2d\u5b66\u751f\u6210\u7ee9");
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button6MouseReleased(e);
                button6MouseReleased(e);
            }
        });

        //---- button7 ----
        button7.setText("\u4e13\u4e1a\u7ba1\u7406");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup().addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(contentPaneLayout.createSequentialGroup().addGap(51, 51, 51).addComponent(label1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE).addGap(8, 8, 8).addComponent(label2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(formattedTextField2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(label3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(40, 40, 40).addComponent(label4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(0, 22, Short.MAX_VALUE)).addGroup(contentPaneLayout.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE).addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 557, GroupLayout.PREFERRED_SIZE))).addGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup().addGap(93, 93, 93).addGroup(contentPaneLayout.createParallelGroup().addComponent(button1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE).addComponent(button2).addComponent(button3).addComponent(button5).addComponent(button6).addComponent(button7))).addGroup(contentPaneLayout.createSequentialGroup().addGap(53, 53, 53).addComponent(button4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))).addGap(118, 118, 118)));
        contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup().addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup().addGap(21, 21, 21).addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(label3).addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(label4).addComponent(button4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE).addComponent(formattedTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(label1).addComponent(label2)).addGap(14, 34, Short.MAX_VALUE).addGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup().addComponent(button1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(button2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(button3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(button5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(button6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(button7)).addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)).addGap(43, 43, 43)));
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
    private JButton button4;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}