package UI;

import java.awt.*; 
import java.awt.event.*;  

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import Core.Book;
import DAO.UserInput;
import DAO.BookDAO;

public class DetailSearchPage extends JPanel {
	private JPanel detailSearchPanel;
	private BookDAO BookDAO;
	private UserInput UserInput;
	
	public void detailSearch() {
    	
    	detailSearchPanel = new JPanel();
        detailSearchPanel.setBorder(new EmptyBorder(10, 10, 18, 10));
        detailSearchPanel.setLayout(new BorderLayout(0, 0));
        
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    //Main.mainFrame.setLocation(dim.width/2 - Main.mainFrame.getSize().width/2, dim.height/2 - Main.mainFrame.getSize().height/2);
       
        
        Main.mainFrame.add(detailSearchPanel);
        Main.mainFrame.revalidate();
        Main.mainFrame.repaint();
        
        
        
        // Result
        
        JPanel panelResult = new JPanel();
        
        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setPreferredSize(new Dimension(775, 400));
        
        ImageIcon backgroundIcon = new ImageIcon("src/background.jpg");
        Image backgroundImg = backgroundIcon.getImage();
        Image newBackgroundImg = backgroundImg.getScaledInstance(760, 390,  java.awt.Image.SCALE_SMOOTH );
        backgroundIcon = new ImageIcon(newBackgroundImg);
        JLabel backgroundPic = new JLabel(backgroundIcon);
        scrollPane1.getViewport().add(backgroundPic, scrollPane1);
        
        panelResult.add(scrollPane1);
        
        JTable tableTemp = new JTable();
        //scrollPane1.setViewportView(tableTemp);
        
        detailSearchPanel.add(panelResult, BorderLayout.SOUTH);
        
        
        // Fields
        
        UserInput = new UserInput();
        
        JPanel panelFields = new JPanel();
        panelFields.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        
        JLabel authorName = new JLabel("Author Name");
        JLabel bookTitle = new JLabel("Book Title");
        JLabel publisher = new JLabel("Publisher");
        JLabel startDate = new JLabel("Date From");
        JLabel endDate = new JLabel("Date Till");
        JLabel language = new JLabel("Language");
        JLabel bookSeries = new JLabel("Book Series");
        JLabel type = new JLabel("Type");
        JLabel transparent1 = new JLabel("");
        JLabel transparent2 = new JLabel("");
        JLabel transparent3 = new JLabel("");
       
        
        JTextField authorNameText = new JTextField("Please Enter Exact Author Name");
        JTextField bookTitleText = new JTextField("Please Enter Exact Book Title");
        JTextField publisherNameText = new JTextField("Please Enter Exact Publisher Name");
        JTextField bookSeriesText = new JTextField("Please Enter Exact Book Series Name");
         
        authorNameText.setColumns(20);
        authorNameText.setEditable(true);
        authorNameText.setForeground(Color.gray);
        authorNameText.addFocusListener(new FocusListener() {
        	public void focusGained(FocusEvent e) {
        		String content = authorNameText.getText();
        		if (content.trim().equals("Please Enter Exact Author Name")) {
        			authorNameText.setText("");
        			authorNameText.setForeground(Color.black);
        		}
        	}
        	public void focusLost(FocusEvent e) {
        		String content = authorNameText.getText();
        		if (content.trim().equals("")) {
        			authorNameText.setForeground(Color.gray);
        			authorNameText.setText("Please Enter Exact Author Name");
        			UserInput.set_Author_Name(null);
        		} else {
        			UserInput.set_Author_Name(content);
        		}
        	}
        });
        
        bookTitleText.setColumns(20);
        bookTitleText.setEditable(true);
        bookTitleText.setForeground(Color.gray);
        bookTitleText.addFocusListener(new FocusListener() {
        	public void focusGained(FocusEvent e) {
        		String content = bookTitleText.getText();
        		if (content.trim().equals("Please Enter Exact Book Title")) {
        			bookTitleText.setText("");
        			bookTitleText.setForeground(Color.black);
        		}
        	}
        	public void focusLost(FocusEvent e) {
        		String content = bookTitleText.getText();
        		if (content.trim().equals("")) {
        			bookTitleText.setForeground(Color.gray);
        			bookTitleText.setText("Please Enter Exact Book Title");
        			UserInput.set_Title_Name(null);
        			UserInput.set_Publication_Name(null);
        		} else {
        			UserInput.set_Title_Name(content);
        			UserInput.set_Publication_Name(content);
        		}
        			
        	}
        });
        
        publisherNameText.setColumns(20);
        publisherNameText.setEditable(true);
        publisherNameText.setForeground(Color.gray);
        publisherNameText.addFocusListener(new FocusListener() {
        	public void focusGained(FocusEvent e) {
        		String content = publisherNameText.getText();
        		if (content.trim().equals("Please Enter Exact Publisher Name")) {
        			publisherNameText.setText("");
        			publisherNameText.setForeground(Color.black);
        		}
        	}
        	public void focusLost(FocusEvent e) {
        		String content = publisherNameText.getText();
        		if (content.trim().equals("")) {
        			publisherNameText.setForeground(Color.gray);
        			publisherNameText.setText("Please Enter Exact Publisher Name");
        			UserInput.set_Publisher_Name(null);
        		} else {
        			UserInput.set_Publisher_Name(content);
        		}
        	}
        });
        
        bookSeriesText.setColumns(20);
        bookSeriesText.setEditable(true);
        bookSeriesText.setForeground(Color.gray);
        bookSeriesText.addFocusListener(new FocusListener() {
        	public void focusGained(FocusEvent e) {
        		String content = bookSeriesText.getText();
        		if (content.trim().equals("Please Enter Exact Book Series Name")) {
        			bookSeriesText.setText("");
        			bookSeriesText.setForeground(Color.black);
        		}
        	}
        	public void focusLost(FocusEvent e) {
        		String content = bookSeriesText.getText();
        		if (content.trim().equals("")) {
        			bookSeriesText.setForeground(Color.gray);
        			bookSeriesText.setText("Please Enter Exact Book Series Name");
        			UserInput.set_Title_Series_Name(null);
            		UserInput.set_Publication_Series_Name(null);
        		} else {
        			UserInput.set_Title_Series_Name(content);
        			UserInput.set_Publication_Series_Name(content);
        		}
        	}
        });
        
        
        JComboBox languageChoice = new JComboBox();
        JComboBox bookType = new JComboBox();
        JComboBox startYear = new JComboBox();
        JComboBox endYear = new JComboBox();
        
        
        String[] avail_Languages = {"", "English", "French", "Chinese", "Spanish", "Arabic", "German", "Other"};
        for (int i = 0; i < avail_Languages.length; i++) {
        	languageChoice.addItem(avail_Languages[i]);
        }
        languageChoice.setPreferredSize(new Dimension(255, 25));
        languageChoice.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent actionEvent) {
        		String language = languageChoice.getSelectedItem().toString();
        		if (language != "") {
        			UserInput.set_Language(language);
        		} else {
        			UserInput.set_Language(null);
        		}
        	}
        });
        
        
        String[] avail_Type = {"", "ANTHOLOGY", "BACKCOVERART", "COLLECTION", "COVERART", "INTERIORART", "EDITOR", "ESSAY", "INTERVIEW", "NOVEL", "NONFICTION", "OMNIBUS", "POEM", "REVIEW", "SERIAL", "SHORTFICTION", "CHAPBOOK", "MAGAZINE", "FANZINE"};
        for (int i = 0; i < avail_Type.length; i++) {
        	bookType.addItem(avail_Type[i]);
        }
        bookType.setPreferredSize(new Dimension(255, 25));
        bookType.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent actionEvent) {
        		String type = bookType.getSelectedItem().toString();
        		if (type != "") {
        			UserInput.set_Title_Type(type);
        			UserInput.set_Publication_Type(type);
        		} else {
        			UserInput.set_Title_Type(null);
        			UserInput.set_Publication_Type(null);
        		}
        	}
        });
        
        
        startYear.addItem("");
        endYear.addItem("");
        for (int i = 2016; i >= 1; i--) {
        	if (i >= 1000) {
        		startYear.addItem(Integer.toString(i));
        		endYear.addItem(Integer.toString(i));
        	}
        	if ((i >= 100) && (i <= 999)) {
        		startYear.addItem("0" + Integer.toString(i));
        		endYear.addItem("0" + Integer.toString(i));
        	}
        	if ((i >= 10) && (i <= 99)) {
        		startYear.addItem("00" + Integer.toString(i));
        		endYear.addItem("00" + Integer.toString(i));
        	}
        	if ((i >= 1) && (i <= 9)) {
        		startYear.addItem("000" + Integer.toString(i));
        		endYear.addItem("000" + Integer.toString(i));
        	}
        }
        
        startYear.setPreferredSize(new Dimension(255, 25));
        startYear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent actionEvent) {
        		String start_Year = startYear.getSelectedItem().toString();
        		if (start_Year != "") {
        			UserInput.set_Start_Date(start_Year + "-01-01");
        		} else {
        			UserInput.set_Start_Date(null);
        		}
        	}
        });

        endYear.setPreferredSize(new Dimension(255, 25));
        endYear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent actionEvent) {
        		String end_Year = endYear.getSelectedItem().toString();
        		if (end_Year != "") {
        			UserInput.set_End_Date(end_Year + "-01-01");
        		} else {
        			UserInput.set_End_Date(null);
        		}
        	}
        });
        
        
        JCheckBox awardedBook = new JCheckBox("Show Only Awarded Books!");
        awardedBook.addFocusListener(new FocusListener() {
        	public void focusGained(FocusEvent e) {}
        	public void focusLost(FocusEvent e) {
        		UserInput.set_Awarded(awardedBook.isSelected());
        	}
        });
        
        ImageIcon searchIcon = new ImageIcon("src/search-button.png");
        Image searchImg = searchIcon.getImage();
        Image newSearchImg = searchImg.getScaledInstance(80, 30,  java.awt.Image.SCALE_SMOOTH );
        searchIcon = new ImageIcon(newSearchImg);
        JButton search = new JButton(searchIcon);
        search.setOpaque(false);
        search.setContentAreaFilled(false);
        search.setBorderPainted(false);
        search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		backgroundPic.setVisible(false);
        		scrollPane1.setViewportView(tableTemp);
        		System.out.println("");
        		System.out.println("****System*******NEW SEARCH************");
                        System.out.println("Author Name = " + UserInput.get_Author_Name());
        		System.out.println("Book Title = " + UserInput.get_Publication_Name());
        		System.out.println("Publisher = " + UserInput.get_Publisher_Name());
        		System.out.println("Book Series Name = " + UserInput.get_Title_Series_Name());
        		System.out.println("Language = " + UserInput.get_Language());
        		System.out.println("Book Type = " + UserInput.get_Title_Type());
        		System.out.println("Start Date = " + UserInput.get_Start_Date());
        		System.out.println("End Date = " + UserInput.get_End_Date());
        		System.out.println("Awarded Book = " + UserInput.get_Awarded());
    
        		BookDAO = new BookDAO();
        		tableTemp.setModel(new DefaultTableModel());
                try {
                    List<Book> books = BookDAO.searchBook(UserInput);					
                    BookTableModel model = new BookTableModel(books);	               
                    tableTemp.setModel(model);
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(DetailSearchPage.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
                }
        	}
        });
        
        ImageIcon backIcon = new ImageIcon("src/back-button.png");
        Image backImg = backIcon.getImage();
        Image newBackImg = backImg.getScaledInstance(80, 30,  java.awt.Image.SCALE_SMOOTH );
        backIcon = new ImageIcon(newBackImg);
        JButton back = new JButton(backIcon);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panelResult.removeAll();
        		panelFields.removeAll();
        		detailSearchPanel.removeAll();
        		Main.mainFrame.remove(detailSearchPanel);
        		Main.mainFrame.setBounds(100, 100, 800, 180);
        		
        		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        	    //Main.mainFrame.setLocation(dim.width/2 - Main.mainFrame.getSize().width/2, dim.height/2 - Main.mainFrame.getSize().height/2);
        		
        		SearchApp searchApp = new SearchApp();
        		searchApp.initialPage();
        	}
        });
        
        JButton specificSearch = new JButton("Specific Search");
        specificSearch.setBorder(null);
        specificSearch.setOpaque(true);
        specificSearch.setForeground(Color.blue);
        specificSearch.setFont(new Font("Plain", Font.PLAIN, 13));
        Font font = specificSearch.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        specificSearch.setFont(font.deriveFont(attributes));       
        specificSearch.setFocusPainted(true);
        specificSearch.setBorderPainted(true);
        specificSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelResult.removeAll();
                panelFields.removeAll();
                detailSearchPanel.removeAll();
                Main.mainFrame.remove(detailSearchPanel);
                //Main.mainFrame.setBounds(100, 100, 800, 999);
                //Main.mainFrame.pack();
                //Main.mainFrame.setVisible(true);
                //Main.mainFrame.setBounds(100, 100, 800, 1000);
                
                //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        	    //Main.mainFrame.setLocation(dim.width/2 - Main.mainFrame.getSize().width/2, dim.height/2 - Main.mainFrame.getSize().height/2);
        	    
            	SpecificSearchPage specificSearchPage = new SpecificSearchPage();
            	specificSearchPage.specificSearch();       	
            }
        });
        
        
        grid.gridx = 0;
        grid.gridy = 0;
        grid.ipady = 40;
        panelFields.add(transparent3, grid);
        grid.ipady = 0;
        
        grid.gridx = 0;
        grid.gridy = 1;
        panelFields.add(authorName, grid);
        grid.gridx = 1;
        grid.gridy = 1;
        panelFields.add(authorNameText, grid);
        
        
        grid.gridx = 0;
        grid.gridy = 2;
        panelFields.add(bookTitle, grid);
        grid.gridx = 1;
        grid.gridy = 2;
        panelFields.add(bookTitleText, grid);
        
        grid.gridx = 0;
        grid.gridy = 3;
        panelFields.add(publisher, grid);
        grid.gridx = 1;
        grid.gridy = 3;
        panelFields.add(publisherNameText, grid);
        
        grid.gridx = 0;
        grid.gridy = 4;
        panelFields.add(bookSeries, grid);
        grid.gridx = 1;
        grid.gridy = 4;
        panelFields.add(bookSeriesText, grid);
        
        grid.gridx = 2;
        grid.gridy = 1;
        grid.ipadx = 20;
        panelFields.add(transparent2, grid);
        grid.ipadx = 0;
        
        grid.gridx = 3;
        grid.gridy = 1;
        panelFields.add(language, grid);
        grid.gridx = 4;
        grid.gridy = 1;
        panelFields.add(languageChoice, grid);
        
        grid.gridx = 3;
        grid.gridy = 2;
        panelFields.add(type, grid);
        grid.gridx = 4;
        grid.gridy = 2;
        panelFields.add(bookType, grid);
        
        
        grid.gridx = 3;
        grid.gridy = 3;
        panelFields.add(startDate, grid);
        grid.gridx = 4;
        grid.gridy = 3;
        panelFields.add(startYear, grid);
        
        grid.gridx = 3;
        grid.gridy = 4;
        panelFields.add(endDate, grid);
        grid.gridx = 4;
        grid.gridy = 4;
        panelFields.add(endYear, grid);
        
        grid.gridx = 4;
        grid.gridy = 5;
        grid.ipady = 30;
        panelFields.add(transparent1, grid);
        
        grid.gridx = 4;
        grid.gridy = 6;
        grid.ipady = 30;
        panelFields.add(awardedBook, grid);
        
        grid.gridx = 4;
        grid.gridy = 7;
        grid.ipady = 5;
        panelFields.add(search, grid);
        
        grid.anchor = GridBagConstraints.WEST;
        grid.gridx = 1;
        grid.gridy = 6;
        grid.ipady = 30;
        panelFields.add(specificSearch, grid);
        
        grid.anchor = GridBagConstraints.WEST;
        grid.gridx = 1;
        grid.gridy = 7;
        grid.ipady = 5;
        panelFields.add(back, grid);
        
        
        
        Border title = BorderFactory.createTitledBorder("Advanced Book Search");
        panelFields.setBorder(title);
        
        detailSearchPanel.add(panelFields, BorderLayout.NORTH);  
        
        Main.mainFrame.pack();
        Main.mainFrame.setVisible(true);
            
    }
}
