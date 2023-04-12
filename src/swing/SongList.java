package swing;

import component.EventItem;
import entity.Song;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author NGUYEN VAN SI
 */
public class SongList extends javax.swing.JPanel {

    /**
     * Creates new form Playlist
     */
    private EventItem event;
    private EventItem eventLblStart;
    private ArrayList<Song> songLoveList;
    private SongItem runningSong;

    public ArrayList<Song> getSongLoveList() {
        return songLoveList;
    }

    public void setSongLoveList(ArrayList<Song> songLoveList) {
        this.songLoveList = songLoveList;
    }

    public void setEvent(EventItem event) {
        this.event = event;
    }

    public void setEventLblStart(EventItem eventPlay) {
        this.eventLblStart = eventPlay;
    }

    public SongList() {
        initComponents();
        repaint();
        jscSongList.getViewport().setBackground(new Color(255, 255, 255, 0));
        new Thread(running).start();
        if (pnlSongList.getComponentCount() == 0) {
            pnlSongList.setPreferredSize(new Dimension(1073, 0));
        }
    }

    public void addSong(Song data, List<Song> list) throws UnsupportedAudioFileException, IOException, URISyntaxException {
        SongItem item = new SongItem();

        item.listSong = list;
        item.setDataSong(data);
        item.getLblStart().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventLblStart.clickEvent(item, data);
            }
        });

        pnlSongList.add(item);
        System.out.println(pnlSongList.getComponentCount());
        if (pnlSongList.getComponentCount() > 3) {
            pnlSongList.setPreferredSize(new Dimension(1073, pnlSongList.getHeight() + 70));
        }

        validate();
        pnlSongList.repaint();
        pnlSongList.revalidate();
    }

    public void addSong(Song data) throws UnsupportedAudioFileException, IOException, URISyntaxException {
        SongItem item = new SongItem();
        item.setDataSong(data);
        item.getLblStart().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventLblStart.clickEvent(item, data);
            }
        });

        pnlSongList.add(item);
        System.out.println(pnlSongList.getComponentCount());
        if (pnlSongList.getComponentCount() > 3) {
            pnlSongList.setPreferredSize(new Dimension(1073, pnlSongList.getHeight() + 70));
        }

        validate();
        pnlSongList.repaint();
        pnlSongList.revalidate();
    }

    public void setSongLove(ArrayList<Song> songLoveList) {
        for (Component com : pnlSongList.getComponents()) {
            SongItem item = (SongItem) com;
            item.listSong = songLoveList;
            if (songLoveList.size() == 0) {
                item.getLblIconLove().setIcon(new ImageIcon(getClass().getResource("/img/timIcon.png")));
            }
            for (Song song : songLoveList) {
                int songLoveId = song.getSongID();
                if (item.getData().getSongID() == songLoveId) {
                    item.getLblIconLove().setIcon(new ImageIcon(getClass().getResource("/img/timSongSelected.png")));
                    break;
                } else {
                    item.getLblIconLove().setIcon(new ImageIcon(getClass().getResource("/img/timIcon.png")));
                }
            }
        }
        repaint();

    }

    public void setRunningSong(Component item) {
        if (((SongItem) item).equals(runningSong)) {
            return;
        }
        for (Component com : pnlSongList.getComponents()) {
            SongItem s = (SongItem) com;
            if (s.isRunning()) {
                s.setRunning(false);
                s.getLblWave().setVisible(false);
                s.getLblIconPlay().setVisible(true);
                s.setBackground(new Color(255, 255, 255, 0));
            }
        }

        ((SongItem) item).setRunning(true);
        runningSong = ((SongItem) item);
    }

    public JScrollPane getJscSongList() {
        return jscSongList;
    }

    public void setJscSongList(JScrollPane jscSongList) {
        this.jscSongList = jscSongList;
    }

    public JPanel getPnlSongList() {
        return pnlSongList;
    }

    public void setPnlSongList(JPanel pnlSongList) {
        this.pnlSongList = pnlSongList;
    }

    Runnable running = new Runnable() {
        @Override
        public void run() {
            while (true) {
                jscSongList.repaint();
            }

        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jscSongList = new javax.swing.JScrollPane();
        pnlSongList = new javax.swing.JPanel();
        scrollBar1 = new component.ScrollBar();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1273, 310));

        jscSongList.setBackground(new java.awt.Color(255, 255, 255));
        jscSongList.setBorder(null);
        jscSongList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jscSongList.setHorizontalScrollBar(null);
        jscSongList.setPreferredSize(new java.awt.Dimension(1073, 100));
        jscSongList.setVerticalScrollBar(scrollBar1);
        jscSongList.setViewportView(null);

        pnlSongList.setBackground(new java.awt.Color(255, 255, 255));
        pnlSongList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlSongList.setMinimumSize(new java.awt.Dimension(10, 0));
        pnlSongList.setOpaque(false);
        pnlSongList.setPreferredSize(new java.awt.Dimension(1073, 100));
        pnlSongList.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        jscSongList.setViewportView(pnlSongList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jscSongList, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jscSongList, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            .addComponent(scrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jscSongList;
    private javax.swing.JPanel pnlSongList;
    private component.ScrollBar scrollBar1;
    // End of variables declaration//GEN-END:variables

}
