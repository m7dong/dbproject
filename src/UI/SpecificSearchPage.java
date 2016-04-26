package UI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SpecificSearchPage {
    
    private JPanel specificSearchPanel;
    private final JTabbedPane pane = new JTabbedPane();
	
    public void specificSearch() {
        specificSearchPanel = new JPanel();
        specificSearchPanel.setBorder(new EmptyBorder(10, 10, 18, 10));
        specificSearchPanel.setLayout(new BorderLayout(0, 0));
        
        
        Main.mainFrame.add(specificSearchPanel);
        Main.mainFrame.revalidate();
        Main.mainFrame.repaint();
        
        
        String[] tabContents = {"All Publishers", "All authors", "Most Popular Books", "Books Published", "All Comics"};
        
        for (int i = 0; i < 5; i++) {
            pane.add(tabContents[i], new TabContent(i));        
        }
        
        JPanel backPanel = new JPanel();
        JButton back = new JButton("back");
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		backPanel.removeAll();
        		pane.removeAll();
        		specificSearchPanel.removeAll();
        		Main.mainFrame.remove(specificSearchPanel);
        		DetailSearchPage detailSearchPage = new DetailSearchPage();
        		detailSearchPage.detailSearch();
        		
        	}
        });
        backPanel.add(back);
        specificSearchPanel.add(pane, BorderLayout.CENTER);
        specificSearchPanel.add(backPanel, BorderLayout.SOUTH);

        //Main.mainFrame.pack();
        Main.mainFrame.setVisible(true);
    }
    
    private static class TabContent extends JPanel {

        private TabContent(int i) {
            setOpaque(true);
            if(i == 0) {
                getAllPublishers();
            }
            else if (i == 1) {
                getAllAuthors();
            }
            else if (i == 2) {
                getMostPopulars();
            }
            else if (i == 3 ) {
                getBooksPublished();
            }
            else {
                getAllComics();
            }
        }
        
        private void getAllPublishers() {
            add(new JLabel("Tab content " + "Publishers"));
            
        }
        
        private void getAllAuthors() {
            
        }
        
        private void getMostPopulars() {
            
        }
        
        private void getBooksPublished() {
            
        }
        
        private void getAllComics() {
            
        }
    }
}
