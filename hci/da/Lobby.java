/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hci.da;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author 429
 */
public class Lobby extends javax.swing.JFrame {

    // ตัวแปรสำหรับ Search และ Autocomplete
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton btnSearch;
    private JPopupMenu popupMenu; // เมนูที่จะเด้งขึ้นมา
    
    // Data Structure: HashMap เก็บชื่อเรื่องคู่กับ Class หน้าต่าง
    private Map<String, Class<? extends javax.swing.JFrame>> pageMap = new HashMap<>();

    /**
     * Creates new form Lobby
     */
    public Lobby() {
        initComponents();
        initSearchSystem(); // เรียกฟังก์ชันสร้างระบบค้นหา
    }
    
    // ตั้งค่าข้อมูลและหน้าตาปุ่มค้นหา
    private void initSearchSystem() {
        // 1. เตรียมข้อมูลลงใน HashMap (Database จำลองของเรา) MainMenu
        pageMap.put("ขอบสันเหรียญ", Coinedges.class);
        pageMap.put("เทคนิคการผลิตเหรียญ", trickcoin.class);
        pageMap.put("ประวัติของพิพิธภัณฑ์", pichis.class);
        pageMap.put("ปฏมบทเงินตรา", one.class);
        pageMap.put("วิวัฒนาการของเหรียญกษาปณ์ไทย", evolution.class);
        pageMap.put("การปรับเปลี่ยนเหรียญกษาปณ์ของประเทศไทย", CoinModi.class);
        pageMap.put("เหรียญตราประจำจังหวัด", coin77.class);
        pageMap.put("เหรียญต่างประเทศ", contrycoin.class);
        pageMap.put("สมาชิก", member.class);

        // *** เพิ่ม: หัวข้อย่อยจากหน้า "วิวัฒนาการ" (เพื่อให้ค้นหาเจอจากหน้าแรก) ***
        // (ต้องมั่นใจว่าน้องมีไฟล์ coin1.java, coin2.java ... coin5.java ครบแล้วนะครับ)
        pageMap.put("1.ก่อนจะเป็นพดด้วง", coin1.class);
        pageMap.put("2.เงินตราสมัยอาณาจักรสุโขทัย", coin2.class);
        pageMap.put("3.เหรียญดีบุกและเงินอีแปะ", coin3.class);
        pageMap.put("4.เงินฮ้อยและเงินลาด", coin4.class);
        pageMap.put("5.เงินเจียงและเงินธ็อก", coin5.class);

        // 2. สร้างช่องค้นหาและปุ่ม (Manual Code)
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        popupMenu = new JPopupMenu(); // สร้างเมนูเปล่าๆ รอไว้

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 18));
        txtSearch.setToolTipText("พิมพ์คำค้นหา...");
        
        btnSearch.setBackground(new java.awt.Color(102, 255, 102));
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        btnSearch.setText("ค้นหา");

        // จัดวางตำแหน่ง (เหมือนเดิม)
        jPanel1.add(txtSearch);
        txtSearch.setBounds(200, 70, 300, 40); 
        
        jPanel1.add(btnSearch);
        btnSearch.setBounds(510, 70, 100, 40);

        // 3. ใส่ Logic เมื่อกดปุ่มค้นหา
        btnSearch.addActionListener(evt -> performSearch(txtSearch.getText()));

        // 4. *** ไฮไลท์สำคัญ: ระบบ Autocomplete ***
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // ถ้ากด Enter ให้ค้นหาเลย
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performSearch(txtSearch.getText());
                    popupMenu.setVisible(false);
                    return;
                }
                
                // ถ้าเป็นปุ่มอื่น ให้ทำ Autocomplete
                String textTyped = txtSearch.getText().trim();
                updateSuggestions(textTyped);
                //updateSuggestions(txtSearch.getText());
            }
        });
        
        jPanel1.validate();
        jPanel1.repaint();
    }

    // ฟังก์ชันสร้างรายการแนะนำ (Dropdown) - แก้ไขให้ค้นหาเฉพาะคำขึ้นต้น
    private void updateSuggestions(String textTyped) {
        popupMenu.setVisible(false);
        popupMenu.removeAll(); // ล้างรายการเก่าออกก่อน

        // ตัดช่องว่างหน้า-หลังออก
        textTyped = textTyped.trim(); 

        if (textTyped.isEmpty()) {
            return;
        }

        boolean foundMatch = false;

        // วนลูปเช็กว่าคำที่พิมพ์ ตรงกับคีย์ไหนใน HashMap บ้าง
        for (String key : pageMap.keySet()) {

            // 1. เช็กแบบปกติ (เช่น "ขอบ..." ขึ้นต้นด้วย ข)
            boolean matchNormal = key.startsWith(textTyped);
            
            // 2. เช็กแบบตัดตัวเลขนำหน้า (เช่น "1.ก่อน..." -> ตัด 1. ทิ้งเหลือ "ก่อน...")
            // ใช้ Regex: ^\d+\. คือหาตัวเลขตามด้วยจุด แล้วแทนที่ด้วยค่าว่าง
            String keyClean = key.replaceFirst("^\\d+\\.", "").trim(); 
            boolean matchNumber = keyClean.startsWith(textTyped);
            
            // ********** จุดที่แก้ **********
            // เปลี่ยนจาก key.contains(...) เป็น key.startsWith(...)
            // เพื่อให้ค้นหาเฉพาะคำที่ "ขึ้นต้น" ด้วยตัวอักษรนั้น
            //if (key.startsWith(textTyped)) {
            // ถ้าตรงเงื่อนไขไหนก็ได้ (Match) ให้แสดงผล
            if (matchNormal || matchNumber) {
                
                // สร้างรายการเมนูย่อย
                JMenuItem item = new JMenuItem(key);
                item.setFont(new java.awt.Font("Tahoma", 0, 16));
                // เพิ่ม Padding (ระยะห่าง) ให้ตัวหนังสือดูไม่อึดอัด
                item.setMargin(new java.awt.Insets(5, 5, 5, 5));

                // *** เพิ่ม: บังคับให้รายการมีความกว้างเท่ากับช่องค้นหา ***
                // แต่ความสูง (Height) ให้ใช้ค่าเดิมของมัน (ไม่ไปบังคับ)
                // นี่คือเทคนิคที่ทำให้ความกว้างเป๊ะ แต่ความสูงไม่เพี้ยน
                java.awt.Dimension prefSize = item.getPreferredSize();
                item.setPreferredSize(new java.awt.Dimension(txtSearch.getWidth(), prefSize.height));
                
                // ถ้าคลิกที่รายการนี้ ให้เติมคำลงช่องแล้วค้นหาทันที!
                item.addActionListener(e -> {
                    txtSearch.setText(key);
                    performSearch(key);
                    popupMenu.setVisible(false);
                });
                
                popupMenu.add(item); 
                foundMatch = true;
            }
        }

        // ถ้ามีรายการที่ตรง ค่อยแสดง Popup
        if (foundMatch) {
            // ********** จุดที่แก้ไข **********
            // ลบพวกคำสั่ง validate() หรือ setPopupSize() แบบคำนวณเองออกให้หมด
            // แล้วใช้แค่ show() ก็พอครับ Java จะจัดการยืดหดความสูงให้เองอัตโนมัติ

            // 1. สั่งให้ Popup คำนวณขนาดที่แท้จริงตามจำนวนข้อมูลที่มี
            //popupMenu.validate(); 
            // 2. ดึงความสูงที่เหมาะสม (Preferred Height) ออกมา
            //int preferredHeight = popupMenu.getPreferredSize().height;
            // 3. ตั้งค่าขนาด: กว้างเท่าช่องค้นหา, สูงเท่าที่คำนวณได้เมื่อกี้
            //popupMenu.setPopupSize(txtSearch.getWidth(), preferredHeight);
            
            // 4. แสดงผล
            popupMenu.show(txtSearch, 0, txtSearch.getHeight());
            txtSearch.requestFocus();
        }
    }

    // ฟังก์ชันค้นหาและเปิดหน้าใหม่
    private void performSearch(String query) {
        query = query.trim();
        
        if (pageMap.containsKey(query)) {
            try {
                // ดึง Class จาก Map มาเปิด
                Class<? extends javax.swing.JFrame> targetClass = pageMap.get(query);
                targetClass.newInstance().setVisible(true);
                dispose(); // ปิดหน้า Lobby
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "เกิดข้อผิดพลาดในการเปิดหน้าต่าง");
            }
        } else {
            // ถ้าไม่ตรงเป๊ะๆ ให้ลองหาแบบคลุมเครือ (เผื่อคนกด Enter เลยโดยไม่เลือกเมนู)
            boolean found = false;
            for (String key : pageMap.keySet()) {
                if (key.contains(query)) {
                    // ถ้าเจอคำใกล้เคียง ให้เปิดหน้านั้นเลย (เปิดอันแรกที่เจอ)
                    performSearch(key); 
                    found = true;
                    break;
                }
            }
            if (!found && !query.isEmpty()) {
                JOptionPane.showMessageDialog(this, "ไม่พบข้อมูล: " + query);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("พิพิธภัณฑ์เหรียญกษาปณานุรักษ์");

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jButton9.setBackground(new java.awt.Color(255, 204, 204));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("เทคนิคการผลิตเหรียญ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 204, 204));
        jButton13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton13.setText("ขอบสันเหรียญ");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("พิพิธภัณฑ์เหรียญกษาปณานุรักษ์");

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("ประวัติของพิพิธภัณฑ์");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 204, 204));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setText("ปฏมบทเงินตรา");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 204, 204));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setText("การปรับเปลี่ยนเหรียญกษาปณ์ของประเทศไทย");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 204, 204));
        jButton11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton11.setText("เหรียญตราประจำจังหวัด");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 204, 204));
        jButton12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton12.setText("เหรียญต่างประเทศ");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 204, 204));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("วิวัฒนนาการของเหรียญกษาปณ์ไทย");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(255, 204, 204));
        jButton14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton14.setText("สมาชิก");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)
                    .addComponent(jButton10)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11)
                    .addComponent(jButton13)
                    .addComponent(jButton9)
                    .addComponent(jButton12))
                .addGap(73, 73, 73))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton14)
                .addGap(335, 335, 335))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(80, 80, 80) // เพิ่มระยะห่างให้ search box
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        new trickcoin().setVisible(true);
        dispose();
      // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        new Coinedges().setVisible(true);
        dispose();
     // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new evolution().setVisible(true);// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new CoinModi().setVisible(true);// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new pichis().setVisible(true);// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        new one().setVisible(true);// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new coin77().setVisible(true);// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       new contrycoin().setVisible(true); // TODO add your handling code here:
       dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        new member().setVisible(true);// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lobby().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}