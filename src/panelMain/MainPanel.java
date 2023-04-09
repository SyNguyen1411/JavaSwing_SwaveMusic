/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panelMain;

import component.EventItem;
import entity.PlayList;
import entity.Song;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import swave.MainFrame;
import swing.MainWindowItem;
import swing.PlaylistPanel;
import swing.SongList;
import swing.utilcomponent.ScrollBarCustom;

/**
 *
 * @author Admin
 */
public class MainPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainPanel
     */
    // những biến dùng tạm
    ArrayList<PlayList> dailyPlayLists = new ArrayList<>();
    ArrayList<PlayList> weeklyPlayLists = new ArrayList<>();
    ArrayList<PlayList> monthlyPlayLists = new ArrayList<>();

    private CardLayout cardLayout;
    private CardLayout cardLPlaylistLayout;
    public MainFrame main;
    private EventItem eventItem;

    public EventItem getEventItem() {
        return eventItem;
    }

    public void setEventItem(EventItem eventItem) {
        this.eventItem = eventItem;
    }

    
    
//    private MouseEvent dayMouseEvent;
//    private MouseEvent weekMouseEvent;
//    private MouseEvent monthMouseEvent;
    public CardLayout getCardLPlaylistLayout() {
        return cardLPlaylistLayout;
    }

    public void setCardLPlaylistLayout(CardLayout cardLPlaylistLayout) {
        this.cardLPlaylistLayout = cardLPlaylistLayout;
    }

    public PlaylistPanel getPnlPlaylist() {
        return pnlPlaylistDaily;
    }

    public void setPnlPlaylist(PlaylistPanel pnlPlaylist) {
        this.pnlPlaylistDaily = pnlPlaylist;
    }

    public SongList getPnlTrendingSongList() {
        return pnlTrendingSongList;
    }

    public void setPnlTrendingSongList(SongList pnlTrendingSongList) {
        this.pnlTrendingSongList = pnlTrendingSongList;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }
    
    

    public MainPanel() {
        initComponents();
        // Biến dùng tạm
        for (int i = 0; i < 100; i++) {
            dailyPlayLists.add(new PlayList(i, "LOFI LOVE " + i, i, true, "TK-06.jpg"));
            weeklyPlayLists.add(new PlayList(i, "LOFI LOVE " + i, i, true, "TK-06.jpg"));
            monthlyPlayLists.add(new PlayList(i, "LOFI LOVE " + i, i, true, "TK-06.jpg"));
        }

        cardLayout = (CardLayout) this.getLayout();
        cardLPlaylistLayout = (CardLayout) pnlPlaylist.getLayout();

        init();

    }

    private void init() {
        this.setOpaque(false);
        this.setBackground(new Color(0, 0, 0, 255));
        cardLayout.first(this);
        cardLPlaylistLayout.first(pnlPlaylist);
        initPnlMainWindow();
        initPnlTrendingSong();
        initPnlTopPlaylist();

    }

    private void initPnlMainWindow() {
        pnlMainWindow.setOpaque(false);
        pnlMainWindow.setBackground(new Color(0, 0, 0, 255));

        jPanel1.setOpaque(false);
        jPanel1.setBackground(new Color(0, 0, 0, 255));

        // set height của scroll pane 
        scrPaneDemoTrending.setPreferredSize(new Dimension(1200, 210));
        ScrollBarCustom scrollBarCustom1 = new ScrollBarCustom();
        scrollBarCustom1.setOrientation(0);
        scrPaneDemoTrending.setHorizontalScrollBar(scrollBarCustom1);
        scrPaneDemoTrending.setViewportView(pnlDemoTrending);
        scrPaneDemoTrending.setOpaque(true);
        scrPaneDemoTrending.setBackground(new Color(0, 0, 0, 255));

        // set height của scroll pane 
        scrPaneDemoTopPlaylist.setPreferredSize(new Dimension(1200, 210));
        ScrollBarCustom scrollBarCustom2 = new ScrollBarCustom();
        scrollBarCustom2.setOrientation(0);
        scrPaneDemoTopPlaylist.setHorizontalScrollBar(scrollBarCustom2);
        scrPaneDemoTopPlaylist.setViewportView(pnlDemoTopPlaylist);
        scrPaneDemoTopPlaylist.setOpaque(true);
        scrPaneDemoTopPlaylist.setBackground(new Color(0, 0, 0, 255));

        lblMainWindowTitle.setFont(new Font("Inter", Font.BOLD, 30));
        lblMainWindowTitle.setForeground(Color.white);

        lblMainWindowTrending.setFont(new Font("Inter", Font.BOLD, 16));
        lblMainWindowTrending.setForeground(Color.white);

        lblMainWindowTopPlaylist.setFont(new Font("Inter", Font.BOLD, 16));
        lblMainWindowTopPlaylist.setForeground(Color.white);

        lblMainWindowTopPlaylist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(pnlMainWindow.getParent(), "cardTopPlaylist");
                fillTopPlaylistDaily();
                cardLPlaylistLayout.show(pnlPlaylist, "cardDailyPlaylist");
                lblDay.setForeground(new Color(165, 43, 168));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblMainWindowTopPlaylist.setForeground(new Color(165, 43, 168));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                lblMainWindowTopPlaylist.setForeground(Color.white);
            }
        });

        lblMainWindowTrending.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(pnlMainWindow.getParent(), "cardTrending");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblMainWindowTrending.setForeground(new Color(165, 43, 168));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                lblMainWindowTrending.setForeground(Color.white);
            }

        });
        repaint();
    }

    public void addTrendingSong(Song song) {
        int positionDemo = pnlDemoTrending.getComponentCount();

        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.gridx = positionDemo;
        gridBagConstraints.gridy = 0;
        addSongToTrendingSong(song, gridBagConstraints);

        // 4 dòng dưới để khiến cho panel có height của các components nằm bên trong
        pnlDemoTrending.setPreferredSize(null);
        pnlDemoTrending.setMaximumSize(new Dimension(pnlDemoTrending.getPreferredSize().width, 200));
        pnlDemoTrending.validate();
        pnlDemoTrending.repaint();

        pnlDemoTrending.setOpaque(true);
        pnlDemoTrending.setBackground(new Color(0, 0, 0, 255));

        btnPlay.setIcon(new ImageIcon(getClass().getResource("/icons/components/btnPlay.png")));

        revalidate();
    }

    public void addSongToTrendingSong(Song song, GridBagConstraints gridBagConstraints) {
        MainWindowItem songItem = new MainWindowItem(song);
        songItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventItem.clickEvent(pnlDemoTrending, song);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                songItem.getLblTitle().setForeground(new Color(165, 43, 168));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                songItem.getLblTitle().setForeground(Color.white);
            }

        });

        pnlDemoTrending.add(songItem, gridBagConstraints);

    }

    public void addTopPlaylist(PlayList playlist) {
        int position = pnlDemoTopPlaylist.getComponentCount();

        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.gridx = position;
        gridBagConstraints.gridy = 0;
        addPlaylistToTopPlaylist(playlist, gridBagConstraints);

        // 4 dòng dưới để khiến cho panel có height của các components nằm bên trong
        pnlDemoTopPlaylist.setPreferredSize(null);
        pnlDemoTopPlaylist.setMaximumSize(new Dimension(pnlDemoTopPlaylist.getPreferredSize().width, 200));
        pnlDemoTopPlaylist.validate();
        pnlDemoTopPlaylist.repaint();

        pnlDemoTopPlaylist.setOpaque(true);
        pnlDemoTopPlaylist.setBackground(new Color(0, 0, 0, 255));

        revalidate();
    }

    public void addPlaylistToTopPlaylist(PlayList playlist, GridBagConstraints gridBagConstraints) {
        MainWindowItem playlistItem = new MainWindowItem(playlist);
        playlistItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //eventLblEditSong.clickEvent(listSongItemAddSongPanel, song);
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                playlistItem.getLblTitle().setForeground(new Color(165, 43, 168));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                playlistItem.getLblTitle().setForeground(Color.white);
            }

        });
        pnlDemoTopPlaylist.add(playlistItem, gridBagConstraints);
    }

    private void initPnlTrendingSong() {
        pnlTrendingSong.setOpaque(false);
        pnlTrendingSong.setBackground(new Color(0, 0, 0, 255));

        pnlTrendingSongInfo.setOpaque(false);
        pnlTrendingSongInfo.setBackground(new Color(0, 0, 0, 255));

        lblTrendingTitle.setFont(new Font("Inter", Font.BOLD, 30));
        lblTrendingTitle.setForeground(Color.white);

        lblLike.setFont(new Font("Inter", Font.BOLD, 20));
        lblLike.setForeground(Color.white);

        lblPosition.setFont(new Font("Inter", Font.BOLD, 20));
        lblPosition.setForeground(Color.white);

        lblSongName.setFont(new Font("Inter", Font.BOLD, 20));
        lblSongName.setForeground(Color.white);

        lblDuration.setFont(new Font("Inter", Font.BOLD, 20));
        lblDuration.setForeground(Color.white);

    }

    private void initPnlTopPlaylist() {
        pnlTopPlaylist.setOpaque(false);
        pnlTopPlaylist.setBackground(new Color(0, 0, 0, 255));

        pnlTopPlaylistMenu.setOpaque(false);
        pnlTopPlaylistMenu.setBackground(new Color(0, 0, 0, 255));

        pnlPlaylist.setOpaque(false);
        pnlPlaylist.setBackground(new Color(0, 0, 0, 255));

        lblTopPlaylistTitle.setFont(new Font("Inter", Font.BOLD, 30));
        lblTopPlaylistTitle.setForeground(Color.white);

        lblDay.setFont(new Font("Inter", Font.BOLD, 20));
        lblDay.setForeground(Color.white);

        lblMonth.setFont(new Font("Inter", Font.BOLD, 20));
        lblMonth.setForeground(Color.white);

        lblWeek.setFont(new Font("Inter", Font.BOLD, 20));
        lblWeek.setForeground(Color.white);

        lblDay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!lblDay.getForeground().equals(new Color(165, 43, 168))) {
                    lblDay.setForeground(new Color(165, 43, 168));
                    lblMonth.setForeground(Color.white);
                    lblWeek.setForeground(Color.white);
                    cardLPlaylistLayout.show(pnlPlaylist, "cardDailyPanel");
                    fillTopPlaylistDaily();
                }
                revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

        });

        lblWeek.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!lblWeek.getForeground().equals(new Color(165, 43, 168))) {
                    lblWeek.setForeground(new Color(165, 43, 168));
                    lblMonth.setForeground(Color.white);
                    lblDay.setForeground(Color.white);
                    cardLPlaylistLayout.show(pnlPlaylist, "cardWeeklyPanel");
                    fillTopPlaylistWeekly();
                }
                revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

        });

        lblMonth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!lblMonth.getForeground().equals(new Color(165, 43, 168))) {
                    lblMonth.setForeground(new Color(165, 43, 168));
                    lblDay.setForeground(Color.white);
                    lblWeek.setForeground(Color.white);
                    cardLPlaylistLayout.show(pnlPlaylist, "cardMonthlyPanel");
                    fillTopPlaylistMonthly();
                }
                revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

        });
    }

    public void fillTopPlaylistDaily() {
        for (PlayList dailyPlayList : dailyPlayLists) {
            pnlPlaylistDaily.addPlayList(dailyPlayList, main);
        }
        revalidate();
    }

    public void fillTopPlaylistWeekly() {
        for (PlayList weeklyPlayList : weeklyPlayLists) {
            pnlPlaylistWeekly.addPlayList(weeklyPlayList, main);
        }
        revalidate();
    }

    public void fillTopPlaylistMonthly() {
        for (PlayList monthlyPlayList : monthlyPlayLists) {
            pnlPlaylistMonthly.addPlayList(monthlyPlayList, main);
        }
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainWindow = new javax.swing.JPanel();
        lblMainWindowTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblMainWindowTrending = new javax.swing.JLabel();
        lblMainWindowTopPlaylist = new javax.swing.JLabel();
        scrPaneDemoTrending = new javax.swing.JScrollPane();
        pnlDemoTrending = new javax.swing.JPanel();
        scrPaneDemoTopPlaylist = new javax.swing.JScrollPane();
        pnlDemoTopPlaylist = new javax.swing.JPanel();
        pnlTopPlaylist = new javax.swing.JPanel();
        lblTopPlaylistTitle = new javax.swing.JLabel();
        pnlTopPlaylistMenu = new javax.swing.JPanel();
        lblDay = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblWeek = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblMonth = new javax.swing.JLabel();
        pnlPlaylist = new javax.swing.JPanel();
        pnlPlaylistDaily = new swing.PlaylistPanel();
        pnlPlaylistWeekly = new swing.PlaylistPanel();
        pnlPlaylistMonthly = new swing.PlaylistPanel();
        pnlTrendingSong = new javax.swing.JPanel();
        lblTrendingTitle = new javax.swing.JLabel();
        btnPlay = new swing.utilcomponent.Button();
        pnlTrendingSongInfo = new javax.swing.JPanel();
        lblPosition = new javax.swing.JLabel();
        lblSongName = new javax.swing.JLabel();
        lblLike = new javax.swing.JLabel();
        lblDuration = new javax.swing.JLabel();
        pnlTrendingSongList = new swing.SongList();

        setMaximumSize(new java.awt.Dimension(1284, 555));
        setMinimumSize(new java.awt.Dimension(1284, 555));
        setPreferredSize(new java.awt.Dimension(1284, 555));
        setLayout(new java.awt.CardLayout());

        pnlMainWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMainWindowTitle.setText("Khám phá Swave");
        lblMainWindowTitle.setMaximumSize(new java.awt.Dimension(300, 36));
        lblMainWindowTitle.setMinimumSize(new java.awt.Dimension(300, 36));
        lblMainWindowTitle.setPreferredSize(new java.awt.Dimension(300, 36));
        pnlMainWindow.add(lblMainWindowTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        lblMainWindowTrending.setText("Trending");

        lblMainWindowTopPlaylist.setText("100 Playlist được yêu thích nhất");

        scrPaneDemoTrending.setBorder(null);
        scrPaneDemoTrending.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnlDemoTrending.setMaximumSize(new java.awt.Dimension(32767, 200));
        pnlDemoTrending.setMinimumSize(new java.awt.Dimension(1200, 200));
        pnlDemoTrending.setPreferredSize(new java.awt.Dimension(1200, 200));
        pnlDemoTrending.setLayout(new java.awt.GridBagLayout());
        scrPaneDemoTrending.setViewportView(pnlDemoTrending);

        scrPaneDemoTopPlaylist.setBorder(null);
        scrPaneDemoTopPlaylist.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnlDemoTopPlaylist.setMaximumSize(new java.awt.Dimension(32767, 200));
        pnlDemoTopPlaylist.setMinimumSize(new java.awt.Dimension(1200, 200));
        pnlDemoTopPlaylist.setPreferredSize(new java.awt.Dimension(1200, 200));
        pnlDemoTopPlaylist.setLayout(new java.awt.GridBagLayout());
        scrPaneDemoTopPlaylist.setViewportView(pnlDemoTopPlaylist);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMainWindowTrending)
                    .addComponent(lblMainWindowTopPlaylist)
                    .addComponent(scrPaneDemoTrending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrPaneDemoTopPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblMainWindowTrending)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrPaneDemoTrending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMainWindowTopPlaylist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrPaneDemoTopPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pnlMainWindow.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1240, 490));

        add(pnlMainWindow, "cardMain");

        pnlTopPlaylist.setMaximumSize(new java.awt.Dimension(1284, 540));
        pnlTopPlaylist.setMinimumSize(new java.awt.Dimension(1284, 540));
        pnlTopPlaylist.setPreferredSize(new java.awt.Dimension(1284, 540));
        pnlTopPlaylist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTopPlaylistTitle.setText("Top 100 Playlist Yêu Thích");
        pnlTopPlaylist.add(lblTopPlaylistTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 6, -1, -1));

        pnlTopPlaylistMenu.setBackground(new java.awt.Color(204, 153, 0));
        pnlTopPlaylistMenu.setMaximumSize(new java.awt.Dimension(300, 41));
        pnlTopPlaylistMenu.setMinimumSize(new java.awt.Dimension(300, 41));
        pnlTopPlaylistMenu.setPreferredSize(new java.awt.Dimension(300, 41));
        pnlTopPlaylistMenu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        lblDay.setText("Ngày");
        pnlTopPlaylistMenu.add(lblDay);

        jSeparator1.setBackground(new java.awt.Color(199, 199, 199));
        jSeparator1.setForeground(new java.awt.Color(199, 199, 199));
        jSeparator1.setMaximumSize(new java.awt.Dimension(1, 16));
        jSeparator1.setMinimumSize(new java.awt.Dimension(1, 16));
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(1, 16));
        pnlTopPlaylistMenu.add(jSeparator1);

        lblWeek.setText("Tuần");
        pnlTopPlaylistMenu.add(lblWeek);

        jSeparator2.setBackground(new java.awt.Color(199, 199, 199));
        jSeparator2.setForeground(new java.awt.Color(199, 199, 199));
        jSeparator2.setMaximumSize(new java.awt.Dimension(1, 16));
        jSeparator2.setMinimumSize(new java.awt.Dimension(1, 16));
        jSeparator2.setOpaque(true);
        jSeparator2.setPreferredSize(new java.awt.Dimension(1, 16));
        pnlTopPlaylistMenu.add(jSeparator2);

        lblMonth.setText("Tháng");
        pnlTopPlaylistMenu.add(lblMonth);

        pnlTopPlaylist.add(pnlTopPlaylistMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, -1, -1));

        pnlPlaylist.setLayout(new java.awt.CardLayout());
        pnlPlaylist.add(pnlPlaylistDaily, "cardDailyPlaylist");
        pnlPlaylist.add(pnlPlaylistWeekly, "cardWeeklyPlaylist");
        pnlPlaylist.add(pnlPlaylistMonthly, "cardMonthlyPlaylist");

        pnlTopPlaylist.add(pnlPlaylist, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        add(pnlTopPlaylist, "cardTopPlaylist");

        pnlTrendingSong.setMaximumSize(new java.awt.Dimension(1270, 540));
        pnlTrendingSong.setMinimumSize(new java.awt.Dimension(1270, 540));
        pnlTrendingSong.setPreferredSize(new java.awt.Dimension(1270, 540));
        pnlTrendingSong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTrendingTitle.setText("Trending");
        pnlTrendingSong.add(lblTrendingTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 6, -1, -1));

        btnPlay.setColor1(new java.awt.Color(0, 0, 0));
        btnPlay.setColor2(new java.awt.Color(0, 0, 0));
        btnPlay.setMaximumSize(new java.awt.Dimension(45, 45));
        btnPlay.setMinimumSize(new java.awt.Dimension(45, 45));
        btnPlay.setPreferredSize(new java.awt.Dimension(45, 45));
        btnPlay.setRadious(new int[] {50, 50});
        pnlTrendingSong.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 50, 50));

        pnlTrendingSongInfo.setMaximumSize(new java.awt.Dimension(1200, 100));
        pnlTrendingSongInfo.setMinimumSize(new java.awt.Dimension(1200, 100));
        pnlTrendingSongInfo.setPreferredSize(new java.awt.Dimension(1200, 100));
        pnlTrendingSongInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPosition.setText("STT");
        pnlTrendingSongInfo.add(lblPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        lblSongName.setText("Tên bài hát");
        pnlTrendingSongInfo.add(lblSongName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        lblLike.setText("Tim");
        pnlTrendingSongInfo.add(lblLike, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        lblDuration.setText("Thời gian");
        pnlTrendingSongInfo.add(lblDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, -1, -1));

        pnlTrendingSong.add(pnlTrendingSongInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        pnlTrendingSong.add(pnlTrendingSongList, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 1100, -1));

        add(pnlTrendingSong, "cardTrending");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.utilcomponent.Button btnPlay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblLike;
    private javax.swing.JLabel lblMainWindowTitle;
    private javax.swing.JLabel lblMainWindowTopPlaylist;
    private javax.swing.JLabel lblMainWindowTrending;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblSongName;
    private javax.swing.JLabel lblTopPlaylistTitle;
    private javax.swing.JLabel lblTrendingTitle;
    private javax.swing.JLabel lblWeek;
    private javax.swing.JPanel pnlDemoTopPlaylist;
    private javax.swing.JPanel pnlDemoTrending;
    private javax.swing.JPanel pnlMainWindow;
    private javax.swing.JPanel pnlPlaylist;
    private swing.PlaylistPanel pnlPlaylistDaily;
    private swing.PlaylistPanel pnlPlaylistMonthly;
    private swing.PlaylistPanel pnlPlaylistWeekly;
    private javax.swing.JPanel pnlTopPlaylist;
    private javax.swing.JPanel pnlTopPlaylistMenu;
    private javax.swing.JPanel pnlTrendingSong;
    private javax.swing.JPanel pnlTrendingSongInfo;
    private swing.SongList pnlTrendingSongList;
    private javax.swing.JScrollPane scrPaneDemoTopPlaylist;
    private javax.swing.JScrollPane scrPaneDemoTrending;
    // End of variables declaration//GEN-END:variables
}
