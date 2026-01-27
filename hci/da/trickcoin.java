/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hci.da;

/**
 *
 * @author 429
 */
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class trickcoin extends javax.swing.JFrame {
   public String names[] = {"C:/Users/429/Documents/NetBeansProjects/HCI&DS/src/picture/1.Proof.PNG",
                            "C:/Users/429/Documents/NetBeansProjects/HCI&DS/src/picture/2.Offset printing.PNG",
                            "C:/Users/429/Documents/NetBeansProjects/HCI&DS/src/picture/3.3D coin.PNG",
                            "C:/Users/429/Documents/NetBeansProjects/HCI&DS/src/picture/4.Sandblasting.PNG",
                            "C:/Users/429/Documents/NetBeansProjects/HCI&DS/src/picture/5.Enamelling.PNG", 
                            "C:/Users/429/Documents/NetBeansProjects/HCI&DS/src/picture/6.Hologram.PNG",
                            "C:/Users/429/Documents/NetBeansProjects/HCI&DS/src/picture/7.Special shape.PNG",
                            "C:/Users/429/Documents/NetBeansProjects/HCI&DS/src/picture/8.Gemstones decoration.PNG",
                            "C:/Users/429/Documents/NetBeansProjects/HCI&DS/src/picture/9.Latent image.PNG"};
   private Icon icons[]= {new ImageIcon(names[0]),
                          new ImageIcon(names[1]),
                          new ImageIcon(names[2]),
                          new ImageIcon(names[3]),
                          new ImageIcon(names[4]),
                          new ImageIcon(names[5]),
                          new ImageIcon(names[6]),
                          new ImageIcon(names[7]),
                          new ImageIcon(names[8]),};
   public String descriptions[] = {
        "เหรียญขัดเงา มีลักษณะเงาคล้ายกับกระจกโดนพ่นทราย\n" +
        "ลงบนบริเวณลวดลายที่ต้องการภายในแม่ตรา\n" +
        "แล้วทำการตีตราลงบนเหรียญตัวเปล่าที่ขัดเงาเตรียมไว้\n", //1 
        "เหรียญพิมพ์สี เป็นการสร้างสีสันให้กับลวดลายบนเหรียญด้วย\n" +
        "เครื่องพิมพ์แบบออฟเซต (Offset printing) โดยพิมพ์สีพื้นก่อน\n" +
        "แล้วตามด้วยการพิมพ์ทีละสีจนครบ\n", //2 
        "เหรียญ 3 มิติ ลักษณะของเหรียญจะหนาและมีลวดลายประดับ\n" +
        "อยู่โดยรอบ\n" +
        "\n" +   
        "ขั้นตอนการผลิตเริ่มจากเตรียมโลหะสำหรับการผลิตเหรียญที่\n" +
        "มีความหนากว่าปกติ\n" +
        "\n" +    
        "จากนั้นใช้เลเซอร์ในการสร้างลวดลายบนหน้าเหรียญ\n" +
        "ส่วนขอบเหรียญใช้การตีตรา",   //3 
        "เหรียญรมดำพ่นทราย จะมีผิวหน้าเหรียญคล้ายทรายและ\n" +
        "มีลวดลายที่เด่นขัดกว่าเหรียญทั่วไป โดยพ่นทรายลงบนเหรียญ\n" +
        "ด้วยเครื่องพ่น หลังจากนั้นทำการรมดำเพื่อสร้างมิติให้แก่\n" +
        "ลวดลายบนเหรียญ ซึ่งแต่ละเหรียญนั้นจะมีน้ำหนักของ\n" +
        "การรมดำที่ไม่เท่ากัน เนื่องจากขั้นตอนการรมดำจะทำด้วมือ\n" +
        "เท่านั้น", //4 
        "เหรียญลงยา เป็นการแต่งแต้มสีลงบนลวดลายของเหรียญ\n" +
        "เริ่มจากนำเหรียญวางลงบนตะแกรงเหนือตะเกียง \n" +
        "\n" +   
        "ใช้พู่กันจุ่มผงสี่ได้จากแร่สีต่างๆ ที่ผ่านการบดอย่างละเอียด\n" +
        "มาแต้มลงบนผิวของเหรียญตามต้องการ\n" +
        "\n" +   
        "แล้วจุดตะเกียงละลายผงสีไปเรื่อยๆจนกว่าจะกลายเป็นเนื้อเดียว\n" +
        "กันและติดอยู่บนผิวของเหรียญ", //5
        "เหรียญโฮโลแกรม เป็นการสร้างสีสันให้แก่ลวดลายบนเหรียญ\n" +
        "จากการทำมุมตกกระทบของแสง โดยใช้เลเซอร์ยิงลงบนผิว\n" +
        "ของกระจกแบบพิเศษ เพื่อสร้างสีสันต่างๆ ตามมุมตกกระทบ\n" +
        "ของแสง จากนั้นนำผิวกระจกที่ยิงเสร็จเรียบร้อยมาถ่ายแบบลง\n" +
        "บนแม่ตรา แล้วทำการตีตราลงบนเหรียญ\n", //6
        "เหรียญรูปทรงพิเศษ จะมีรูปทรงอื่นๆ ที่แตกต่างจากเหรียญ\n" +
        "กลมแบนทั่วไป\n" +
        "ซึ่งรูปทรงขึ้นอยู่กับการสร้างขอบจานในการตีเหรียญ\n" +
        "เมื่อตีตราลงบนเหรียญ\n" +
        "ขอบเหรียญจะพุ่งเข้าสู่ขอบจานเกิดเป็นรูปทรงต่างๆ เช่น \n" +
        "เหรียญเสมา เป็นต้น\n", //7
        "เหรียญประดับอัญมณีเป็นการตกแต่งอัญมณี\n" +
        "หลากสีสันบนหน้าเหรียญเริ่มจากสร้างร่องสำหรับใส่อัญมณี\n" + 
        "บนแม่ตรา หลังจากนั้นใช้แม่ตราตีลงบนเหรียญ\n" +
        "แล้วจึงนำอัญมณีมาประดับลงบนเหรียญที่ดีเสร็จเรียบร้อย\n" +
        "โดยใช้กาวเชื่อมโลหะในการยืด\n", //8
        "เหรียญภาพแฝง ลวดลายบางส่วนบนเหรียญจะเปลี่ยนแปลงไป\n" +
        "ตามมุมของการมองเหรียญ\n" +
        "โดยสร้างพื้นผิวบนแม่ตราที่ต้องการทำภาพแฝงให้มีพื้นผิว\n" +
        "คล้ายกับปริซึมสามเหลี่ยมที่เรียงแถวแนวยาว จากนั้นสร้าง\n" +
        "ลวดลายแต่ละด้านของปริซึมให้แตกต่าง\n" +
        "เช่น ด้านซ้ายของปริซึมเป็นตัวอักษร ด้านขวาเป็นภาพ\n" +
        "หลังจากทำการตีตราเรียบร้อย เมื่อทำการเอียงเหรียญจะ\n" +
        "เห็นแนวปริซึมนั้น เกิดออกมาเป็นตัวอักษรและภาพที่แฝงอยู่บน\n" +
        "เหรียญตามมุมมองของการเอียง\n" //9   
    };
    /**
     * Creates new form trickcoin
     */
    public trickcoin() {
        initComponents();
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
        Lb1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("เทคนิคการผลิตเหรียญ");
        setBackground(new java.awt.Color(255, 255, 51));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        Lb1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Lb1.setText("ภาพ");

        descriptionArea.setEditable(false);
        descriptionArea.setBackground(new java.awt.Color(255, 204, 204));
        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        jScrollPane1.setViewportView(descriptionArea);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("เทคนิคการผลิตเหรียญ");

        combo.setBackground(new java.awt.Color(0, 153, 153));
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1.การขัดเงา (Proof)", "2.การพิมพ์สี (Offset printing)", "3.การทำเหรียญ 3 มิติ (3D coins)", "4.การรมดำพ่นทราย (Sandblasting)", "5.การลงยาสี (Enamelling)", "6.เทคนิคโฮโลแกรม (Hologram)", "7.รูปทรงพิเศษ (Special shape)", "8.การประดับอัญมณี (Gemstones decoration)", "9.เทคนิคภาพแฝง (Latent image)" }));
        combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboItemStateChanged(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(Lb1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(348, 348, 348))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lb1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboItemStateChanged
      // เปลี่ยนภาพเมื่อผู้ใช้เลือก ComboBox
        Lb1.setIcon(icons[combo.getSelectedIndex()]);
       // แสดงข้อความที่เกี่ยวข้องกับภาพที่เลือก
        descriptionArea.setText(descriptions[combo.getSelectedIndex()]);   
    }//GEN-LAST:event_comboItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // เปลี่ยนภาพเมื่อผู้ใช้เลือก ComboBox
        Lb1.setIcon(icons[combo.getSelectedIndex()]);
       // แสดงข้อความที่เกี่ยวข้องกับภาพที่เลือก
        descriptionArea.setText(descriptions[combo.getSelectedIndex()]);
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Lobby().setVisible(true);
        //setVisible(false);// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(trickcoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trickcoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trickcoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trickcoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trickcoin().setVisible(true);
            }
        });
    }
    
    //public String names[] = {"C:/Users/429/Documents/HCI&DA/src/picture/1.Proof.PNG",
    //                        "C:/Users/429/Documents/HCI&DA/src/picture/2.Offset printing.PNG",
    //                        "C:/Users/429/Documents/HCI&DA/src/picture/3.3D coin.PNG",
    //                        "C:/Users/429/Documents/HCI&DA/src/picture/4.Sandblasting.PNG",
    //                        "C:/Users/429/Documents/HCI&DA/src/picture/5.Enamelling.PNG", 
    //                        "C:/Users/429/Documents/HCI&DA/src/picture/6.Hologram.PNG",
    //                        "C:/Users/429/Documents/HCI&DA/src/picture/7.Special shape.PNG",
    //                       "C:/Users/429/Documents/HCI&DA/src/picture/8.Gemstones decoration.PNG",
    //                        "C:/Users/429/Documents/HCI&DA/src/picture/9.Latent image.PNG"};

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lb1;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
