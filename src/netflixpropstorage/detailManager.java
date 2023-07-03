package netflixpropstorage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

//a class used to generate the page showing a selected prop
public class detailManager {
    
    String propID;  //stores the id of the prop being displayed
    String propAvailable;       //determines whether the props is currently on hire
    
    public void generateDetailPage (String col1 , String col2, String col3, String col4, String col5, String col6, String col7, String col8){
        JFrame f=new JFrame();//creating instance of JFrame  
        propID = col1;  //sets the id of the prop
        propAvailable = col8;   //stores the availability of the prop
        f.getContentPane().setBackground(Color.WHITE);      //set background to white
        
        //sets the labels to the characteristics of the prop found in the parameters
        JLabel detail1 = new JLabel("Prop index: "+col1);       //sets the label to the prop id
        detail1.setBounds(700,130,1000, 40);    //determines the size and position of the label
        detail1.setFont(new Font("Bebas Neue", Font.PLAIN, 35));    //sets the font and size
        detail1.setForeground(new Color(229,9,20));     //colour of the label using the rgb value from netflix
        
        JLabel detail2 = new JLabel("Type: "+col2);
        detail2.setBounds(700,190,1000, 40);
        detail2.setFont(new Font("Bebas Neue", Font.PLAIN, 35));
        detail2.setForeground(new Color(229,9,20));
        
        JLabel detail3 = new JLabel("Colour: "+col3);
        detail3.setBounds(700,250,1000, 40);
        detail3.setFont(new Font("Bebas Neue", Font.PLAIN, 35));
        detail3.setForeground(new Color(229,9,20));
        
        JLabel detail4 = new JLabel("Period: "+col4);
        detail4.setBounds(700,310,1000, 40);
        detail4.setFont(new Font("Bebas Neue", Font.PLAIN, 35));
        detail4.setForeground(new Color(229,9,20));
        
        JLabel detail5 = new JLabel("Date: "+col5);
        detail5.setBounds(700,370,1000, 40);
        detail5.setFont(new Font("Bebas Neue", Font.PLAIN, 35));
        detail5.setForeground(new Color(229,9,20));
        
        JTextArea detail6 = new JTextArea("Description: "+col6);
        detail6.setBounds(700,430,300, 140);
        detail6.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
        detail6.setForeground(new Color(229,9,20));
        detail6.setLineWrap(true);
        detail6.setEditable(false);
        detail6.setBorder(null);
        detail6.setWrapStyleWord(true);
        
        //creates the image of the prop
        ImageIcon icon = new ImageIcon(col7);   //stores the file in a icon object
        Image scaleImage = icon.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);      //scales the image to the right size
        icon = new ImageIcon(scaleImage);   //sets the image icon to the the icon so it can be assigned to a label
        JLabel detail7 = new JLabel(icon);      //sets the label to the value of the icon
        detail7.setBounds(110,110,450, 450);    //size and position of the image
        
        //title text
        JLabel detail8 = new JLabel("Prop Details");
        detail8.setBounds(440,30,1000, 40);//x axis, y axis, width, height  
        detail8.setFont(new Font("Bebas Neue", Font.PLAIN, 50));
        detail8.setForeground(new Color(229,9,20));
        
        f.add(detail1);//adding button in JFrame  
        f.add(detail2);
        f.add(detail3);
        f.add(detail4);
        f.add(detail5);
        f.add(detail6);
        f.add(detail7);
        f.add(detail8);
        
        
        JButton b=new JButton("Hire Prop");  
        b.setBounds(700,575,160,40);
        b.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
        b.setForeground(new Color(229,9,20));
        b.setBackground(Color.white);
        
        JButton c=new JButton("Add to basket");  
        c.setBounds(700,625,160,40);  
        c.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
        c.setForeground(new Color(229,9,20));
        c.setBackground(Color.white);
        
        JButton d=new JButton("Return to search");  
        d.setBounds(700,675,160,40);  
        d.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
        d.setForeground(new Color(229,9,20));
        d.setBackground(Color.white);
        
        b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){         //excecuted when the hire button is pressed
                //checks the validity of the string entered by the user
                
                    //confirms with the user 
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to hire this prop","Warning",dialogButton);
                    
                    if(dialogResult == JOptionPane.YES_OPTION){
                        }
                    else{
                        JOptionPane.showMessageDialog(null, "Prop has not been hired");
                    }
                    sqlConnection sC = new sqlConnection();
                    loginPage lP = new loginPage();
                    ResultSet resSet = sC.emailToID(loginPage.emailGlobal);     //stores the id of the user
                    try {
                        if (propAvailable.equals("1")){     //checks if the prop is available to hire
                                resSet.first();     //sets the current row to the first row
                                String currentJob = resSet.getString("job");    //retrieves the current job
                                String userID = resSet.getString("userID");     //retrieves the user id
                                sC.addOrder(propID, userID, currentJob);     //generates an order
                                JOptionPane.showMessageDialog(null, "This prop has been hired by user with email: "+lP.emailGlobal);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "This prop is not available to hire currently");
                        }

                        
                    } catch (SQLException ex) {
                        Logger.getLogger(detailManager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                Logger.getLogger(detailManager.class.getName()).log(Level.SEVERE, null, ex);
            }
                }

            
        });  
        
        c.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  //excecuted when the add to basket button is pressed

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to add this prop to basket","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                basketManager bM = new basketManager();
                loginPage lP = new loginPage();
                int  tempInt = Integer.parseInt(col1);  //used to hold the ID of the prop
                if (propAvailable.equals("1")){
                    if(bM.addToBasket(lP.basketArray , tempInt) == -1){     //used as a check to see if the item has already been added
                                                                                                             //returns -1 if the item is not found
                        JOptionPane.showMessageDialog(null, "This prop has been added to basket");
                        lP.basketArray.add(tempInt);
                    }
                    
                
                    else{
                        JOptionPane.showMessageDialog(null, "This prop is already in the basket so has not been added");
                    }
                    }
                else{JOptionPane.showMessageDialog(null, "This prop is not available to hire currently");}
                
                
            }
            else{JOptionPane.showMessageDialog(null, "This prop has not been added to basket");}

                
            }
            
        });  
        
        //runs when the return search to button pressed
        d.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                  f.setVisible(false);      //hides the current window to show the search page
            }  
        });  
        
        
        f.add(b);       //adds the buttons to the frame
        f.add(c);
        f.add(d);

        f.setSize(1080,800);
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  
        f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
    }
}
