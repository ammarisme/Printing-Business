/*
 * copyright Ammar Bin Ameerdeen
 * All rights reserved
 */
package printare_system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

/**
 * @author Ammar Bin Ameerdeen
 * 
 * The Theme file for the whole App. A class that serves as a helper to manipulate "Universal" UI characteristics.
 * 
 * Contains - All the colors used throughout the software
 *          - Some of the location Points
 * 
 * TODO : Put all the panel Location and Dimensions
 */
public class Theme {
    // Constants that are used throught the Application
    public static final Color BUTTON_COLOR       = new Color(244,246,244); // 244,246,244
    public static final Color MAIN_AREA_COLOR    = new Color(211,222,209);
    public static final Color MAIN_BOXES_COLOR   = new Color(242,241,240);
    public static final Color BACKGROUND_COLOR   = new Color(188,197,190);
    public static final Color CENTER_BOX_COLOR   = new Color(60,75,61);
    public static final Font TITLE_FONT          = new java.awt.Font("FreeMono", 1, 48); 
    public static final Color TITLE_FONT_COLOR   = new java.awt.Color(0, 0, 0) ;
    public static final Point TITLE_LOCATION     = new Point(40,25);
    public static final Color INACTIVE_TEXT_BOX_COLOR = new Color(226,230,221);
    public static final Color SALE_ACTIVE = new Color (254,198,111);
    public static final Color SALE_INACTIVE = new Color (237,227,211);
    public static final Color FONT_COLOR = Color.WHITE;
    
    
    // Constants that belongs to Notification feature.
    public static final Point NOTIFICATION_LOCATION = new Point(750, 10);
    public static final Dimension NOTIFICATIONS_PANEL_MIN_SIZE = new Dimension(60,60);
    public static final Color NOTIFICATIONS_PANEL_COLOR = new Color(250,136,133);
    public static final Color NO_NOTIFICATIONS_PANEL_COLOR = new Color(BACKGROUND_COLOR.getRed()-10,BACKGROUND_COLOR.getGreen()-10,BACKGROUND_COLOR.getBlue()-10);
    public static final Color NOTIFICATIONS_ITEM_COLOR = BACKGROUND_COLOR;
    public static final Dimension NOTIFICATION_ITEM_SIZE_DEFAULT  = new Dimension(350,60);
    public static final Dimension NOTIFICATION_ICON_SIZE_DEFAULT = new Dimension(60,60);
    public static final Font NOTIFICATION_FONT          = new java.awt.Font("FreeMono", 1, 16); 
    public static final String NO_NOTIFICATIONS_TEXT = "No notifications!";
    public static final Font NUMBER_OF_NOTIFICATION_FONT   =new java.awt.Font("Ubuntu", 1, 18);
    public final int NOTIFICATION_HEIGHT_MAX = 800; // pretty much unused
    public final int NOTIFICATION_WIDTH_MAX = 600; // pretty much unused
    
    // The Menu bar - TODO : Put this somewhere else, Here also ok. But its odd.
    public javax.swing.JMenuBar menuBar;
    public javax.swing.JMenuItem menuCardReloadSale;
    public javax.swing.JMenu menuCompany;
    public javax.swing.JMenu menuCustomers;
    public javax.swing.JMenuItem menuGRN;
    public javax.swing.JMenuItem menuManageCardsReloads;
    public javax.swing.JMenuItem menuManageCustomers;
    public javax.swing.JMenuItem menuManagePrintOrders;
    public javax.swing.JMenuItem menuManageProducts;
    public javax.swing.JMenuItem menuManageProjects;
    public javax.swing.JMenuItem menuManageServices;
    public javax.swing.JMenuItem menuNewPrintOrders;
    public javax.swing.JMenu menuOrders;
    public javax.swing.JMenu menuPrintOrders;
    public javax.swing.JMenuItem menuProductSale;
    public javax.swing.JMenu menuProducts;
    public javax.swing.JMenu menuProjects;
    public javax.swing.JMenu menuSale;
    public javax.swing.JMenuItem menuServiceSales;
    public javax.swing.JMenu menuServices;
    public javax.swing.JMenuItem menuUtitlityBills;
    public javax.swing.JMenu menuAllSale;
    public javax.swing.JMenuItem anySale;
    
    // The frame. Use this to maniputation of the caller.
    public IMSFrame frame;
    
    public Theme(){
     // Well the set theme function can be called within this.? But needs refactoring all the childrens of IMSFrame    
    }
    
    /**
     * Setting the UI characteristics of the caller
    */
    public void setTheme(IMSFrame frame){
        this.frame = frame;  // saving an instance for later use.
        
        // basic UI
        frame.backgroundPanel.setBackground(BACKGROUND_COLOR);
        frame.centerPanel.setBackground(CENTER_BOX_COLOR);
        frame.title.setFont(TITLE_FONT);
        frame.title.setForeground(TITLE_FONT_COLOR);
        frame.title.setLocation(TITLE_LOCATION);
        frame.centerPanel.setLocation(new Point(30,(30+30+frame.title.getHeight())));

        // The notification feature UI
        if (frame.notificationsBox==true){ // This will be set to true, if the IMSFrame child needs the notification feature
        if (frame.notifications.getNumberOfNotifications() > 0){
                            // manipulating the notification box to its default.. Location is not set here.
                            frame.notifications.setBackground(Theme.NOTIFICATIONS_PANEL_COLOR);    
                            JLabel numberOfNotifications = new javax.swing.JLabel();
                            numberOfNotifications.setFont(Theme.NOTIFICATION_FONT); // NOI18N
                            numberOfNotifications.setText(""+frame.notifications.getNumberOfNotifications()+"");
                            numberOfNotifications.setName("numberOfNotifications"); // NOI18N
                            frame.notifications.add(numberOfNotifications, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
                        }else{
                            // only the color is set
                           frame.notifications.setBackground(Theme.NO_NOTIFICATIONS_PANEL_COLOR);
                        }
        // set size and location, (Note the location depends on some other dynamic variables!).
            frame.notifications.setSize(NOTIFICATIONS_PANEL_MIN_SIZE);
            Point p = new Point((int) (30+frame.centerPanel.getWidth()-NOTIFICATIONS_PANEL_MIN_SIZE.getWidth()),10);
            frame.notifications.setLocation(new Point(750,10));
            
            
        }
        
        // Setting the frame to match the margins
        frame.setSize((60+frame.centerPanel.getWidth()), (frame.title.getHeight()+110+frame.centerPanel.getHeight()));
        
        // Menu bar is created within the theme. Good idea.?
        createMenuBar(); // then set it
        if (frame.getMenuBar()!=null){
            frame.setJMenuBar(null);
        }
        frame.setJMenuBar(menuBar);
        
        // set font color
        for (int i = 0; i< frame.jLabels.length ; i++){
            frame.jLabels[i].setForeground(FONT_COLOR);
        }
        
        frame.repaint();
        //-------------------
    }
    
    
    // manipulating the menubar - each time  a new frame is added. This function needs to be amended.
    
    public void createMenuBar(){
        
        menuBar = new javax.swing.JMenuBar();
        menuProducts = new javax.swing.JMenu();
        menuManageCardsReloads = new javax.swing.JMenuItem();
        menuManageProducts = new javax.swing.JMenuItem();
        menuSale = new javax.swing.JMenu();
        menuProductSale = new javax.swing.JMenuItem();
        menuCardReloadSale = new javax.swing.JMenuItem();
        menuGRN = new javax.swing.JMenuItem();
        menuOrders = new javax.swing.JMenu();
        menuPrintOrders = new javax.swing.JMenu();
        menuNewPrintOrders = new javax.swing.JMenuItem();
        menuManagePrintOrders = new javax.swing.JMenuItem();
        menuServices = new javax.swing.JMenu();
        menuUtitlityBills = new javax.swing.JMenuItem();
        menuManageServices = new javax.swing.JMenuItem();
        menuServiceSales = new javax.swing.JMenuItem();
        menuProjects = new javax.swing.JMenu();
        menuManageProjects = new javax.swing.JMenuItem();
        menuCustomers = new javax.swing.JMenu();
        menuManageCustomers = new javax.swing.JMenuItem();
        menuCompany = new javax.swing.JMenu();
        
        
        menuProducts.setText("Products");
        menuProducts.setName("menuProducts"); // NOI18N

        menuManageCardsReloads.setText("Manage Cards/Reloads");
        menuManageCardsReloads.setName("menuManageCardsReloads"); // NOI18N
        menuManageCardsReloads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        ManageCardsAndReloads pSale = new ManageCardsAndReloads(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuProducts.add(menuManageCardsReloads);

        menuManageProducts.setText("Manage Products");
        menuManageProducts.setName("menuManageProducts"); // NOI18N
        menuManageProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        ManageProducts pSale = new ManageProducts(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuProducts.add(menuManageProducts);

        menuSale.setText("Sale");
        menuSale.setName("menuSale"); // NOI18N
        menuSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
         
            }
        });

        menuProductSale.setText("Product Sale");
        menuProductSale.setName("menuProductSale"); // NOI18N
        menuProductSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        ProductSale pSale = new ProductSale(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuSale.add(menuProductSale);

        menuCardReloadSale.setText("Card/ Reload Sale");
        menuCardReloadSale.setName("menuCardReloadSale"); // NOI18N
        menuCardReloadSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        CardsAndReloads pSale = new CardsAndReloads(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuSale.add(menuCardReloadSale);

        menuProducts.add(menuSale);

        menuGRN.setText("Goods Recieved Note");
        menuGRN.setName("menuGRN"); // NOI18N
        menuGRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        GRN pSale = new GRN(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuProducts.add(menuGRN);

        menuBar.add(menuProducts);

        menuOrders.setText("Orders");
        menuOrders.setName("menuOrders"); // NOI18N

        menuPrintOrders.setText("Print Orders");
        menuPrintOrders.setName("menuPrintOrders"); // NOI18N

        menuNewPrintOrders.setText("New Print Order");
        menuNewPrintOrders.setName("menuNewPrintOrders"); // NOI18N
        menuNewPrintOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        CreateNewPrintOrder pSale = new CreateNewPrintOrder(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuPrintOrders.add(menuNewPrintOrders);

        menuManagePrintOrders.setText("Manage Print Orders");
        menuManagePrintOrders.setName("menuManagePrintOrders"); // NOI18N
        menuManagePrintOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        // TODO : implement a funcitonality disabled frame
                CreateNewPrintOrder pSale = new CreateNewPrintOrder(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuPrintOrders.add(menuManagePrintOrders);

        menuOrders.add(menuPrintOrders);

        menuBar.add(menuOrders);

        menuServices.setText("Services");
        menuServices.setName("menuServices"); // NOI18N

        menuUtitlityBills.setText("Utility Bills");
        menuUtitlityBills.setName("menuUtitlityBills"); // NOI18N
        menuUtitlityBills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        UtilityBills pSale = new UtilityBills(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuServices.add(menuUtitlityBills);

        menuManageServices.setText("Manage Services");
        menuManageServices.setName("menuManageServices"); // NOI18N
        menuManageServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        ManageServices pSale = new ManageServices(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuServices.add(menuManageServices);

        menuServiceSales.setText("Service Sale");
        menuServiceSales.setName("menuServiceSales"); // NOI18N
        menuServiceSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        ServicesSale pSale = new ServicesSale(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuServices.add(menuServiceSales);

        menuBar.add(menuServices);

        menuProjects.setText("Projects");
        menuProjects.setName("menuProjects"); // NOI18N

        menuManageProjects.setText("Manage Projects");
        menuManageProjects.setName("menuManageProjects"); // NOI18N
        menuManageProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        ManageProducts pSale = new ManageProducts(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuProjects.add(menuManageProjects);

        menuBar.add(menuProjects);

        menuCustomers.setText("Customers");
        menuCustomers.setName("menuCustomers"); // NOI18N

        menuManageCustomers.setText("Manage Customers");
        menuManageCustomers.setName("menuManageCustomers"); // NOI18N
        menuManageCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        ManageCustomers pSale = new ManageCustomers(frame,true);
        goToChild((JFrame) pSale);
            }
        });
        menuCustomers.add(menuManageCustomers);

        menuBar.add(menuCustomers);

        menuCompany.setText("Company");
        menuCompany.setName("menuCompany"); // NOI18N
        menuCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        // TODO : To be implemented @ammar
            }
        });
        menuBar.add(menuCompany);
        

menuAllSale = new javax.swing.JMenu();

menuAllSale.setText("Sale");

menuAllSale.setName("menuAllSale"); // NOI18N

menuAllSale.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        HibridSale pSale = new HibridSale(frame,true);
        goToChild((JFrame) pSale);
    }
});


anySale = new javax.swing.JMenuItem();

anySale.setText("Any Sale");

anySale.setName("anySale"); // NOI18N

anySale.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        HibridSale pSale = new HibridSale(frame,true);
        goToChild((JFrame) pSale);
    }
});

menuAllSale.add(anySale);


// Code of sub-components and layout - not shown here

menuBar.add(menuAllSale);



        
    }
    
    
    /**
     * @param the frame you need to go
     * Goes to the jFrame - Hides the current frame
     */
    private void goToChild(JFrame jFrame) {
        frame.setVisible(false);
        jFrame.setVisible(true);
    }
}
