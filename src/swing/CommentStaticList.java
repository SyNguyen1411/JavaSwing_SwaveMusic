/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package swing;

import Vu.ui.ReportCommentPanel;
import dao.CommentDAO;
import dao.ReportCommentDAO;
import entity.Comment;
import entity.ReportComment;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JPanel;
import utils.MsgBox;

/**
 *
 * @author NGUYEN VAN SI
 */
public class CommentStaticList extends javax.swing.JPanel {

    /**
     * Creates new form CommentStaticList
     */
    private CommentDAO cmDao = new CommentDAO();
    private ReportCommentDAO rpcmDao = new ReportCommentDAO();

    public CommentStaticList () {
        initComponents();
    }

    public void addCommentStatic (ReportComment data) {
        CommentStaticItem item = new CommentStaticItem(data);
        item.getBtnDelete().addMouseListener(new MouseListener() {
            private List<Comment> cmList;
            private List<ReportComment> rpcmList = rpcmDao.selectAll();

            @Override
            public void mouseClicked (MouseEvent e) {
                cmDao.delete(data.getCommentID());

//                for (ReportComment reportComment : rpcmList) {
//                    cmList.add(cmDao.selectById(reportComment.getCommentID()));
//                }
                if (ReportCommentPanel.index == 0) //                
                {
                    cmList = cmDao.selectAll();
                    loadLoadListAll(cmList);
                }
                else {
                    rpcmList = rpcmDao.selectAll();
                    loadLoadList(rpcmList);
                }

                MsgBox.alert(getParent(), "Xóa bình luận thành công");
                pnlCommentStaticList.repaint();

            }

            @Override
            public void mousePressed (MouseEvent e) {
            }

            @Override
            public void mouseReleased (MouseEvent e) {
            }

            @Override
            public void mouseEntered (MouseEvent e) {
            }

            @Override
            public void mouseExited (MouseEvent e) {
            }
        });
        pnlCommentStaticList.add(item);
        System.out.println(pnlCommentStaticList.getComponentCount());
        if (pnlCommentStaticList.getComponentCount() >= 5) {
            System.out.println("swing.CommentStaticList.addCommentStatic()");
            pnlCommentStaticList.setPreferredSize(new Dimension(955, pnlCommentStaticList.getHeight() + 93));
        }
        validate();
        pnlCommentStaticList.repaint();
        pnlCommentStaticList.revalidate();
    }

    public void addCommentStatic (Comment data) {
        CommentStaticItem item = new CommentStaticItem(data);
        item.getBtnDelete().addMouseListener(new MouseListener() {
            private List<Comment> cmList;
            private List<ReportComment> rpcmList = rpcmDao.selectAll();

            @Override
            public void mouseClicked (MouseEvent e) {
                cmDao.delete(data.getCommentID());

//                for (ReportComment reportComment : rpcmList) {
//                    cmList.add(cmDao.selectById(reportComment.getCommentID()));
//                }
                if (ReportCommentPanel.index == 0) //                
                {
                    cmList = cmDao.selectAll();
                    loadLoadListAll(cmList);
                }
                else {
                    rpcmList = rpcmDao.selectAll();
                    loadLoadList(rpcmList);
                }
                MsgBox.alert(getParent(), "Xóa bình luận thành công");
                pnlCommentStaticList.repaint();

            }

            @Override
            public void mousePressed (MouseEvent e) {
            }

            @Override
            public void mouseReleased (MouseEvent e) {
            }

            @Override
            public void mouseEntered (MouseEvent e) {
            }

            @Override
            public void mouseExited (MouseEvent e) {
            }
        });
        pnlCommentStaticList.add(item);
        System.out.println(pnlCommentStaticList.getComponentCount());
        if (pnlCommentStaticList.getComponentCount() >= 5) {
            System.out.println("swing.CommentStaticList.addCommentStatic()");
            pnlCommentStaticList.setPreferredSize(new Dimension(955, pnlCommentStaticList.getHeight() + 93));
        }
        validate();
        pnlCommentStaticList.repaint();
        pnlCommentStaticList.revalidate();
    }

    public void loadLoadList (List<ReportComment> list) {
        pnlCommentStaticList.removeAll();
        pnlCommentStaticList.setPreferredSize(new Dimension(955, 540));
        for (ReportComment comment : list) {
            addCommentStatic(comment);
        }
    }

    public void loadLoadListAll (List<Comment> list) {
        pnlCommentStaticList.removeAll();
        pnlCommentStaticList.setPreferredSize(new Dimension(955, 540));
        for (Comment comment : list) {
            addCommentStatic(comment);
        }
    }

    public JPanel getPnlCommentStaticList () {
        return pnlCommentStaticList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jscSongList = new javax.swing.JScrollPane();
        pnlCommentStaticList = new javax.swing.JPanel();
        scrollBar1 = new component.ScrollBar();

        setBackground(new java.awt.Color(0, 0, 0));

        jscSongList.setBackground(new java.awt.Color(0, 0, 0));
        jscSongList.setBorder(null);
        jscSongList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jscSongList.setHorizontalScrollBar(null);
        jscSongList.setOpaque(false);
        jscSongList.setPreferredSize(new java.awt.Dimension(955, 500));
        jscSongList.setVerticalScrollBar(scrollBar1);
        jscSongList.setViewportView(null);

        pnlCommentStaticList.setBackground(new java.awt.Color(0, 0, 0));
        pnlCommentStaticList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlCommentStaticList.setMinimumSize(new java.awt.Dimension(10, 0));
        pnlCommentStaticList.setOpaque(false);
        pnlCommentStaticList.setPreferredSize(new java.awt.Dimension(955, 540));
        pnlCommentStaticList.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        jscSongList.setViewportView(pnlCommentStaticList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jscSongList, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jscSongList, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jscSongList;
    private javax.swing.JPanel pnlCommentStaticList;
    private component.ScrollBar scrollBar1;
    // End of variables declaration//GEN-END:variables
}
