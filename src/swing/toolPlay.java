package swing;

import component.Slidebar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import entity.Song;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Port;
//import javax.sound.sampled.LineUnavailableException;
//import javax.sound.sampled.Mixer;
//import javax.sound.sampled.Port;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import swave.MainFrame;

/**
 *
 * @author NGUYEN VAN SI
 */
public class toolPlay extends javax.swing.JPanel {

    /**
     * Creates new form toolPlay
     */
    boolean running = false;
    boolean shuffle = false;
    boolean replay = false;
    boolean lyrics = false;
    boolean library = false;
    boolean comment = false;

    private Song data;
    public SongItem songItem;
    public MainFrame main;
    private File f;
    private FileInputStream fi;
    private BufferedInputStream bi;
    public Player player;
    private long totalTime;
    private long pause = -1;
    private long totalByte;
    Timer timeSongRunning;
    long time;

    private Runnable play = new Runnable() {
        @Override
        public void run() {
            f = new File(getClass().getResource(data.getFileSong()).getFile());
            try {
                System.out.println("Đang chạy nhạc");
                fi = new FileInputStream(f);
                bi = new BufferedInputStream(fi);
                player = new Player(bi);
                totalTime = fi.available();

                if (pause <= -1) {
                    player.play();
                } else {
                    fi.skip(totalTime - pause);
                    player.play();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(toolPlay.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JavaLayerException ex) {
                Logger.getLogger(toolPlay.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(toolPlay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    private Runnable resumeRun = new Runnable() {
        @Override
        public void run() {

        }
    };
    private int loading;
    private long timePause;

    public boolean isShuffle() {
        return shuffle;
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public boolean isLibrary() {
        return library;
    }

    public void setLibrary(boolean library) {
        this.library = library;
    }

    public Song getData() {
        return data;
    }

    public void setData(Song data) {
        this.data = data;
    }

    public JLabel getLblCmt() {
        return lblCmt;
    }

    public void setLblCmt(JLabel lblCmt) {
        this.lblCmt = lblCmt;
    }

    public JLabel getLblLibary() {
        return lblVolunm;
    }

    public void setLblLibary(JLabel lblLibary) {
        this.lblVolunm = lblLibary;
    }

    public JLabel getLblLibary1() {
        return lblLibary1;
    }

    public void setLblLibary1(JLabel lblLibary1) {
        this.lblLibary1 = lblLibary1;
    }

    public JLabel getLblLoveSong() {
        return lblLoveSong;
    }

    public void setLblLoveSong(JLabel lblLoveSong) {
        this.lblLoveSong = lblLoveSong;
    }

    public JLabel getLblLyrics() {
        return lblLyrics;
    }

    public void setLblLyrics(JLabel lblLyrics) {
        this.lblLyrics = lblLyrics;
    }

    public JLabel getLblNameSong() {
        return lblNameSong;
    }

    public void setLblNameSong(JLabel lblNameSong) {
        this.lblNameSong = lblNameSong;
    }

    public JLabel getLblNext() {
        return lblNext;
    }

    public void setLblNext(JLabel lblNext) {
        this.lblNext = lblNext;
    }

    public JLabel getLblPrev() {
        return lblPrev;
    }

    public void setLblPrev(JLabel lblPrev) {
        this.lblPrev = lblPrev;
    }

    public JLabel getLblRePlay() {
        return lblRePlay;
    }

    public void setLblRePlay(JLabel lblRePlay) {
        this.lblRePlay = lblRePlay;
    }

    public JLabel getLblRun() {
        return lblRun;
    }

    public void setLblRun(JLabel lblRun) {
        this.lblRun = lblRun;
    }

    public JLabel getLblShuffel() {
        return lblShuffel;
    }

    public void setLblShuffel(JLabel lblShuffel) {
        this.lblShuffel = lblShuffel;
    }

    public JLabel getLblSinger() {
        return lblSinger;
    }

    public void setLblSinger(JLabel lblSinger) {
        this.lblSinger = lblSinger;
    }

    public JLabel getLblTimeStart() {
        return lblTimeStart;
    }

    public void setLblTimeStart(JLabel lblTimeStart) {
        this.lblTimeStart = lblTimeStart;
    }

    public JLabel getLblTimeStart1() {
        return lblTimeStart1;
    }

    public void setLblTimeStart1(JLabel lblTimeStart1) {
        this.lblTimeStart1 = lblTimeStart1;
    }

    public JPanel getPnlItemPlay() {
        return pnlItemPlay;
    }

    public void setPnlItemPlay(JPanel pnlItemPlay) {
        this.pnlItemPlay = pnlItemPlay;
    }

    public toolPlay() {
        initComponents();
        setVolunm(slidebar2.getValue());
    }

    public long getPause() {
        return pause;
    }

    public void setPause(int pause) {
        this.pause = pause;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNameSong = new javax.swing.JLabel();
        lblSinger = new javax.swing.JLabel();
        lblLoveSong = new javax.swing.JLabel();
        lblCmt = new javax.swing.JLabel();
        lblTimeStart = new javax.swing.JLabel();
        lblTimeStart1 = new javax.swing.JLabel();
        pnlItemPlay = new javax.swing.JPanel();
        lblRePlay = new javax.swing.JLabel();
        lblNext = new javax.swing.JLabel();
        lblRun = new javax.swing.JLabel();
        lblPrev = new javax.swing.JLabel();
        lblShuffel = new javax.swing.JLabel();
        lblLyrics = new javax.swing.JLabel();
        lblVolunm = new javax.swing.JLabel();
        lblLibary1 = new javax.swing.JLabel();
        slMusic = new component.Slidebar();
        slidebar2 = new component.Slidebar();
        lblAVTSong = new components.borderImage();

        setBackground(new java.awt.Color(24, 24, 24));
        setPreferredSize(new java.awt.Dimension(1532, 150));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNameSong.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNameSong.setForeground(new java.awt.Color(255, 255, 255));
        lblNameSong.setText("Mây hồng đưa lối");
        lblNameSong.setPreferredSize(new java.awt.Dimension(130, 25));
        add(lblNameSong, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        lblSinger.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSinger.setForeground(new java.awt.Color(125, 125, 125));
        lblSinger.setText("Đạt Ka");
        lblSinger.setPreferredSize(new java.awt.Dimension(122, 18));
        add(lblSinger, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 81, -1, -1));

        lblLoveSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/timSongSelected.png"))); // NOI18N
        lblLoveSong.setPreferredSize(new java.awt.Dimension(25, 25));
        add(lblLoveSong, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 64, -1, -1));

        lblCmt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CommentIcon.png"))); // NOI18N
        lblCmt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCmtMouseClicked(evt);
            }
        });
        add(lblCmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 65, -1, -1));

        lblTimeStart.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTimeStart.setForeground(new java.awt.Color(125, 125, 125));
        lblTimeStart.setText("03:10");
        add(lblTimeStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 90, 40, -1));

        lblTimeStart1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTimeStart1.setForeground(new java.awt.Color(125, 125, 125));
        lblTimeStart1.setText("00:00");
        add(lblTimeStart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 92, 40, -1));

        pnlItemPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlItemPlay.setOpaque(false);
        pnlItemPlay.setPreferredSize(new java.awt.Dimension(368, 43));
        pnlItemPlay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRePlay.setForeground(new java.awt.Color(255, 255, 255));
        lblRePlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/autoPlay.png"))); // NOI18N
        lblRePlay.setPreferredSize(new java.awt.Dimension(19, 43));
        lblRePlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRePlayMouseClicked(evt);
            }
        });
        pnlItemPlay.add(lblRePlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 30, 40));

        lblNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Next.png"))); // NOI18N
        lblNext.setText("pre");
        lblNext.setMinimumSize(new java.awt.Dimension(19, 43));
        lblNext.setPreferredSize(new java.awt.Dimension(19, 43));
        pnlItemPlay.add(lblNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 4, 30, 40));

        lblRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/StopSong.png"))); // NOI18N
        lblRun.setText("jLabel2");
        lblRun.setMinimumSize(new java.awt.Dimension(43, 43));
        lblRun.setPreferredSize(new java.awt.Dimension(43, 43));
        lblRun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRunMouseClicked(evt);
            }
        });
        pnlItemPlay.add(lblRun, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 0, -1, -1));

        lblPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Prev.png"))); // NOI18N
        lblPrev.setText("pre");
        lblPrev.setPreferredSize(new java.awt.Dimension(19, 43));
        pnlItemPlay.add(lblPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 0, 30, 40));

        lblShuffel.setForeground(new java.awt.Color(255, 255, 255));
        lblShuffel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/replay.png"))); // NOI18N
        lblShuffel.setPreferredSize(new java.awt.Dimension(19, 43));
        lblShuffel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShuffelMouseClicked(evt);
            }
        });
        pnlItemPlay.add(lblShuffel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 30, 40));

        add(pnlItemPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 32, -1, -1));

        lblLyrics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lyrics.png"))); // NOI18N
        lblLyrics.setText("jLabel1");
        lblLyrics.setPreferredSize(new java.awt.Dimension(18, 19));
        lblLyrics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLyricsMouseClicked(evt);
            }
        });
        add(lblLyrics, new org.netbeans.lib.awtextra.AbsoluteConstraints(1306, 64, -1, -1));

        lblVolunm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/soundLow.png"))); // NOI18N
        lblVolunm.setPreferredSize(new java.awt.Dimension(20, 20));
        add(lblVolunm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1384, 65, 30, -1));

        lblLibary1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/liblary.png"))); // NOI18N
        lblLibary1.setPreferredSize(new java.awt.Dimension(20, 20));
        lblLibary1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLibary1MouseClicked(evt);
            }
        });
        add(lblLibary1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1346, 64, -1, -1));

        slMusic.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slMusicStateChanged(evt);
            }
        });
        slMusic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                slMusicMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                slMusicMouseReleased(evt);
            }
        });
        add(slMusic, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 95, 680, 10));

        slidebar2.setValue(50);
        slidebar2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidebar2StateChanged(evt);
            }
        });
        add(slidebar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 65, 90, -1));

        lblAVTSong.setSizeImage(new int[] {100, 100});
        add(lblAVTSong, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 25, 100, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void lblRunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRunMouseClicked
        running = !running;
        setRunning(running);
        if (running) {
            Thread runningSong = new Thread(play);
            runningSong.start();
            main.itemSong.setRunning(running);
            main.itemSong.getLblWave().setVisible(running);
            main.itemSong.getLblIconPlay().setVisible(!running);
            main.itemSong.getLblStart().setVisible(!running);
            main.itemSong.selectRunning(running);
        } else {
            try {
                pauseSong();
                main.itemSong.setRunning(running);
                main.itemSong.getLblWave().setVisible(running);
                main.itemSong.getLblStart().setVisible(!running);
            } catch (IOException ex) {
                Logger.getLogger(toolPlay.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(toolPlay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lblRunMouseClicked

    private void lblShuffelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShuffelMouseClicked
        shuffle = !shuffle;
        setShuffel(shuffle);
    }//GEN-LAST:event_lblShuffelMouseClicked

    private void lblRePlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRePlayMouseClicked
        replay = !replay;
        setReplay(replay);
    }//GEN-LAST:event_lblRePlayMouseClicked

    private void lblLibary1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLibary1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblLibary1MouseClicked

    private void lblLyricsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLyricsMouseClicked
        lyrics = !lyrics;
        setLyrics(lyrics);
        if (lyrics) {
            main.getPnlLyrics().show();
        } else {
            main.getPnlLyrics().hide();
        }
    }//GEN-LAST:event_lblLyricsMouseClicked

    private void lblCmtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCmtMouseClicked
        comment = !comment;
        setComment(comment);
        if (comment) {
            main.getPnlComment().setVisible(true);

        } else {
            main.getPnlComment().setVisible(false);

        }
    }//GEN-LAST:event_lblCmtMouseClicked

    private void slMusicStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slMusicStateChanged
        System.out.println(slMusic.getValue());
        loading = slMusic.getValue();
    }//GEN-LAST:event_slMusicStateChanged

    private void slMusicMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slMusicMousePressed

    }//GEN-LAST:event_slMusicMousePressed

    private void slMusicMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slMusicMouseReleased

        slMusic.setValue(loading);
        timePause = loading * time;
        System.out.println(timePause);
        try {
            fi.skip(timePause);
            pause = fi.available();
            player.close();
            Thread runningThread = new Thread(play);
            runningThread.start();
        } catch (IOException ex) {
            Logger.getLogger(toolPlay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_slMusicMouseReleased

    private void slidebar2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidebar2StateChanged
        setGain(slidebar2.getValue());
        System.out.println(slidebar2.getValue());
        setVolunm(slidebar2.getValue());
    }//GEN-LAST:event_slidebar2StateChanged

    public void setGain(float ctrl) {
        try {
            Mixer.Info[] infos = AudioSystem.getMixerInfo();
            for (Mixer.Info info : infos) {
                Mixer mixer = AudioSystem.getMixer(info);
                if (mixer.isLineSupported(Port.Info.SPEAKER)) {
                    Port port = (Port) mixer.getLine(Port.Info.SPEAKER);
                    port.open();
                    if (port.isControlSupported(FloatControl.Type.VOLUME)) {
                        FloatControl volume = (FloatControl) port.getControl(FloatControl.Type.VOLUME);
                        volume.setValue(ctrl / 100);
                    }
//                    port.close();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro\n" + e);
        }
    }

    public void setVolunm(int a) {
        if (a == 0) {
            lblVolunm.setIcon(new ImageIcon(getClass().getResource("/img/mute.png")));
        } else if (a > 0 && a <= 50) {
            lblVolunm.setIcon(new ImageIcon(getClass().getResource("/img/soundLow.png")));
        } else if (a > 50) {
            lblVolunm.setIcon(new ImageIcon(getClass().getResource("/img/volunmMax.png")));
        }
    }

    public void setRunning(boolean check) {
        this.running = check;
        if (check) {
            lblRun.setIcon(new ImageIcon(getClass().getResource("/img/playing.png")));
        } else {
            lblRun.setIcon(new ImageIcon(getClass().getResource("/img/stopSong.png")));
        }
    }

    public void setShuffel(boolean check) {
        if (check) {
            lblShuffel.setIcon(new ImageIcon(getClass().getResource("/img/shuffel_selected.png")));
        } else {
            lblShuffel.setIcon(new ImageIcon(getClass().getResource("/img/replay.png")));
        }
    }

    public void setReplay(boolean check) {
        if (check) {
            lblRePlay.setIcon(new ImageIcon(getClass().getResource("/img/replay_selected.png")));
        } else {
            lblRePlay.setIcon(new ImageIcon(getClass().getResource("/img/autoPlay.png")));
        }
    }

    public void setLyrics(boolean check) {
        if (check) {
            lblLyrics.setIcon(new ImageIcon(getClass().getResource("/img/LyricsIcon_selected.png")));
        } else {
            lblLyrics.setIcon(new ImageIcon(getClass().getResource("/img/lyrics.png")));
        }
    }

    public void setComment(boolean check) {
        if (check) {
            lblCmt.setIcon(new ImageIcon(getClass().getResource("/img/comment.png")));
        } else {
            lblCmt.setIcon(new ImageIcon(getClass().getResource("/img/CommentIcon.png")));
        }
    }

    public Slidebar getSlMusic() {
        return slMusic;
    }

    public void setSlMusic(Slidebar slMusic) {
        this.slMusic = slMusic;
    }

    public void fillData(Song data) {
        this.data = data;
        lblAVTSong.setIcon(new ImageIcon(getClass().getResource("/img/song/" + data.getAVT())));
        lblNameSong.setText(data.getNameSong());
        lblSinger.setText(data.getSinger());
        lblTimeStart.setText("0" + data.minutetotalLength + ":" + "0" + data.secondTotalLength);
        revalidate();
    }

    public void runningSong() {
        Thread runningThread = new Thread(play);
        timeSongRunning = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setRunningTime();
                } catch (IOException ex) {
                    Logger.getLogger(toolPlay.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(toolPlay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        runningThread.start();
        timeSongRunning.start();
    }

    public void setRunningTime() throws IOException, InterruptedException {
        System.out.println(totalTime / (songItem.minutetotalLength * 60 + songItem.secondTotalLength));
        time = totalTime / (songItem.minutetotalLength * 60 + songItem.secondTotalLength);
        try {
            pause = fi.available() / time;
            slMusic.setValue((int) (slMusic.getMaximum() - (int) pause));
            int minute = (slMusic.getMaximum() - (int) pause) / 60;
            int sec = (slMusic.getMaximum() - (int) pause) % 60;
            if (sec >= 10) {
                lblTimeStart1.setText("0" + minute + ":" + sec);
            } else {
                lblTimeStart1.setText("0" + minute + ":" + "0" + sec);
            }
        } catch (IOException ex) {
            System.out.println("Kết thúc bài hát");
        }
    }

    public void pauseSong() throws IOException, InterruptedException {
        pause = fi.available();
        player.close();
    }

    public void stopSong() throws IOException {
        totalTime = 0;
        pause = -1;
        player.close();
    }

    public void resume() throws IOException, JavaLayerException {
        fi.skip(totalTime - pause);
        player.play();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.borderImage lblAVTSong;
    private javax.swing.JLabel lblCmt;
    private javax.swing.JLabel lblLibary1;
    private javax.swing.JLabel lblLoveSong;
    private javax.swing.JLabel lblLyrics;
    private javax.swing.JLabel lblNameSong;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblPrev;
    private javax.swing.JLabel lblRePlay;
    private javax.swing.JLabel lblRun;
    private javax.swing.JLabel lblShuffel;
    private javax.swing.JLabel lblSinger;
    private javax.swing.JLabel lblTimeStart;
    private javax.swing.JLabel lblTimeStart1;
    private javax.swing.JLabel lblVolunm;
    private javax.swing.JPanel pnlItemPlay;
    private component.Slidebar slMusic;
    private component.Slidebar slidebar2;
    // End of variables declaration//GEN-END:variables
}
