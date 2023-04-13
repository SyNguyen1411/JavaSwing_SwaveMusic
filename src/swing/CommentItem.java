package swing;

import dao.CommentInteractionDAO;
import entity.Comment;
import entity.CommentInteraction;
import java.security.Timestamp;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import swave.Login;
import utils.XDate;

/**
 *
 * @author NGUYEN VAN SI
 */
public class CommentItem extends javax.swing.JPanel {

    /**
     * Creates new form CommentItem
     */
    String nameUser;
    String Content;
    int like;
    int dislike;
    String AVT;
    private boolean likeCheck = false;
    private boolean dislikeCheck = false;
    public JScrollPane js;
    int[] a = {100, 100};
    public Comment data;
    CommentInteractionDAO ciDao = new CommentInteractionDAO();
    CommentInteraction item;
    boolean open = false;

    public CommentItem(String nameUser, String Content, int like, int dislike, String AVT) {
        this.nameUser = nameUser;
        this.Content = Content;
        this.like = like;
        this.dislike = dislike;
        this.AVT = AVT;
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

        childrenComment1 = new swing.childrenComment();
        lblAVT = new model.borderImage();
        lblNameUser = new javax.swing.JLabel();
        lblContent = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblCountDislike = new javax.swing.JLabel();
        lblDislike = new javax.swing.JLabel();
        lblCountLike = new javax.swing.JLabel();
        lblLike = new javax.swing.JLabel();
        lblExpend = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(620, 113));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(childrenComment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        lblAVT.setImage("");
        lblAVT.setPreferredSize(new java.awt.Dimension(50, 50));
        lblAVT.setSizeImage(new int[] {50, 50});
        add(lblAVT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblNameUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNameUser.setForeground(new java.awt.Color(255, 255, 255));
        lblNameUser.setPreferredSize(new java.awt.Dimension(125, 22));
        add(lblNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 21, 240, 22));

        lblContent.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblContent.setForeground(new java.awt.Color(255, 255, 255));
        lblContent.setPreferredSize(new java.awt.Dimension(494, 19));
        add(lblContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 430, 30));

        lblTime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTime.setForeground(new java.awt.Color(125, 108, 108));
        lblTime.setText("4 giờ trước");
        add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 23, 100, 22));

        lblCountDislike.setForeground(new java.awt.Color(255, 255, 255));
        lblCountDislike.setText("4");
        lblCountDislike.setPreferredSize(new java.awt.Dimension(20, 20));
        add(lblCountDislike, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 40, -1));

        lblDislike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DislikeIcon.png"))); // NOI18N
        lblDislike.setPreferredSize(new java.awt.Dimension(20, 20));
        lblDislike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDislikeMouseClicked(evt);
            }
        });
        add(lblDislike, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        lblCountLike.setForeground(new java.awt.Color(255, 255, 255));
        lblCountLike.setText("10");
        lblCountLike.setPreferredSize(new java.awt.Dimension(20, 20));
        add(lblCountLike, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 40, -1));

        lblLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LikeIcon.png"))); // NOI18N
        lblLike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLikeMouseClicked(evt);
            }
        });
        add(lblLike, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        lblExpend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editCmt.png"))); // NOI18N
        lblExpend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExpendMouseClicked(evt);
            }
        });
        add(lblExpend, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void lblLikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLikeMouseClicked
        likeCheck = !likeCheck;
        CommentInteraction item = ciDao.selectByUser(Login.user.getUserID(), data.getCommentID());
        if (likeCheck == true && dislikeCheck == true) {
            dislikeCheck = !dislikeCheck;

            if (dislikeCheck) {
                lblDislike.setIcon(new ImageIcon(getClass().getResource("/img/DislikeIcon_Selected.png")));
                int likeCount = Integer.parseInt(lblCountDislike.getText());
                lblCountDislike.setText((likeCount + 1) + "");
            } else {
                lblDislike.setIcon(new ImageIcon(getClass().getResource("/img/DislikeIcon.png")));
                int likeCount = Integer.parseInt(lblCountDislike.getText());
                lblCountDislike.setText((likeCount - 1) + "");
            }

        }

        if (likeCheck) {
            lblLike.setIcon(new ImageIcon(getClass().getResource("/img/LikeIcon_Selected.png")));
            int likeCount = Integer.parseInt(lblCountLike.getText()) + 1;
            lblCountLike.setText((likeCount) + "");
            if (item == null) {
                ciDao.insert(new CommentInteraction(data.getCommentID(), Login.user.getUserID(), true, false));
            } else {
                item.setLiked(true);
                ciDao.update(item);
            }
        } else {
            lblLike.setIcon(new ImageIcon(getClass().getResource("/img/LikeIcon.png")));
            int likeCount = Integer.parseInt(lblCountLike.getText()) - 1;
            lblCountLike.setText((likeCount) + "");
            if (item != null) {
                ciDao.deleteByUser(Login.user.getUserID(), data.getCommentID());
            }

    }//GEN-LAST:event_lblLikeMouseClicked
        js.repaint();
        js.invalidate();
    }

    private void lblDislikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDislikeMouseClicked
        CommentInteraction item = ciDao.selectByUser(Login.user.getUserID(), data.getCommentID());
        dislikeCheck = !dislikeCheck;
        if (likeCheck == true && dislikeCheck == true) {
            likeCheck = !likeCheck;

            if (likeCheck) {
                lblLike.setIcon(new ImageIcon(getClass().getResource("/img/LikeIcon_Selected.png")));
                int likeCount = Integer.parseInt(lblCountLike.getText()) + 1;
                lblCountLike.setText((likeCount) + "");
            } else {
                lblLike.setIcon(new ImageIcon(getClass().getResource("/img/LikeIcon.png")));
                int likeCount = Integer.parseInt(lblCountLike.getText()) - 1;
                lblCountLike.setText((likeCount) + "");
            }

        }
        if (dislikeCheck) {
            lblDislike.setIcon(new ImageIcon(getClass().getResource("/img/DislikeIcon_Selected.png")));
            int likeCount = Integer.parseInt(lblCountDislike.getText());
            lblCountDislike.setText((likeCount + 1) + "");
            if (item == null) {
                ciDao.insert(new CommentInteraction(data.getCommentID(), Login.user.getUserID(), false, false));
            } else {
                item.setLiked(false);
                ciDao.update(item);
            }
        } else {
            lblDislike.setIcon(new ImageIcon(getClass().getResource("/img/DislikeIcon.png")));
            int likeCount = Integer.parseInt(lblCountDislike.getText());
            lblCountDislike.setText((likeCount - 1) + "");
            if (item != null) {
                ciDao.deleteByUser(Login.user.getUserID(), data.getCommentID());
            }
        }
        js.repaint();
        js.invalidate();
    }//GEN-LAST:event_lblDislikeMouseClicked

    private void lblExpendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExpendMouseClicked
        setOpen();
        childrenComment1.checkRole();
        childrenComment1.pane.repaint();
//        repaint();
    }//GEN-LAST:event_lblExpendMouseClicked

    public void setOpen() {
        open = !open;
        if (open) {
            childrenComment1.setVisible(open);
        } else {
            childrenComment1.setVisible(open);
        }
    }

    public void loadDataCommentIn() {
        CommentInteraction item = ciDao.selectByUser(Login.user.getUserID(), data.getCommentID());
        childrenComment1.comment = data;
        if (item != null) {
            likeCheck = item.isLiked();
            dislikeCheck = !item.isLiked();
            if (item.isLiked()) {
                lblDislike.setIcon(new ImageIcon(getClass().getResource("/img/DislikeIcon.png")));
                lblLike.setIcon(new ImageIcon(getClass().getResource("/img/LikeIcon_Selected.png")));
            } else {
                lblLike.setIcon(new ImageIcon(getClass().getResource("/img/LikeIcon.png")));
                lblDislike.setIcon(new ImageIcon(getClass().getResource("/img/DislikeIcon_Selected.png")));
            }
        }
    }

    public JLabel getLblExpend() {
        return lblExpend;
    }

    public childrenComment getChildrenComment1() {
        return childrenComment1;
    }

    public void setChildrenComment1(childrenComment childrenComment1) {
        this.childrenComment1 = childrenComment1;
    }

    public void loadData() {
        lblNameUser.setText(nameUser);
        lblContent.setText(Content);
        lblCountLike.setText(like + "");
        lblCountDislike.setText(dislike + "");
        long currentTimestamp = System.currentTimeMillis();
        long dateCommentTimestamp = data.getCommentDate().getTime();
        long difference = currentTimestamp - dateCommentTimestamp;
        long mm = difference / 60000;
        long hh = Math.round(mm / 60);
        System.out.println(currentTimestamp);
        System.out.println(data.getCommentDate());
        System.out.println(dateCommentTimestamp);
        System.out.println(mm);
        System.out.println(hh);
        if (mm >= 60) {
            lblTime.setText(hh + " giờ trước");
        } else {
            lblTime.setText(mm + " phút trước");
        }
        System.out.println(AVT);
        lblAVT.setBorder(a);
        lblAVT.setIcon(new ImageIcon("../Swave/src/img/avt/" + AVT));
        childrenComment1.setVisible(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.childrenComment childrenComment1;
    private model.borderImage lblAVT;
    private javax.swing.JLabel lblContent;
    private javax.swing.JLabel lblCountDislike;
    private javax.swing.JLabel lblCountLike;
    private javax.swing.JLabel lblDislike;
    private javax.swing.JLabel lblExpend;
    private javax.swing.JLabel lblLike;
    private javax.swing.JLabel lblNameUser;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
